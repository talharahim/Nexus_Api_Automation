package Public;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.path.json.JsonPath;

public class checkControllerv4 {

	
	public static JsonPath jsonPathEvaluator;

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

}
