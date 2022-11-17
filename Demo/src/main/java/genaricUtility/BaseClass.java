package genaricUtility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static ExtentSparkReporter reporter;
	public static ExtentReports report;
	public static ExtentTest logger;
	
public static WebDriver driver;
@BeforeSuite(alwaysRun=true)
public void launchingBrowser() {
	reporter=new ExtentSparkReporter("./Reports/extentdemo.html");
	report=new ExtentReports();
	report.attachReporter(reporter);
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
}
@BeforeTest(alwaysRun=true)
public void beforeTest() {
	report.createTest("testcase1");
	
}

@BeforeClass(alwaysRun=true)
public void navigatingToApp() {
	driver.get("https://demowebshop.tricentis.com/login");
	//logger.log(Status.INFO, "succesfully navigate to application");
	
}

@AfterMethod(alwaysRun=true)
public void CheackinfFailure(ITestResult result) throws IOException {
	if(result.getStatus()==ITestResult.FAILURE) {
	//	screenshortUtility.tackingScreenshort(result.getName());
		String path=screenshortUtility.tackingScreenshort(result.getName());
		System.out.println(result.getName());
		logger.log(Status.FAIL, "the test script"+result.getName()+"is faild");
		logger.addScreenCaptureFromPath(path);
		
	}
}
 @AfterClass(alwaysRun=true)
 public void loggingOut() {
	 System.out.println("logged out");
	 logger.log(Status.INFO, "logged out from application");
	 
 }
 @AfterSuite(alwaysRun=true)
 public void tearDownTheBrowser() {
	 driver.quit();
	 logger.log(Status.INFO, "closed the browser");
	 report.flush();
	 
 }
 

}
