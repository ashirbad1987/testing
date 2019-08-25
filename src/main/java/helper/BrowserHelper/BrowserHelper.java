package helper.BrowserHelper;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import helper.Logger.LoggerHelper;

public class BrowserHelper 
{
	private WebDriver driver;
	private Logger log=LoggerHelper.getLogger(LoggerHelper.class);
	
	public BrowserHelper(WebDriver driver) 
	{
		this.driver=driver;
		log.debug("BrowserHelper"+this.driver.hashCode());
	}
	//This method will help in backward navigation of the browser.
	public  void navigateBackward()
	{
		driver.navigate().back();
		log.info("Backward navigation successful");
	}
	//This method will help in forward navigation of the browser.
	public  void navigateForward()
	{
		driver.navigate().forward();
		log.info("forward navigation successful");
	}
	//This method will help in refreshing the current browser.
	public void browserRefresh()
	{
		driver.navigate().refresh();
		log.info("Browser is refresh successful");
	}
	
	//This method will help to get all the window handles.
	public Set<String> getwindowHandles()
	{
		log.info("Child window capture successful");
		return driver.getWindowHandles();
	}
	
	//This method will give the window based on the index supplied by the user.
	public void switchToWindow(int index)
	{
		//Converted to linked list because based on the index supplied we can navigate to the window.
		List<String>windowId=new LinkedList<String>(getwindowHandles());
		if(index<0||index>windowId.size())
		{
			throw new IllegalArgumentException();
		}
		else
		{
			driver.switchTo().window(windowId.get(index));
			log.info(index);
		}
	}
	
	//This method will help in switching to the parent window.
	public void switchToParentWindow()
	{
		List<String>windowId=new LinkedList<String>(getwindowHandles());
		driver.switchTo().window(windowId.get(0));
		log.info("Successfully switched to the parent ID");
	}
	
	//This method will close all the child window and then will navigate to the parent window.
	public void closeAllChildAndSwitchToParent()
	{
		List<String>windowId=new LinkedList<String>(getwindowHandles());
		for(int i=1;i<windowId.size();i++)
		{
			log.info(windowId.get(i));
			driver.switchTo().window(windowId.get(i));
			driver.close();
		}
		switchToParentWindow();
	}
	
	//Switch to Frame based on the Id or Name provided.
	public void switchToFrame(String frameIDorName)
	{
		driver.switchTo().frame(frameIDorName);
		log.info(frameIDorName);
	}
	
	
}
