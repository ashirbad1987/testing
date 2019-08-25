package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.TestBase;
import utilities.ExcelUtils;

public class TC_DDT_002 extends TestBase{

	@DataProvider(name="TestData")
	public String[][] getData() {
		String excelpath=System.getProperty("user.dir")+"\\src\\main\\java\\testData\\LoginData.xlsx";
		int rowCount=ExcelUtils.getRowCount(excelpath, "Sheet4");
		int colCount=ExcelUtils.getCellCount(excelpath, "Sheet4",1);
		String [][]data=new String[rowCount][colCount];
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				
				data[i-1][j]=ExcelUtils.getCellData(excelpath, "Sheet4", i, j);
			}
		}
	return data;
	}
   @Test(dataProvider="TestData")
   public void TestDataProvider(String username, String password) {
	
	   LoginPage ref= new LoginPage(driver);
	   ref.LoginFunctionality(username, password);
	   try {
		   Thread.sleep(2000);	
	   }
	   catch(InterruptedException e) {
		   e.printStackTrace();
	   }
	   if(isAlertPresent()==true) {
		   acceptAlert();// Close the alert.
		   try {
		   Thread.sleep(2000);	
		   captureScreen(driver, "TestDataProvider");
		   Thread.sleep(2000);
		   }
		   catch(InterruptedException e) {
			   e.printStackTrace();
		   }
		   switchToDefaultContent();//switch to default page.
		   Assert.assertTrue(true);
		   log.warn("Login Failed");
	   }
	   else {
		   Assert.assertTrue(true);
		   log.info("Login Passed");
		   ref.logOutButton();
		   System.out.println(getAlertText());
		   acceptAlert();
		   switchToDefaultContent();
		   
		   
	   }
	   
	  

   }
  
   public Alert getAlert() {
	   return driver.switchTo().alert();
   }
   
   public void acceptAlert() {
	   getAlert().accept();
   }
   
   public void rejectAlert() {
	   getAlert().dismiss();;
   }
   
   public String getAlertText() {
	   return getAlert().getText();
   }
   public void switchToDefaultContent() {
	    driver.switchTo().defaultContent();
   }
   
   //User defined method to check the Alert is present or not.
   public boolean isAlertPresent() {
	   try {
	   getAlert();
	   return true;
       }
	   catch(NoAlertPresentException e) {
	   return false;  
	   }	  
     } 
}   
   