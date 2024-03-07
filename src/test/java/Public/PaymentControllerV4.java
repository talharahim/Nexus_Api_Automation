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

	@Test(priority = 4, groups = "Payment")
	public void postPaymentSimulatev4() throws ClassNotFoundException, SQLException, InterruptedException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/payment/simulate";
		String ver = "4.0";
		String payload = "./\\TestData\\paymentsimulatev4.json";
		String exptected = "{\"Payment\":{\"Success\":true,\"Data\":{\"LocationId\":\"000000000523000\",\"CustomerId\":\"0012200\",\"CreditNoteId\":\"RMGT-OTH-000002\",\"TaxScheduleId\":\"ONT GST\\/PST\",\"Amount\":5.00,\"TotalTax\":0.00,\"TotalAmount\":5.00,\"UnappliedAmount\":5.00,\"DistributionDetail\":[{\"TypeId\":3,\"Type\":\"RECV\",\"Description\":\"Accounts Receivable\",\"Index\":6,\"Number\":\"000-1200-00\",\"DebitAmount\":0.00,\"CreditAmount\":5.00},{\"TypeId\":9,\"Type\":\"SALES\",\"Description\":\"Other Electric Revenues\",\"Index\":554,\"Number\":\"900-4740-00\",\"DebitAmount\":5.00,\"CreditAmount\":0.00}],\"DistributionTotal\":{\"DebitAmount\":5.00,\"CreditAmount\":5.00},\"TaxDetail\":[],\"Document\":[{\"Number\":\"BUDG00000002604\",\"LocationId\":\"000000000523000\",\"LocationAddress\":\"130 W SAMSULA DR\",\"StatementNumber\":0,\"Type\":[{\"Id\":7,\"Description\":\"Budget Document\"}],\"ServiceType\":[{\"Id\":\"\",\"Description\":\"\"}],\"Date\":\"2000-05-22\",\"DueDate\":\"2000-05-22\",\"Amount\":167.00,\"OutstandingAmount\":167.00,\"ApplyAmount\":0.00,\"Sequence\":1,\"ReferenceDocumentNumber\":\"BUDG00000002600\",\"ReferenceDocumentDate\":\"2000-01-01\",\"ServiceCategory\":[{\"Id\":0,\"Description\":\"\"}],\"Attribute\":[{\"ChargeType\":\"\",\"ChargeDescription\":\"\",\"PaymentOrigin\":\"\",\"SupportAuthorization\":0,\"Service\":[{\"Category\":0,\"Description\":\"\",\"Type\":\"\",\"Amount\":0.00,\"OutstandingAmount\":0.00,\"ApplyAmount\":0.00}]}]},{\"Number\":\"BUDG00000002605\",\"LocationId\":\"000000000523000\",\"LocationAddress\":\"130 W SAMSULA DR\",\"StatementNumber\":0,\"Type\":[{\"Id\":7,\"Description\":\"Budget Document\"}],\"ServiceType\":[{\"Id\":\"\",\"Description\":\"\"}],\"Date\":\"2000-06-21\",\"DueDate\":\"2000-06-21\",\"Amount\":167.00,\"OutstandingAmount\":167.00,\"ApplyAmount\":0.00,\"Sequence\":2,\"ReferenceDocumentNumber\":\"BUDG00000002600\",\"ReferenceDocumentDate\":\"2000-01-01\",\"ServiceCategory\":[{\"Id\":0,\"Description\":\"\"}],\"Attribute\":[{\"ChargeType\":\"\",\"ChargeDescription\":\"\",\"PaymentOrigin\":\"\",\"SupportAuthorization\":0,\"Service\":[{\"Category\":0,\"Description\":\"\",\"Type\":\"\",\"Amount\":0.00,\"OutstandingAmount\":0.00,\"ApplyAmount\":0.00}]}]},{\"Number\":\"BUDG00000002606\",\"LocationId\":\"000000000523000\",\"LocationAddress\":\"130 W SAMSULA DR\",\"StatementNumber\":0,\"Type\":[{\"Id\":7,\"Description\":\"Budget Document\"}],\"ServiceType\":[{\"Id\":\"\",\"Description\":\"\"}],\"Date\":\"2000-07-21\",\"DueDate\":\"2000-07-21\",\"Amount\":167.00,\"OutstandingAmount\":167.00,\"ApplyAmount\":0.00,\"Sequence\":3,\"ReferenceDocumentNumber\":\"BUDG00000002600\",\"ReferenceDocumentDate\":\"2000-01-01\",\"ServiceCategory\":[{\"Id\":0,\"Description\":\"\"}],\"Attribute\":[{\"ChargeType\":\"\",\"ChargeDescription\":\"\",\"PaymentOrigin\":\"\",\"SupportAuthorization\":0,\"Service\":[{\"Category\":0,\"Description\":\"\",\"Type\":\"\",\"Amount\":0.00,\"OutstandingAmount\":0.00,\"ApplyAmount\":0.00}]}]},{\"Number\":\"BUDG00000002607\",\"LocationId\":\"000000000523000\",\"LocationAddress\":\"130 W SAMSULA DR\",\"StatementNumber\":0,\"Type\":[{\"Id\":7,\"Description\":\"Budget Document\"}],\"ServiceType\":[{\"Id\":\"\",\"Description\":\"\"}],\"Date\":\"2000-08-21\",\"DueDate\":\"2000-08-21\",\"Amount\":167.00,\"OutstandingAmount\":167.00,\"ApplyAmount\":0.00,\"Sequence\":4,\"ReferenceDocumentNumber\":\"BUDG00000002600\",\"ReferenceDocumentDate\":\"2000-01-01\",\"ServiceCategory\":[{\"Id\":0,\"Description\":\"\"}],\"Attribute\":[{\"ChargeType\":\"\",\"ChargeDescription\":\"\",\"PaymentOrigin\":\"\",\"SupportAuthorization\":0,\"Service\":[{\"Category\":0,\"Description\":\"\",\"Type\":\"\",\"Amount\":0.00,\"OutstandingAmount\":0.00,\"ApplyAmount\":0.00}]}]},{\"Number\":\"BUDG00000002608\",\"LocationId\":\"000000000523000\",\"LocationAddress\":\"130 W SAMSULA DR\",\"StatementNumber\":0,\"Type\":[{\"Id\":7,\"Description\":\"Budget Document\"}],\"ServiceType\":[{\"Id\":\"\",\"Description\":\"\"}],\"Date\":\"2000-09-21\",\"DueDate\":\"2000-09-21\",\"Amount\":167.00,\"OutstandingAmount\":167.00,\"ApplyAmount\":0.00,\"Sequence\":5,\"ReferenceDocumentNumber\":\"BUDG00000002600\",\"ReferenceDocumentDate\":\"2000-01-01\",\"ServiceCategory\":[{\"Id\":0,\"Description\":\"\"}],\"Attribute\":[{\"ChargeType\":\"\",\"ChargeDescription\":\"\",\"PaymentOrigin\":\"\",\"SupportAuthorization\":0,\"Service\":[{\"Category\":0,\"Description\":\"\",\"Type\":\"\",\"Amount\":0.00,\"OutstandingAmount\":0.00,\"ApplyAmount\":0.00}]}]},{\"Number\":\"BUDG00000002609\",\"LocationId\":\"000000000523000\",\"LocationAddress\":\"130 W SAMSULA DR\",\"StatementNumber\":0,\"Type\":[{\"Id\":7,\"Description\":\"Budget Document\"}],\"ServiceType\":[{\"Id\":\"\",\"Description\":\"\"}],\"Date\":\"2000-10-23\",\"DueDate\":\"2000-10-23\",\"Amount\":167.00,\"OutstandingAmount\":167.00,\"ApplyAmount\":0.00,\"Sequence\":6,\"ReferenceDocumentNumber\":\"BUDG00000002600\",\"ReferenceDocumentDate\":\"2000-01-01\",\"ServiceCategory\":[{\"Id\":0,\"Description\":\"\"}],\"Attribute\":[{\"ChargeType\":\"\",\"ChargeDescription\":\"\",\"PaymentOrigin\":\"\",\"SupportAuthorization\":0,\"Service\":[{\"Category\":0,\"Description\":\"\",\"Type\":\"\",\"Amount\":0.00,\"OutstandingAmount\":0.00,\"ApplyAmount\":0.00}]}]},{\"Number\":\"BUDG00000002610\",\"LocationId\":\"000000000523000\",\"LocationAddress\":\"130 W SAMSULA DR\",\"StatementNumber\":0,\"Type\":[{\"Id\":7,\"Description\":\"Budget Document\"}],\"ServiceType\":[{\"Id\":\"\",\"Description\":\"\"}],\"Date\":\"2000-11-21\",\"DueDate\":\"2000-11-21\",\"Amount\":167.00,\"OutstandingAmount\":167.00,\"ApplyAmount\":0.00,\"Sequence\":7,\"ReferenceDocumentNumber\":\"BUDG00000002600\",\"ReferenceDocumentDate\":\"2000-01-01\",\"ServiceCategory\":[{\"Id\":0,\"Description\":\"\"}],\"Attribute\":[{\"ChargeType\":\"\",\"ChargeDescription\":\"\",\"PaymentOrigin\":\"\",\"SupportAuthorization\":0,\"Service\":[{\"Category\":0,\"Description\":\"\",\"Type\":\"\",\"Amount\":0.00,\"OutstandingAmount\":0.00,\"ApplyAmount\":0.00}]}]},{\"Number\":\"BUDG00000002611\",\"LocationId\":\"000000000523000\",\"LocationAddress\":\"130 W SAMSULA DR\",\"StatementNumber\":0,\"Type\":[{\"Id\":7,\"Description\":\"Budget Document\"}],\"ServiceType\":[{\"Id\":\"\",\"Description\":\"\"}],\"Date\":\"2000-12-21\",\"DueDate\":\"2000-12-21\",\"Amount\":167.00,\"OutstandingAmount\":167.00,\"ApplyAmount\":0.00,\"Sequence\":8,\"ReferenceDocumentNumber\":\"BUDG00000002600\",\"ReferenceDocumentDate\":\"2000-01-01\",\"ServiceCategory\":[{\"Id\":0,\"Description\":\"\"}],\"Attribute\":[{\"ChargeType\":\"\",\"ChargeDescription\":\"\",\"PaymentOrigin\":\"\",\"SupportAuthorization\":0,\"Service\":[{\"Category\":0,\"Description\":\"\",\"Type\":\"\",\"Amount\":0.00,\"OutstandingAmount\":0.00,\"ApplyAmount\":0.00}]}]},{\"Number\":\"BUDG00000002612\",\"LocationId\":\"000000000523000\",\"LocationAddress\":\"130 W SAMSULA DR\",\"StatementNumber\":0,\"Type\":[{\"Id\":7,\"Description\":\"Budget Document\"}],\"ServiceType\":[{\"Id\":\"\",\"Description\":\"\"}],\"Date\":\"2001-01-21\",\"DueDate\":\"2001-01-21\",\"Amount\":167.00,\"OutstandingAmount\":167.00,\"ApplyAmount\":0.00,\"Sequence\":9,\"ReferenceDocumentNumber\":\"BUDG00000002600\",\"ReferenceDocumentDate\":\"2000-01-01\",\"ServiceCategory\":[{\"Id\":0,\"Description\":\"\"}],\"Attribute\":[{\"ChargeType\":\"\",\"ChargeDescription\":\"\",\"PaymentOrigin\":\"\",\"SupportAuthorization\":0,\"Service\":[{\"Category\":0,\"Description\":\"\",\"Type\":\"\",\"Amount\":0.00,\"OutstandingAmount\":0.00,\"ApplyAmount\":0.00}]}]},{\"Number\":\"BILL00000000582\",\"LocationId\":\"000000000523000\",\"LocationAddress\":\"130 W SAMSULA DR\",\"StatementNumber\":384,\"Type\":[{\"Id\":5,\"Description\":\"Regular Bill\"}],\"ServiceType\":[{\"Id\":\"\",\"Description\":\"\"}],\"Date\":\"2019-09-01\",\"DueDate\":\"2019-09-22\",\"Amount\":133.45,\"OutstandingAmount\":133.45,\"ApplyAmount\":0.00,\"Sequence\":10,\"ReferenceDocumentNumber\":\"\",\"ReferenceDocumentDate\":\"\",\"ServiceCategory\":[{\"Id\":0,\"Description\":\"\"}],\"Attribute\":[{\"ChargeType\":\"\",\"ChargeDescription\":\"\",\"PaymentOrigin\":\"\",\"SupportAuthorization\":0,\"Service\":[{\"Category\":2,\"Description\":\"Water\",\"Type\":\"IR\",\"Amount\":51.55,\"OutstandingAmount\":51.55,\"ApplyAmount\":0.00},{\"Category\":3,\"Description\":\"Sewer\",\"Type\":\"PC\",\"Amount\":37.20,\"OutstandingAmount\":37.20,\"ApplyAmount\":0.00},{\"Category\":2,\"Description\":\"Water\",\"Type\":\"WR\",\"Amount\":44.70,\"OutstandingAmount\":44.70,\"ApplyAmount\":0.00}]}]},{\"Number\":\"BILL00000000583\",\"LocationId\":\"000000000523000\",\"LocationAddress\":\"130 W SAMSULA DR\",\"StatementNumber\":384,\"Type\":[{\"Id\":5,\"Description\":\"Regular Bill\"}],\"ServiceType\":[{\"Id\":\"\",\"Description\":\"\"}],\"Date\":\"2019-09-01\",\"DueDate\":\"2019-09-22\",\"Amount\":31.36,\"OutstandingAmount\":31.36,\"ApplyAmount\":0.00,\"Sequence\":11,\"ReferenceDocumentNumber\":\"\",\"ReferenceDocumentDate\":\"\",\"ServiceCategory\":[{\"Id\":1,\"Description\":\"Electric\"}],\"Attribute\":[{\"ChargeType\":\"\",\"ChargeDescription\":\"\",\"PaymentOrigin\":\"\",\"SupportAuthorization\":0,\"Service\":[{\"Category\":1,\"Description\":\"Electric\",\"Type\":\"GC\",\"Amount\":14.79,\"OutstandingAmount\":14.79,\"ApplyAmount\":0.00},{\"Category\":1,\"Description\":\"Electric\",\"Type\":\"RE_FIX\",\"Amount\":5.65,\"OutstandingAmount\":5.65,\"ApplyAmount\":0.00},{\"Category\":1,\"Description\":\"Electric\",\"Type\":\"RE_MR\",\"Amount\":10.92,\"OutstandingAmount\":10.92,\"ApplyAmount\":0.00}]}]},{\"Number\":\"MISC00000000305\",\"LocationId\":\"000000000523000\",\"LocationAddress\":\"130 W SAMSULA DR\",\"StatementNumber\":384,\"Type\":[{\"Id\":2,\"Description\":\"Misc Charge\"}],\"ServiceType\":[{\"Id\":\"\",\"Description\":\"\"}],\"Date\":\"2000-04-20\",\"DueDate\":\"2019-09-22\",\"Amount\":20.00,\"OutstandingAmount\":20.00,\"ApplyAmount\":0.00,\"Sequence\":12,\"ReferenceDocumentNumber\":\"\",\"ReferenceDocumentDate\":\"\",\"ServiceCategory\":[{\"Id\":0,\"Description\":\"\"}],\"Attribute\":[{\"ChargeType\":\"L K\\/RECON WR\",\"ChargeDescription\":\"FEE FOR WR METER REINSTALLATION\",\"PaymentOrigin\":\"\",\"SupportAuthorization\":0,\"Service\":[{\"Category\":0,\"Description\":\"\",\"Type\":\"\",\"Amount\":0.00,\"OutstandingAmount\":20.00,\"ApplyAmount\":0.00}]}]},{\"Number\":\"MISC00000000332\",\"LocationId\":\"000000000523000\",\"LocationAddress\":\"130 W SAMSULA DR\",\"StatementNumber\":384,\"Type\":[{\"Id\":2,\"Description\":\"Misc Charge\"}],\"ServiceType\":[{\"Id\":\"\",\"Description\":\"\"}],\"Date\":\"2019-07-31\",\"DueDate\":\"2019-09-22\",\"Amount\":500.00,\"OutstandingAmount\":500.00,\"ApplyAmount\":0.00,\"Sequence\":13,\"ReferenceDocumentNumber\":\"\",\"ReferenceDocumentDate\":\"\",\"ServiceCategory\":[{\"Id\":0,\"Description\":\"\"}],\"Attribute\":[{\"ChargeType\":\"CHEQUE\",\"ChargeDescription\":\"Misc charge for printed cheque\",\"PaymentOrigin\":\"\",\"SupportAuthorization\":0,\"Service\":[{\"Category\":0,\"Description\":\"\",\"Type\":\"\",\"Amount\":500.00,\"OutstandingAmount\":500.00,\"ApplyAmount\":0.00}]}]}]},\"Messages\":[]}}";
		Response result = CommonMethods.postMethodResponseasString(payload, uri, ver);
		String actualResult = result.print();
		if (!actualResult.contentEquals(exptected)) {
			Assert.fail(actualResult);
		}

	}

}
