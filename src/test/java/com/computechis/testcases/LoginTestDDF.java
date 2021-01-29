package com.computechis.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.computechis.factory.DataProviderFactory;
import com.computechis.factory.ExcelReader;
import com.computechis.pages.LoginPage;

@SuppressWarnings("unused")
public class LoginTestDDF extends BaseClass {
	
	LoginPage lp;
	
	@Test
	public void login() {
		//ExcelReader excel = new ExcelReader();
		lp = PageFactory.initElements(driver, LoginPage.class);
		lp.loginToApplication(DataProviderFactory.getExcel().getStringData("LoginTest", 0, 0), 
				               DataProviderFactory.getExcel().getStringData("LoginTest", 0, 1));
		//lp.loginToApplication(excel.getStringData("LoginTest", 0, 0), excel.getStringData("LoginTest", 0, 1));
//		lp.loginToApplication("Admin", "admin123");
	}

	
}
