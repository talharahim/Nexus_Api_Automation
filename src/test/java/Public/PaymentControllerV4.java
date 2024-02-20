package Public;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.path.json.JsonPath;

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
			System.out.println(jsonPathEvaluator.toString());
			Assert.fail();
		}
		System.out.println(jsonPathEvaluator.toString());
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
			System.out.println(jsonPathEvaluator.toString());
			Assert.fail();
		}
		System.out.println(jsonPathEvaluator.toString());
	}
	
	

}
