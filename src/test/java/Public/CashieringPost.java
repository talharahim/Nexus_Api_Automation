package Public;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.path.json.JsonPath;

public class CashieringPost {

	public static JsonPath jsonPathEvaluator;

	@Test(priority = 1, groups = "Cashering")
	public void TC001_saveReciept() throws ClassNotFoundException, SQLException, InterruptedException {

		Thread.sleep(5000);
		JsonPath next = CommonMethods.getMethod("/cashiering/receipt/TRREG000001/nextReceipt", "2.4");
		Assert.assertEquals(next.get("Receipt[0].ReceiptNumber"), "004220707000001");

		// CommonMethods.CompanyDBRestore();
		String uri = "/cashiering/receipt";
		String ver = "2.4";
		String payload = "./\\TestData\\saveReciept.json";
		jsonPathEvaluator = CommonMethods.postMethod(payload, uri, ver);
		Boolean Result = jsonPathEvaluator.get("Receipt.Success");
		System.out.println(jsonPathEvaluator.get().toString().toString());
		if (Result == false) {
			Assert.fail();
		}
		Thread.sleep(25000);

	}

	@Test(priority = 2, groups = "Cashering", dependsOnMethods = "TC001_saveReciept")
	public void TC002_RecieptAdjustment() throws ClassNotFoundException, SQLException, InterruptedException {
		// CommonMethods.CompanyDBRestore();
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
