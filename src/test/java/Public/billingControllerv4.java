package Public;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;
import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class billingControllerv4 extends BaseClass {

	public static JsonPath jsonPathEvaluator;

	@Test(priority = 1, groups = "Billing")
	public void TC001_getutilitySetup() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		//extent.createTest("Test", "");
		String uri = "/billing/utilitySetup";
		String ver = "4.0";
		String jpath = "./\\TestData\\getutilitySetup_v4.json";
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("ConnectionSequence", "1");
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);
	}
}
