package Public;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

public class customerController_v2 {

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
	public void getCustomerbylocation_v_2()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/customer/getCustomersByLocation";
		String ver = "2";
		String jpath = "./\\TestData\\customerbylocationv2.json";

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("LocationId", "WATER003");

		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);

	}

	@Test(priority = 3, groups = "CustomerController")
	public void getCustomerBillingOptions_v2()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/customers/Customer003/billingoptions";
		String ver = "2";
		String jpath = "./\\TestData\\getcustomerbillingoptionsv2.json";
		HashMap<String, String> params = new HashMap<String, String>();
		// params.put("LocationId", "WATER003");
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);

	}

	@Test(priority = 4, groups = "CustomerController")
	public void getCollectionsoptions_v2()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/customers/customer003/collectionsoptions";
		String ver = "2";
		String jpath = "./\\TestData\\getcollectionsoptionsv2.json";
		HashMap<String, String> params = new HashMap<String, String>();
		// params.put("LocationId", "WATER003");
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);

	}

	@Test(priority = 5, groups = "CustomerController")
	public void getOtheroptions_v2() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/customers/CUSTOMER003/otheroptions";
		String ver = "2";
		String jpath = "./\\TestData\\customerotheroptions2.json";
		HashMap<String, String> params = new HashMap<String, String>();
		// params.put("LocationId", "WATER003");
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);

	}

	@Test(priority = 6, groups = "CustomerController")
	public void getinfolabels_v2() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/customers/infoLabels";
		String ver = "2";
		String jpath = "./\\TestData\\customersinfoLabelsv2.json";

		HashMap<String, String> params = new HashMap<String, String>();
		// params.put("LocationId", "WATER003");
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);

	}

	@Test(priority = 7, groups = "CustomerController")
	public void getLocationsByCustomer_v2()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/customer/getLocationsByCustomer";
		String ver = "2";
		String jpath = "./\\TestData\\getLocationsByCustomerv2.json";

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("CustomerId", "AUTO1001");
		params.put("LocationId", "LOCATION008");
		params.put("PageSize", "50");
		params.put("PageSelected", "1");
		params.put("ExcludeFormerLocationsWithZeroBalance", "");

		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);

	}

	@Test(priority = 7, groups = "CustomerController")
	public void getnextCustomerId_v2() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/customers/nextCustomerId";
		String ver = "2";
		// String jpath = "./\\TestData\\getnextCustomerIdv2.json";

		HashMap<String, String> params = new HashMap<String, String>();
		/*
		 * params.put("CustomerId", "AUTO1001"); params.put("LocationId",
		 * "LOCATION008"); params.put("PageSize", "50"); params.put("PageSelected",
		 * "1"); params.put("ExcludeFormerLocationsWithZeroBalance", "");
		 */

		JsonPath jsonPathEvaluator = CommonMethods.getMethod(uri, ver);
		Boolean Result = jsonPathEvaluator.get("GetNextCustomerId[0].Success");
		if (!Result) {
			Assert.fail(uri + " Next id failed");
		}

		String CustId = jsonPathEvaluator.get("GetNextCustomerId[0].CustomerId");
		if (!CustId.contains("CUS@")) {
			System.out.println(CustId);
			Assert.fail();
		}

	}

	@Test(priority = 8, groups = "CustomerController")
	public void getCustomerDetail_v2() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/customer/getCustomerDetail";
		String ver = "2";
		String jpath = "./\\TestData\\getCustomerDetailv2.json";
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("CustomerId", "customer003");
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);
	}

	@Test(priority = 9, groups = "CustomerController")
	public void getpreauthorizepaymentplan_v2()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/customers/103900/preauthorizedPaymentPlan/external";
		String ver = "2";
		/*
		 * / String jpath = "./\\TestData\\getCustomerDetailv2.json"; // HashMap<String,
		 * String> params = new HashMap<String, String>(); // params.put("CustomerId",
		 * "customer003");
		 */
		JsonPath jsonPathEvaluator = CommonMethods.getMethod(uri, ver);
		Boolean Result = jsonPathEvaluator.get("PreauthorizedPaymentPlan.Success");
		if (!Result) {
			Assert.fail(uri + " Next id failed");
		}

	}

	@Test(priority = 10, groups = "CustomerController")
	public void putcustomersaddressv2() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/customers/address";
		String ver = "2";
		String jpath = "./\\TestData\\putcustomersaddressv2.json";
		String jrpath = "./\\TestData\\putcustomersaddressrespv2.json";
		ValidatableResponse result = CommonMethods.putMethodvalidate(uri, ver, jpath, jrpath);
//		System.out.println(result.log());

	}
	
	@Test(priority = 11, groups = "CustomerController")
	public void putcustomerbillingoptionv2() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/customers/billingOptions";
		String ver = "2";
		String jpath = "./\\TestData\\putcustomersbillingOptionsv2.json";
		String jrpath = "./\\TestData\\putcustomersbillingOptionsrespv2.json";
		ValidatableResponse result = CommonMethods.putMethodvalidate(uri, ver, jpath, jrpath);
//		System.out.println(result.log());

	}
	
	@Test(priority = 12, groups = "CustomerController")
	public void putcustomerscollectionsOptionsv2() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/customers/collectionsOptions";
		String ver = "2";
		String jpath = "./\\TestData\\putcustomerscollectionsOptionsv2.json";
		String jrpath = "./\\TestData\\putcustomerscollectionsOptionsrespv2.json";
		ValidatableResponse result = CommonMethods.putMethodvalidate(uri, ver, jpath, jrpath);
//		System.out.println(result.log());

	}
	
	@Test(priority = 13, groups = "CustomerController")
	public void putcustomersotherOptionsv2() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/customers/otherOptions";
		String ver = "2";
		String jpath = "./\\TestData\\putcustomersotherOptionsv2.json";
		String jrpath = "./\\TestData\\putcustomersotherOptionsrespv2.json";
		ValidatableResponse result = CommonMethods.putMethodvalidate(uri, ver, jpath, jrpath);
//		System.out.println(result.log());

	}


}