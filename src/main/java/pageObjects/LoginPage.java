package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	 public WebDriver driver;
	 
	 public LoginPage(WebDriver driver) {
		 
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(name="uid")
	 @CacheLookup
	 public WebElement Username;
	 

	 @FindBy(name="password")
	 @CacheLookup
	 public WebElement Password;
	 

	 @FindBy(name="btnLogin")
	 @CacheLookup
	 public WebElement LoginButton;
	 
	 @FindBy(how=How.XPATH, using="/html/body/div[3]/div/ul/li[15]/a")
	 @CacheLookup
	 public WebElement LogOut;
	 
	 public void logOutButton() {
		 LogOut.click();
	 }
	 
	 
	 public void LoginFunctionality(String username, String password) {
		 this.Username.sendKeys(username);
		 this.Password.sendKeys(password);
		 LoginButton.click();
	 }
	 
	 
	 
}
