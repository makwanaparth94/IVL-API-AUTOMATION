package baseTest;

import org.testng.annotations.BeforeSuite;

import testbase.TestConfiguraionProperties;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class TestBase {
	@BeforeSuite(alwaysRun = true)
	public void configure () {
		TestConfiguraionProperties config = new TestConfiguraionProperties();
		baseURI = config.getbaseURI();
		basePath=config.getbasePath();
		//To enable and disable http certificate.
		System.setProperty("jsse.enableSNIExtension", "true");
	}
}
