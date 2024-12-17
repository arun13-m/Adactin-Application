package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_005_BookAHotel extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void dataSetup() {
		testName = "Booking Hotel Functionality";
		testDescription = "Booking a hotel with valid & invalid data's";
		testAuthor = "ArunPrasath Mohanraj";
	}

	@BeforeClass
    public void testDetails() {
    	tDetails();
    	sheetName = "BookAHoteltestData";
    }
	
	@Test(dataProvider = "excelRead")
	public void bookAHotelTest(String userName, String password, String hotelLocation, String hotelName, 
	    String room, String roomCount, String inDate, String outDate, String adultCount, String childrenCount,
	    String fName, String lName, String billAddress, String cardNumber, String cardType, 
	    String expMonth, String expYear, String cvvNum) throws InterruptedException {
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
		.firstName(fName)
		.lastName(lName)
		.billingAddress(billAddress)
		.creditCardNumber(cardNumber)
		.creditCardType(cardType)
		.expiryDateMonth(expMonth)
		.expiryDateYear(expYear)
		.cvvNumber(cvvNum)
		.clickBookNow()
		.logOut();
	}
}