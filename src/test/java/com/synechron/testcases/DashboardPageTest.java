package com.synechron.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.synechron.base.SynechronTestBase;
import com.synechron.pages.DashboardPage;
import com.synechron.pages.LoginPage;

public class DashboardPageTest extends SynechronTestBase {

	LoginPage lp;
	DashboardPage dp;

	@BeforeMethod
	public void browserSetup() throws IOException {
		lp = new LoginPage();
		initialization();
	}

	@Test
	public void validateTimeAtWorkSection() {

	}

	@Test
	public void validateQuickLaunchSectionTest() {
		// this, browser, login
		dp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(dp.getQuickLaunchSection());

	}

	@AfterMethod
	public void closeSetup() {
		tearDown();
	}
}
