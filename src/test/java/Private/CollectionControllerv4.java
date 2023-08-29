package Private;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.response.ValidatableResponse;

public class CollectionControllerv4 {

	@Test(priority = 1, groups = "Collection")
	public void getcollectionsetupv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/collection/setup";
		String ver = "4.0";
		String jpath = "./\\TestData\\collectionsetupv4.json";
		HashMap<String, String> params = new HashMap<String, String>();
		// params.put("CustomerId", "CUSTOMER012"); 
		 //params.put("LocationId", "LOCATION011"); 
		 String result = CommonMethods.getMethod(uri, ver, params, jpath);
		 System.out.println(result);
	}
	

	
}