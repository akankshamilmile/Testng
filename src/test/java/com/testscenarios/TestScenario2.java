package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
 
public class TestScenario2 extends BaseClass {
 
	@Test(priority = 1, timeOut = 20000)
	public void testScenario2() {
		try {
			SoftAssert softAssert = new SoftAssert();
			
			WebElement checkboxDemoLink = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Checkbox Demo')]")));
			checkboxDemoLink.click();
 
			System.out.println("second page Title" + driver.getTitle());
			Thread.sleep(5);
			WebElement checkbox = driver.findElement(By.xpath("//*[@id='isAgeSelected']"));
			checkbox.click();
 
			softAssert.assertTrue(checkbox.isSelected(), "Checkbox is selected");
 
			checkbox.click();
 
			softAssert.assertFalse(checkbox.isSelected(), "Checkbox is unselected");
			softAssert.assertAll();
			System.out.println("Test case 2 Pass");
		} catch (Exception e) {
			e.printStackTrace();
		}
 
	}
}

