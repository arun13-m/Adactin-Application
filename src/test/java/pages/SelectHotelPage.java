package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ProjectSpecificationMethods;

public class SelectHotelPage extends ProjectSpecificationMethods {

	public SelectHotelPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// select the hotel
	public SelectHotelPage selectHotel() {
		driver.findElement(By.id("radiobutton_0")).click();
		return this;
	}
	
	// click the continue button
	public BookAHotelPage clickContinue() {
		driver.findElement(By.xpath("(//input[contains(@class,'reg_button')])[1]")).click();
		return new BookAHotelPage(driver);
	}
}
