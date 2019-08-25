package helper.Logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import utility.ResourceHelper;


/***********************************************************
 ***********************************************************
 ***********************************************************
                        Log4j Configuration 
 ***********************************************************
 ***********************************************************
 ***********************************************************
 *Note:-Every class needs to be logged with Log4j for 
        generating logs.
        This method will accept one Argument of Class type.  
        This method will help in getting the object of the Log class
 ********************************************************************
 
 */
 
@SuppressWarnings("rawtypes")
public class LoggerHelper {

	private static boolean root=false;
	
	
	public static Logger getLogger(Class clas)
	{
			if (root)
			{
				return Logger.getLogger(clas);
			}
			
			else
			{
				PropertyConfigurator.configure(ResourceHelper.getResourcePath("\\log4j.properties"));
			    root=true;
			    return Logger.getLogger(clas);
			}
	}
	
}

