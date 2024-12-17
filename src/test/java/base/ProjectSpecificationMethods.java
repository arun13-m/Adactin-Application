package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utility.UtilitiesClass;

public class ProjectSpecificationMethods extends UtilitiesClass {

	//launching the browser
	@Parameters({"browser"})
	@BeforeMethod
	public void launchBrowserAndURL(String browser){
		browserAndURL(browser);
	}
	
	
	@DataProvider(name="excelRead")
	public String[][] excelRead() throws IOException {
		return excelData(sheetName); 
	}
	
	
    @BeforeSuite
	public void reportInitilization() {
		reptInitilization();
	}
    

    @AfterSuite
    public void reportClose() {
    	report.flush();
    }
    
	//closing the browser
	@AfterMethod
	public void closeBrowser() {
		browserClose();
	}
	
}
