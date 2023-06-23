package Public;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

public class checkControllerv4 {

	public static JsonPath jsonPathEvaluator;
	
	//If an error is thrown then you might need to restore database

	@Test(priority = 1, groups = "Cashering")
	public void getCheckv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/check/CHEQ00000000009";
		String ver = "4.0";
		String jpath = "./\\TestData\\getCheckv4.json";
		HashMap<String, String> params = new HashMap<String, String>();
		//params.put("SearchQuery", "sally");
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);

	}
	

	@Test(priority = 1, groups = "Cashering", dependsOnMethods = "getCheckv4" )
	public void delCheckv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/check/CHEQ00000000009";
		String ver = "4.0";
		String jpath = "/\\TestData\\delCheckv4.json";
		ValidatableResponse result = CommonMethods.deleteMethod(uri, ver, jpath);
		System.out.println(result.toString());

	}
		
}
