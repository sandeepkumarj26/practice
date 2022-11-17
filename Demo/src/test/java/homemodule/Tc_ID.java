package homemodule;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genaricUtility.BaseClass;
import genaricUtility.propertyfileUtility;

public class Tc_ID extends BaseClass {
	@Test
	public void TestCaseDescription() throws IOException {
		WebElement email=driver.findElement(By.id("Email"));
		WebElement password=driver.findElement(By.id("Password"));
		WebElement login= driver.findElement(By.xpath("//input[@value='Log in']"));
		String username=propertyfileUtility.PropertyReader("username");
		email.sendKeys(username);
		password.sendKeys(propertyfileUtility.PropertyReader("password"));
		login.click();
		assertEquals(login.isSelected(), true);//to cheack whether the login selected or not ,expected is should select
		logger.log(Status.PASS, "passed");
	}

}
