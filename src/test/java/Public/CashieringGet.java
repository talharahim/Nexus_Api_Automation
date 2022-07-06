 package Public;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CashieringGet {

	public static JsonPath jsonPathEvaluator;

	@Test(priority = 1, groups = "Cashering")
	public void TC003_getCashin() throws ClassNotFoundException, SQLException, InterruptedException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/cashiering/cashIn";
		String ver = "2.4";
		String payload = "";
		jsonPathEvaluator = CommonMethods.getMethod(uri, ver);
		System.out.println(jsonPathEvaluator.get().toString());
		Boolean Result = jsonPathEvaluator.get("CashedIn[0].IsCashedIn");

		if (Result == false) {
			Assert.fail();
		}

	}

	 @Test(priority = 2, groups = "Cashering", dependsOnMethods = "TC003_getCashin")
	public void TC004_balances() throws ClassNotFoundException, SQLException, InterruptedException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/cashiering/balances/customer006/1999-03-24";
		String ver = "2.4"; 

		jsonPathEvaluator = CommonMethods.getMethod(uri, ver);
		System.out.println(jsonPathEvaluator.get().toString());
		String Result = (jsonPathEvaluator.get("Cashiering[0].Amount[0].TotalBalanceDue")).toString();

		if (!Result.contains("64.57")) {
			Assert.fail(Result.toString());
		}

		Result = (jsonPathEvaluator.get("Cashiering[0].Amount[0].Current")).toString();

		if (!Result.contains("-115")) {
			Assert.fail(Result.toString());
		}

		Result = (jsonPathEvaluator.get("Cashiering[0].Amount[0].PastDue")).toString();

		if (!Result.contains("179.57")) {
			Assert.fail(Result.toString());
		}

	}

	 @Test(priority = 3, groups = "Cashering", dependsOnMethods = "TC004_balances")
	public void TC003_getnextReceipt() throws ClassNotFoundException, SQLException, InterruptedException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/cashiering/receipt/TRREG000001/nextReceipt";
		String ver = "2.4";
		String payload = "";
		jsonPathEvaluator = CommonMethods.getMethod(uri, ver);
		System.out.println(jsonPathEvaluator.get().toString());
		Boolean Result = jsonPathEvaluator.get("Receipt[0].Success");

		if (!Result == true) {
			Assert.fail();
		}

	}

	@Test(priority = 4, groups = "Cashering", dependsOnMethods = "TC003_getnextReciept")
	public void TC004_getReceipt() throws ClassNotFoundException, SQLException, InterruptedException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/cashiering/receipt/004270412000001";
		String ver = "2.4";
		String payload = "";
		jsonPathEvaluator = CommonMethods.getMethod(uri, ver);
		System.out.println(jsonPathEvaluator.get().toString());
		String Result = jsonPathEvaluator.get("Receipt.PreviousReceiptNumber");

		if (!Result.contentEquals("004211025000003")) {
			Assert.fail(Result);
		}

		Result = jsonPathEvaluator.get("Receipt.ReceiptNumber");

		if (!Result.contentEquals("004270412000001")) {
			Assert.fail(Result);
		}

	}

	@Test(priority = 5, groups = "Cashering", dependsOnMethods = "TC004_getReceipt")
	public void TC005_getRegisterInfo() throws ClassNotFoundException, SQLException, InterruptedException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/cashiering/register/TRREG000001/info";
		String ver = "2.4";
		jsonPathEvaluator = CommonMethods.getMethod(uri, ver);
		System.out.println(jsonPathEvaluator.get().toString());
		String Result = jsonPathEvaluator.get("Register[0].RegId");

		if (!Result.contentEquals("4")) {
			Assert.fail();
		}

		Result = jsonPathEvaluator.get("Register[0].RegisterId");

		if (!Result.contentEquals("TRREG000001")) {
			Assert.fail();
		}

	}

    @Test(priority = 6, groups = "Cashering", dependsOnMethods = "TC005_getRegisterInfo")
	public void TC006_gettransactions() throws ClassNotFoundException, SQLException, InterruptedException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/cashiering/transactions/customer017";
		String ver = "2.4";
		jsonPathEvaluator = CommonMethods.getMethod(uri, ver);
		System.out.println(jsonPathEvaluator.get().toString());
		String Result = jsonPathEvaluator.get("CashieringTransaction[0].CustomerId");

		if (!Result.contentEquals("customer017")) {
			Assert.fail();
		}

	}

	@Test(priority = 7, groups = "Cashering", dependsOnMethods = "TC006_gettransactions")
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
