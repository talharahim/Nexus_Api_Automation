package Private;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.response.ValidatableResponse;

public class lookupControllerv4 {

	@Test(priority = 4, groups = "lookup")
	public void getapplyByService_v4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/lookupBatch";
		String ver = "4.0";
		String jpath = "./\\TestData\\lookupBatch_v4.json";
		HashMap<String, String> params = new HashMap<String, String>();
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
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
	
}