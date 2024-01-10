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
	
	@Test(priority = 2, groups = "Collection")
	public void getcollectionv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/collection";
		String ver = "4.0";
		String jpath = "./\\TestData\\getcollectionv4.json";
		HashMap<String, String> params = new HashMap<String, String>();
		// params.put("CustomerId", "CUSTOMER012"); 
		 //params.put("LocationId", "LOCATION011"); 
		 String result = CommonMethods.getMethod(uri, ver, params, jpath);
		 System.out.println(result);
	}
	

	@Test(priority = 3, groups = "Collection")
	public void postcollectionGeneratev4()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		//JsonPath jsonPathEvaluator;
		String uri = "/collection/generate";
		String ver = "4.0";
		String payload = "./\\TestData\\postcollectionv4.json";
		String exResponse = "{\"Collection\":{\"Success\":true,\"Data\":null,\"Messages\":[{\"Enabled\":1,\"Info\":\"Collection Notices Calculated.\",\"Level\":1}]}}";
		CommonMethods.postcall(uri, payload, ver, exResponse);
		
	}
	
	

	@Test(priority = 4, groups = "Collection")
	public void putcollectionapplyDisconnectDatev4()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		//JsonPath jsonPathEvaluator;
		String uri = "/collection/applyDisconnectDate";
		String ver = "4.0";
		String jpath = "./\\TestData\\collectionapplyDisconnectDatev4.json";
	//	HashMap<String, String> params = new HashMap<String, String>();
		ValidatableResponse result = CommonMethods.putMethod(uri, ver, jpath);
		System.out.println(result);
		
	}

	

	@Test(priority = 5, groups = "Collection")
	public void postcollectionprocessv4()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		//JsonPath jsonPathEvaluator;
		String uri = "/collection/process";
		String ver = "4.0";
		String payload = "./\\TestData\\collectionprocessv4.json";
		String exResponse = "{\"Collection\":{\"Success\":false,\"Data\":null,\"Messages\":[{\"Enabled\":1,\"Info\":\"No Notice found for this customer CUSTOMER007 / location ELECWAT001 combination.\",\"Level\":3}]}}";
		CommonMethods.postcall(uri, payload, ver, exResponse);
		
	}

	

	@Test(priority = 6, groups = "Collection")
	public void postcollectionprintv4()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		//JsonPath jsonPathEvaluator;
		String uri = "/collection/print";
		String ver = "4.0";
		String payload = "./\\TestData\\collectionprintv4.json";
		String exResponse = "{\"Collection\":{\"Success\":true,\"Data\":null,\"Messages\":[{\"Enabled\":1,\"Info\":\"Collection Notices Printed.\",\"Level\":1}]}}";
		CommonMethods.postcall(uri, payload, ver, exResponse);
		
	}

	
	@Test(priority = 7, groups = "Collection")
	public void getcollectionMessagesv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/collection/textMessage";
		String ver = "4.0";
		String jpath = "./\\TestData\\getcollectionMessagesv4.json";
		HashMap<String, String> params = new HashMap<String, String>();
		// params.put("CustomerId", "CUSTOMER012"); 
		 //params.put("LocationId", "LOCATION011"); 
		 String result = CommonMethods.getMethod(uri, ver, params, jpath);
		 System.out.println(result);
	}
	
	
	@Test(priority = 8, groups = "Collection")
	public void getcollectionNoticeTypev4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/collection/noticeType";
		String ver = "4.0";
		String jpath = "./\\TestData\\getcollectionnoticeTypev4.json";
		HashMap<String, String> params = new HashMap<String, String>();
		// params.put("CustomerId", "CUSTOMER012"); 
		 //params.put("LocationId", "LOCATION011"); 
		 String result = CommonMethods.getMethod(uri, ver, params, jpath);
		 System.out.println(result);
	}
	
}