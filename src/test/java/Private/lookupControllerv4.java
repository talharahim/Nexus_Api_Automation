package Private;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.response.ValidatableResponse;

public class lookupControllerv4 {

	@Test(priority = 4, groups = "lookup")
	public void getapplyByService_v4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/lookupBatch";
		String ver = "4.0";
		String expected = "{\"Batch\":[{\"Id\":\"000700";
		HashMap<String, String> params = new HashMap<String, String>();
		String result = CommonMethods.getMethodasString(uri, ver, params);
	
		if (!result.contains(expected)) 
		{
			Assert.fail("Actual Result "+result);
		}
		System.out.println(result);
	}
	
	@Test(priority = 2, groups = "lookup")
	public void getapplyByService_Paymentsv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri2 = "/lookupBatch";
		String ver = "4.0";
		String jpath = "./\\TestData\\lookupBatchPayments_v4.json";
		HashMap<String, String> params = new HashMap<String, String>();
		 params.put("Batchsource", "PAYMENTS"); 
		 //params.put("LocationId", "LOCATION011"); 
		 String result = CommonMethods.getMethod(uri2, ver, params, jpath);
		 System.out.println(result);
	}
	
	@Test(priority = 3, groups = "lookup")
	public void getapplyByService_nonev4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri3 = "/lookupBatch";
		String ver = "4.0";
		String jpath = "./\\TestData\\lookupBatchNone_v4.json";
		HashMap<String, String> params = new HashMap<String, String>();
		 params.put("Batchsource", "NONE");  
		 //params.put("LocationId", "LOCATION011"); 
		 String result = CommonMethods.getMethod(uri3, ver, params, jpath);
		 System.out.println(result);
	}
	
	@Test(priority = 1, groups = "lookup")
	public void lookupMetergroup4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri3 = "/lookupMeterGroup";
		String ver = "4.0";
		String jpath = "./\\TestData\\lookupMeterGroupv4.json";
	 	HashMap<String, String> params = new HashMap<String, String>();
		// params.put("Batchsource", "NONE");  //params.put("LocationId", "LOCATION011"); 
		String result = CommonMethods.getMethod(uri3, ver, params, jpath);
		System.out.println(result);
	}
	
	@Test(priority = 5, groups = "lookup")
	public void lookupCheckBookv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri3 = "/lookupCheckBook";
		String ver = "4.0";
		String jpath = "./\\TestData\\lookupCheckBookv4.json";
	 	HashMap<String, String> params = new HashMap<String, String>();
		// params.put("Batchsource", "NONE");  //params.put("LocationId", "LOCATION011"); 
		String result = CommonMethods.getMethod(uri3, ver, params, jpath);
		System.out.println(result);
	}
	
	
	@Test(priority = 6, groups = "lookup")
	public void lookupReadingTypev4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri3 = "/lookupReadingType";
		String ver = "4.0";
		String jpath = "./\\TestData\\lookupReadingTypev4.json";
	 	HashMap<String, String> params = new HashMap<String, String>();
		// params.put("Batchsource", "NONE");  //params.put("LocationId", "LOCATION011"); 
		String result = CommonMethods.getMethod(uri3, ver, params, jpath);
		System.out.println(result);
	}
	
	
	@Test(priority = 7, groups = "lookup")
	public void lookupNsfReasonCodev4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri3 = "/lookupNsfReasonCode";
		String ver = "4.0";
		String jpath = "./\\TestData\\lookupNsfReasonCodev4.json";
	 	HashMap<String, String> params = new HashMap<String, String>();
		// params.put("Batchsource", "NONE");  //params.put("LocationId", "LOCATION011"); 
		String result = CommonMethods.getMethod(uri3, ver, params, jpath);
		System.out.println(result);
	}
	
	@Test(priority = 8, groups = "lookup")
	public void lookupMeterReadv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri3 = "/lookupMeterRead";
		String ver = "4.0";
		String jpath = "./\\TestData\\lookupMeterRead_v4.json";
	 	HashMap<String, String> params = new HashMap<String, String>();
		// params.put("Batchsource", "NONE");  //params.put("LocationId", "LOCATION011"); 
		String result = CommonMethods.getMethod(uri3, ver, params, jpath);
		System.out.println(result);
	}
	
	
	@Test(priority = 9, groups = "lookup")
	public void lookupdocumentTypev4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri3 = "/lookup/documentType";
		String ver = "4.0";
		String jpath = "./\\TestData\\lookupdocumentType_v4.json";
	 	HashMap<String, String> params = new HashMap<String, String>();
		// params.put("Batchsource", "NONE");  //params.put("LocationId", "LOCATION011"); 
		String result = CommonMethods.getMethod(uri3, ver, params, jpath);
		System.out.println(result);
	}
	
	
	@Test(priority = 10, groups = "lookup")
	public void lookupzonev4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri3 = "/lookup/zone";
		String ver = "4.0";
		String jpath = "./\\TestData\\lookupzone_v4.json";
	 	HashMap<String, String> params = new HashMap<String, String>();
		String result = CommonMethods.getMethod(uri3, ver, params, jpath);
	}
	
	@Test(priority = 11, groups = "lookup")
	public void lookupequipmentModelv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/lookup/equipmentModel";
		String ver = "4.0";
		String jpath = "./\\TestData\\equipmentModel_v4.json";
	 	HashMap<String, String> params = new HashMap<String, String>();
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);
	}
	
	
	@Test(priority = 12, groups = "lookup")
	public void lookupequipmentClassv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/lookup/EquipmentClass";
		String ver = "4.0";
		String jpath = "./\\TestData\\equipmentClass_v4.json";
	 	HashMap<String, String> params = new HashMap<String, String>();
	 	params.put("EquipmentClass", "ELECMETER");
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);
	}
	
	@Test(priority = 13, groups = "lookup")
	public void lookupequipmentTypev4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/Lookup/EquipmentType";
		String ver = "4.0";
		String jpath = "./\\TestData\\EquipmentType_v4.json";
	 	HashMap<String, String> params = new HashMap<String, String>();
	 	params.put("ServiceCategoryId", "1");
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);
	}
	
	@Test(priority = 13, groups = "lookup")
	public void lookupequipmentStatusv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/lookup/EquipmentStatus";
		String ver = "4.0";
		String jpath = "./\\TestData\\equipmentStatus_v4.json";
	 	HashMap<String, String> params = new HashMap<String, String>();
	 	params.put("EquipmentClass", "ELECMETER");
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);
	}

	@Test(priority = 14, groups = "lookup")
	public void lookupequipmentNetMetervType4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/lookup/equipmentNetMeterType";
		String ver = "4.0";
		String jpath = "./\\TestData\\equipmentNetMeter_v4.json";
	 	HashMap<String, String> params = new HashMap<String, String>();
	 	String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);
	}
	
	
	@Test(priority = 15, groups = "lookup")
	public void lookupEquipmentRegisterCode4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/lookup/EquipmentRegisterCode";
		String ver = "4.0";
		String jpath = "./\\TestData\\EquipmentRegisterCodev4.json";
	 	HashMap<String, String> params = new HashMap<String, String>();
	 	String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);
	}

	

	@Test(priority = 16, groups = "lookup")
	public void lookupEquipmentAttributeProtection4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/lookup/EquipmentAttributeProtection";
		String ver = "4.0";
		String jpath = "./\\TestData\\EquipmentAttributeProtectionv4.json";
	 	HashMap<String, String> params = new HashMap<String, String>();
	 	String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);
	}
	
	@Test(priority = 17, groups = "lookup")
	public void lookupbillType() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/lookup/billType";
		String ver = "4.0";
		String jpath = "./\\TestData\\billTypev4.json";
	 	HashMap<String, String> params = new HashMap<String, String>();
	 	String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);
	}
	
	
	@Test(priority = 18, groups = "lookup")
	public void lookupbillingPrepareType() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/lookup/billingPrepareType";
		String ver = "4.0";
		String jpath = "./\\TestData\\billingPrepareTypev4.json";
	 	HashMap<String, String> params = new HashMap<String, String>();
	 	String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);
	}
	
}

	
	
	
	
