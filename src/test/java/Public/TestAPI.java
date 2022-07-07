package Public;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

public class TestAPI {

	public static JsonPath jsonPathEvaluator;

	@Test(priority = 7, groups = "Cashering")
	public void TC007_getAutoApply() throws ClassNotFoundException, SQLException, InterruptedException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/cashiering/autoApply";
		String ver = "2.4";
		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put("CustomerId", "CUSTOMER010");
		responseMap.put("LocationId", "LOCATION009");
		responseMap.put("ReceiptNumber", "0123555555");
		responseMap.put("ApplyAmount", "50.00");
		responseMap.put("PaymentOrigin", "TEST");
		jsonPathEvaluator = CommonMethods.getMethod(uri, ver, responseMap);
		System.out.println(jsonPathEvaluator.get().toString());
		// String Result = jsonPathEvaluator.get("CashieringTransaction.CustomerId");
		String Result = jsonPathEvaluator.getJsonObject("CashieringTransaction.CustomerId[0]");
 
		if (!Result.contentEquals("CUSTOMER010"))
			Assert.fail(Result);
			Result = jsonPathEvaluator.get("CashieringTransaction.Document[0].Number[0]");
		if (!Result.contentEquals("BILL00000000374"))
			Assert.fail(Result);
	}
}
