package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class EndLogoutPage extends ProjectSpecificationMethods {

	public EndLogoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//deleting all the bookings
	public EndLogoutPage deleteAll() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='check_all']")).click();
		driver.findElement(By.xpath("//input[contains(@value,'Cancel Selected')]")).click();
		Thread.sleep(5000);
		a = driver.switchTo().alert();
		a.accept();
		driver.switchTo().defaultContent();
		ele = driver.findElement(By.xpath("//label[contains(text(),'Selected booking Are cancelled.')]"));
		Assert.assertTrue(ele.isDisplayed(), "All bookings are canceled");
		return this;
	}
	
	//Clicking the logout button
	public EndLogoutPage endLogout() throws InterruptedException {
		Thread.sleep(2000);
		logOut();
		return this;
	}
	
	//validation for successfull logout
	public HomePage logoutMsg() throws InterruptedException {
		Thread.sleep(2000);
		expectedResult = "You have successfully logged out. Click here to login again";
		WebElement actualResult = driver.findElement(By.xpath("//td[contains(text(),'You have successfully logged out. ')]"));
		Assert.assertEquals(actualResult.getText(),expectedResult);
		System.out.println(expectedResult);
		return new HomePage(driver);
	}
}