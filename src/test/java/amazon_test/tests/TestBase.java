package amazon_test.tests;

import amazon_test.utilities.BrowserUtils;
import amazon_test.utilities.Driver;
import amazon_test.utilities.ExcelUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;
import java.util.Locale;

public class TestBase {

    protected WebDriver driver;
    protected static ExtentReports report;
    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentLogger;
    protected String emailaddress;
    protected String password;


    @BeforeTest
    public void setUpTest(){
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");
        //initialize the class
        report = new ExtentReports();

        //create a report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath +"/test-output/report.html";

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Amazon Test");

        //set environment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser","Chrome");
        report.setSystemInfo("OS",System.getProperty("os.name"));

    }

    @BeforeMethod
    @Parameters("env")
    public void setUpMethod(@Optional String env){


        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ExcelUtility.GetASpecificData("url"));
        emailaddress = ExcelUtility.GetASpecificData("Email Adresi");
        password=ExcelUtility.GetASpecificData("password");

    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws InterruptedException, IOException {

        ExcelUtility.writeExcel(result);

        if (result.getStatus()==ITestResult.FAILURE){
            extentLogger.fail(result.getName());
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            extentLogger.fail(result.getThrowable());
        }
//        Driver.closeDriver();
    }


//    public void tearDownTest(){
//        report.flush();
//    }
}
