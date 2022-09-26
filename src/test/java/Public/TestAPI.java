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

	@Test(priority = 5, groups = "ServiceOrder")
	public static void putaddMeterReading_v_3()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/serviceOrder/addMeterReading";
		String ver = "3.0";
		String jpath = "./\\TestData\\addMeterReading_v2.json";
		// String fresponse = "./\\TestData\\addMeterReadingresp_v2.json";
		// ValidatableResponse result = CommonMethods.putMethodvalidate(uri, ver, jpath,fresponse);
		ValidatableResponse result = CommonMethods.putMethod(uri, ver, jpath);
		result.assertThat().body(Matchers.containsString("true"));
		result.assertThat().body(Matchers.containsString("READ"));
		result.assertThat().body(Matchers.containsString("created"));
		//System.out.println(result.extract().asString());

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
