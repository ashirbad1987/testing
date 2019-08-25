package helper.AssertionHelper;



import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import helper.Logger.LoggerHelper;

public class VerificationHelper 
/**
 * Assertion helper is used to perform the right assertion .
 * There may be multiple instances when we need to perform the assertions.
 * Therefore this class can be reused in any script which needs the assertions to be in place.
 * 
 * **
 */
{
	 private static final Logger log=LoggerHelper.getLogger(VerificationHelper.class);
	 
	 //Synchronized for thread safety.
	 public static synchronized boolean isElementPresent(WebElement element)
	 {
		 boolean isElementDisplayed=false;
		 
		 try
		 {
			isElementDisplayed = element.isDisplayed(); 
			log.info(element.getText()+"is Displayed ");
		 }
		 catch(Exception e)
		 {
			 log.error("Element not found:"+e);
		 }
		 
		 return isElementDisplayed;
	 }
	 
	 public static synchronized boolean isElementNotPresent(WebElement element)
	 {
		 boolean isElementDisplayed=false;
		 try
		 {
			 element.isDisplayed();
			 log.info(element.getText()+ "is Displayed");
		 }
		 catch(Exception e)
		 {
			 log.error("Element Not found:"+e);
			 isElementDisplayed=true;
		 }
		 return isElementDisplayed;
	 }
	 
	 public static boolean verifyTextAreEqual(WebElement element, String ExpectedText)
	 {
		 boolean status=false;
		 try
		 {
			 String ActualText=element.getText();
			 
			 if(ActualText.equalsIgnoreCase(ExpectedText))
			 {
			 log.info("Expected Text is : "+ExpectedText + " Actual Text is: " +ActualText);
			 status=true;
			 }
			 
			 else
			 {		 
			 log.info("Expected Text is : "+ExpectedText + " Actual Text is: " +ActualText);
			 return status;
			 }	 
		 }
		 
		 catch(Exception e )
		 {
			 log.error("Actual Text is:" + element.getText() + "Expected Text is:"+ ExpectedText);
			 log.info("Text No Matching"+ e); 
		 }
		 return status;
	 }
}



