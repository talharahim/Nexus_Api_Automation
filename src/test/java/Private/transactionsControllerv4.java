package Private;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.response.ValidatableResponse;

public class transactionsControllerv4 {

	@Test(priority = 1, groups = "Transaction")
	public void getapplyByService_v4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/transaction/payment/PYMT00000000405/MISC00000000311/applyByService";
		String ver = "4.0";
		String jpath = "./\\TestData\\getapplyByService_v4.json";
		HashMap<String, String> params = new HashMap<String, String>();
		// params.put("CustomerId", "CUSTOMER012"); 
		 //params.put("LocationId", "LOCATION011"); 
		 String result = CommonMethods.getMethod(uri, ver, params, jpath);
		 System.out.println(result);
	}
	
	@Test(priority = 2, groups = "Transaction")
	public void getMeterReadInquiryWork_v4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/transaction/read/READ00000000913";
		String ver = "4.0";
		String expected = "{\"Read\":{\"Success\":true,\"Data\":{\"DocumentNumber\":\"READ00000000913\",\"PrevDocumentNumber\":\"\",\"NextDocumentNumber\":\"\",\"BatchId\":\"TEST100\",\"Description\":\"\",\"LocationId\":\"WATER100\",\"EquipmentId\":\"ELECT\",\"ReadingType\":{\"Id\":1,\"Description\":\"Actual\"},\"NetMeterType\":{\"Id\":1,\"Description\":\"None\"},\"MeterReader\":\"\",\"ReasonCodeId\":\"\",\"CreatedBy\":\"sa\",\"NumberOfDays\":32,\"Components\":0,\"MeterGroup\":\"\",\"SequenceNumber\":0,\"RouteId\":\"001\",\"Status\":\"Open\",\"TotalMultiplier\":1.00000,\"ConnectionSequence\":1,\"ServiceTypeId\":\"ELECTRIC\",\"ReadingDateTime\":\"2020-02-10T08:14:31\",\"PreviousReadingDate\":\"2020-01-10\",\"CreateDate\":\"2027-04-12\",\"DateAdjusted\":\"1900-01-01\",\"Customer\":{\"Id\":\"CUSTOMER001\",\"Type\":\"Individual\",\"Individual\":{\"FullName\":\"Mr. Joe P MacDonald\",\"Name\":{\"Title\":\"Mr.\",\"First\":\"Joe\",\"Middle\":\"P\",\"Last\":\"MacDonald\"}},\"Business\":null}},\"Messages\":[]}}";
		HashMap<String, String> params = new HashMap<String, String>();
	    String result = CommonMethods.getMethodasString(uri, ver, params);
	    if (!result.contentEquals(expected))
	    {
	    	Assert.fail();
	    }
		System.out.println(result);
	}
	
	@Test(priority = 3, groups = "Transaction")
	public void getMeterReadInquiryOpen_v4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/transaction/read/READ00000000418";
		String ver = "4.0";
		String expected = "{\"Read\":{\"Success\":true,\"Data\":{\"DocumentNumber\":\"READ00000000418\",\"PrevDocumentNumber\":\"\",\"NextDocumentNumber\":\"\",\"BatchId\":\"READ55\",\"Description\":\"\",\"LocationId\":\"LOCEMP-1\",\"EquipmentId\":\"EQUIPELEC021\",\"ReadingType\":{\"Id\":1,\"Description\":\"Actual\"},\"NetMeterType\":{\"Id\":1,\"Description\":\"None\"},\"MeterReader\":\"\",\"ReasonCodeId\":\"\",\"CreatedBy\":\"\",\"NumberOfDays\":91,\"Components\":0,\"MeterGroup\":\"\",\"SequenceNumber\":101,\"RouteId\":\"ROUTEE001\",\"Status\":\"Open\",\"TotalMultiplier\":1.00000,\"ConnectionSequence\":1,\"ServiceTypeId\":\"ELECTRIC\",\"ReadingDateTime\":\"2000-06-30T11:49:04\",\"PreviousReadingDate\":\"2000-03-31\",\"CreateDate\":\"2000-06-30\",\"DateAdjusted\":\"1900-01-01\",\"Customer\":{\"Id\":\"CUSTOMER003\",\"Type\":\"Individual\",\"Individual\":{\"FullName\":\"Miss Jeannie K Bernard\",\"Name\":{\"Title\":\"Miss\",\"First\":\"Jeannie\",\"Middle\":\"K\",\"Last\":\"Bernard\"}},\"Business\":null}},\"Messages\":[]}}";
		HashMap<String, String> params = new HashMap<String, String>();
	    String result = CommonMethods.getMethodasString(uri, ver, params);
	    if (!result.contentEquals(expected))
	    {
	    	Assert.fail();
	    }
		System.out.println(result);
	}
	
	@Test(priority = 4, groups = "Transaction")
	public void getMeterReadInquiryHistory_v4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/transaction/read/READ00000000002";
		String ver = "4.0";
		String expected = "{\"Read\":{\"Success\":true,\"Data\":{\"DocumentNumber\":\"READ00000000002\",\"PrevDocumentNumber\":\"\",\"NextDocumentNumber\":\"\",\"BillNumber\":\"BILL00000000001\",\"Description\":\"\",\"EquipmentId\":\"EQUIPMENT011\",\"ReadingType\":{\"Id\":1,\"Description\":\"Actual\"},\"LocationId\":\"ELECWAT001\",\"NetMeterType\":{\"Id\":1,\"Description\":\"None\"},\"MeterReader\":\"\",\"ReasonCodeId\":\"\",\"CreatedBy\":\"\",\"NumberOfDays\":1,\"Components\":0,\"MeterGroup\":\"\",\"SequenceNumber\":0,\"RouteId\":\"ROUTEEW001\",\"Status\":\"History\",\"TotalMultiplier\":1.00000,\"ConnectionSequence\":1,\"ServiceTypeId\":\"ELECTRIC\",\"ReadingDateTime\":\"1997-01-01T10:27:00\",\"PreviousReadingDate\":\"1997-01-01\",\"CreateDate\":\"1997-01-01\",\"DateAdjusted\":\"1900-01-01\",\"Customer\":{\"Id\":\"CUSTOMER014\",\"Type\":\"Individual\",\"Individual\":{\"FullName\":\"Test Name\",\"Name\":{\"Title\":\"\",\"First\":\"Test\",\"Middle\":\"\",\"Last\":\"Name\"}},\"Business\":null}},\"Messages\":[]}}";
		HashMap<String, String> params = new HashMap<String, String>();
	    String result = CommonMethods.getMethodasString(uri, ver, params);
	    if (!result.contentEquals(expected))
	    {
	    	Assert.fail();
	    }
		System.out.println(result);
	}
	
	
	@Test(priority = 5, groups = "Transaction")
	public void gettransactionbatch_v4() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		String uri = "/transaction/batch/NADMC2022093001";
		String ver = "4.0";
		String expected = "{\"Batch\":{\"Success\":true,\"Data\":{\"Approved\":false,\"ApprovedDate\":\"1900-01-01\",\"ApprovedUser\":\"\",\"BatchDescription\":\"API Deposit Misc Charge\",\"BatchId\":\"NADMC2022093001\",\"source\":\"MISC CHARGES\",\"Status\":0,\"Frequency\":1,\"FrequencyDescription\":\"Single Use\",\"BatchTotal\":92.00000,\"ControlTotal\":0.00000,\"ControlNumber\":0,\"CreatedDate\":\"1900-01-01\",\"ModifiedDate\":\"1900-01-01\",\"PostedDate\":\"1900-01-01\",\"Marked\":false,\"NumberOfTransactions\":1,\"PostUserId\":\"\",\"PostDate\":\"2022-09-30\",\"RecurringPost\":0,\"RecurringLastDate\":\"1900-01-01\",\"NumberOfPosting\":0,\"BatchDaysToIncrement\":0,\"CurrencyId\":\"\",\"CheckBookId\":\"FIRST NATIONAL\",\"PaymentoriginId\":\"\"},\"Messages\":[]}}";
		HashMap<String, String> params = new HashMap<String, String>();
	    String result = CommonMethods.getMethodasString(uri, ver, params);
	    if (!result.contentEquals(expected))
	    {
	    	Assert.fail(result);
	    }
		System.out.println(result);
		
		
		uri = "/transaction/batch/ABC1213";
		ver = "4.0";
		expected = "{\"Batch\":{\"Success\":true,\"Data\":{\"Approved\":false,\"ApprovedDate\":\"1900-01-01\",\"ApprovedUser\":\"\",\"BatchDescription\":\"\",\"BatchId\":\"ABC1213\",\"source\":\"MISC CHARGES\",\"Status\":0,\"Frequency\":0,\"FrequencyDescription\":\"\",\"BatchTotal\":3.82000,\"ControlTotal\":0.00000,\"ControlNumber\":0,\"CreatedDate\":\"1900-01-01\",\"ModifiedDate\":\"1900-01-01\",\"PostedDate\":\"1900-01-01\",\"Marked\":false,\"NumberOfTransactions\":4,\"PostUserId\":\"sa\",\"PostDate\":\"2019-07-31\",\"RecurringPost\":0,\"RecurringLastDate\":\"1900-01-01\",\"NumberOfPosting\":0,\"BatchDaysToIncrement\":0,\"CurrencyId\":\"\",\"CheckBookId\":\"FIRST NATIONAL\",\"PaymentoriginId\":\"\"},\"Messages\":[]}}";
		params = new HashMap<String, String>();
	    result = CommonMethods.getMethodasString(uri, ver, params);
	    if (!result.contentEquals(expected))
	    {
	    	Assert.fail(result);
	    }
		System.out.println(result);
	}
}