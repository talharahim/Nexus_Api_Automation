package Public;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import org.apache.pdfbox.text.PDFTextStripper;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.NexustAPIAutomation.java.CommonMethods;

import io.restassured.response.ValidatableResponse;

public class printControllerV4 {

	@Test(priority = 1, groups = "printController")
	public void getprintreportPaymentPostEditListv3()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {

		String uri = "/print/report/PaymentPostEditList";
		String ver = "4.0";
		String jpath = "./\\TestData\\paymentPostEditlistv4.json";
		HashMap<String, String> params = new HashMap<String, String>();

		String result = CommonMethods.getMethodContains(uri, ver, params, jpath);
		System.out.println(result);
	}

}