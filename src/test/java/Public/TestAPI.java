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

	@Test(priority = 3, groups = "Search")
	public void getAccountsAdvanced_v_3()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/search/getAccountsAdvanced";
		String ver = "3.0";

		String jpath = "./\\TestData\\getAccountsAdvancedv2.json";
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("SearchCustomerName", "sally");
		params.put("SearchAccountNumber", "");
		params.put("SearchPhoneNumber", "");
		params.put("SearchEmailAddress", "");
		params.put("SortOrder", "1");
		params.put("SortDescending", "0");
		params.put("ShowAll", "0");

		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);

	}

	public static int retrunIndex(int[] arr1) {
		
			int arrayL = arr1.length;
			for (int i = 0; i < arrayL; i++) {
				int rightindexsum = 0;
				int leftindexsum = 0;
				for (int j = i; j < arrayL; j++) {
					leftindexsum += arr1[j];
					System.out.println("Hello Ibrahim leftindexsum =" + leftindexsum + " value of j ="+j);
				}
				for (int k = i - 1; k >= 0; k--) {
					rightindexsum += arr1[k];
					System.out.println("Hellow Affan rightindexsum = " + rightindexsum + " value of i ="+i);
				}
				if (rightindexsum == leftindexsum) {
					return i;
				}

			}

		
		return -1;

	}

	public static void main(String args[]) {

		int calc[] = { 1, 3, 1, 1, 1, 1 };
		if (retrunIndex(calc) == -1) {
			System.out.println("There is no index at which the condition sum left == sum right is fulfilled");
		} else {
			System.out.println("There is index at " + retrunIndex(calc));
		}

	}

}
