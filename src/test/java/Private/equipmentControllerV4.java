package Private;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

public class equipmentControllerV4 {

	@Test(priority = 1, groups = "equipmentController")
	public void postequipmentControllerv4()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		JsonPath jsonPathEvaluator;
		String uri = "/Equipment";
		String ver = "4.0";
		String payload = "./\\TestData\\/postEquipmentv4.json";
		jsonPathEvaluator = CommonMethods.postMethod(payload, uri, ver);
		Boolean Result = jsonPathEvaluator.get("Equipment.Success");
		System.out.println(jsonPathEvaluator.prettyPrint());
		if (Result != true) {
			Assert.fail(jsonPathEvaluator.prettyPrint());
		}
		
		
	}
	
	@Test(priority = 2, groups = "equipmentController")
	public void postequipmentControllerv4Error()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		JsonPath jsonPathEvaluator;
		String uri = "/Equipment";
		String ver = "4.0";
		String payload = "./\\TestData\\/postEquipmentv4.json";
		jsonPathEvaluator = CommonMethods.postMethod(payload, uri, ver);
		Boolean Result = jsonPathEvaluator.get("Equipment.Success");
		System.out.println(jsonPathEvaluator.prettyPrint());
		if (Result != true) {
			Assert.fail(jsonPathEvaluator.prettyPrint());
		}
		
		
	}
	
	


}