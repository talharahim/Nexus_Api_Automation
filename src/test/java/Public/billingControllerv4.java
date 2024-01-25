package Public;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;
import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class billingControllerv4 extends BaseClass {

	public static JsonPath jsonPathEvaluator;

	@Test(priority = 1, groups = "Billing")
	public void TC001_getutilitySetup() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// extent.createTest("Test", "");
		String uri = "/billing/utilitySetup";
		String ver = "4.0";
		String jpath = "./\\TestData\\getutilitySetup_v4.json";
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("ConnectionSequence", "1");
		String result = CommonMethods.getMethodContains(uri, ver, params, jpath);
		System.out.println(result);
	}

	@Test(priority = 2, groups = "Billing")
	public void TC002_getbillBatchStatus()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// extent.createTest("Test", "");
		String uri = "/billing/billBatchStatus/BAT012301203";
		String ver = "4.0";
		String jpath = "./\\TestData\\billBatchStatus_v4.json";
		HashMap<String, String> params = new HashMap<String, String>();
		// params.put("ConnectionSequence", "1");
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);
	}

	@Test(priority = 3, groups = "Billing")
	public static void PostBillingcalculatev4()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/billing/calculate";
		String ver = "4.0";
		String payload = "{\n" + "    \"Billing\": {\n" + "        \"BatchId\": \"DUMMY\",\n"
				+ "        \"BillingType\": 2,\n" + "        \"PrepareType\": 2,\n" + "        \"PrepareValue\": [\n"
				+ "            \"002\"\n" + "        ],\n" + "        \"PeriodStartDate\": \"2000-04-01\",\n"
				+ "        \"PeriodEndDate\": \"2000-05-01\",\n" + "        \"ReadingDate\": \"2000-05-01\",\n"
				+ "        \"BillingDate\": \"2000-05-01\",\n" + "        \"PowerFactor\": 0,\n"
				+ "        \"BtuPgaFactorDate\": \"2000-01-01\",\n" + "        \"Cycle\": {\n"
				+ "            \"Id\": \"\",\n" + "            \"BillingPeriod\": 0\n" + "        }\n" + "    }\n"
				+ "}";
		String filepath = "./\\TestData\\PostBillingcalculatev4.json";
		FileWriter file = new FileWriter(filepath);
		file.write(payload);
		file.close();
		jsonPathEvaluator = CommonMethods.postMethod(filepath, uri, ver);
		Boolean Result = jsonPathEvaluator.get("Billing.Success");
		System.out.println(Result);
		if (!Result) {

			Assert.fail("Bill Calculation Failed");

		}
	}

	@Test(priority = 4, groups = "Billing")
	public void getbillprintTemplatePath()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// extent.createTest("Test", "");
		String uri = "/billing/printTemplatePath";
		String ver = "4.0";
		String jpath = "./\\TestData\\printTemplatePathv4.json";
		HashMap<String, String> params = new HashMap<String, String>();
		// params.put("ConnectionSequence", "1");
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);
	}
	
	
	@Test(priority = 5, groups = "Billing")
	public static void postBillingStatementv4()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/billing/createStatement";
		String ver = "4.0";
		String payload = "{\n"
				+ "    \"Billing\":{\n"
				+ "        \"BatchId\":\"BT1231\",\n"
				+ "        \"Confirm\": {\n"
				+ "            \"IgnoreMiscChargeOrCreditValidation\": false\n"
				+ "        }\n"
				+ "    }\n"
				+ "}";
		String filepath = "./\\TestData\\postBillingStatementv4.json";
		FileWriter file = new FileWriter(filepath);
		file.write(payload);
		file.close();
		jsonPathEvaluator = CommonMethods.postMethod(filepath, uri, ver);
		Boolean Result = jsonPathEvaluator.get("Billing.Success");
		System.out.println(Result);
		if (!Result) {

			Assert.fail("Bill Posting Failed");

		}
	}
	
	@Test(priority = 6, groups = "Billing")
	public static void postcreateStatementv4()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/billing/createStatement";
		String ver = "4.0";
		String payload = "{\n"
				+ "    \"Billing\":{\n"
				+ "        \"BatchId\":\"BT1231\",\n"
				+ "        \"Confirm\": {\n"
				+ "            \"IgnoreMiscChargeOrCreditValidation\": false\n"
				+ "        }\n"
				+ "    }\n"
				+ "}";
		String filepath = "./\\TestData\\postBillingStatementv4.json";
		FileWriter file = new FileWriter(filepath);
		file.write(payload);
		file.close();
		jsonPathEvaluator = CommonMethods.postMethod(filepath, uri, ver);
		Boolean Result = jsonPathEvaluator.get("Billing.Success");
		System.out.println(Result);
		if (!Result) {

			Assert.fail("Bill Posting Failed");

		}
	}
	
	
	@Test(priority = 7, groups = "Billing")
	public static void postBillingv4()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/billing/postingBill";
		String ver = "4.0";
		String payload = "{\n"
				+ "    \"Billing\": {\n"
				+ "        \"BatchId\": \"BAT012301203\",\n"
				+ "        \"Document\": []\n"
				+ "    }\n"
				+ "}";
		String filepath = "./\\TestData\\postingBillv4.json";
		FileWriter file = new FileWriter(filepath);
		file.write(payload);
		file.close();
		jsonPathEvaluator = CommonMethods.postMethod(filepath, uri, ver);
		Boolean Result = jsonPathEvaluator.get("Billing.Success");
		System.out.println(Result);
		if (Result) {
			Assert.fail("Bill Posting success");

		}
	}
	
	
	@Test(priority = 8, groups = "Billing")
	public static void generateEditReportv4()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/billing/generateEditReport";
		String ver = "4.0";
		String payload = "{\n"
				+ "    \"Billing\": {\n"
				+ "        \"BatchId\": \"BT1231\"\n"
				+ "    }\n"
				+ "}";
		String filepath = "./\\TestData\\generateEditReportv4.json";
		FileWriter file = new FileWriter(filepath);
		file.write(payload);
		file.close();
		jsonPathEvaluator = CommonMethods.postMethod(filepath, uri, ver);
		Boolean Result = jsonPathEvaluator.get("Billing.Success");
		System.out.println(Result);
		if (!Result) {

			Assert.fail("Bill Posting was success");

		}
	}
	
	@Test(priority = 9, groups = "Billing")
	public static void billingprintStatementv4()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/billing/printStatement";
		String ver = "4.0";
		String payload = "{\n"
				+ "    \"Billing\":{\n"
				+ "        \"ExportToCSV\": true,\n"
				+ "        \"IncludeEbills\": true,\n"
				+ "        \"PrintAction\": 1,\n"
				+ "        \"BatchId\": \"BT1231\",\n"
				+ "        \"Confirm\": {\n"
				+ "            \"RefreshBillPrintData\": true\n"
				+ "        }\n"
				+ "    }\n"
				+ "}";
		String filepath = "./\\TestData\\billingprintStatement.json";
		FileWriter file = new FileWriter(filepath);
		file.write(payload);
		file.close();
		jsonPathEvaluator = CommonMethods.postMethod(filepath, uri, ver);
		Boolean Result = jsonPathEvaluator.get("Billing.Success");
		System.out.println(Result);
		if (!Result) {

			Assert.fail("Bill Posting was success");

		}
	}
	
	
	

	@Test(priority = 10, groups = "Billing")
	public void printcsvbillingStatements()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// extent.createTest("Test", "");
		String uri = "/print/csv/billingStatements";
		String ver = "4.0";
		String jpath = "./\\TestData\\printcsvbillingStatementsv4.json";
		HashMap<String, String> params = new HashMap<String, String>();
		// params.put("ConnectionSequence", "1");
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);
	}
	
	

}
