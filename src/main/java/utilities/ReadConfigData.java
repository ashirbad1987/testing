package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigData {

	Properties prop;
	File file;
	FileInputStream fis;
	
	public ReadConfigData() {
		file=new File("./Configuration\\config.properties");
		try {
			fis= new FileInputStream(file);
			prop= new Properties();
			prop.load(fis);
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("IO Exception is resulted");
		}
		
	}
	
	public String getApplicationURL() {
		return prop.getProperty("url");
	}
	

	public String getUsername() {
		return prop.getProperty("username");
	}


	public String getPassword() {
		return prop.getProperty("password");
	}


	public String getChromeDriverPath() {
		return prop.getProperty("chromepath");
	}


	public String getFirefoxPath() {
		return prop.getProperty("firefoxpath");
	}


	public String getIEPath() {
		return prop.getProperty("iepath");
	}

	
}
