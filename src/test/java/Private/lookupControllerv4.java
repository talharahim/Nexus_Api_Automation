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
		String jpath = "./\\TestData\\lookupMeterReadv4.json";
	 	HashMap<String, String> params = new HashMap<String, String>();
		// params.put("Batchsource", "NONE");  //params.put("LocationId", "LOCATION011"); 
		String result = CommonMethods.getMethod(uri3, ver, params, jpath);
		System.out.println(result);
	}
	
	
	
	
	
}