package testCases_Guru99;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import helper.Alert.AlertHelper;
import pageObjects.AddCustomerPage1;
import pageObjects.LoginPage;
import testBase.TestBase;
import utilities.ExcelUtils;

public class Demo123 extends TestBase{

	LoginPage login;
	AddCustomerPage1 addCust;
	AlertHelper ah;
	@DataProvider(name="TestData")
	public String[][] getData() {
		String excelpath=System.getProperty("user.dir")+"\\src\\main\\java\\testData\\LoginData.xlsx";
		int rowCount=ExcelUtils.getRowCount(excelpath, "Sheet3");
		int colCount=ExcelUtils.getCellCount(excelpath, "Sheet3",1);
		String [][]data=new String[rowCount][colCount];
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				
				data[i-1][j]=ExcelUtils.getCellData(excelpath, "Sheet3", i, j);
			}
		}
	return data;
	}
	
   @Test(dataProvider="TestData")
   public void TestDataProvider(String CustomerName,String Day,String Month ,String Year,String Address,String City,
		   String State,String Pin,String MobileNumber,String Email,String Password) {
	    login= new LoginPage(driver);
		log.info("Login page object is created");
		login.LoginFunctionality(username, password);
		
     addCust=new AddCustomerPage1(driver);
     addCust.addCustomer(CustomerName, Day, Month, Year, Address,City,State, Pin, MobileNumber, Password);
    
     //This line is to verify that any field is not valid.
     ah=new AlertHelper(driver);
     
     if(ah.verifyAlertIsPresent()) {
    	 ah.acceptAlert(); 
    	 captureScreen(driver, "TestDataProvider");
    	 Assert.assertTrue(true);
    	 
     }
     else {
         boolean result=driver.getPageSource().contains("Customer Registered Successfully!!!");
         if (result==true){
        	 log.info("Customer registration successful:");
        	 
        	  String excelpath=System.getProperty("user.dir")+"\\src\\main\\java\\testData\\LoginData.xlsx";
      		  int rowCount=ExcelUtils.getRowCount(excelpath, "Sheet3");
      		  int colCount=ExcelUtils.getCellCount(excelpath, "Sheet3",1);
         	  for(int i=1;i<=rowCount;i++) {
      		  for(int j=12;j<colCount;j++) {
         	  ExcelUtils.setData(excelpath, "Sheet3", i, j, "pass");
               }
             }
         }
         else {
         log.info("Customer registration failed: "); 	 
         captureScreen(driver, "TestDataProvider");
         
   	      String excelpath=System.getProperty("user.dir")+"\\src\\main\\java\\testData\\LoginData.xlsx";
 		  int rowCount=ExcelUtils.getRowCount(excelpath, "Sheet3");
 		  int colCount=ExcelUtils.getCellCount(excelpath, "Sheet3",1);
    	  for(int i=1;i<=rowCount;i++) {
 		  for(int j=12;j<colCount;j++) {
    	  ExcelUtils.setData(excelpath, "Sheet3", i, j, "pass");
          }
        }
         Assert.assertTrue(false);
       }
     }
   }
}