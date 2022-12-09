package com.synechron.pages;

import org.openqa.selenium.By;

import com.synechron.base.SynechronTestBase;

public class DashboardPage extends SynechronTestBase{

	public boolean timeATworkSection() {
		return driver.findElement(By.xpath("//p[text()='Time at Work']")).isDisplayed();
	}
	
	public boolean getQuickLaunchSection() {
		return driver.findElement(By.xpath("//p[text()='Quick Launch']")).isDisplayed();
	}
}
