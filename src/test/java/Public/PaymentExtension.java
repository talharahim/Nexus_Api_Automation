package Public;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.path.json.JsonPath;

public class PaymentExtension {

	public static JsonPath jsonPathEvaluator;

	//@Test(priority = 1, groups = "Cashering")
	public void PaymentExtension_v2() throws ClassNotFoundException, SQLException, InterruptedException {
	//	CommonMethods.CompanyDBRestore();
		String uri = "/paymentextension";
		String ver = "2.0";
		String payload = "./\\TestData\\PayementExtension.json";
		jsonPathEvaluator = CommonMethods.postMethod(payload, uri, ver);
		Boolean Result = jsonPathEvaluator.get("Receipt.Success");
		System.out.println(jsonPathEvaluator.get().toString());
		if (Result == false) {
			Assert.fail();
		}

	}

	
	
	
}
