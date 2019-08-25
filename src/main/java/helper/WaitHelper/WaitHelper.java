package helper.WaitHelper;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.Logger.LoggerHelper;

public class WaitHelper {
	
	public WebDriver driver;
	private static Logger log=LoggerHelper.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver) 
	{
		this.driver=driver;
		log.debug("waitHelper: "+this.driver.hashCode());
	}
	
	/**Implicit Timeout.
	 * When the time unit supplied then consider that else by default consider the time unit in seconds.
	 * @param timeOut
	 * @param unit
	 */
	
	public void setImplicitWait(long timeOut, TimeUnit unit)
	{
		log.info("supplied time is:" +timeOut);
		driver.manage().timeouts().implicitlyWait(timeOut, unit==null? TimeUnit.SECONDS:unit);
		
	}
	
	/***
	 * This is the timeout defined for the entire page. If unit is not supplied then take the default value else consider
	 * the unit value supplied. 
	 * @param timeout
	 * @param unit
	 */
	public void setPageLoadTimeOut(long timeout, TimeUnit unit)
	{
		log.info(timeout);
		driver.manage().timeouts().pageLoadTimeout(timeout, unit==null?TimeUnit.SECONDS:unit);
	}
	
	//This is a wait with pooling interval.
	public WebDriverWait getWait(int timeOutInSeconds, int poolingEveryInMilliSecs)
	{
		log.debug(" ");
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(poolingEveryInMilliSecs, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
	
	//This method is to wait for an element until the element is visibility of element with pooling interval.
	public void waitForElementToBeVisible(WebElement element, int timeOut, int poolingTimeInSec)
	{
		log.info("Waiting for the element to be visible");
	    WebDriverWait wait=	getWait(timeOut, poolingTimeInSec);
	    wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//This method is to wait for an element until the element is found.
	public void waitForElement(WebDriver driver, WebElement element, long time)
	{
		WebDriverWait wait= new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element found " +element.getText());
	}

	//This function is to wait for an element until the element is clickable.
	public WebElement waitForElement(WebDriver driver,long time,  WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
}
