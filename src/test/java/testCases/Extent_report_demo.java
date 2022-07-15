package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extent_report_demo {


	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		{

			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");

			// create ExtentReports and attach reporter(s)
			ExtentReports extent = new ExtentReports();
			extent.attachReporter(htmlReporter);

			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("https://getflags.net/");
			driver.manage().window().maximize();
			

			ExtentTest test = extent.createTest("MyLogin_LogoutTest", "Login_Logout");
			test.log(Status.INFO, "This step shows usage of log(status, details)");
			// info(details)
			test.info("This step shows usage of info(details)");

			// log with snapshot
			//test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

			// test with snapshot
			//test.addScreenCaptureFromPath("screenshot.png");

			// calling flush writes everything to the log file
			extent.flush();



		}
	}
}

