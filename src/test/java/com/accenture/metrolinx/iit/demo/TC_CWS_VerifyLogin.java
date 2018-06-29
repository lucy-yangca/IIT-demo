package com.accenture.metrolinx.iit.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.accenture.metrolinx.iit.demo.lib.AutomationProperties;
import com.accenture.metrolinx.iit.demo.lib.templates.SeleniumTestTemplate;

public class TC_CWS_VerifyLogin extends SeleniumTestTemplate {

	@DataProvider(name = "provider")
	public Object[][] provide() throws Exception {
		//Handle input data
		return new Object[][] { { "User001", "Passwd1" }, { "User002", "Passwd2" },

		};
	}

	@Test(dataProvider = "provider")
	public void testLogin(String user, String passwd) throws InterruptedException {
		//Added comment for PRES-1 again
		WebDriver  driver = this.getDriver();
		String CSWURL = AutomationProperties.getProperty("metrolinx.presto.iit.cws.url");
		
		driver.get(CSWURL);
		
		WebElement signInBtn = driver.findElement(By.xpath("//a[@role='button' and contains(text(),'Sign In')]"));
		
		signInBtn.click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("SignIn_Username")).sendKeys(user);
		driver.findElement(By.id("SignIn_Password")).sendKeys(passwd);
		
		driver.findElement(By.id("btnsubmit")).click();
		
		try
		{
		driver.findElement(By.id("loginError"));
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	}

}
