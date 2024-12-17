package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class ChangePasswordPage extends ProjectSpecificationMethods{

	public ChangePasswordPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//Entering the current password
	public ChangePasswordPage currentPassword(String currentPass) {
		driver.findElement(By.xpath("//input[contains(@name,'current_pass')]")).sendKeys(currentPass);
		return this;
	}
	
	//Entering the new password
	public ChangePasswordPage newPassword(String newPass) {
		driver.findElement(By.xpath("//input[contains(@name,'new_password')]")).sendKeys(newPass);
		return this;
	}
	
	//Entering the confirm password
	public ChangePasswordPage confirmPassword(String confirmPass) {
		driver.findElement(By.xpath("//input[contains(@name,'re_password')]")).sendKeys(confirmPass);
		return this;
	}
	
	//click the submit button
	public HomePage changePasswordSubmit() {
		driver.findElement(By.xpath("//input[contains(@name,'change_password_Submit')]")).click();
		ele = driver.findElement(By.xpath("(//span[contains(@class,'reg_error')])[3]"));
		Assert.assertFalse(ele.isDisplayed(), "please enter the correct current password");
		return new HomePage(driver);
	}
}