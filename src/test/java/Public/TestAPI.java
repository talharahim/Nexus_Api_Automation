package Public;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

public class TestAPI {

	public static JsonPath jsonPathEvaluator;

	
	@Test(priority = 5, groups = "ServiceOrder")
	public static void putaddMeterReading_v_2()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/serviceOrder/detail";
		String ver = "3.0";
		String jpath = "./\\TestData\\serviceorderrequestdetailsOptionalv3.json";
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("ServiceOrderNumber", "SORD00000000002");
		params.put("ShowDrillBack", "true");
		params.put("IncludeHistory", "true");
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);
	}
	
}
