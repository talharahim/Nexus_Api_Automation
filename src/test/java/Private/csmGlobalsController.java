package Private;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class csmGlobalsController {

	@Test(priority = 1, groups = "csmGlobalsController")
	public void csmSetupautoGeneratenextIdv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/csmSetup/autoGenerate/nextId/3";
		String ver = "4.0";
		HashMap<String, String> params = new HashMap<String, String>();
		Response response = CommonMethods.getMethod(uri, ver, params);
		
        String param ="{\"CsmSetup\":{\"Success\":true,\"Data\":{\"EntityId\":3,\"NextId\":";
        String param2 = "\"},\"Messages\":[]}}";
		// To check for sub string presence get the Response body as a String.
		// Do a String.contains
		String bodyAsString = response.asString();
		System.out.println(bodyAsString);

		if (!bodyAsString.contains(param) && !bodyAsString.contains(param2)) {
			Assert.fail(param + param2 + "Not Found");
		}
		System.out.println(response.prettyPrint());
		 
	}
	
		
}