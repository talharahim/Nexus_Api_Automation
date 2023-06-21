package Public;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.response.ValidatableResponse;

public class connectionControllerv4 {

	public static ValidatableResponse jsonPathEvaluator;

	//@Test(priority = 1, groups = "ConsumptionHistoryController")
	public void putconnectionmeterGroupV4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/connection/meterGroup";
		String ver = "4.0";
		String jpath = "./\\TestData\\consumptionHist.json";
						
		String params =null;
		ValidatableResponse result = CommonMethods.putMethod(uri, ver, params , jpath);
		System.out.println(result);
		
	}
	
	@Test(priority = 1, groups = "ConnectionController")
	public void getconnectionV4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/connection/ELECWAT003/";
		String ver = "4.0";
		String jpath = "./\\TestData\\getConnectionv4.json";
						
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("ConnectionSequence", "1");
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);
		
	}
	
	
	
		
	

}