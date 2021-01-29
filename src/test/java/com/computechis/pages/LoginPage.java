package com.computechis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.computechis.utilites.Utility;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	// Locators
	/*
	  @FindBy(id = "foobar") WebElement foobar;
	 */
	@FindBy(id="txtUsername") WebElement txtUser;
	/*
	  @FindBy(how = How.ID, using = "foobar") WebElement foobar;
	 */
	@FindBy(how = How.NAME, using ="txtPassword") WebElement txtPasswd;
	
	@FindBy(how = How.CSS, using ="input#btnLogin") WebElement loginBtn;
	
	
	
	
	// Action methods
	public void typeUserName() {
		txtUser.sendKeys("Admin");
	}
	public void typeUserName(String user) {
		txtUser.sendKeys(user);
	}
	public void typePassword(String pwd) {
		txtPasswd.sendKeys("admin123");
	}
	public void typePassword() {
		txtPasswd.sendKeys("admin123");
	}
	public void clickOnLogin() {
		loginBtn.click();
	}
	
	/*public void loginToApplication() {
		txtUser.sendKeys("Admin");
		txtPasswd.sendKeys("admin123");
		loginBtn.click();
	}*/
	public void loginToApplication() {
		Utility.highLightElement(driver, txtUser);
		txtUser.sendKeys("Admin");
		Utility.highLightElement(driver, txtPasswd);
		txtPasswd.sendKeys("admin123");
		Utility.highLightElement(driver, loginBtn);
		loginBtn.click();
	}
	public void loginToApplication(String uName, String pass) {
		txtUser.sendKeys(uName);
		txtPasswd.sendKeys(pass);
		loginBtn.click();
	}
}
