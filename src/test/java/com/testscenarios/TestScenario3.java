package com.testscenarios;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
 
public class TestScenario3 extends BaseClass {
 
	@Test(priority = 1, timeOut = 20000)
	public void testScenario3() throws InterruptedException {
		try {
			SoftAssert softAssert = new SoftAssert();
			
			WebElement javaScriptAlertLink = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Javascript Alerts')]")));
			javaScriptAlertLink.click();
 
			Thread.sleep(5);
			driver.findElement(
					By.xpath("//button[@class='btn btn-dark my-30 mx-10 hover:bg-lambda-900 hover:border-lambda-900']"))
					.click();
			Thread.sleep(5);
			Alert alert = driver.switchTo().alert();
 
			softAssert.assertEquals(alert.getText(), "I am an alert box!", "Alert message mismatch");
			alert.accept();
			softAssert.assertAll();
			System.out.println("Test case 3 Pass");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
