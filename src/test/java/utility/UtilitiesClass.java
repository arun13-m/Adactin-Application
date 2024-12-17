package utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.HomePage;

public class UtilitiesClass {

	 public static WebDriver driver;
	 public static WebElement ele;
	 public static String expectedResult;
	 public static Properties prop;
	 public static String expectedValue;
	 public static String orderId;
	 public static String sheetName;
	 public static ExtentReports report;
	 public static ExtentTest test;
	 public String testName, testDescription, testAuthor;
	 public static Alert a;
	 
	 //browserAndURl method
	 public void browserAndURL(String browser) {
		 if(browser.equals("chrome")) {
			 driver = new ChromeDriver();
		 }
		 else if(browser.equals("edge")) {
			 driver = new EdgeDriver();
		 } 
		 driver.get("https://adactinhotelapp.com/HotelAppBuild2/index.php");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 }
	 
	 //closing browser method
	 public void browserClose() {
		 driver.close();
	 }
	 
	 //logout
	 public HomePage logOut() {
		 driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		 return new HomePage(driver);
	 }
	 
	 public static void propertyFileTestData() throws IOException {
		 FileReader file = new FileReader("C:\\Users\\arunp\\eclipse-workspace\\Adactin\\src\\test\\resources\\TestData\\RegisterTestData.properties");
		 prop = new Properties();
		 prop.load(file);
	 }
	 
	 //creating the report in the location
	 public void reptInitilization() {
		 String path = "C:\\Users\\arunp\\eclipse-workspace\\Adactin\\Report\\Adactin-Report\\Adactin_Hotel_Booking_Application.html";
		 //to crate a report in given location
		 ExtentSparkReporter reporter = new ExtentSparkReporter(path); 
		 reporter.config().setReportName("Adactin Hotel Booking Application");
				
		 //to capture the data
		 report = new ExtentReports();
		 report.attachReporter(reporter);
	 }
	
	 //Giving the test details
	 public void tDetails() {
		 test = report.createTest(testName, testDescription);
		 test.assignAuthor(testAuthor);
	 }
	 
	 //excel reading code
	 public static String[][] excelData(String sheetName) throws IOException  {
	 XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\arunp\\eclipse-workspace\\Adactin\\src\\test\\resources\\TestData\\AdactinTestData.xlsx");
	 XSSFSheet sheet = book.getSheet(sheetName);
	 int rowCount = sheet.getLastRowNum();
	 int columnCount = sheet.getRow(0).getLastCellNum();
	 String[][] data = new String[rowCount][columnCount];		
	 for(int i=1;i<=rowCount;i++) {
		 XSSFRow row = sheet.getRow(i);
		 for(int j=0;j<columnCount;j++) {
			 XSSFCell col =  row.getCell(j);
			 data[i-1][j] = col.getStringCellValue();
		     }
	     }
	 System.out.println(sheet.getSheetName());
	 book.close();
	 return data;
	 }
	 
	 //screenshot method for failed testcase
	 public String screenShot(String name) throws IOException {
		 String path = "C:\\Users\\arunp\\eclipse-workspace\\Adactin\\Snaps\\"+name+".png";
		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File dest = new File(path);
		 FileUtils.copyFile(src, dest);
		 return path;
	 }
}