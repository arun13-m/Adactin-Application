package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ProjectSpecificationMethods;

public class HomePage extends ProjectSpecificationMethods {

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public RegisterPage registerLink() {
		driver.findElement(By.linkText("New User Register Here")).click();
		return new RegisterPage(driver);
	}
	
	public LoginPage loginButton() {
		driver.findElement(By.className("login_button")).click();
		return new LoginPage(driver);
	}
	
	public SearchHotelPage searchHotel() {
		driver.findElement(By.xpath("//a[contains(text(),'Search Hotel')]")).click();
		return new SearchHotelPage(driver);
	}
	
	//Clicking the change password link
	public ChangePasswordPage changePasswordLink() {
		driver.findElement(By.linkText("Change Password")).click();
		return new ChangePasswordPage(driver);
	}
	
	public EndLogoutPage myItinerary() {
		driver.findElement(By.xpath("//a[contains(text(),'Booked Itinerary')]")).click();
		return new EndLogoutPage(driver);
	}
	
}