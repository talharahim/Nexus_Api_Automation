package Private;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.response.ValidatableResponse;

public class transactionsController {

	

	@Test(priority = 1, groups = "Transaction")
	public void getTransactions_v_2() throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/transactions/getTransactions";
		String ver = "2";
		String jpath = "./\\TestData\\getTransactionsv2.json";
				
		HashMap<String, String> params = new HashMap<String, String>();
		//CustomerId=500001&LocationId=100001&MeterReads=true&MiscCharges=true&Payment=true&Penalty=true&Bill=true&Check=true&Ticket=true&License=true
		//&Permit=true&Rental=true&SmallItem=true&OtherCharge=true&Invoice=true&Work=true&Open=true&History=true&Void=true&CSM=true
		//&LocalGov=true&Electric=true&Water=true
		params.put("CustomerId", "500001");
		params.put("LocationId", "100001");
		params.put("MeterReads", "true");
		params.put("MiscCharges", "true");
		params.put("Payment", "true");
		params.put("Penalty", "true");
		params.put("Bill", "true");
		params.put("Check", "true");
		params.put("Ticket", "true");
		params.put("License", "true");
		params.put("Permit", "true");
		params.put("Rental", "true");
		params.put("SmallItem", "true");
		params.put("OtherCharge", "true");
		params.put("Invoice", "true");
		params.put("Work", "true");
		params.put("Open", "true");
		params.put("History", "true");
		params.put("Void", "true");
		params.put("CSM", "true");
		params.put("Electric", "true");
		params.put("Water", "true");
	
		
		
				
		String result = CommonMethods.getMethod(uri, ver, params, jpath);
		System.out.println(result);
		
	}
	
	
	

}