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
		String expected = "{\"Batch\":[{\"Id\":\"000700\",\"Description\":\"\"},{\"Id\":\"10001\",\"Description\":\"\"},{\"Id\":\"1001\",\"Description\":\"\"},{\"Id\":\"100111\",\"Description\":\"\"},{\"Id\":\"10111\",\"Description\":\"\"},{\"Id\":\"109090ABC\",\"Description\":\"\"},{\"Id\":\"12312312\",\"Description\":\"\"},{\"Id\":\"12345\",\"Description\":\"\"},{\"Id\":\"2.0.0\",\"Description\":\"\"},{\"Id\":\"ABC10001\",\"Description\":\"\"},{\"Id\":\"ABC1213\",\"Description\":\"\"},{\"Id\":\"API 20190430\",\"Description\":\"Payments from Web Service - API\"},{\"Id\":\"API 20190503\",\"Description\":\"Payments from Web Service - API\"},{\"Id\":\"API20220908001\",\"Description\":\"Payments from Nexus Api - API\"},{\"Id\":\"API20220929001\",\"Description\":\"Payments from Nexus Api - API\"},{\"Id\":\"API20230821001\",\"Description\":\"Payments from Nexus Api - API\"},{\"Id\":\"API8222023\",\"Description\":\"\"},{\"Id\":\"BAT012301203\",\"Description\":\"\"},{\"Id\":\"BAT1\",\"Description\":\"\"},{\"Id\":\"BAT10123123\",\"Description\":\"\"},{\"Id\":\"BT1231\",\"Description\":\"\"},{\"Id\":\"CHEQ1\",\"Description\":\"\"},{\"Id\":\"CHK041227sa01\",\"Description\":\"CHEQUE\"},{\"Id\":\"DPP041227sa01\",\"Description\":\"PYMT\"},{\"Id\":\"MISC10001\",\"Description\":\"\"},{\"Id\":\"NADMC2022093001\",\"Description\":\"API Deposit Misc Charge\"},{\"Id\":\"RM(3)120427\",\"Description\":\"\"},{\"Id\":\"Test Batch\",\"Description\":\"\"},{\"Id\":\"TEST109\",\"Description\":\"\"},{\"Id\":\"WO101619CRP001\",\"Description\":\"Write Off - sa\"}]}";
		HashMap<String, String> params = new HashMap<String, String>();
		String result = CommonMethods.getMethodasString(uri, ver, params);
		System.out.println(result);
		if (!expected.contentEquals(result)) 
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
	
	
}