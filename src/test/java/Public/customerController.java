package Public;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.response.ValidatableResponse;

public class customerController {

	public static ValidatableResponse jsonPathEvaluator;

	@Test(priority = 1, groups = "CustomerController")
	public void getCustomerDetail_v_2() throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/customer/getCustomerDetail";
		String ver = "2";
		String jpath = "./\\TestData\\customerDetailsv2.json";
				
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("CustomerId", "customer003");
				
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);
		
	}
	
	@Test(priority = 2, groups = "CustomerController")
	public void getCustomerbylocation_v_2() throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/customer/getCustomersByLocation";
		String ver = "2";
		String jpath = "./\\TestData\\customerbylocationv2.json";
				
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("LocationId", "WATER003");
		
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);
		
	}
	
	@Test(priority = 3, groups = "CustomerController")
	public void getlocationsByCustomerv_2_4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/customers/AUTO1001/locationsByCustomer";
		String ver = "2.4";
		String jpath = "./\\TestData\\locationsByCustomerv2_4.json";
				
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("LocationId", "LOCATION008");
		params.put("NumPerPage", "50");
		params.put("OrderBy", "status, locationId");
		params.put("PageNum", "1");
				
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);
		
	}
	
		
	

}