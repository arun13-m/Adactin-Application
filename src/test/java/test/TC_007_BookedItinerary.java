package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_007_BookedItinerary extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void dataSetup() {
		testName = "Booked Itinerary Functionality";
		testDescription = "Checking the woking functionality of cancellation";
		testAuthor = "ArunPrasath Mohanraj";
	}

	@BeforeClass
    public void testDetails() {
    	tDetails();
    	sheetName = "BookedItineraryTestData";
    }
	
	@Test(dataProvider = "excelRead")
	public void bookedItineraryTest(String userName, String password, String hotelLocation, String hotelName, 
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
		.clickMyItinerary()
		.searhBox(orderId)
		.cancelCheckbox()
		.clickCancelSelected()
		.clickCancelConfirm()
		.confirmCancel()
		.logOut();
	}
}