package Private;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.response.ValidatableResponse;

public class BillingControllerv4 {

	@Test(priority = 1, groups = "billing")
	public static void delBatv4()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/billing/delete/BT1231";
		String ver = "4.0";
		String jpath = "./\\TestData\\delBatv4.json";
		String result = CommonMethods.deleteMethod(uri, ver, jpath);
		System.out.println(result.toString());

	}
	
	@Test(priority = 2, groups = "billing")
	public static void delBatv4Err()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/billing/delete/BT1231";
		String ver = "4.0";
		String jpath = "./\\TestData\\delBatv4Err.json";
		String result = CommonMethods.deleteMethod(uri, ver, jpath);
		System.out.println(result.toString());

	}

	

	
}
