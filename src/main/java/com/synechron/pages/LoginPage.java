package com.synechron.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synechron.base.SynechronTestBase;

public class LoginPage extends SynechronTestBase{

	public boolean appLoad() {
		return driver.findElement(By.name("username")).isDisplayed();
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	public DashboardPage login(String username, String password) {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		return new DashboardPage();
	}
}
