package testCases_Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import testBase.TestBase;

public class TestLogin extends TestBase{

	//WebDriver driver;
	
	@Test
	public void workFlow() throws InterruptedException {
		
		//WebElement signinOption=driver.findElement(By.xpath("//*[@id='nav-link-accountList']/span[1]"));
		Actions mouseHover=new Actions(driver);
		Thread.sleep(3000);
		//mouseHover.moveToElement(signinOption).perform();
		driver.findElement(By.xpath("//*[@id='nav-link-accountList']/span[1]")).click();
		
		Thread.sleep(3000);
		WebElement signin=driver.findElement(By.xpath("//*[@id='nav-flyout-ya-signin']/a/span"));
		mouseHover.moveToElement(signin).click().build().perform();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys("9538987917");
		driver.findElement(By.xpath("//*[@id='continue']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys("Tikans1987!");
		driver.findElement(By.xpath("//*[@id='signInSubmit']")).click();
		
		Thread.sleep(4000);
		//mouseHover.moveToElement(driver.findElement(By.xpath("//*[@id='nav-link-accountList']/span[2]"))).perform();
		driver.findElement(By.xpath("//*[@id='nav-link-accountList']/span[1]")).click();
		
		Thread.sleep(2000);
		mouseHover.moveToElement(driver.findElement(By.xpath("//*[@id='nav-item-signout']/span"))).click().build().perform();
	

		
	}
	
}
