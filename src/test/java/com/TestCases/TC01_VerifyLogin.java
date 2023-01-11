package com.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pages.Fb_LoginPage;
import com.Utilities.FunctionalityLibrary;
import com.Utilities.ReadXcel;
import com.Utilities.Reporting;

public class TC01_VerifyLogin extends FunctionalityLibrary{
	int rowCount;
	int colCount;
	ReadXcel excel;
	
	@BeforeClass
	public void before() {
	     excel=new ReadXcel("./src/test/resources/TestData/TC01_TestData.xlsx");
		rowCount= excel.getRowCount("Sheet1");
		colCount= excel.getColumnCount("Sheet1");
		
	}

	
	
	@Test(dataProvider = "LoginData")
	public void LoginTest(String email,String password) {
		Reporting.startReport();
		initBrowser();
	    Fb_LoginPage loginPage= new Fb_LoginPage();

		openUrl();
		loginPage.loginFb(email, password);
        
	
	}
	
	@DataProvider(name = "LoginData",parallel = true)
	public Object[][] getLoginData() {
		Object[][] testData= new Object[rowCount-1][colCount];
		for(int i=1;i<rowCount;i++) {
			
			for(int j=0;j<colCount;j++) {
				testData[i-1][j]=excel.getCelValue("Sheet1", i, j);
			}
		}
		
		return testData;
	}
	@AfterMethod
	public void after() {
		driver.get().close();
	}
}
