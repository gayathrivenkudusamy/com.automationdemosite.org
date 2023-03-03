package ReportPakage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class automationreport implements ITestListener {

	
	
	public static ExtentReports extentreport;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest test;
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	public static WebDriver driver;
	
	public static ExtentReports setup()
	{
		String fileName=getReportName();
		
		String directory=System.getProperty("user.dir")+"/Reports/";
		new File(directory).mkdir();
		
		String path=directory+fileName;
		
		
		
		extentreport=new ExtentReports();
		htmlReporter=new ExtentHtmlReporter(path);
		extentreport.attachReporter(htmlReporter);
		
		extentreport.setSystemInfo("OS","Windows 10");
		extentreport.setSystemInfo("Browser", "Chrome");
		extentreport.setSystemInfo("QA", "Gayathri");
		
		
		htmlReporter.config().setDocumentTitle("Automation Demo Sit Report");
		htmlReporter.config().setReportName("Automation Demo Site - Registeration");
		htmlReporter.config().setTheme(Theme.DARK);
		
				
		return extentreport;
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
			
			
		
		test=extentreport.createTest("Register Form"+result.getMethod().getMethodName());
		test.info("done");
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String logtext="Registeration success";
		Markup m=MarkupHelper.createLabel(logtext, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, m);
		
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
 String methodName=result.getMethod().getMethodName();
		
		String errorMessage=Arrays.toString(result.getThrowable().getStackTrace());
		extentTest.get().fail("<details><summary><b><font color=red>"+"Exception occure,click here"+"</font></b></summary>"+errorMessage.replace(",","<br>"+"</details> /n"));
		
		String path=takeScreenshot(result.getMethod().getMethodName());
		
		try {
			extentTest.get().fail("<b><font color=red>"+"screenshot of failure"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}catch(IOException e)
		{
			extentTest.get().fail("<b><i>"+"Test failed, cant not attach screenshot"+"</i></b>");	
		}
		
		
		
		String logText="<b>The Method"+methodName+"Fail</b>";
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, m);
		

		
	}

	

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String logmsg="The Method"+result.getMethod().getMethodName()+"Success";
		Markup m=MarkupHelper.createLabel(logmsg, ExtentColor.YELLOW);
		extentTest.get().log(Status.SKIP, m); 
	}

	@Override
	public void onStart(ITestContext context) {
		setup();
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		if(extentreport!=null)
		{
			extentreport.flush();
		}
		
	}
	public static String getReportName()
	{
		Date d=new Date();
		
		String fileName="Report"+d.toString().replace(":","_").replace(" ","_")+".html";
		return fileName;
		
	}
public static String takeScreenshot(String methodName) {
		
		String fileName=getScreenshotName(methodName);
		String directory=System.getProperty("user.dir")+"/Automation Demo Site/";
		new File(directory).mkdirs();
		
		String path=directory+fileName;
		
		try {
			
			File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot,new File(path));
			System.out.println("**********************************");
			System.out.println("Screenshot sotredat:"+path);
			System.out.println("**********************************");
			
		}catch (Exception e)
		{
			e.getStackTrace();
			
		}
		
		return path;
	}
	public static String getScreenshotName(String methodName)
	{
		Date d=new Date();
		String fileName=methodName+"_"+d.toString().replace(":", "_").replace(" ","_")+".png";
		
		return fileName;
		
	}


}
