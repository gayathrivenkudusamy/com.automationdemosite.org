package PageObjectsPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class regterationpageobj {
	
	@FindBy(xpath="//input[@ng-model='FirstName']")
	@CacheLookup
	public static WebElement firstname;
	
	@FindBy(xpath="//input[@ng-model=\"LastName\"]")
	@CacheLookup
	public static WebElement lastname;
	
	@FindBy(xpath="//textarea[@ng-model=\"Adress\"]")
	@CacheLookup
	public static WebElement address;
	
	@FindBy(xpath="//input[@ng-model='EmailAdress']")
	@CacheLookup
	public static WebElement email;
	
	@FindBy(xpath="//input[@ng-model='Phone']")
	@CacheLookup
	public static WebElement phone;
	
	@FindBy(xpath="//input[@value='Male']")
	@CacheLookup
	public static WebElement gender;
	
	@FindBy(css="#checkbox1")
	@CacheLookup
	public static WebElement cricket;
	
	@FindBy(css="#checkbox3")
	@CacheLookup
	public static WebElement hockey;
	
	@FindBy(css="#msdd")
	@CacheLookup
	public static WebElement language;
	
	@FindBy(css="#Skills")
	@CacheLookup
	public static WebElement skills;
	
	@FindBy(css=".selection")
	@CacheLookup
	public static WebElement country;
	
	@FindBy(css="#yearbox")
	@CacheLookup
	public static WebElement year;
	
	@FindBy(xpath="//select[@ng-model='monthbox']")
	@CacheLookup
	public static WebElement month;
	
	@FindBy(css="#daybox")
	@CacheLookup
	public static WebElement date;
	
	@FindBy(css="#firstpassword")
	@CacheLookup
	public static WebElement firstpassword;
	
	@FindBy(css="#secondpassword")
	@CacheLookup
	public static WebElement secondpassword;
	
	
	@FindBy(css="#submitbtn")
	@CacheLookup
	public static WebElement submit;
	
	@FindBy(css="#Button1")
	@CacheLookup
	public static WebElement refgresh;
	
	
	@FindBy(css="#imagesrc")
	@CacheLookup
	public static WebElement upload;
	
	
	

}
