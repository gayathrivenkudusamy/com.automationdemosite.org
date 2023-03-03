package TestCasesPackage;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import PageObjectsPackage.regterationpageobj;

public class TC_register_001 extends commonfunction{
	
	@Test(priority=1)
	public void reg()
	{
		
		PageFactory.initElements(driver,regterationpageobj.class);
		
		regterationpageobj.firstname.sendKeys(properties.getProperty("fname"));
		regterationpageobj.lastname.sendKeys(properties.getProperty("lname"));
		
		regterationpageobj.address.sendKeys(properties.getProperty("address"));
		regterationpageobj.email.sendKeys(properties.getProperty("email"));
		
		regterationpageobj.phone.sendKeys(properties.getProperty("phone"));
		
		regterationpageobj.gender.click();
		
		regterationpageobj.cricket.click();
		
		regterationpageobj.hockey.click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
			
		regterationpageobj.language.click();
		
		
		
		
		
	
	//	lang();
		//skilldrop();
				
	}
	@Test(priority=2)
	public void lang() throws Exception
	{
		
		
		
		List <WebElement> allLang=driver.findElements(By.xpath("//ul[@class=\"ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all\"]/li"));
		//Thread.sleep(2000);
		//selectoptionfromdropdown(allLang,"English");
	logger.info("total language:"+allLang.size());
			for (WebElement options : allLang) {
		
			
			if(options.getText().equals("English"))
			{
				
				
				options.click();
				logger.info("selected language:"+options.getText());
				break;
			}
			
			
					}
			driver.findElement(By.xpath("//label[text()='Skills']")).click();
		
		
	}
	@Test(priority=3)
	public void skilldrop() 
	{
		
		WebElement s=driver.findElement(By.cssSelector("#Skills"));
		
		s.click();
		Select select=new Select(s);
		select.selectByValue("Android");
		
		
		
			
	}
	
	@Test(priority=4)
	public void country() throws Exception
	{
		//Thread.sleep(3000);
		regterationpageobj.country.click();
		WebElement ss=driver.findElement(By.cssSelector("#country"));
		ss.sendKeys(properties.getProperty("c"));
		
		Select s=new Select(ss);
		s.selectByValue("India");
		
		
		
	}
	
	@Test(priority=5)
	public void dob() throws Exception
	{
		//Thread.sleep(3000);
		regterationpageobj.year.click();
		WebElement year=driver.findElement(By.xpath("//select[@id='yearbox']"));
		Select s=new Select(year);
		s.selectByValue("1917");
		
		//Thread.sleep(3000);
		regterationpageobj.month.click();
		WebElement month=driver.findElement(By.xpath("//select[@ng-model='monthbox']"));
		Select s1=new Select(month);
		s1.selectByValue("March");	
		
		//Thread.sleep(3000);
		regterationpageobj.date.click();
		WebElement date=driver.findElement(By.cssSelector("#daybox"));
		Select s2=new Select(date);
		s2.selectByValue("2");		
	}
	
	@Test(priority=6)
	public void passwordfun() throws Exception
	{
		
		regterationpageobj.firstpassword.sendKeys(properties.getProperty("password"));
		regterationpageobj.secondpassword.sendKeys(properties.getProperty("password"));
		
		
	}
	
	@Test(priority=7)
	public void fileupload()
	{
		regterationpageobj.upload.sendKeys(properties.getProperty("fileupload"));
		logger.info("file uploated successfully");
	}
	
public  void selectoptionfromdropdown(WebElement ele, String value)
{
	
	Select select=new Select(ele);
	List<WebElement> alloption=select.getOptions();
	logger.info("all option"+alloption.size());
	
	for (WebElement options : alloption) {
		
		if(options.getText().equals(value))
		{
			options.click();
			logger.info("item selected from dropdowm");
			break;
			
		}
		
	}
}
}
