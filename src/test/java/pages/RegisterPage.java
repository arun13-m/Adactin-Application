package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class RegisterPage extends ProjectSpecificationMethods {

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//userName
	public RegisterPage userName(String rName) {
		driver.findElement(By.id("username")).sendKeys(rName);
		return this;
	}
	
	//passWord
	public RegisterPage passWord(String rPassword) {
		driver.findElement(By.id("password")).sendKeys(rPassword);
		return this;
	}
	
	//confirmPassword
	public RegisterPage confirmPassword(String rConfirmPassword) {
		driver.findElement(By.xpath("//input[contains(@id,'re_password')]")).sendKeys(rConfirmPassword);
		return this;
	}
	
	//fullName
	public RegisterPage fullName(String rFullName) {
		driver.findElement(By.xpath("//input[contains(@id,'full_name')]")).sendKeys(rFullName);
		return this;
	}
	
	//Email
	public RegisterPage emailAddress(String rEmailAddress) throws InterruptedException {
		driver.findElement(By.xpath("//input[contains(@id,'email_add')]")).sendKeys(rEmailAddress);
		Thread.sleep(10000);
		return this;
	}
	
	//terms and conditions checkbox
	public RegisterPage termsAndConditions() {
		driver.findElement(By.xpath("//input[@id='tnc_box']")).click();
		return this;
	}
	
	//register button
	public HomePage clickRegister() {
		ele = driver.findElement(By.xpath("//input[contains(@value,'Register')]"));
		Assert.assertTrue(ele.isEnabled(), "Please enter the valid credentials");
		driver.findElement(By.id("Submit")).click();
		return new HomePage(driver);
	}
	/*
	public LoginPage backToLoginpage() {
		driver.findElement(By.linkText("Go back to Login page")).click();
		return new LoginPage(driver);
	}
	*/
}