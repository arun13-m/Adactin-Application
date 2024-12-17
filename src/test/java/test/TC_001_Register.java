package test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_001_Register extends ProjectSpecificationMethods {
	
	
	@BeforeTest
	public void dataSetup() throws IOException {
		propertyFileTestData();
		testName = "Registration Functionality";
		testDescription = "Registration with valid & invalid credentials";
		testAuthor = "ArunPrasath Mohanraj";
	}
	
	@BeforeClass
    public void testDetails() {
    	tDetails();
    }

	@Test(priority=0, description="Valid Test Case")
	public void regTestValidTestData() throws InterruptedException, IOException {
		HomePage obj = new HomePage(driver);
		obj.registerLink()
		.userName(prop.getProperty("validusername"))
		.passWord(prop.getProperty("validpassword"))
		.confirmPassword(prop.getProperty("vaildconfirmpassword"))
		.fullName(prop.getProperty("validfullname"))
		.emailAddress(prop.getProperty("validemailaddress"))
		.termsAndConditions()
		.clickRegister();
	}
	
	
	@Test(priority=1, description="invalid Test Case")
	public void regTestInvalidTestData() throws InterruptedException, IOException {
		HomePage obj = new HomePage(driver);
		obj.registerLink()
		.userName(prop.getProperty("invalidusername"))
		.passWord(prop.getProperty("invalidpassword"))
		.confirmPassword(prop.getProperty("invaildconfirmpassword"))
		.fullName(prop.getProperty("invalidfullname"))
		.emailAddress(prop.getProperty("invalidemailaddress"))
		.termsAndConditions()
		.clickRegister();
	}
	
}