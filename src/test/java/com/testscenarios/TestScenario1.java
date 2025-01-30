package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
 
public class TestScenario1 extends BaseClass {
 
	@Test(priority = 1, timeOut = 20000)
	public void testScenario1() {
		SoftAssert softAssert = new SoftAssert();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
		String pageTitle = driver.getTitle();
		softAssert.assertEquals(pageTitle, "LambdaTest", "Page title did not match the expected value!");
		System.out.println("Test continues even after soft assertion failure!");
		softAssert.assertAll();
	}	
}