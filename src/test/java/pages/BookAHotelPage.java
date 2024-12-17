package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class BookAHotelPage extends ProjectSpecificationMethods{

	public BookAHotelPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Entering the firstname
	public BookAHotelPage firstName(String fName) {
		driver.findElement(By.id("first_name")).sendKeys(fName);
		return this;
	}
	
	//Entering the lastname
	public BookAHotelPage lastName(String lName) {
		driver.findElement(By.id("last_name")).sendKeys(lName);
		return this;
	}
	
	//Entering the billing address
	public BookAHotelPage billingAddress(String billAddress) {
		driver.findElement(By.id("address")).sendKeys(billAddress);
		return this;
	}
	
	//entering the Credit Card Number
	public BookAHotelPage creditCardNumber(String cardNumber) {
		driver.findElement(By.id("cc_num")).sendKeys(cardNumber);
		return this;
	}
	
	//select the Credit card type using select class
	public BookAHotelPage creditCardType(String cardType) {
		ele = driver.findElement(By.xpath("(//select[contains(@class,'select_combobox')])[1]"));
		Select s = new Select(ele);
		s.selectByValue(cardType);
		return this;
	}
	
	//select the Expiry date month using select class
	public BookAHotelPage expiryDateMonth(String expMonth) {
		ele = driver.findElement(By.xpath("(//select[contains(@class,'select_combobox')])[2]"));
		Select s = new Select(ele);
		s.selectByVisibleText(expMonth);
		return this;
	}
	
	//select the Expiry date year using select class
	public BookAHotelPage expiryDateYear(String expYear) {
		ele = driver.findElement(By.xpath("(//select[contains(@class,'select_combobox')])[3]"));
		Select s = new Select(ele);
		s.selectByValue(expYear);
		return this;
	}
	
	//Entering the CVV number
	public BookAHotelPage cvvNumber(String cvvNum) {
		driver.findElement(By.id("cc_cvv")).sendKeys(cvvNum);
		return this;
	}
	
	//Clicking the Book Now button
	public BookingConfirmationPage clickBookNow() throws InterruptedException {
		driver.findElement(By.xpath("(//input[contains(@class,'reg_button')])[1]")).click();
		ele = driver.findElement(By.xpath("//td[contains(text(),'Booking Confirmation ')]"));
		Assert.assertTrue(ele.isDisplayed());
		return new BookingConfirmationPage(driver);
	}
}