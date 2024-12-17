package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class BookingConfirmationPage extends ProjectSpecificationMethods {

	public BookingConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}

	//verify the booking
	public BookingConfirmationPage bookingConfirm() {
		expectedResult = "Booking Confirmation";
		WebElement actualResult = driver.findElement(By.xpath("//td[contains(text(),'Booking Confirmation ')]"));
		Assert.assertEquals(expectedResult, actualResult.getText());
		System.out.println("Booking Confirmed");
		return this;
	}
	
	//getting the order id
	public BookedItineraryPage orderId() {
		WebElement e = driver.findElement(By.xpath("//input[@id='order_no']"));
		orderId = e.getAttribute("value");
		System.out.println("Order Id: "+ orderId);
		return new BookedItineraryPage(driver);
	}
}