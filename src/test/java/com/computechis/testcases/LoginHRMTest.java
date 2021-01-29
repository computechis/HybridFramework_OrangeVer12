package com.computechis.testcases;

import org.testng.annotations.Test;

import com.computechis.factory.BrowserFactory;
import com.computechis.factory.ConfigProvider;
import com.computechis.pages.LoginPage;

import org.testng.annotations.BeforeClass;
import org.apache.log4j.xml.Log4jEntityResolver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

@SuppressWarnings("unused")
public class LoginHRMTest extends BaseClass{
	
	LoginPage lp;
	
	@Test
	public void login() {
		logger =report.createTest("Orange HRM Login Test");
		logger.info("Browser and Application is up and running.. ");
		lp=PageFactory.initElements(driver, LoginPage.class);
		/*lp.typeUserName();
		lp.typePassword();
		lp.clickOnLogin();*/
		lp.loginToApplication();
		logger.pass("Login done successfully..");
	}
	

}
