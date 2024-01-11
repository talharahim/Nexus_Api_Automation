package Private;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

public class MiscellaneousChargeControllerV4 {

	@Test(priority = 1, groups = "misccharge")
	public void miscellaneousChargeSimulatev4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/miscellaneous/simulate";
		String ver = "4.0";
		String payload = "./\\TestData\\/miscellaneoussimulatev4.json";
		String exResponse = "{\"MiscellaneousCharge\":{\"Success\":true,\"Data\":{\"LocationId\":\"LOCATION013\",\"CustomerId\":\"CUSTOMER017\",\"MiscChargeType\":\"INSTALLELEC\",\"MiscChargeAmount\":41.55,\"TaxScheduleId\":\"ONT GST\\/PST\",\"ServiceDetail\":[{\"ServiceType\":\"ELECTRIC\",\"ChargeAmount\":41.55,\"TaxAmount\":0.00,\"TotalAmount\":41.55,\"OutstandingAmount\":41.55}],\"ServiceTotal\":{\"ChargeAmount\":41.55,\"TaxAmount\":0.00,\"TotalAmount\":41.55,\"OutstandingAmount\":41.55},\"DistributionDetail\":[{\"TypeId\":3,\"Type\":\"RECV\",\"Description\":\"Customer Accounts Receivable - Electric\",\"Index\":506,\"Number\":\"900-1410-00\",\"DebitAmount\":41.55,\"CreditAmount\":0.00},{\"TypeId\":9,\"Type\":\"SALES\",\"Description\":\"Metered Sales to Residential - Electric\",\"Index\":515,\"Number\":\"900-4611-00\",\"DebitAmount\":0.00,\"CreditAmount\":41.55}],\"DistributionTotal\":{\"DebitAmount\":41.55,\"CreditAmount\":41.55}},\"Messages\":[]}}";
		CommonMethods.postcall(uri, payload, ver, exResponse);
	}

	
	


}