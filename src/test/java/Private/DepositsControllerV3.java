package Private;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.response.ValidatableResponse;

public class DepositsControllerV3 {

	@Test(priority = 1, groups = "Deposits")
	public void getdeposit_v_3() throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/deposit";
		String ver = "3.0";
		String jpath = "./\\TestData\\depositsv3.json";
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("LocationId", "SPALOCATION1");
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);

	}

	@Test(priority = 2, groups = "Deposits")
	public void getdepositpaymentPlan_v_3()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/deposit/paymentPlan";
		String ver = "3.0";
		String jpath = "./\\TestData\\depositsPaymentPlanv3.json";
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("DocumentNumber", "DEPS00000000026");
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);

	}

	@Test(priority = 3, groups = "Deposits")
	public void lookupDepositId_v_3() throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/lookupDepositId";
		String ver = "3.0";
		String jpath = "./\\TestData\\lookupDepositIdV2.json";
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("OrderBy", "description");
		params.put("PageNum", "1");
		params.put("NumPerPage", "32000");
		params.put("ServiceCategory", "electric");
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);

	}

}