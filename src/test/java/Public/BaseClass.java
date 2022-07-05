package Public;

import java.sql.SQLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.NexustAPIAutomation.java.CommonMethods;

public class BaseClass {

	@BeforeClass
	void BeforeTest() throws ClassNotFoundException, SQLException, InterruptedException {
		CommonMethods.CompanyDBRestore();
	}
}
