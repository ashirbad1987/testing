package helper.GenericHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import helper.Logger.LoggerHelper;

public class GenericHelper 
{
	private static Logger log= LoggerHelper.getLogger(GenericHelper.class);
	
	//Hence this method will help in returning the text from the element.
	public String readValueFromElement(WebElement element)
	{
		//Verify if the element contain null value then null value is returned.
		if(element==null)
		{
			log.info("Element not found");
			return null;
		}
		
		//If the element is not displayed then the value cannot be returned.
		  boolean status=false;
		  try
		  {
			status=element.isDisplayed();
			
		  }
		 catch(Exception e)
		   {
			log.error(e);
		    return null; 
		   }
		  {
			  //If false then go to the status else get the text and return the value.
			  if(!status)
			  {
				  return null;
			  }
		  }
		  String text= element.getText();
		  log.info("Text of the element is:"+text);
		  return text;
	}
	
//This method will help in returning the text value from the element.
	
	public String getAttributeValueOfElement(WebElement element)
	{
		//If element is null then return null.
		if(element==null)
		{
			return null;
		}
		//If element is not displayed then return null.
		if(!isDisplayed(element))
		{
			return null;
		}
		//Else get the text from the attribute.
		String text=element.getAttribute("text");
		log.info(text);
		return text;
	}
	

	/**This method will provide the boolean value about the presence of the element. 
	 * isDisplayed() will always return true when the element is found and will return
	 * an exception when the element is not found. But this method will provide the 
	 * information to the user that the element is not found with a result false instead 
	 * of an exception in place. **/

    public boolean isDisplayed(WebElement element) 
    {
    try
       {
    	element.isDisplayed();
    	log.info("Element is displayed" + element);
    	return true;
       }
    
    catch(Exception e)
       {
    	log.info(e);
    	//To See the detailed emailable report in more detailed manner we can use the below line of code.
    	// More details of the reports can be seen under the "messages" section under the "emailable-report.html" after refresh.
    	Reporter.log(e.fillInStackTrace().toString());
    	return false;
       }
	
     } 
	 
    
    /***This method intention is exactly opposite to that of the above method and the return 
     *  type should be true as expected, hence when this method is called then we should make 
     *  sure that control goes to the catch block.
    */
    public boolean isnotDisplayed(WebElement element) 
    {
    try
       {
    	element.isDisplayed();
    	log.info("Element is displayed" + element);
    	return false;
       }
    
    catch(Exception e)
       {
    	log.info(e);
    	Reporter.log(e.fillInStackTrace().getMessage());
    	return true;
       }
	
     } 
    
    protected String getDisplayText(WebElement element)
    {
    	if(element==null)
    	{
    		return null;
    	}
    	else if(!isDisplayed(element))
    	{
    		return null;
    	}
    	else
    		return element.getText();
    }
    
    
    
    
 }
