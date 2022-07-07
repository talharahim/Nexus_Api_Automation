package Public;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.path.json.JsonPath;

public class CashieringPost {

	public static JsonPath jsonPathEvaluator;


	@Test(priority = 1, groups = "Cashering" )
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
	
	@Test(priority = 2, groups = "Cashering", dependsOnMethods ="TC002_saveReciept")
	public void TC001_RecieptAdjustment() throws ClassNotFoundException, SQLException, InterruptedException {
	//	CommonMethods.CompanyDBRestore();
		String uri = "/cashiering/receipt/adjust";
		String ver = "2.4";
		String payload = "./\\TestData\\recieptAdjust.json";
		jsonPathEvaluator = CommonMethods.postMethod(payload, uri, ver);
		Boolean Result = jsonPathEvaluator.get("Receipt.Success");
		System.out.println(jsonPathEvaluator.get().toString().toString());
		if (Result == false) {
			Assert.fail();
		}

	}
	
	
}
