package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
	public String strUserName;
	public String strPassword;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getStrUserName() {
		return strUserName;
	}
	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}
	public String getStrPassword() {
		return strPassword;
	}
	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}
	
	public void enterUserName(){
		driver.findElement(By.name("username")).sendKeys(strUserName);
	}
	
	public void enterPassword(){
		driver.findElement(By.name("password")).sendKeys(strPassword);
	}
	
	public void signin(){
		driver.findElement(By.cssSelector("input[value=Login]")).click();
	}
	
	public boolean isSignInSuccessful(String strUser){
		String strText;
		//strText = driver.findElement(By.xpath("//div[@class='userProfile']")).getText();
		strText = driver.findElement(By.cssSelector("div[class='userProfile']")).getText();
		return strText.contains("Welcome " + strUser);
	}
	
	public boolean isUserRedirectedToLoginPg(){
		return driver.findElement(By.xpath("//form[@id='loginForm']")).isDisplayed();
	}

	public void gotoWebshop() {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Webshop'][contains(text(), 'Start Shopping')]")));
			driver.findElement(By.xpath("//a[@title='Webshop'][contains(text(), 'Start Shopping')]")).click();
	}
}
