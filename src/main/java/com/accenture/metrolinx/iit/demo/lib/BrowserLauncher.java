package com.accenture.metrolinx.iit.demo.lib;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.accenture.metrolinx.iit.demo.lib.constants.TestParameters;
import com.accenture.metrolinx.iit.demo.lib.exception.SeleniumGridException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLauncher {

	public static WebDriver launch(String browser, boolean remote) {
		if (remote) {
			return launchRemoteWebDriver(browser);
		}

		WebDriver driver;
		switch (browser) {
		case TestParameters.IE:
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case TestParameters.FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;	
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		
		return driver;

	}

	private static WebDriver launchRemoteWebDriver(String browser) {
		String urlAddr = AutomationProperties.getProperty("metrolinx.presto.iit.automation.selenium.grid.hub");

		if (urlAddr == null) {
			throw new SeleniumGridException("Selenium Grid Hub url is not defined!");
		}

		URL url = null;
		try {
			url = new URL(urlAddr);
		} catch (MalformedURLException e) {
			throw new SeleniumGridException(e);
		}
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(browser);
		
		return new RemoteWebDriver(url, cap);
	}

}
