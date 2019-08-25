package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ResourceHelper {

	/** #1
	 * *This method is designed to provide the path till the project Location.
	 * @return
	 */
	public static String getBaseResourcePath()
	{
		String path=System.getProperty("user.dir");
		System.out.println(path);
		return path;
	}
	

	/** #2
	 * *This method will call the above method and will accept the file path.
	 * @return
	 */
	 
	public static String getResourcePath(String resource)
	{
		String pathValue= getBaseResourcePath()+resource;
		return pathValue;
	}
	
	
	/** #3
	 * *This method is handy when there is call to the fileinput stream.
	 * @return
	 */
	public static FileInputStream Resources(String path)
	{
		try
		{
		return new FileInputStream(ResourceHelper.getResourcePath(path));
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/*public static void main(String[] args) {
		
		getResourcePath("\\log4j.properties");
	}*/
}
