package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_003_SearchHotel extends ProjectSpecificationMethods{
	
	@BeforeTest
	public void dataSetup() {
		testName = "Search Hotel Functionality";
		testDescription = "Searching a hotel with valid and invalid data's";
		testAuthor = "ArunPrasath Mohanraj";
	}

	@BeforeClass
    public void testDetails() {
    	tDetails();
    	sheetName = "SearchHotelTestData";
    }
	
	@Test(dataProvider = "excelRead")
	public void searchHotelTest(String userName, String password, String hotelLocation, String hotelName, 
			String room, String roomCount, String inDate, String outDate, String adultCount, String childrenCount) throws InterruptedException {
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
		.logOut();		
	}
}