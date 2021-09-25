package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "uid")
	@CacheLookup
	WebElement txtUserName;

	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath = "//*[@id='details-button']")
	@CacheLookup
	WebElement btAdv;

	@FindBy(id = "proceed-link")
	@CacheLookup
	WebElement pLink;
	
	@FindBy(xpath = "//a[@href='Logout.php']")
	@CacheLookup
	WebElement btLogout;
	
	public void SetUserName(String uname) {
		txtUserName.sendKeys(uname);//Action methods
	}

	public void SetPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()

	{
		btnLogin.click();
	}
	
	public void clickLogout() {
		btLogout.click();
	}

	/*public void handleSecurityPopUp() {
		btAdv.click();
		pLink.click();

	}*/
}
