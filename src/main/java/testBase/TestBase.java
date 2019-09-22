package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ReadConfigData;



public class TestBase {
	
	public WebDriver driver;
	public static Logger log;
	ReadConfigData ref= new ReadConfigData();
	public String url=ref.getApplicationURL();
	public String username=ref.getUsername();
	public String password=ref.getPassword();
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String br) {
				
		log=Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver",ref.getChromeDriverPath()/*System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe"*/);
		driver=new ChromeDriver();
		log.info("Chrome Driver object is created:");
		driver.manage().window().maximize();
		log.info("Driver maximization done:");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		log.info("Timeout is set to 10 secs:" );
		driver.get(url);
		log.info("Url is launched");
		}
		
		else if(br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",ref.getFirefoxPath()/*System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe"*/);
			driver=new FirefoxDriver();
			log.info("Firefox Driver object is created:");
			driver.manage().window().maximize();
			log.info("Driver maximization done:");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			log.info("Timeout is set to 10 secs:" );
			driver.get(url);
			log.info("Url is launched");	
		}
		
		else if(br.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",ref.getIEPath()/*System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe"*/);
			driver=new InternetExplorerDriver();
			log.info("IE Driver object is created:");
			driver.manage().window().maximize();
			log.info("Driver maximization done:");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			log.info("Timeout is set to 10 secs:" );
			driver.get(url);
			log.info("Url is launched");
		}
	}
	
	
/*	@AfterTest
	public void tearDown() {
		driver.quit();
	}*/
	
	
	public void captureScreen(WebDriver driver, String tname)  {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		Calendar cal= Calendar.getInstance();
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname /*+sdf.format(cal.getTime())+*/ + ".png");
		try {
		FileUtils.copyFile(source, target);
		}
		catch(IOException io) {
		io.printStackTrace();	
		}
		System.out.println("Screenshot taken");
	}
	
	    //from the Apache Commons Lang3.
		public static String randomStringGenerator(int count) {
			return (RandomStringUtils.randomAlphabetic(count));
		}
		
		//from the Apache Commons Lang3.
		public static String randomNumberGenerator(int count) {
			return (RandomStringUtils.randomNumeric(count));
		}
		

		public static String dateTimeCreator() {
			Calendar cal= Calendar.getInstance();
			SimpleDateFormat sdf= new SimpleDateFormat("_ddMMyyyy:hhmmss");
			return sdf.format(cal.getTime());
		}
		
		
		
}

