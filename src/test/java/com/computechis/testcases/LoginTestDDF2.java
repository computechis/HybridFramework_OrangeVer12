package com.computechis.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.computechis.factory.DataProviderFactory;
import com.computechis.pages.LoginPage;
import com.computechis.pages.LogoutPage;

@SuppressWarnings("unused")
public class LoginTestDDF2 extends BaseClass {
	
	LoginPage lp;
	@Test
	public void login() {
		//ExcelReader excel = new ExcelReader();
		lp = PageFactory.initElements(driver, LoginPage.class);
		
		lp.loginToApplication(DataProviderFactory.getExcel().getCellData("LoginTest", 0, 0),DataProviderFactory.getExcel().getCellData("LoginTest", 0, 1));
		//lp.loginToApplication("Admin", "admin123");
		
	}
	
	
	 
}
