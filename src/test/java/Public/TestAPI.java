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

	

	@Test(priority = 4,  groups = "SPA")
	public void recancelSPA_v_2() throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String customerId = "500300";
		String spaIndexfromdb = CommonMethods.getSPAIndex(customerId);
		System.out.println("SPA Index from DB ="+spaIndexfromdb);
		Boolean res = CommonMethods.cancelSpa(spaIndexfromdb, customerId);

		
		String uri = "/spa/calculate";
		String ver = "2";
		String jpath = "./\\TestData\\calculateddocumentsv2.json";

		ValidatableResponse result = CommonMethods.putMethod(uri, ver, jpath);
		result.assertThat().body(Matchers.containsString("true"));
		System.out.println(result.extract().asString());

		System.out.println(res);
	}

}
