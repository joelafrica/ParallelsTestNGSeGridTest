package stepdefns;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.LoginPage;
import factories.DriverThreadManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginStepDefn {

	/*private final EventFiringWebDriver webDriver;
	*/
	WebDriver driver;
	
	@Before
	public void initializeScenario(){		
		driver = DriverThreadManager.getDriver();
		driver.manage().window().maximize();
		driver.get("http://www.cashconverters.com.au");
	}
	
	@After
	public void terminateScenario(){
		driver = DriverThreadManager.getDriver();
        if (driver != null) {
            driver.quit();
        }
	}
	
	@Given("^the user is on webshop$")
	public void the_user_is_on_webshop() throws Throwable {				
		LoginPage loginPg = new LoginPage(driver);
		loginPg.gotoWebshop();
	}

	@When("^user enters valid username and password$")
	public void user_enters_valid_username_and_password() throws Throwable {
		LoginPage loginPg = new LoginPage(driver);
		loginPg.strUserName = "jafrica";
		loginPg.strPassword = "Joel27070";		
		loginPg.enterUserName();
		loginPg.enterPassword();
		loginPg.signin();
	    
	}
	
	
	@Then("^user is logged in successfully$")
	public void user_is_logged_in_successfully() throws Throwable {
		String strName = "Joel";
	    Assert.assertTrue(new LoginPage(driver).isSignInSuccessful(strName));
	    //Assert.assertTrue(false);
	}

	
	@When("^user enters invalid username and password$")
	public void user_enters_invalid_username_and_password() throws Throwable {
		LoginPage loginPg = new LoginPage(driver);
		loginPg.strUserName = "jafrica";
		loginPg.strPassword = "Joel27070xx";		
		loginPg.enterUserName();
		loginPg.enterPassword();
		loginPg.signin();
	}

	
	@Then("^user is redirected to login page$")
	public void user_is_redirected_to_login_page() throws Throwable {
		Assert.assertTrue(new LoginPage(driver).isUserRedirectedToLoginPg());
	}
	
}
