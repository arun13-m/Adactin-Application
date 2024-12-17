package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import base.ProjectSpecificationMethods;

public class SearchHotelPage extends ProjectSpecificationMethods {

	public SearchHotelPage (WebDriver driver) {
		this.driver = driver;
	}
	
	//select the location using select class
	public SearchHotelPage location(String hotelLocation) {
		ele = driver.findElement(By.xpath("(//select[contains(@class,'search_combobox')])[1]"));
		Select s = new Select(ele);
		s.selectByValue(hotelLocation);
		return this;
	}
	
	//select the hotel using select class
	public SearchHotelPage hotel(String hotelName) {
		ele = driver.findElement(By.xpath("(//select[contains(@class,'search_combobox')])[2]"));
		Select s = new Select(ele);
		s.selectByVisibleText(hotelName);
		return this;
	}
	
	//select the room type using select class
	public SearchHotelPage roomType(String room) {
		ele = driver.findElement(By.xpath("(//select[contains(@class,'search_combobox')])[3]"));
		Select s = new Select(ele);
		s.selectByValue(room);	
		return this;
	}
	
	//select the number of rooms using select class
	public SearchHotelPage noOfRooms(String roomCount) {
		ele = driver.findElement(By.xpath("(//select[contains(@class,'search_combobox')])[4]"));
		Select s = new Select(ele);
		s.selectByVisibleText(roomCount);	
		return this;
		}
	
	//check in date
	public SearchHotelPage checkInDate(String inDate) {
		driver.findElement(By.id("datepick_in")).sendKeys(inDate);
		return this;
	}
	
	//check out date
	public SearchHotelPage checkOutDate(String outDate) {
		driver.findElement(By.id("datepick_out")).sendKeys(outDate);
		return this;
	}
	
	//select adults per room using select class
	public SearchHotelPage adultsPerRoom(String adultCount ) {
		ele = driver.findElement(By.xpath("(//select[contains(@class,'search_combobox')])[5]"));
		Select s = new Select(ele);
		s.selectByVisibleText(adultCount);
		return this;
	}
	
	//select childrens per room using select class
	public SearchHotelPage childrensPerRoom(String childrenCount) {
		ele = driver.findElement(By.xpath("(//select[contains(@class,'search_combobox')])[6]"));
		Select s = new Select(ele);
		s.selectByValue(childrenCount);
		return this;
	}
	
	//click the search button
	public SelectHotelPage clickSearch() {
		driver.findElement(By.xpath("(//input[contains(@class,'reg_button')])[1]")).click();
		return new SelectHotelPage(driver);
	}
	
}