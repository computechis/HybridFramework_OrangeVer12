package com.computechis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.computechis.utilites.Utility;

public class LogoutPage {

	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using ="//a[@id='welcome']") WebElement brandingLink;
	@FindBy(how=How.XPATH, using="//a[text()='Logout']") WebElement logoutLink;
	
	public void logoutFromApplicaion() {
		Utility.highLightElement(driver, brandingLink);
		brandingLink.click();
		Utility.highLightElement(driver, logoutLink);
		logoutLink.click();
	}
	/*
	 public void logoutFromApplicaion() {
		brandingLink.click();
		logoutLink.click();
	}
	 */
}
