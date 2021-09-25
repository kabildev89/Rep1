package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_Login_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {

		
		logger.info("URL is open");
		LoginPage lp = new LoginPage(driver);

		/*lp.handleSecurityPopUp();*/
		lp.SetUserName(username);
		logger.info("Enter username");
		lp.SetPassword(password);
		logger.info("Enter password");
		lp.clickSubmit();

		/*System.out.println(driver.getTitle());*/

		if (driver.getTitle().equals("Guru99 Bank Manager HomePagecccc")) {
			Assert.assertTrue(true);
			logger.info("Login test is passed");

		} else {
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test is failed");

		}

	}

}
