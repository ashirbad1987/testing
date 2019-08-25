package helper.JavascriptHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Logger.LoggerHelper;

public class JavaScriptHelper 
{
	private WebDriver driver;
	private	Logger log=LoggerHelper.getLogger(JavaScriptHelper.class);
	
	public JavaScriptHelper(WebDriver driver) 
	{
		this.driver=driver;
		log.debug("JavaScriptHelper"+this.driver.hashCode());
	}
	
	//This method will help in executing javascript.
	public Object executeScript(String script)
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		log.info("info");
		return jse.executeScript(script);
	}

	//This method will help in executing multiple script and multiple argument.
	public Object executeScript(String script, Object...args)
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		log.info("Multiple script and multiple argument are passed");
		return jse.executeScript(script, args);
	}
	
	//This method is used to scroll to certain location which will consider the x,y co-ordinate of the element in the DOM.
	public void scrollToELement(WebElement element)
	{
		executeScript("window.scrollTo(argument[0],argument[1])",element.getLocation().x,element.getLocation().y);
		log.info("Scrolled to element and found in the Location");
	}
	
	//This method will use the above function and will click on the element.  
	public void scrollToElementAndClick(WebElement element)
	{
		scrollToELement(element);
		element.click();
		log.info(element+"is clicked");
	}
	
	//This function will performing the mouse hovering.
	public void scrollIntoView(WebElement element)
	{
		executeScript("argument[0].scrollIntoView()", element);
		log.info(element +" is highlighted");
	}
	
	//This functionality will perform the mouse hovering on the element and will click on the element.
	public void scrollIntoViewAndClick(WebElement element)
	{
		scrollIntoView(element);
		element.click();
		log.info("performed mouse hovering on"+element +"And Clicked");
	}
	
	//This functionality is to perform full scroll down vertically.
	public void scrollDownVertically()
	{
		executeScript("window.scrollTo(0, document.body.scrollHeight");
	}
	
	//This functionality is to scroll up vertically.
	public void scrollUpVertically()
	{
		executeScript("window.scrollTo(0, -document.body.scrollHeight");
	}
	
	//This functionality is to scroll down by pixel.
	public void scrollDownByRequiredPixel()
	{
		executeScript("window.scrollBy(0,1500)");
	}
	
	//This functionality will help in scroll up by required pixel.
	public void scrollUpByPixel()
	{
		executeScript("window.scrollBy(0,-1500)");
	}
	
	//This functionality will perform Zoom In.
	public void zoominByPercentage()
	{
		executeScript("document.body.style.zoom='60%'");
	}
	
	//This is the Zoom Out Functionality to default.
	public void zoomInByPercentage()
	{
		executeScript("document.body.style.zoom='100%'");
	}
	
	
}
