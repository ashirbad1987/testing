package testCases_Guru99;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.TestBase;

public class TC_LoginTest_001 extends TestBase{

	@Test(priority=1)
	public void test1() {
	
		
		
		LoginPage login= new LoginPage(driver);
		log.info("Login page object is created");
		login.LoginFunctionality(username, password);
		log.info(" Username and password is accessed and Logged into the application");
		String str=driver.getTitle();
		System.out.println(str);
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage", "String values are not equals");
		
	}
	
	@Test(priority=2)
	public void test2() {
	
		
		
		LoginPage login= new LoginPage(driver);
		log.info("Login page object is created");
		login.LoginFunctionality(username, password);
		log.info(" Username and password is accessed and Logged into the application");
		String str=driver.getTitle();
		System.out.println(str);
		if(driver.getTitle().equals("James")) {
			
			captureScreen(driver, "Test2");
			Assert.assertTrue(false);
			log.info("Test failed");
			
			
		}
		else {
			
			log.info("Test Passed");
			Assert.assertTrue(true);
		}
		
	}
	
}
