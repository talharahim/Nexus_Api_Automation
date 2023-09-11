package Private;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.response.ValidatableResponse;

public class voidController {

	@Test(priority = 1, groups = "void")
	public void putvoidvalidatev4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/void/validate";
		String ver = "4.0";
		String jpath = "./\\TestData\\putvoidvalidateReasonCodev4.json";
		String params = new String(Files.readAllBytes(Paths.get(jpath)));
		String expected = "./\\TestData\\ExpputvoidvalidateReasonCodev4.json";
		ValidatableResponse result = CommonMethods.putMethod(uri, ver, params, expected);
		 
	}
	
	
	@Test(priority = 2, groups = "void")
	public void putvoidvalidateInvaliddocumentv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/void/validate";
		String ver = "4.0";
		String jpath = "./\\TestData\\putvoidvalidateReasonCode1v4.json";
		String params = new String(Files.readAllBytes(Paths.get(jpath)));
		String expected = "./\\TestData\\ExpputvoidvalidateReasonCode1v4.json";
		ValidatableResponse result = CommonMethods.putMethod(uri, ver, params, expected);
		 
	}
	
	
	
	

	

	
}