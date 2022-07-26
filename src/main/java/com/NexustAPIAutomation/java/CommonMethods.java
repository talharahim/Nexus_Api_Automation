package com.NexustAPIAutomation.java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.security.sasl.SaslException;

import org.apache.http.ConnectionClosedException;
import org.hamcrest.Matchers;
import org.testng.Assert;

import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellResponse;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CommonMethods {

	public static ReadProjectProperties Read = new ReadProjectProperties();
	public static String userName = Read.ReadFile("username");
	public static String Password = Read.ReadFile("password");
	public static String keycloakurl = Read.ReadFile("keycloakurl");
	public static String urlv1 = Read.ReadFile("urlv1");
	public static String urlv2 = Read.ReadFile("urlv2");
	public static String urlv210 = Read.ReadFile("urlv210");
	public static String urlv220 = Read.ReadFile("urlv220");
	public static String urlv230 = Read.ReadFile("urlv230");
	public static String urlv231 = Read.ReadFile("urlv231");
	public static String urlv240 = Read.ReadFile("urlv240");

	public static String getToken() throws InterruptedException {
		String url = keycloakurl + "/auth/realms/nexus-portal/protocol/openid-connect/token";
		Response response = RestAssured.given().auth().preemptive().basic("nexus-portal", url)
				.contentType("application/x-www-form-urlencoded").log().all().formParam("grant_type", "password")
				.formParam("username", userName).formParam("password", Password).when().post(url); // authorization_token
		CommonMethods.Delay(100); // value is not
		if (response.path("access_token").toString() == "") {
			Assert.fail("Austhorisation failed");
		}
		// The auth token could then be set to a string variable
		String auth_token = response.path("access_token").toString();
		// System.out.println(auth_token);
		return auth_token;

	}

	private static void Delay(int i) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(i);

	}

	public static boolean CompanyDBRestore() {

		try {
			CommonMethods.Delay(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PowerShell powerShell = PowerShell.openSession();
			// Execute a command in PowerShell session
			PowerShellResponse response;
			Map<String, String> config = new HashMap<String, String>();
			config.put("maxWait", "200000");
			response = powerShell.configuration(config).executeScript("./\\Configuration\\DBOnlyrestore.ps1");
			System.out.println("Script output:" + response.getCommandOutput());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Scripts got error while rinning DB Scripts, please see logs");

			System.exit(1);
		}

		return true;

	}

	void test() throws ConnectionClosedException, InterruptedException {

		String uri = "/cashiering/receipt/adjust";
		String ver = "2.4";
		String payload = "./\\TestData\\recieptAdjust.json";

		// getToken();
		postMethod(payload, uri, ver);

	}

	public static JsonPath postMethod(String payload, String uri, String version) throws InterruptedException {

		switch (version) {
		case "1":
			RestAssured.baseURI = urlv1;
			break;
		case "2":
			RestAssured.baseURI = urlv2;
			break;
		case "2.1":
			RestAssured.baseURI = urlv210;
			break;
		case "2.2":
			RestAssured.baseURI = urlv220;
			break;
		case "2.3":
			RestAssured.baseURI = urlv230;
			break;
		case "2.3.1":
			RestAssured.baseURI = urlv231;
			break;
		case "2.4":
			RestAssured.baseURI = urlv240;
			break;

		default:
			version = "Invalid version";
			break;
		}
		File jsonDataInFile = new File(payload);
		// System.out.println(RestAssured.baseURI);
		Response response;
		JsonPath jsonPathEvaluator;
		RestAssured.baseURI = RestAssured.baseURI + uri;
		RequestSpecification httpRequest = RestAssured.given()
				.headers("Authorization", "Bearer " + getToken(), "Content-Type", ContentType.JSON, "Accept", "*/*",
						"Connection", "keep-alive", "Accept-Encoding", "gzip, deflate, br")
				.body(jsonDataInFile);

		response = httpRequest.post();
		System.out.println(response.asString());
		jsonPathEvaluator = response.jsonPath();

		return jsonPathEvaluator;

	}

	public static JsonPath postMethodStringPayload(String payload, String uri, String version)
			throws InterruptedException {

		switch (version) {
		case "1":
			RestAssured.baseURI = urlv1;
			break;
		case "2":
			RestAssured.baseURI = urlv2;
			break;
		case "2.1":
			RestAssured.baseURI = urlv210;
			break;
		case "2.2":
			RestAssured.baseURI = urlv220;
			break;
		case "2.3":
			RestAssured.baseURI = urlv230;
			break;
		case "2.3.1":
			RestAssured.baseURI = urlv231;
			break;
		case "2.4":
			RestAssured.baseURI = urlv240;
			break;

		default:
			version = "Invalid version";
			break;
		}
		// File jsonDataInFile = new File(payload);
		// System.out.println(RestAssured.baseURI);
		Response response;
		JsonPath jsonPathEvaluator;
		RestAssured.baseURI = RestAssured.baseURI + uri;
		RequestSpecification httpRequest = RestAssured.given()
				.headers("Authorization", "Bearer " + getToken(), "Content-Type", ContentType.JSON, "Accept", "*/*",
						"Connection", "keep-alive", "Accept-Encoding", "gzip, deflate, br")
				.body(payload);

		response = httpRequest.post();
		System.out.println(response.asString());
		jsonPathEvaluator = response.jsonPath();

		return jsonPathEvaluator;

	}

	public static JsonPath getMethod(String uri, String version) throws InterruptedException {
		switch (version) {
		case "1":
			RestAssured.baseURI = urlv1;
			break;
		case "1.0":
			RestAssured.baseURI = urlv1;
			break;
		case "2.0":
			RestAssured.baseURI = urlv2;
			break;
		case "2":
			RestAssured.baseURI = urlv2;
			break;
		case "2.1":
			RestAssured.baseURI = urlv210;
			break;
		case "2.2":
			RestAssured.baseURI = urlv220;
			break;
		case "2.3":
			RestAssured.baseURI = urlv230;
			break;
		case "2.3.1":
			RestAssured.baseURI = urlv231;
			break;
		case "2.4":
			RestAssured.baseURI = urlv240;
			break;

		default:
			version = "Invalid version";
			break;
		}
		// File jsonDataInFile = new File(payload);
		System.out.println(RestAssured.baseURI);
		RestAssured.baseURI = RestAssured.baseURI + uri;
		RequestSpecification httpRequest = RestAssured.given().headers("Authorization", "bearer " + getToken(),
				"Content-Type", ContentType.JSON, "Accept", "*/*", "Connection", "keep-alive", "Accept-Encoding",
				"gzip, deflate, br", "Cache-Control", "no-cache", "urlEncodingEnabled", "false");

		Response response = httpRequest.get();
		JsonPath jsonPathEvaluator = response.jsonPath();
		System.out.println(jsonPathEvaluator.prettyPrint());
		return jsonPathEvaluator;

	}

	public static JsonPath getMethod(String uri, String version, Map<String, String> responseMap)
			throws InterruptedException {
		switch (version) {
		case "1":
			RestAssured.baseURI = urlv1;
			break;
		case "2":
			RestAssured.baseURI = urlv2;
			break;
		case "2.1":
			RestAssured.baseURI = urlv210;
			break;
		case "2.2":
			RestAssured.baseURI = urlv220;
			break;
		case "2.3":
			RestAssured.baseURI = urlv230;
			break;
		case "2.3.1":
			RestAssured.baseURI = urlv231;
			break;
		case "2.4":
			RestAssured.baseURI = urlv240;
			break;

		default:
			version = "Invalid version";
			break;
		}
		// File jsonDataInFile = new File(payload);
		RestAssured.baseURI = RestAssured.baseURI + uri;
		System.out.println(RestAssured.baseURI.toString());
		RequestSpecification httpRequest = RestAssured.given().headers("Authorization", "Bearer " + getToken(),
				"Content-Type", ContentType.JSON, "Accept", "*/*", "Connection", "keep-alive", "Accept-Encoding",
				"gzip, deflate, br");

		Iterator<Entry<String, String>> it = responseMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
			httpRequest.queryParam(pair.getKey().toString(), pair.getValue().toString());
		}

		Response response = null;
		JsonPath jsonPathEvaluator;
		try {
			response = httpRequest.get();
		} catch (NullPointerException e) {

		}
		jsonPathEvaluator = response.jsonPath();
		return jsonPathEvaluator;

	}

	public static Response getMethod(String uri, String version, HashMap<String, String> params)
			throws InterruptedException {
		switch (version) {
		case "1":
			RestAssured.baseURI = urlv1;
			break;
		case "2":
			RestAssured.baseURI = urlv2;
			break;
		case "2.1":
			RestAssured.baseURI = urlv210;
			break;
		case "2.2":
			RestAssured.baseURI = urlv220;
			break;
		case "2.3":
			RestAssured.baseURI = urlv230;
			break;
		case "2.3.1":
			RestAssured.baseURI = urlv231;
			break;
		case "2.4":
			RestAssured.baseURI = urlv240;
			break;

		default:
			version = "Invalid version";
			break;
		}
		// File jsonDataInFile = new File(payload);
		RestAssured.baseURI = RestAssured.baseURI + uri;
		System.out.println(RestAssured.baseURI.toString());
		RequestSpecification httpRequest = RestAssured.given().headers("Authorization", "Bearer " + getToken(),
				"Content-Type", ContentType.JSON, "Connection", "keep-alive", "Accept-Encoding", "gzip, deflate, br")
				.queryParams(params);

		Response response = httpRequest.get();

		return response;

	}

	public static String getMethod(String uri, String version, HashMap<String, String> params, String jpath)
			throws InterruptedException, IOException {

		switch (version) {
		case "1":
			RestAssured.baseURI = urlv1;
			break;
		case "2":
			RestAssured.baseURI = urlv2;
			break;
		case "2.1":
			RestAssured.baseURI = urlv210;
			break;
		case "2.2":
			RestAssured.baseURI = urlv220;
			break;
		case "2.3":
			RestAssured.baseURI = urlv230;
			break;
		case "2.3.1":
			RestAssured.baseURI = urlv231;
			break;
		case "2.4":
			RestAssured.baseURI = urlv240;
			break;

		default:
			version = "Invalid version";
			break;
		}

		RestAssured.baseURI = RestAssured.baseURI + uri;
		System.out.println(RestAssured.baseURI.toString());
		RequestSpecification httpRequest = RestAssured.given().headers("Authorization", "Bearer " + getToken(),
				"Content-Type", ContentType.JSON, "Connection", "keep-alive", "Accept-Encoding", "gzip, deflate, br")
				.queryParams(params);

		ValidatableResponse response = httpRequest.get().then().assertThat()
				.body(Matchers.equalTo(new String(Files.readAllBytes(Paths.get(jpath)))));
		System.out.println(response.extract().asString());
		System.out.println(response.log());

		return response.extract().asString();

	}

	public static String putMethod(String uri, String version, HashMap<String, String> params, String payload,
			String responseFile) throws InterruptedException, IOException {

		switch (version) {
		case "1":
			RestAssured.baseURI = urlv1;
			break;
		case "2":
			RestAssured.baseURI = urlv2;
			break;
		case "2.1":
			RestAssured.baseURI = urlv210;
			break;
		case "2.2":
			RestAssured.baseURI = urlv220;
			break;
		case "2.3":
			RestAssured.baseURI = urlv230;
			break;
		case "2.3.1":
			RestAssured.baseURI = urlv231;
			break;
		case "2.4":
			RestAssured.baseURI = urlv240;
			break;

		default:
			version = "Invalid version";
			break;
		}

		File jsonDataInFile = new File(payload);
		RestAssured.baseURI = RestAssured.baseURI + uri;
		System.out.println(RestAssured.baseURI.toString());
		RequestSpecification httpRequest = RestAssured
				.given().headers("Authorization", "Bearer " + getToken(), "Content-Type", ContentType.JSON,
						"Connection", "keep-alive", "Accept-Encoding", "gzip, deflate, br")
				.queryParams(params).body(jsonDataInFile);

		Response responseTest = httpRequest.put();
		System.out.println(responseTest.asString());
		ValidatableResponse response = httpRequest.put().then().assertThat().statusCode(200)
				.body(Matchers.equalTo(new String(Files.readAllBytes(Paths.get(responseFile)))));
		;
		System.out.println(response.extract().asString());
		System.out.println(response.log());

		return response.extract().asString();

	}

	public static ValidatableResponse putMethod(String uri, String version, String payload)
			throws InterruptedException, IOException {

		switch (version) {
		case "1":
			RestAssured.baseURI = urlv1;
			break;
		case "2":
			RestAssured.baseURI = urlv2;
			break;
		case "2.1":
			RestAssured.baseURI = urlv210;
			break;
		case "2.2":
			RestAssured.baseURI = urlv220;
			break;
		case "2.3":
			RestAssured.baseURI = urlv230;
			break;
		case "2.3.1":
			RestAssured.baseURI = urlv231;
			break;
		case "2.4":
			RestAssured.baseURI = urlv240;
			break;

		default:
			version = "Invalid version";
			break;
		}

		File jsonDataInFile = new File(payload);
		RestAssured.baseURI = RestAssured.baseURI + uri;
		System.out.println(RestAssured.baseURI.toString());
		RequestSpecification httpRequest = RestAssured.given().headers("Authorization", "Bearer " + getToken(),
				"Content-Type", ContentType.JSON, "Connection", "keep-alive", "Accept-Encoding", "gzip, deflate, br")
				.body(jsonDataInFile);
		System.out.println(httpRequest.put().prettyPrint());
		ValidatableResponse response = httpRequest.put().then().assertThat().statusCode(200);
		return response;

	}

	public static ValidatableResponse putMethodvalidate(String uri, String version, String payload, String fresponse)
			throws InterruptedException, IOException {

		switch (version) {
		case "1":
			RestAssured.baseURI = urlv1;
			break;
		case "2":
			RestAssured.baseURI = urlv2;
			break;
		case "2.1":
			RestAssured.baseURI = urlv210;
			break;
		case "2.2":
			RestAssured.baseURI = urlv220;
			break;
		case "2.3":
			RestAssured.baseURI = urlv230;
			break;
		case "2.3.1":
			RestAssured.baseURI = urlv231;
			break;
		case "2.4":
			RestAssured.baseURI = urlv240;
			break;

		default:
			version = "Invalid version";
			break;
		}

		File jsonDataInFile = new File(payload);
		RestAssured.baseURI = RestAssured.baseURI + uri;
		System.out.println(RestAssured.baseURI.toString());
		RequestSpecification httpRequest = RestAssured.given().headers("Authorization", "Bearer " + getToken(),
				"Content-Type", ContentType.JSON, "Connection", "keep-alive", "Accept-Encoding", "gzip, deflate, br")
				.body(jsonDataInFile);
		System.out.println(httpRequest.put().prettyPrint());
		ValidatableResponse response = httpRequest.put().then().assertThat()
				.body(Matchers.equalTo(new String(Files.readAllBytes(Paths.get(fresponse))))).assertThat()
				.statusCode(200);
		return response;

	}

	public static ValidatableResponse putMethod(String uri, String version, String payload, String Message)
			throws InterruptedException, IOException {

		switch (version) {
		case "1":
			RestAssured.baseURI = urlv1;
			break;
		case "2":
			RestAssured.baseURI = urlv2;
			break;
		case "2.1":
			RestAssured.baseURI = urlv210;
			break;
		case "2.2":
			RestAssured.baseURI = urlv220;
			break;
		case "2.3":
			RestAssured.baseURI = urlv230;
			break;
		case "2.3.1":
			RestAssured.baseURI = urlv231;
			break;
		case "2.4":
			RestAssured.baseURI = urlv240;
			break;

		default:
			version = "Invalid version";
			break;
		}

		RestAssured.baseURI = RestAssured.baseURI + uri;
		System.out.println(RestAssured.baseURI.toString());
		RequestSpecification httpRequest = RestAssured.given().headers("Authorization", "Bearer " + getToken(),
				"Content-Type", ContentType.JSON, "Connection", "keep-alive", "Accept-Encoding", "gzip, deflate, br")
				.body(payload);

		ValidatableResponse response = httpRequest.put().then().assertThat().statusCode(200);
		return response;

	}

	public static JsonPath getMethodTest() throws InterruptedException, IOException {

		String version = "2.4";
		switch (version) {
		case "1":
			RestAssured.baseURI = urlv1;
			break;
		case "2":
			RestAssured.baseURI = urlv2;
			break;
		case "2.1":
			RestAssured.baseURI = urlv210;
			break;
		case "2.2":
			RestAssured.baseURI = urlv220;
			break;
		case "2.3":
			RestAssured.baseURI = urlv230;
			break;
		case "2.3.1":
			RestAssured.baseURI = urlv231;
			break;
		case "2.4":
			RestAssured.baseURI = urlv240;
			break;

		default:
			version = "Invalid version";
			break;
		}
		// File jsonDataInFile = new File(payload);

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("LocationId", "loc@0001");
		params.put("CustomerId", "0000011111");
		params.put("UserDate", "2027-04-12");
		/*
		 * Iterator<Entry<String, String>> it = responseMap.entrySet().iterator(); while
		 * (it.hasNext()) { Map.Entry pair = (Map.Entry) it.next();
		 * System.out.println(pair.getKey() + " = " + pair.getValue());
		 * httpRequest.queryParam(pair.getKey().toString(), pair.getValue().toString());
		 * 
		 * resp = RestAssured.given() .headers(headers) .queryParameters(params)
		 * .post(apiURL).andReturn() }
		 */

		String uri = "/accountBalance/getAccountBalances";
		RestAssured.baseURI = RestAssured.baseURI + uri;
		System.out.println(RestAssured.baseURI.toString());
		RequestSpecification httpRequest = RestAssured.given().headers("Authorization", "Bearer " + getToken(),
				"Content-Type", ContentType.JSON, "Connection", "keep-alive", "Accept-Encoding", "gzip, deflate, br")
				.queryParams(params);

		ValidatableResponse response = httpRequest.get().then().assertThat()
				.body(Matchers.equalTo(new String(Files.readAllBytes(Paths.get("./TestData\\accountBalance.json")))));
		// JsonPath jsonPathEvaluator = ((ResponseBodyExtractionOptions)
		// response).jsonPath();
		JsonPath jsonPathEvaluator = null;
		System.out.println(response.extract().asString());
		// ValidatableResponse response =
		// httpRequest.get().then().assertThat().statusCode(200).body(Matchers.equalTo(new
		// String(Files.readAllBytes(jsonDataInFile))));

		return jsonPathEvaluator;

	}

	public static void main(String args[])
			throws InterruptedException, IOException, ClassNotFoundException, SQLException {
		// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		getSPAIndex("500300");
	}

	public static ValidatableResponse getMethod(String uri, String version, String pathToResponse)
			throws InterruptedException, IOException {
		switch (version) {
		case "1":
			RestAssured.baseURI = urlv1;
			break;
		case "2":
			RestAssured.baseURI = urlv2;
			break;
		case "2.1":
			RestAssured.baseURI = urlv210;
			break;
		case "2.2":
			RestAssured.baseURI = urlv220;
			break;
		case "2.3":
			RestAssured.baseURI = urlv230;
			break;
		case "2.3.1":
			RestAssured.baseURI = urlv231;
			break;
		case "2.4":
			RestAssured.baseURI = urlv240;
			break;

		default:
			version = "Invalid version";
			break;
		}
		Path jsonDataInFile = Paths.get(pathToResponse);
		System.out.println(RestAssured.baseURI);
		RestAssured.baseURI = RestAssured.baseURI + uri;
		String token = "Bearer " + getToken();
		// RestAssured.given().headers("Authorization", token,
		// "Content-Type", ContentType.JSON, "Accept", "*/*", "Connection",
		// "keep-alive", "Accept-Encoding",
		// "gzip, deflate, br").when().get().then().assertThat()
		// .statusCode(200).body(Matchers.equalTo(new
		// String(Files.readAllBytes(jsonDataInFile))));
		RestAssured.baseURI = RestAssured.baseURI + uri;
		RequestSpecification httpRequest = RestAssured.given().headers("Authorization", "Bearer " + getToken(),
				"Content-Type", ContentType.JSON, "Connection", "keep-alive", "Accept-Encoding", "gzip, deflate, br");

		ValidatableResponse response = httpRequest.get().then().assertThat().statusCode(200)
				.body(Matchers.equalTo(new String(Files.readAllBytes(jsonDataInFile))));
		;

		return response;
		// JsonPath jsonPathEvaluator = response.jsonPath();

	}

	public static String getSPAIndex(String customerId) throws ClassNotFoundException, SQLException, SaslException {
		String columnName = "umSPAIndex";
		String Command1 = "select * from [UMCO102] where CUSTNMBR ='" + customerId + "'";
		String Result = "";
		String ConnectionString = Read.ReadFile("ConnectionStringServTWO");
		Result = selectFromDb(Command1, ConnectionString, columnName);

		if (Result != "") {
			log("Open spa found Order verified = " + Result);

		}

		return Result;

	}

	public static String selectFromDb(String Command, String ConnectionString, String columnName)
			throws ClassNotFoundException, SQLException {
		// Following will created database
		String Result = "";
		Connection con = DriverManager.getConnection(ConnectionString);
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// Creating connection to the database

			// Executing the SQL Query and store the results in ResultSet
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(Command);
			while (rs.next()) {
				Result = rs.getString(columnName);
				// System.out.println(Result);
			}
			// While loop to iterate through all data and print results

		} catch (SQLDataException e) {
			e.printStackTrace();
			Assert.fail("Record not found check query");
		}

		finally {
			con.close();
		}
		return Result;

	}

	private static void log(String string) {

		System.out.println(string);
		// TODO Auto-generated method stub

	}

	public static boolean cancelSpa(String spaIndexfromdb, String Customer)
			throws ConnectionClosedException, InterruptedException {
		// CUSTOMER001
		char q = '"';
		RestAssured.baseURI = "http://localhost:3000/api/v2/spa/cancel";
		String rawbody = "{ " + q + "SpaCancel" + q + " :[{ " + q + "CustomerId" + q + ":" + q + Customer + q + "," + q
				+ "SpaIndex" + q + ":" + q + spaIndexfromdb + q + "," + q + "CancelDate" + q + ":" + q + "2020-06-08"
				+ q + "," + q + "CancelReason" + q + ":" + q + "Test" + q + "," + q + "ReasonCode" + q + ":" + q + " "
				+ q + "}]}";

		RequestSpecification httpRequest = RestAssured.given()
				.headers("Authorization", "Bearer " + getToken(), "Content-Type", ContentType.JSON, "Accept", "*/*",
						"Connection", "keep-alive", "Accept-Encoding", "gzip, deflate, br")
				.body(rawbody);

		Response response = httpRequest.put();
		JsonPath jsonPathEvaluator = response.jsonPath();
		Boolean result = true;
		try {
			result = jsonPathEvaluator.get("SPACancel[0].Success");
		} catch (IllegalArgumentException e) {

		}
		// System.out.println(getToken());
		if (result == false) {
			System.out.println(
					"Active (Open) special payment arrangement does not exist for customer at " + spaIndexfromdb);
			return false;
		}

		System.out.println("Active (Open) special payment arrangement cancelled for customer at " + spaIndexfromdb);
		return result;

	}

}
