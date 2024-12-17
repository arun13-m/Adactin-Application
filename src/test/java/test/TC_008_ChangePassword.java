package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_008_ChangePassword extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void dataSetup() {
		testName = "Change Password Functionality";
		testDescription = "Checking the change password option is working or not with valid & invalid credentials";
		testAuthor = "ArunPrasath Mohanraj";
	}

	@BeforeClass
    public void testDetails() {
    	tDetails();
    	sheetName = "ChangePasswordTestData";
    }
	
	@Test(dataProvider = "excelRead")
	public void changePasswordTest(String userName, String password, String currentPass, String newPass,
		    String confirmPass) throws InterruptedException {
		HomePage obj = new HomePage(driver);
		obj.loginButton()
		.loginUsername(userName)
		.loginPassword(password)
		.clickLogin()
		.changePasswordLink()
		.currentPassword(currentPass)
		.newPassword(newPass)
		.confirmPassword(confirmPass)
		.changePasswordSubmit()
		.logOut();
	}
}