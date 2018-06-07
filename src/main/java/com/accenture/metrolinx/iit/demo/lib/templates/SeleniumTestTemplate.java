package com.accenture.metrolinx.iit.demo.lib.templates;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.accenture.metrolinx.iit.demo.lib.BrowserLauncher;
import com.accenture.metrolinx.iit.demo.lib.constants.TestParameters;

public class SeleniumTestTemplate {
	private WebDriver driver;
	private Map<String, String> testParameters;

  @BeforeClass
  public void setup(ITestContext context) {
	  //Handle environment variable
	  testParameters = context.getCurrentXmlTest().getAllParameters();
	  String browser = testParameters.get(TestParameters.BROWSER) == null? TestParameters.CHROME : testParameters.get(TestParameters.BROWSER);
	  boolean remote = TestParameters.TRUE.equalsIgnoreCase(testParameters.get(TestParameters.REMOTE));
	  driver = BrowserLauncher.launch(browser, remote);
  }

  @AfterClass(alwaysRun = true)
  public void teardown() {
	  if (driver != null) {
          driver.quit();
      }
  }
  
  public WebDriver getDriver()
  {
	  return this.driver;
  }

}
