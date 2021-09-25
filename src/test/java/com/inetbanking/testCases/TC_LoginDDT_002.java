package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.reporters.jq.IPanel;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass

{
	@Test(dataProvider="LoginData")
	public void LoginDDt(String user,String pwd) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.SetUserName(user);
		lp.SetPassword(pwd);
		logger.warn("password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close the alert window
			driver.switchTo().defaultContent();//focus on main page
			Assert.assertTrue(false);
			logger.warn("login failed");
			}
		else
			{
				Assert.assertTrue(true);
				logger.warn("login passed");
				lp.clickLogout();
				Thread.sleep(3000);
				driver.switchTo().alert().accept();//close the logout alert
				driver.switchTo().defaultContent();//focus on main page


				 
			}
	}
	public boolean isAlertPresent()//user defined method created to check alert is present or not
	{
	try {
		driver.switchTo().alert();
	}
	catch(Exception e)
	{
	}return false;
		
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = "./src/test/java/com/inetbanking/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String[][] logindata = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++)

		{
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);// 1 0
			}

		}

		return logindata;

	}
}
