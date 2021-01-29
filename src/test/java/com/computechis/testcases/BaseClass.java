package com.computechis.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.computechis.factory.BrowserFactory;
import com.computechis.factory.ConfigProvider;
import com.computechis.factory.DataProviderFactory;
import com.computechis.utilites.Utility;

@SuppressWarnings("unused")
public class BaseClass {

	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	String path;
	@BeforeSuite
	public void setupTestSuite() {
				//E:\Workspace7AM\HybridFramework\Reports
		path = System.getProperty("user.dir")+"\\Reports\\OrnageHRM.html";
	
		ExtentHtmlReporter  htmlReporter = new ExtentHtmlReporter(path);
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		System.out.println("Log:INFO - Report value : " +report);
		System.out.println("Log:INFO - Report setup ready");
	}
	@BeforeClass
	public void setUp() {
//		ConfigProvider config = new ConfigProvider();
//		driver = BrowserFactory.startApplication(config.getBrowser(), config.getStagingURL());
		driver = BrowserFactory.startApplication(DataProviderFactory.getConfig().getBrowser(), DataProviderFactory.getConfig().getStagingURL());
	}
	@AfterMethod
	public void tearDownTest(ITestResult result) {
		if(result.getStatus()== ITestResult.SUCCESS) {
			System.out.println("Log:INFO - Test Executed -Test status is passed ");
		}
		else if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Log:INFO - Test Executed -Test status is Failed ");
		}else if(result.getStatus() == ITestResult.SKIP) {
			System.out.println("Log:INFO - Test Executed -Test status is Skipped ");
		}
		if(result.getStatus() == ITestResult.SUCCESS) {
			try {
				logger.pass("Test Passed : ",MediaEntityBuilder.createScreenCaptureFromPath(Utility.getScreenshot(driver)).build());
			} catch (IOException e) {
				System.out.println("Unable to attach screenshot in report : " +e.getMessage());
			}
		}else if(result.getStatus() == ITestResult.FAILURE) {
			try {
				logger.fail("Test Failed : ", MediaEntityBuilder.createScreenCaptureFromPath(Utility.getScreenshot(driver)).build());
			} catch (IOException e) {
				System.out.println("Unable to attach screenshot in report : " +e.getMessage());
			}
		}else if(result.getStatus() == ITestResult.SKIP) {
			logger.skip("Test skipped..");
		}
		report.flush();
	}
	@AfterClass
	public void tearDown() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());		
		}
		BrowserFactory.closeApplication(driver);
	}

}
