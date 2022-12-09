package com.synechron.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SynechronTestBase {

	public static WebDriver driver;
	public static Properties prop;

	public void initialization() throws IOException {
		prop = new Properties();
		String propPath = "./src/main/java/com/synechron/config/config.properties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreenshot(String tcName) {
		
	}
}
