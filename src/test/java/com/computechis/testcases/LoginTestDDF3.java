package com.computechis.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.computechis.factory.DataProviderFactory;
import com.computechis.pages.LoginPage;
import com.computechis.pages.LogoutPage;

public class LoginTestDDF3 extends BaseClass{
	LoginPage lp;
	LogoutPage lout;
	@Test(dataProvider = "OrangeHRM_Excel")
	public void loginDDF(String user, String pwd) {
		lp=PageFactory.initElements(driver, LoginPage.class);
		lp.loginToApplication(user, pwd);
		lout=PageFactory.initElements(driver, LogoutPage.class);
		lout.logoutFromApplicaion();
	}
	@DataProvider(name="OrangeHRM_Excel")
	public static Object[][] getData(){
		int totalRows=DataProviderFactory.getExcel().rowsCount("LoginTest");
		Object[][] data = new Object[totalRows][2];
		for(int rowNo = 0; rowNo < totalRows; rowNo++)
		{
			data[rowNo][0] =DataProviderFactory.getExcel().getStringData("LoginTest",rowNo, 0);
			data[rowNo][1] =DataProviderFactory.getExcel().getStringData("LoginTest", rowNo, 1);
		}
		return data;
	}
	@DataProvider(name="OrangeHRM_HardCoding")
	public static Object[][] getData1(){
		Object[][] data = new Object[3][2];
		data[0][0] ="vasuvvs";
		data[0][1] ="selenium@123";
		
		data[1][0] ="vasuvvs";
		data[1][1] ="selenium@123";
		
		data[2][0] ="vasuvvs";
		data[2][1] ="selenium@123";
		return data;
	}
	@DataProvider
	public static Object[][] getData2(){
		Object[][] data = new Object[3][2];
		data[0][0] ="vasuvvs";
		data[0][1] ="selenium@123";
		
		data[1][0] ="vasuvvs";
		data[1][1] ="selenium@123";
		
		data[2][0] ="vasuvvs";
		data[2][1] ="selenium@123";
		return data;
	}
}
