package Public;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.NexustAPIAutomation.java.CommonMethods;

public class BaseClass {

	@BeforeAll
	void BeforeTest() throws ClassNotFoundException, SQLException, InterruptedException {
		CommonMethods.CompanyDBRestore();
		Thread.sleep(25000);
	}
}
