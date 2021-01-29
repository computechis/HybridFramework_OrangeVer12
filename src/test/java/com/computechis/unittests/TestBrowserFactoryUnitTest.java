package com.computechis.unittests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.computechis.factory.BrowserFactory;
import com.computechis.factory.ConfigProvider;


public class TestBrowserFactoryUnitTest {

	@Test
	public void testBrowser() {
		//;
		ConfigProvider config = new ConfigProvider();
		WebDriver driver =BrowserFactory.startApplication(config.getBrowser(), config.getStagingURL());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		BrowserFactory.closeApplication(driver);
	}
}
