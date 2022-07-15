package testCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public String baseURL="https://admin-demo.nopcommerce.com/";
	public String username="admin@yourstore.com";
	public String password="admin";
	public static WebDriver driver;
	
	public static Logger log=(Logger) LogManager.getLogger();
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		log.info("Chrome browser is opened successfully");
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		log.info("Chrome browser is closed successfully");
	}


}
