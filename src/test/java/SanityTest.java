import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import factories.DriverFactory;
import factories.DriverThreadManager;


@CucumberOptions(features = "src/test/java/Features/", monochrome = true, plugin = {"pretty", "json:target/cucumberbatch3.json"})
public class SanityTest extends AbstractTestNGCucumberTests {

	@BeforeTest
	@Parameters({"hubhost", "hubport", "platform", "browser"})
	public void setup(String hubhost, String hubport, String platform, String browser) {
		WebDriver driver = DriverFactory.getDriver(hubhost, hubport, platform, browser);
		DriverThreadManager.setWebDriver(driver);
        System.out.println(">>>>>> inside setup, setting driver for " + browser);
	}
	
}
