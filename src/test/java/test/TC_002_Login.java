package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_002_Login extends ProjectSpecificationMethods {
	
	
	@BeforeTest 
	public void dataSetup() { 
		testName = "Login Functionality";
	    testDescription = "Login with valid & invalid credentials"; 
	    testAuthor = "ArunPrasath Mohanraj"; 
	}
	 

	@BeforeClass
	public void testDetails() {
		tDetails();
		sheetName = "LoginTestData";
	}

	@Test(dataProvider = "excelRead")
	public void loginTest(String userName, String password) throws InterruptedException {
		HomePage obj = new HomePage(driver);
		obj.loginButton()
		.loginUsername(userName)
		.loginPassword(password)
		.clickLogin()
		.logOut();
	}
}