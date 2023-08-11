package Private;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.response.ValidatableResponse;

public class MeterReadControllerV4 {

	@Test(priority = 1, groups = "MeterRead")
	public void deletemeterReadingvalidv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/meterReading/READ00000000915";
		String ver = "4.0";
		String expected = "{\"MeterReading\":{\"Success\":true,\"Data\":null,\"Messages\":[{\"Enabled\":1,\"Info\":\"Meter Reading successfully Deleted!\",\"Level\":1}]}}";
		String result = CommonMethods.deleteMethodasString(uri, ver);
		
		if (!result.contains(expected))
		{
			Assert.fail();
		}
			System.out.println(result);
	}
	
	@Test(priority = 2, groups = "MeterRead", dependsOnMethods ="deletemeterReadingvalidv4" )
	public void deletemeterReadingErrorv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/meterReading/READ00000000915";
		String ver = "4.0";
		String expected = "{\"MeterReading\":{\"Success\":false,\"Data\":null,\"Messages\":[{\"Enabled\":1,\"Info\":\"Invalid document number (READ00000000915).\",\"Level\":3},{\"Enabled\":1,\"Info\":\"Cannot delete meter reading as the document (READ00000000915) is not in work\\/open.\",\"Level\":3}]}}";
		String result = CommonMethods.deleteMethodasString(uri, ver);
		
		if (!result.contains(expected))
		{
			Assert.fail();
		}
			System.out.println(result);
		System.out.println(result);

	}

	

}