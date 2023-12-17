package com.TestCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JenkinsClass {
	
	WebDriver driver ;
	
	@Test
	private void method() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		String title=driver.getTitle();
		
		System.out.println("Title --> "+title);
		
	}
	
	public void tearDown() {
		driver.close();
	}

}
