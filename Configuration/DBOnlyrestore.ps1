#### This script expects the updated code to have already been placed in the Nexus Api folder
#### There are 6 parameters required:
####    $Nexus_APIPath 				: 	Path to Nexus_Api
####    $Nexus_APIDistPathToDelete 	:	Path to DIST folder for Nexus_Api
####    $Nexus_APIPathToSQL 		:	Path to SQL in Nexus_Api folder
####    $SQLServerInstance 			:	SQL Server Instance
####    $SQLCompanyDB 				:	CSM Company Database
####    $SQLApiDB 					:	Nexus Api Database
####
param (
   
    [string]$DbBackup_Path_FileVersion = "D:\DatabaseBackup\TWO_2020R2_APITEST.bak", # Path to SQL in Nexus_Api folder
    [string]$SQLServerInstance = "RND-BASE-A\SQL_2017", # SQL Server Instance
    [string]$SQLCompanyDB = "TWO", # CSM Company Database
	[string]$SQLApiDB = "Nexus_Api", # CSM Company Database
	[string]$Nexus_APIPath = "C:\Program Files (x86)\Jenkins\workspace\NexusAPIBuild\", # Path to Nexus_Api
	[string]$BackupDestination = "C:\Program Files (x86)\Jenkins\workspace\Backup\", # Path to Nexus_Api backup
    [string]$Nexus_APIDistPathToDelete = $Nexus_APIPath+"dist\server\*", # Path to DIST folder for Nexus_Api
    [string]$Nexus_APIPathToSQL = $Nexus_APIPath+"src\server\db scripts\", # Path to 
	[string]$Nexus_APIPathTopatch = $Nexus_APIPathToSQL+"\Patches" # Path to \Patches
	
)
	

If (!(Test-Path $DbBackup_Path_FileVersion)) 
{
    Write-Host "DB path is invalid! " $DbBackup_Path_FileVersion
    exit
}
	
# Restore database the password is 'cogs'
Write-Host "Restore DB from location " $DbBackup_Path_FileVersion "=============================="
invoke-sqlcmd -ServerInstance $SQLServerInstance -U "sa" -Password "cogs" -Query "IF EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name ='TWO') BEGIN ALTER DATABASE TWO SET SINGLE_USER WITH ROLLBACK IMMEDIATE; DROP DATABASE TWO;  END"
Restore-SqlDatabase -ServerInstance $SQLServerInstance -Database $SQLCompanyDB -BackupFile $DbBackup_Path_FileVersion  -ReplaceDatabase 


Set-Location $Nexus_APIPath

#npm run pm2:start
#npm run pm2:stop
#Read-Host -Prompt "Does that look right? Press any key to continue or CTRL+C to quit" 


Set-Location $Nexus_APIPathTopatch
Write-Host "Running Patches.sql...."
#Invoke-sqlcmd -inputfile "CSM_Coreum_udReceiptHeader_Pre2021R2.sql" -serverinstance $SQLServerInstance -database $SQLCompanyDB
#Invoke-sqlcmd -inputfile "CSM_CoreSwitchMeters_Pre2020R2.sql" -serverinstance $SQLServerInstance -database $SQLCompanyDB
#Write-Host "Running CSM_CoreSwitchMeters_Pre2020R2.sql....DONE"
$scripts = Get-ChildItem $Nexus_APIPathTopatch | Where-Object {$_.Extension -eq ".sql"}
 
foreach ($s in $scripts)
    {
        Write-Host "Running Script : " $s.Name -BackgroundColor DarkGreen -ForegroundColor White
        $script = $s.FullName
        Invoke-Sqlcmd -InputFile $script -serverinstance $SQLServerInstance -database $SQLCompanyDB
    }



# Update SQL
Set-Location $Nexus_APIPathToSQL
Start-Process "BuildInstallScript.bat"
Start-Sleep -s 5
#Read-Host -Prompt "Did the batch file complete successfully? Press <ENTER> to continue or CTRL+C to quit" 
Write-Host "Updating COMPANY procedures....InstallCsmApiDatabaseComponents_v2.0.0.sql"
Invoke-sqlcmd -inputfile "InstallCsmApiDatabaseComponents_v2.0.0.sql" -serverinstance $SQLServerInstance -database $SQLCompanyDB
Write-Host "Updating COMPANY procedures....DONE"
#Read-Host -Prompt "Does that look right? Press <ENTER> to continue or CTRL+C to quit" 

Write-Host "Running Initialize.sql...."
Invoke-sqlcmd -inputfile "Initialize.sql" -serverinstance $SQLServerInstance -database $SQLApiDB
Write-Host "Running Initialize.sql....DONE"
#Read-Host -Prompt "Does that look right? Press <ENTER> to continue or CTRL+C to quit" 

Write-Host "Running PostInitialize.sql...."
Invoke-sqlcmd -inputfile "PostInitializeCompanyDB.sql" -serverinstance $SQLServerInstance -database $SQLCompanyDB
Write-Host "Running PostInitialize.sql....DONE"



[reflection.assembly]::LoadWithPartialName("Microsoft.SqlServer.Smo") | Out-Null
$inst=$SQLServerInstance
$srv = new-object ('Microsoft.SqlServer.Management.Smo.Server') $inst
# Cycle through the databases
$db=$SQLCompanyDB
$dbname = $db.Name
$dbname=$srv.Databases[$db]
$srv.KillAllProcesses($db)

#write-output "Database $dbname set to Single User Successfully"
write-output "Changing database $dbname to Multi user"
$dbname.useraccess = "Multiple"
$dbname.Alter()
$srv.KillAllProcesses($db)
write-output "Database $dbname set to Multi User Successfull"

