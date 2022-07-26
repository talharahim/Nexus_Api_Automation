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

	// @Test(priority = 1, groups = "Cashering" )
	public void TC002_saveReciept() throws ClassNotFoundException, SQLException, InterruptedException {

		// CommonMethods.CompanyDBRestore();
		String uri = "/cashiering/receipt";
		String ver = "2.4";
		String payload = "./\\TestData\\saveReciept.json";
		CommonMethods.postMethod(payload, uri, ver);
		jsonPathEvaluator = CommonMethods.postMethod(payload, uri, ver);
		Boolean Result = jsonPathEvaluator.get("Receipt.Success");
		System.out.println(jsonPathEvaluator.get().toString().toString());
		if (Result == false) {
			Assert.fail();
		}

	}

	public static void main(String args[]) {

		String str = "Find the in this string the. the the their the the the the";
		String find = "the";
		int j = 0;
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			if (find.charAt(j) == str.charAt(i)) {
				j++;
				i++;
				if (find.charAt(j) == str.charAt(i)) {
					j++;
					i++;
					if (find.charAt(j) == str.charAt(i)) {
						result++;
					}
				}
			}
			j = 0;
			//System.out.println(i);
		}
		result--;
		System.out.println("String " + find + " found " + result + " times");
	}
}
