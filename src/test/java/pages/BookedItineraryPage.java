package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class BookedItineraryPage extends ProjectSpecificationMethods{

	public BookedItineraryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//click the MyItinerary button
	public BookedItineraryPage clickMyItinerary() {
		driver.findElement(By.xpath("//input[@id='my_itinerary']")).click();
		return this;
	}
	
	//search order with id
	public BookedItineraryPage searhBox(String orderId) throws InterruptedException {
		driver.findElement(By.xpath("//input[contains(@class,'input_search')]")).sendKeys(orderId);
		driver.findElement(By.xpath("//input[contains(@class,'button_search')]")).click();
		Thread.sleep(2000);
		return this;
	}
	
	//Clicking the cancel checkbox from booked itinerary
	public BookedItineraryPage cancelCheckbox() throws InterruptedException {
		driver.findElement(By.xpath("(//input[contains(@type,'checkbox')])[2]")).click();
		Thread.sleep(2000);
		return this;
	}
	
	//clicking the cancel selected button
	public BookedItineraryPage clickCancelSelected() throws InterruptedException {
		driver.findElement(By.xpath("//input[contains(@value,'Cancel Selected')]")).click();
		Thread.sleep(2000);
		return this;
	}
	
	//switch to alert for confirm the cancel
	public BookedItineraryPage clickCancelConfirm() {
		a = driver.switchTo().alert();
		a.accept();
		driver.switchTo().defaultContent();
		return this;
	}
	
	//validation for confirm the cancellation
	public HomePage confirmCancel() {
		String expectedResult = "Selected booking Are cancelled.";
		WebElement actualResult = driver.findElement(By.xpath("//label[contains(text(),'Selected booking Are cancelled.')]"));
		Assert.assertEquals(expectedResult, actualResult.getText());
		System.out.println("Cancellation Done");
		return new HomePage(driver);
	}
}