package Public;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PaymentControllerV4 {

	public static JsonPath jsonPathEvaluator;

	@Test(priority = 1, groups = "Payment")
	public void postPaymentv4() throws ClassNotFoundException, SQLException, InterruptedException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/payment";
		String ver = "4.0";
		String payload = "./\\TestData\\PostPaymentv4.json";
		jsonPathEvaluator = CommonMethods.postMethod(payload, uri, ver);
		Boolean Result = jsonPathEvaluator.get("result[0].Success");
		if (Result == false) {
			System.out.println(jsonPathEvaluator.prettyPrint());
			Assert.fail(jsonPathEvaluator.prettyPrint());
		}
		// System.out.println(jsonPathEvaluator.toString());
		System.out.println();
	}

	@Test(priority = 2, groups = "Payment")
	public void postPaymentBatchv4() throws ClassNotFoundException, SQLException, InterruptedException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/payment/paymentBatch";
		String ver = "4.0";
		String payload = "./\\TestData\\paymentBatchv4.json";
		jsonPathEvaluator = CommonMethods.postMethod(payload, uri, ver);
		Boolean Result = jsonPathEvaluator.get("Payment.Success");
		if (Result == false) {
			System.out.println(jsonPathEvaluator.prettyPrint());
			Assert.fail(jsonPathEvaluator.prettyPrint());
		}
		// System.out.println(jsonPathEvaluator.toString());
	}

	@Test(priority = 3, groups = "Payment")
	public void gettPaymentNextv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/payment/next";
		String ver = "4.0";
		String expected = "./\\TestData\\gettPaymentNextv4.json";
		HashMap<String, String> params = new HashMap<String, String>();
		// params.put("ConnectionSequence", "1");
		String result = CommonMethods.getMethod(uri, ver, params, expected);
		System.out.println(result);

	}

	

	

}
