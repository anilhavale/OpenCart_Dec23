package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.LogManager;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass
{
	
	  public static  WebDriver driver;
	  
	  public Logger  logger;  // for logging
	  
	  
	  public ResourceBundle rb;
	
	@BeforeClass(groups= {"Master","Regression","Sanity"})
	@Parameters("browser")
	public void setUp(String br)
	{
		rb=ResourceBundle.getBundle("config");
		
		// logger=LogManager.getLogger(this.getClass());
		
		logger=org.apache.logging.log4j.LogManager.getLogger(this.getClass());
		
		
		ChromeOptions options= new ChromeOptions();
		
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		//
		
		if(br.equals("chrome"))
		{
		driver=new ChromeDriver();
		}
		
		else if(br.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		
		else
		{
			driver= new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("http://localhost/opencart/upload/index.php");
		
		driver.get(rb.getString("appURL"));
		
		driver.manage().window().maximize();
		
	}
	
	
	@AfterClass(groups= {"Master","Regression","Sanity"})
	public void tearDown()
	{
		driver.quit();
		
	}
	
	
	
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}
	
	
	public String captureScreen(String tname) 
	{
		
	//	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		
	//	Date	dt=new Date();
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		
	     TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
		File src=takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir")+"\\screenshots\\"+ tname +"_"+timeStamp + ".png";
		
		
		try 
		{
			FileUtils.copyFile(src, new File(destination));
		}
		
		catch (Exception e)
		{
			e.getMessage();
		}
		
		return destination;	
	}
	
	
}
