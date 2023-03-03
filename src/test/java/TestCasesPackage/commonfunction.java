package TestCasesPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class commonfunction {
	
	public static Properties properties=null;
	public static WebDriver driver=null;
	
	public static Logger logger=Logger.getLogger(commonfunction.class);
	
	public Properties loadproperty() throws Exception 
	{
		FileInputStream fis=new FileInputStream("config.properties");
		properties=new Properties();
		properties.load(fis);
		return properties;
		
	}
	
	@BeforeClass
	
	public void browserlunch() throws Exception
	{
		loadproperty();
		PropertyConfigurator.configure("log4j.properties");
		
		String Driverlocation=properties.getProperty("Driverlocation");
		String browser=properties.getProperty("Browser");
		String url=properties.getProperty("Url");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			
			System.getProperty("webdriver.chrome.driver",Driverlocation);
			driver=new ChromeDriver();
		}
		else
		{
			System.getProperty("webdriver.geco.driver",Driverlocation);
			driver=new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
			@AfterClass
	public void deardown()
	{
		driver.quit();
	}
	

}
