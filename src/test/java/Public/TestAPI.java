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


	//@Test(priority = 1, groups = "Cashering" )
	public void TC002_saveReciept() throws ClassNotFoundException, SQLException, InterruptedException {

		//CommonMethods.CompanyDBRestore();
		String uri = "/cashiering/receipt";
		String ver = "2.4";
		String payload = "./\\TestData\\saveReciept.json";
		CommonMethods.postMethod(payload, uri, ver);
		jsonPathEvaluator = CommonMethods.postMethod(payload, uri, ver);
		Boolean Result = jsonPathEvaluator.get("Receipt.Success");
		System.out.println(jsonPathEvaluator.get().toString().toString());
		if (Result == false) {
			Assert.fail();
		}

	}
}
	