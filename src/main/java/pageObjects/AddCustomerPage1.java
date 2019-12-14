package pageObjects;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class AddCustomerPage1 {

	WebDriver driver;
	public AddCustomerPage1(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer; 
	
	@FindBy(how = How.XPATH, using = "//*[@name='name']")
	@CacheLookup
	WebElement txtCustomerName;

	@FindBy(how = How.XPATH, using = "//*[@name='rad1']")
	@CacheLookup
	WebElement rdGender;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='dob']")
	WebElement txtdob;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@name='addr']")
	WebElement txtaddress;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@name='city']")
	WebElement txtcity;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@name='state']")
	WebElement txtstate;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@name='pinno']")
	WebElement txtpinno;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@name='telephoneno']")
	WebElement txttelephoneno;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@name='emailid']")
	WebElement txtemailid;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@name='password']")
	WebElement txtpassword;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@name='sub']")
	WebElement btnSubmit;
	
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
			
	}

	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
		
	}

	public void custgender(String cgender) {
		rdGender.click();
	}

	public void custdob(String dd,String mm,String yyyy) {
		txtdob.sendKeys(dd+mm+yyyy);
			
	}
	
	

	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}

		
	public void custemailid() {
		txtemailid.sendKeys(TestBase.randomStringGenerator(4)+TestBase.dateTimeCreator()+"@gmail.com");
	}

	public void custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}

	public void custsubmit() {
		btnSubmit.click();
	}
	
	public void addCustomer(String cusName, String day, String month, String year, String address, String city, String state,String pin, String mobileNumber, String password) {
		try {
	    Thread.sleep(1000);
		clickAddNewCustomer();
		Thread.sleep(1000);
		custName(cusName);
		Thread.sleep(2000);
		custdob(day, month, year);
		Thread.sleep(2000);
		custaddress(address);
		Thread.sleep(1000);
		custcity(city);
		Thread.sleep(1000);
		custstate(state);
		Thread.sleep(1000);
		custpinno(pin);
		Thread.sleep(1000);
		custtelephoneno(mobileNumber);
		Thread.sleep(1000);
		custemailid();
		Thread.sleep(1000);
		custpassword(password);
		Thread.sleep(1000);
		custsubmit();
		Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
