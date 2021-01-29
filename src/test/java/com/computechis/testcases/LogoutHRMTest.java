package com.computechis.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.computechis.factory.BrowserFactory;
import com.computechis.factory.ConfigProvider;
import com.computechis.pages.LoginPage;
import com.computechis.pages.LogoutPage;
import com.computechis.utilites.Utility;

@SuppressWarnings("unused")
public class LogoutHRMTest extends BaseClass{
	LoginPage lp;
	LogoutPage lout;
	@Test
	public void logout() {
		lp=PageFactory.initElements(driver, LoginPage.class);
		lp.loginToApplication();
		/*try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());		
		}*/
		Utility.waitTo(3);
		lout=PageFactory.initElements(driver, LogoutPage.class);
		lout.logoutFromApplicaion();
	}

}
