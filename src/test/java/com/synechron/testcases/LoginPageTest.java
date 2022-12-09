package com.synechron.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.synechron.base.SynechronTestBase;
import com.synechron.pages.DashboardPage;
import com.synechron.pages.LoginPage;

public class LoginPageTest extends SynechronTestBase{
	
	/*
	 * Problems
	 * 1. browser launching code is repeated
	 * 2. Code/Logic and Test are mixed
	 * 3. We are hard coding the data
	 */
	
	LoginPage lp;
	DashboardPage dp;
	
	
	@BeforeMethod
	public void browserSetup() throws IOException {
		lp = new LoginPage();
		initialization();
	}

	@Test
	public void appLoadCheckTest() {
		boolean ispresent =  lp.appLoad();
		Assert.assertTrue(ispresent);
	}
	
	@Test
	public void validateTitleTest() {
		String expTitle = "OrangeHRM";
		String actTitle =  lp.getTitle();
		Assert.assertEquals(actTitle, expTitle);
	}
	
	@Test
	public void validateLoginTest() {
		dp = lp.login(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertTrue(dp.timeATworkSection());	
	}
	
	@Test
	public void forgotPasswordLinkTest() {
		
	}
	
	@AfterMethod
	public void browserClose() {
		tearDown();
	}
}
