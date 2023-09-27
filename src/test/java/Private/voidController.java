package Private;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

public class voidController {

	//@Test(priority = 1, groups = "void")
	public void putvoidvalidatev4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/void/validate";
		String ver = "4.0";
		String jpath = "./\\TestData\\putvoidvalidateReasonCodev4.json";
		String params = new String(Files.readAllBytes(Paths.get(jpath)));
		String expected = "./\\TestData\\ExpputvoidvalidateReasonCodev4.json";
		ValidatableResponse result = CommonMethods.putMethod(uri, ver, params, expected);
		 
	}
	
	
	//@Test(priority = 2, groups = "void")
	public void putvoidvalidateInvaliddocumentv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/void/validate";
		String ver = "4.0";
		String jpath = "./\\TestData\\putvoidvalidateReasonCode1v4.json";
		String params = new String(Files.readAllBytes(Paths.get(jpath)));
		String expected = "./\\TestData\\ExpputvoidvalidateReasonCode1v4.json";
		ValidatableResponse result = CommonMethods.putMethod(uri, ver, params, expected);
		 
	}
	
	
	@Test(priority = 1, groups = "void")
	public void putvoidv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/void";
		String ver = "4.0";
		String jpath = "./\\TestData\\putvoidv4.json";
		String params = new String(Files.readAllBytes(Paths.get(jpath)));
		String expected = "./\\TestData\\expvoidv4.json";
		ValidatableResponse result = CommonMethods.putMethod(uri, ver, params, expected);
		 
	}
	
	
	@Test(priority = 2, groups = "void")
	public void getVoidLaodv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/void/load/ELECWAT001/CUSTOMER007";
		String ver = "4.0";
		String expected = "{\"Void\":{\"Success\":true,\"Data\":{\"Document\":[{\"Number\":\"BILL00000000483\",\"StatementNumber\":356,\"Date\":\"2000-02-29\",\"Type\":\"Bill\",\"Status\":\"Open\",\"DocumentAmount\":586.17,\"OutstandingAmount\":131.22,\"VerificationList\":{\"spa\":null,\"Penalty\":null,\"WriteOffExport\":null,\"CollectionImport\":null,\"DepositReceivable\":null,\"NegativeBill\":null,\"BillCreditNote\":null,\"TransferBalanceDocument\":null,\"CashieringCheckCreditCard\":null}},{\"Number\":\"BILL00000000602\",\"StatementNumber\":392,\"Date\":\"2019-09-05\",\"Type\":\"Bill\",\"Status\":\"Open\",\"DocumentAmount\":110.00,\"OutstandingAmount\":110.00,\"VerificationList\":{\"spa\":null,\"Penalty\":null,\"WriteOffExport\":null,\"CollectionImport\":null,\"DepositReceivable\":null,\"NegativeBill\":null,\"BillCreditNote\":null,\"TransferBalanceDocument\":null,\"CashieringCheckCreditCard\":null}},{\"Number\":\"BILL00000000603\",\"StatementNumber\":392,\"Date\":\"2019-09-05\",\"Type\":\"Bill\",\"Status\":\"Open\",\"DocumentAmount\":30.00,\"OutstandingAmount\":30.00,\"VerificationList\":{\"spa\":null,\"Penalty\":null,\"WriteOffExport\":null,\"CollectionImport\":null,\"DepositReceivable\":null,\"NegativeBill\":null,\"BillCreditNote\":null,\"TransferBalanceDocument\":null,\"CashieringCheckCreditCard\":null}},{\"Number\":\"BILL00000000604\",\"StatementNumber\":392,\"Date\":\"2019-09-05\",\"Type\":\"Bill\",\"Status\":\"Open\",\"DocumentAmount\":59.71,\"OutstandingAmount\":59.71,\"VerificationList\":{\"spa\":null,\"Penalty\":null,\"WriteOffExport\":null,\"CollectionImport\":null,\"DepositReceivable\":null,\"NegativeBill\":null,\"BillCreditNote\":null,\"TransferBalanceDocument\":null,\"CashieringCheckCreditCard\":null}},{\"Number\":\"BILL00000000605\",\"StatementNumber\":392,\"Date\":\"2019-09-05\",\"Type\":\"Bill\",\"Status\":\"Open\",\"DocumentAmount\":24.00,\"OutstandingAmount\":24.00,\"VerificationList\":{\"spa\":null,\"Penalty\":null,\"WriteOffExport\":null,\"CollectionImport\":null,\"DepositReceivable\":null,\"NegativeBill\":null,\"BillCreditNote\":null,\"TransferBalanceDocument\":null,\"CashieringCheckCreditCard\":null}},{\"Number\":\"BILL00000000606\",\"StatementNumber\":392,\"Date\":\"2019-09-05\",\"Type\":\"Bill\",\"Status\":\"Open\",\"DocumentAmount\":10.50,\"OutstandingAmount\":10.50,\"VerificationList\":{\"spa\":null,\"Penalty\":null,\"WriteOffExport\":null,\"CollectionImport\":null,\"DepositReceivable\":null,\"NegativeBill\":null,\"BillCreditNote\":null,\"TransferBalanceDocument\":null,\"CashieringCheckCreditCard\":null}}]},\"Messages\":[]}}";
		HashMap<String, String> params = new HashMap<String, String>();
	    String result = CommonMethods.getMethodasString(uri, ver, params);
	    if (!result.contentEquals(expected))
	    {
	    	Assert.fail();
	    }
		System.out.println(result);
		 
	}
	
	
	
	@Test(priority = 2, groups = "void")
	public void getlinkedDocumentv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/void/linkedDocument/BILL00000000496";
		String ver = "4.0";
		String expected = "{\"Void\":{\"Success\":true,\"Data\":{\"LinkedDocument\":{\"Spa\":null,\"Penalty\":null,\"WriteOffExport\":[{\"Number\":\"PYMT00000000505\"}],\"CollectionImport\":null,\"DepositReceivable\":null,\"NegativeBill\":null,\"BillCreditNote\":null,\"TransferBalanceDocument\":null,\"CashieringCheckCreditCard\":null}},\"Messages\":[]}}";
		HashMap<String, String> params = new HashMap<String, String>();
	    String result = CommonMethods.getMethodasString(uri, ver, params);
	    if (!result.contentEquals(expected))
	    {
	    	Assert.fail();
	    }
		System.out.println(result);
		 
	}
	
	
	
		

	

	
}