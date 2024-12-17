package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_004_SelectHotel extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void dataSetup() {
		testName = "Select Hotel Functionality";
		testDescription = "Checking the working functionality of select radio button";
		testAuthor = "ArunPrasath Mohanraj";
	}

	@BeforeClass
    public void testDetails() {
    	tDetails();
    	sheetName = "SelectHoteltestData";
    }
	
	@Test(dataProvider = "excelRead")
	public void selectHotelTest(String userName, String password, String hotelLocation, String hotelName, 
			String room, String roomCount, String inDate, String outDate, String adultCount, String childrenCount) {
		HomePage obj = new HomePage(driver);
		obj.loginButton()
		.loginUsername(userName)
		.loginPassword(password)
		.clickLogin()
		.searchHotel()
		.location(hotelLocation)
		.hotel(hotelName)
		.roomType(room)
		.noOfRooms(roomCount)
		.checkInDate(inDate)
		.checkOutDate(outDate)
		.adultsPerRoom(adultCount)
		.childrensPerRoom(childrenCount)
		.clickSearch()
		.selectHotel()
		.clickContinue()
		.logOut();
	}
}
