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

	@Test(priority = 6, groups = "SPA")
	public void getcalculatedocuments_v_2()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/spa/CUSTOMER002/documents/1/1";
		String ver = "2";
		String jpath = "./\\TestData\\getcalculateddocumentsv2.json";

		HashMap<String, String> params = new HashMap<String, String>();
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);

	}
}