package factories;

import org.openqa.selenium.WebDriver;

public class DriverThreadManager {

	    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	 
	    public static WebDriver getDriver() {
	        return webDriver.get();
	    }
	 
	    public static void setWebDriver(WebDriver driver) {
	        webDriver.set(driver);
	    }
	
}
