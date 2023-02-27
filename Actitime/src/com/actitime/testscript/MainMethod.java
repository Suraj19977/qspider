package com.actitime.testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.actitime.pom.LgnPge;

public class MainMethod {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test
	public void validLogin(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("http://demo.actitime.com");
	LgnPge l=new LgnPge(driver);
	l.setLogin("admin", "manager");
	}
}
