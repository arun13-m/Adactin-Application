package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_009_EndLogout extends ProjectSpecificationMethods {

	@BeforeTest
	public void dataSetup() {
		testName = "Logout Functionality";
		testDescription = "Final logout of the application";
		testAuthor = "ArunPrasath Mohanraj";
	}
	 
	@BeforeClass
    public void testDetails() {
    	tDetails();
    	sheetName = "EndLogoutTestData";
    }
	
	@Test(dataProvider = "excelRead")
	public void endLogoutTest(String userName, String password) throws InterruptedException {
		HomePage obj = new HomePage(driver);
		obj.loginButton()
		.loginUsername(userName)
		.loginPassword(password)
		.clickLogin()
		.myItinerary()
		.deleteAll()
		.endLogout()
		.logoutMsg();
	}
}