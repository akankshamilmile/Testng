package com.testscenarios;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
 
public class BaseClass {
 
	public WebDriver driver;
	public WebDriverWait wait;
	String browser;
	String version;
	String platform;
	private String username = "akankshamilmile02";
	private String accessKey = "wipAVMYCkzar06Q2unu6mrQLS4DGsaGtWxZNBalix03ynbqZiy";
 
	@BeforeClass
	@Parameters({ "browser", "version", "platform", "URL" })
	public void setUp(String browser, String version, String platform, String siteUrl) throws Exception {
		this.browser = browser;
		this.version = version;
		this.platform = platform;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("browserVersion", version);
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", username);
		ltOptions.put("accessKey", accessKey);
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("network", true);
		ltOptions.put("build", "Lambdatest");
		ltOptions.put("platformName", platform);
		ltOptions.put("build", "TestNG_LambdaTest");
		ltOptions.put("project", "TestNG_Assignment");
		ltOptions.put("name", browser + "-" + getClass().getSimpleName());
		ltOptions.put("console", "true");
		ltOptions.put("w3c", true);
		ltOptions.put("plugin", "java-testNG");
		capabilities.setCapability("LT:Options", ltOptions);
		driver = new RemoteWebDriver(new URL("http://hub.lambdatest.com/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(siteUrl);
	}
 
	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
 
}
