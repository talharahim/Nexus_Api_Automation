package Public;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.path.json.JsonPath;

public class CashieringPost {

	public static JsonPath jsonPathEvaluator;
	public static String nextRecieptNumber;

	@Test(priority = 1, groups = "Cashering")
	public void TC001_saveReciept() throws ClassNotFoundException, SQLException, InterruptedException {

		
		JsonPath next = CommonMethods.getMethod("/cashiering/receipt/TRREG000001/nextReceipt", "2.4");
		nextRecieptNumber =next.get("Receipt[0].ReceiptNumber");

		String uri = "/cashiering/receipt";
		String ver = "2.4";
		
		
		//String payload = "./\\TestData\\saveReciept.json";
		String payload = "{\"Receipt\":{\"ReceiptNumber\":\""+nextRecieptNumber+"\",\"OriginatingReceiptNumber\":\"\",\"Void\":false,\"CustomerId\":\"CUSTOMER008\",\"LocationId\":\"LOCATION007\",\"PaymentOrigin\":\"TEST\",\"CheckbookId\":\"FIRST NATIONAL\",\"PaidBy\":{\"Type\":1,\"Description\":\"\",\"Id\":\"\"},\"Cash\":185.42,\"Check\":{\"Amount\":0,\"Number\":\"\"},\"CreditCard\":{\"Amount\":0},\"Unapplied\":{\"Amount\":0,\"Account\":\"\",\"LocationId\":\"\"},\"Change\":0,\"Comment\":\"ThisisacommenttobesavedintocommentinUMRM102\",\"Document\":[{\"Number\":\"MISC00000000317\",\"LocationId\":\"LOCATION007\",\"StatementNumber\":0,\"ApplyAmount\":185.42,\"OutstandingAmount\":0,\"ReferenceDocumentNumber\":\"\"}]}}";
		jsonPathEvaluator = CommonMethods.postMethodStringPayload(payload, uri, ver);
		Boolean Result = jsonPathEvaluator.get("Receipt.Success");
		System.out.println(jsonPathEvaluator.get().toString().toString());
		if (Result == false) {
			Assert.fail();
		}
		

	}

	@Test(priority = 2, groups = "Cashering", dependsOnMethods = "TC001_saveReciept")
	public void TC002_RecieptAdjustment() throws ClassNotFoundException, SQLException, InterruptedException {
	
		String uri = "/cashiering/receipt/adjust";
		String ver = "2.4";
		//String payload = "./\\TestData\\recieptAdjust.json";
		
		String payload = "{\"Receipt\":{\"ReceiptNumber\":\""+nextRecieptNumber+"\",\"Comment\":\"NexusAPIadjustment\"}}";
		jsonPathEvaluator = CommonMethods.postMethodStringPayload(payload, uri, ver);
		Boolean Result = jsonPathEvaluator.get("Receipt.Success");
		System.out.println(jsonPathEvaluator.get().toString().toString());
		if (Result == false) {
			Assert.fail();
		}

	}

}
