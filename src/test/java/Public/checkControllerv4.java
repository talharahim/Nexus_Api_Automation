package Public;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

public class checkControllerv4 {
	public static String chq;

	public static JsonPath jsonPathEvaluator;

	@Test(priority = 1, groups = "check")
	public static void PostCheckv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/check";
		String ver = "4.0";
		String payload = "./\\TestData\\postcheckv4.json";
		jsonPathEvaluator = CommonMethods.postMethod(payload, uri, ver);
		Boolean Result = jsonPathEvaluator.get("Check.Success");
		chq = jsonPathEvaluator.get("Check.Data.DocumentNumber");
		System.out.println(Result);
		System.out.println(chq);
		if (Result != null) {
			if (Result == false) {
				System.out.println("Unable to post check, check data" + Result);
			}
		}
		getCheckv4(chq);

	}

	// If an error is thrown then you might need to restore database

	// @Test(priority = 2, groups = "check", dependsOnMethods = "PostCheckv4")
	public static void getCheckv4(String str)
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/check/".concat(str);
		String ver = "4.0";
		String jpath = "./\\TestData\\getCheckv4.json";
		HashMap<String, String> params = new HashMap<String, String>();
		// params.put("SearchQuery", "sally");
		String result = CommonMethods.getMethodContains(uri, ver, params, jpath);
		System.out.println(result);
		delCheckv4(str);

	}

	// @Test(priority = 3, groups = "check")
	public static void delCheckv4(String str)
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/check/".concat(str);
		String ver = "4.0";
		String jpath = "./\\TestData\\delCheckv4.json";
		ValidatableResponse result = CommonMethods.deleteMethod(uri, ver, jpath);
		System.out.println(result.toString());

	}

	@Test(priority = 4, groups = "check")
	public void getCheckSetupv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/check/setup";
		String ver = "4.0";
		jsonPathEvaluator = CommonMethods.getMethod(uri, ver);
		Boolean Result = jsonPathEvaluator.get("Check.Success");
		if (!Result.equals(false)) {
			Assert.fail(null);
		}

	}

	@Test(priority = 5, groups = "check")
	public static void getNextCheckv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/check/nextCheck";
		String ver = "4.0";
		JsonPath result = CommonMethods.getMethod(uri, ver);
		System.out.println(result.getString("Check"));
		String j = result.getString("Check");
		if (!j.contains("CHEQ000000000")) {
			Assert.fail("next Check API is failed");
		}
		if (!j.contains("Success:true")) {
			Assert.fail("next Check API is failed");
		}
	}

	@Test(priority = 5, groups = "check")
	public static void putCheckv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/check";
		String ver = "4.0";
		String jpath = "./\\TestData\\putCheckv4.json";
		String params = new String(Files.readAllBytes(Paths.get(jpath)));
		String expected = "./\\TestData\\putCheckv4expected_v4.json";
		ValidatableResponse result = CommonMethods.putMethod(uri, ver, params, expected);

	}

	public static void main(String args[])
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		PostCheckv4();

	}

}
