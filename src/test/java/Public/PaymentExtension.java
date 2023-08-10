package Public;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.path.json.JsonPath;

public class PaymentExtension {

	public static JsonPath jsonPathEvaluator;
	
	@Test(priority = 1, groups = "Cashering")
	public void postPaymentv2() throws ClassNotFoundException, SQLException, InterruptedException {
		String uri = "/payment";
		String ver = "2";
		String payload = "./\\TestData\\PostPayment2_1.json";
		jsonPathEvaluator = CommonMethods.postMethod(payload, uri, ver);
		Boolean Result = jsonPathEvaluator.get("result[0].Success");
		
		if (Result == false) {
			System.out.println(jsonPathEvaluator.toString());
			Assert.fail();
		}
		System.out.println(jsonPathEvaluator.toString());
	}

	@Test(priority = 2, groups = "Cashering")
	public void paymentExtensionv2() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
	//	CommonMethods.CompanyDBRestore();
		String uri = "/paymentextension";
		String ver = "2";
		String payload = "./\\TestData\\PayementExtension.json";
		jsonPathEvaluator = CommonMethods.postMethod(payload, uri, ver);
		System.out.println(jsonPathEvaluator.get().toString());
		String Result = jsonPathEvaluator.get("PaymentExtension.Messages[0].Info");
		
		if (Result == "Payment extensions are not allowed. A payment extension already exist or invalid date condition.") {
			Assert.fail();
		}
		else {
			System.out.println(jsonPathEvaluator.toString());
		}

	}

	
	@Test(priority = 3, groups = "Cashering")
	public void postPaymentv2_2() throws ClassNotFoundException, SQLException, InterruptedException {
		String uri = "/payment";
		String ver = "2";
		String payload = "./\\TestData\\PostPayment2_1.json";
		jsonPathEvaluator = CommonMethods.postMethod(payload, uri, ver);
		Boolean Result = jsonPathEvaluator.get("result[0].Success");
		System.out.println(jsonPathEvaluator.toString());
		if (Result != false) {
			Assert.fail();
		}

	}
	
	
	
}
