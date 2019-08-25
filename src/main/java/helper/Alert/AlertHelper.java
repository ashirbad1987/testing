package helper.Alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import helper.Logger.LoggerHelper;

public class AlertHelper 
{
  private WebDriver driver;
  private Logger log=LoggerHelper.getLogger(AlertHelper.class);
  
  public AlertHelper(WebDriver driver) 
  {
	  this.driver=driver;
	  log.debug("AlertHelper:" + this.driver.hashCode());
  }
  
  public Alert getAlert()
  {
	  log.debug("");
	  return driver.switchTo().alert();
  }
  
  public void acceptAlert()
  {
	  log.info("Alert is Accepted");
	  getAlert().accept();
  }
  
  public void dismissAlert()
  {
	log.info("");
	getAlert().dismiss();
  }
  public String getAlertText()
  {
	  String text=getAlert().getText();
	  log.info("Text from the Alert is:"+text);
	  return text;
  }
  
  public boolean verifyAlertIsPresent()
  {
	  try
	  {
		  driver.switchTo().alert();
		  log.info("True");
		  return true;
	  }
	  catch(NoAlertPresentException e)
	  {
		  e.printStackTrace();
		  log.info("False");
		  return false;
	  }
  }
  public void acceptAlertIfPresent()
  {
	  if(!verifyAlertIsPresent())
	  {
		  return;
	  }
	  else
		  acceptAlert();
	  	  log.info("Alert is Accepted");
  }
  
  public void dismissAlertIfPresent()
  {
	  if(!verifyAlertIsPresent())
	  {
		  return;
	  }
	  else
	  {
		  dismissAlert();
		  log.info("");
	  }
	  
  }
  
  public void acceptPrompt(String text)
  {
	  if(!verifyAlertIsPresent())
	  {
		  return;
	  }
	  
	  else
	  {
		  Alert alert = getAlert();
		  alert.sendKeys(text);
		  alert.accept();
		  log.info("");
	  }
  }
}
