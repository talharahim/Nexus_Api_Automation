package Private;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

public class MeterReadControllerV4 {

	@Test(priority = 1, groups = "MeterRead")
	public void deletemeterReadingvalidv4()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/meterReading/READ00000000915";
		String ver = "4.0";
		String expected = "{\"MeterReading\":{\"Success\":true,\"Data\":null,\"Messages\":[{\"Enabled\":1,\"Info\":\"Meter Reading successfully Deleted!\",\"Level\":1}]}}";
		String result = CommonMethods.deleteMethodasString(uri, ver);

		if (!result.contains(expected)) {
			System.out.println("MeterRead Already deleted" + result);
			Assert.fail();
		}
		System.out.println(result);
	}

	@Test(priority = 2, groups = "MeterRead", dependsOnMethods = "deletemeterReadingvalidv4")
	public void deletemeterReadingErrorv4()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/meterReading/READ00000000915";
		String ver = "4.0";
		String expected = "{\"MeterReading\":{\"Success\":false,\"Data\":null,\"Messages\":[{\"Enabled\":1,\"Info\":\"Invalid document number (READ00000000915).\",\"Level\":3},{\"Enabled\":1,\"Info\":\"Cannot delete meter reading as the document (READ00000000915) is not in work\\/open.\",\"Level\":3}]}}";
		String result = CommonMethods.deleteMethodasString(uri, ver);

		if (!result.contains(expected)) {
			Assert.fail();
		}
		System.out.println(result);
		System.out.println(result);

	}

	@Test(priority = 3, groups = "MeterRead")
	public void getmeterReadingnextv4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/meterReading/next";
		String ver = "4.0";
		String expected = "{\"MeterReading\":{\"Success\":true,\"Data\":{\"PreviousDocumentNumber\":\"\",\"NextDocumentNumber\":\"READREAD000000";
		String expected2 = "\"},\"Messages\":[]}}";
		HashMap<String, String> params = new HashMap<String, String>();

		String result = CommonMethods.getMethodasString(uri, ver, params);
		if (!result.contains(expected) && !result.contains(expected2)) {
			Assert.fail();
		}
		System.out.println(result);
		System.out.println(result);

	}

	@Test(priority = 4, groups = "MeterRead")
	public static void PostMeterReadv4()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// CommonMethods.CompanyDBRestore();
		String uri = "/meterReading";
		String ver = "4.0";

		String payload = "{\r\n" + "    \"MeterReading\": [\r\n" + "        {\r\n"
				+ "            \"LocationId\": \"Z100036\",\r\n" + "            \"Connection\": 1,\r\n"
				+ "            \"EquipmentId\": \"EE1\",\r\n" + "            \"RemoteId\": \"\",\r\n"
				+ "            \"BatchId\": \"NewBatch\",\r\n" + "            \"ReadDocumentLocation\": 2,\r\n"
				+ "            \"ServiceOrder\": \r\n" + "                {\r\n"
				+ "                    \"Id\": \"\",\r\n" + "                    \"Task\": {\r\n"
				+ "                            \"Sequence\": 0\r\n" + "                    }\r\n"
				+ "                },\r\n" + "            \"MeterReadInfo\": \r\n" + "                {\r\n"
				+ "                    \"EmployeeId\": \"BANK0001\",\r\n"
				+ "                    \"Description\": \"Meter Read from street\",\r\n"
				+ "                    \"ReadingType\": 1,\r\n"
				+ "                    \"ReadingDateTime\": \"2022-05-31T10:11:23\",\r\n"
				+ "                    \"ReasonCode\": \"\",\r\n" + "                    \"Periods\": \r\n"
				+ "                        [\r\n" + "                            {\r\n"
				+ "                                \"Index\": 1,\r\n"
				+ "                                \"ConsumptionOverride\": \"true\",\r\n"
				+ "                                \"Rollover\": 0,\r\n"
				+ "                                \"NetRollover\": 0,\r\n"
				+ "                                \"ConsumptionReading\": 3.3,\r\n"
				+ "                                \"Consumption\": 2.2,\r\n"
				+ "                                \"KW\": 0,\r\n" + "                                \"KVA\": 0,\r\n"
				+ "                                \"NetMeterReceived\": 0,\r\n"
				+ "                                \"NetMeterPreviousReceived\": 0,\r\n"
				+ "                                \"PowerFactor\": 0,\r\n"
				+ "                                \"LoadFactor\": 0\r\n" + "                            }\r\n"
				+ "                        ]\r\n" + "                }\r\n" + "            \r\n" + "        }\r\n"
				+ "    ]\r\n" + "}\r\n" + "";
		String filepath = "./\\TestData\\PostMeterReadv4.json";
		FileWriter file = new FileWriter(filepath);
		file.write(payload);
		file.close();
		JsonPath jsonPathEvaluator = CommonMethods.postMethod(filepath, uri, ver);
		Boolean Result = jsonPathEvaluator.get("MeterReading[0].Success");
		if (Result == true) {

			Assert.fail("Meter Reading posting should not be done ");

		} else {

			System.out.print(jsonPathEvaluator.prettyPrint());
		}
	}

	@Test(priority = 5, groups = "MeterRead")
	public void putMeterReadinginWorkV4()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/meterReading";
		String ver = "4.0";
		String jpath = "./\\TestData\\putMeterReadingV4.json";
		String params = new String(Files.readAllBytes(Paths.get(jpath)));
		String expected = "./\\TestData\\putMeterReadingexpected_v4.json";
		ValidatableResponse result = CommonMethods.putMethod(uri, ver, params, expected);

	}

	@Test(priority = 6, groups = "MeterRead")
	public void putMeterReadingNetMeterV4()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/meterReading";
		String ver = "4.0";
		String jpath = "./\\TestData\\putMeterReadingNetMeterV4.json";
		String params = new String(Files.readAllBytes(Paths.get(jpath)));
		String expected = "./\\TestData\\putMeterReadingexpectedNetMeter_v4.json";
		ValidatableResponse result = CommonMethods.putMethod(uri, ver, params, expected);

	}

	@Test(priority = 7, groups = "MeterRead")
	public void putMeterReadingnottheLatestreadingV4()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/meterReading";
		String ver = "4.0";
		String jpath = "./\\TestData\\putMeterReadingnottheLatestreadingV4.json";
		String params = new String(Files.readAllBytes(Paths.get(jpath)));
		String expected = "./\\TestData\\putMeterReadingnottheLatestreadingexpectedNetMeter_v4.json";
		ValidatableResponse result = CommonMethods.putMethod(uri, ver, params, expected);

	}

}
