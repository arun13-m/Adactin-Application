package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_006_BookingConfirmation extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void dataSetup() {
		testName = "Booking Confirmation Functionality";
		testDescription = "Checking the booking details";
		testAuthor = "ArunPrasath Mohanraj";
	}

	@BeforeClass
    public void testDetails() {
    	tDetails();
    	sheetName = "BookingConfirmationTestData";
    }
	
	@Test(dataProvider = "excelRead")
	public void bookingConfirmationTest(String userName, String password, String hotelLocation, String hotelName, 
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
		.bookingConfirm()
		.orderId()
		.logOut();
	}
}