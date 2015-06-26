package factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class DriverFactory {

	public static WebDriver getDriver(String hubhost, String hubport, String platform, String browserName) {
        WebDriver driver = null;
        
        /* ****** for Se Grid execution ****** */
        DesiredCapabilities caps = new DesiredCapabilities();
        
        switch (platform) {
		case "windows":  caps.setPlatform(Platform.WINDOWS);	
						break;
		case "mac": caps.setPlatform(Platform.MAC);
						break;
        }
        
        switch (browserName) {
        case "chrome": //System.setProperty("webdriver.chrome.driver", "/Users/Joel/Documents/Technical-Testing/BrowserDrivers");
        				caps = DesiredCapabilities.chrome();
        				break;
        case "firefox": caps = DesiredCapabilities.firefox();
        				break;
        }
        
        try {
        	
            URL hubURL = new URL("http://" + hubhost + ":" + hubport + "/wd/hub");
            driver = new RemoteWebDriver(hubURL, caps);
            
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        
        
        /* ******for non grid execution******* 
        switch (browserName) {
		case "chrome":  System.setProperty("webdriver.chrome.driver", "/Users/Joel/Documents/Technical-Testing/BrowserDrivers/chromedriver");
						driver = new ChromeDriver();	
						break;
		case "firefox": driver = new FirefoxDriver();
						break;
        } */
        
        return driver;
    }
	
}
