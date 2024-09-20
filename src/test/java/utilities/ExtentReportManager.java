package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

	
	public class ExtentReportManager implements ITestListener{
		
		ExtentSparkReporter sparkReporter;
		ExtentReports extent;
		ExtentTest test;
		
		String repName;
		
		public void onStart(ITestContext testContext) {
			
			/*SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
			Date dt=new Date();
			String currentdatetimestamp=df.format(dt);*/
			
			String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			
			repName="Test-Report-"+timeStamp+".html";
			sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);
			
			sparkReporter.config().setReportName("opencart Automation");
			sparkReporter.config().setDocumentTitle("opencartFunctional testing");
			sparkReporter.config().setTheme(Theme.DARK);
			
			extent=new ExtentReports();
			extent.attachReporter(sparkReporter);
			
			extent.setSystemInfo("Application", "opencart");
			extent.setSystemInfo("Module", "Admin");
			extent.setSystemInfo("Username", System.getProperty("user.name"));
			
			String browser=testContext.getCurrentXmlTest().getParameter("browser");
			extent.setSystemInfo("Browser", browser);
			
			String os=testContext.getCurrentXmlTest().getParameter("os");
			extent.setSystemInfo("Operating system", os);
			
			List<String> includedGroups=testContext.getCurrentXmlTest().getIncludedGroups();
			if(!includedGroups.isEmpty()) {
				extent.setSystemInfo("Groups", includedGroups.toString());
			}
			}
		

		public void onTestSuccess(ITestResult result) {
			
			test=extent.createTest(result.getTestClass().getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.PASS, "Test case passed is: "+result.getName());
			
		}

		public void onTestSkipped(ITestResult result) {
			
			test=extent.createTest(result.getTestClass().getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.SKIP, "Test case skiped is: "+result.getName());
			test.log(Status.INFO, result.getThrowable().getMessage());
		}

		public void onTestFailure(ITestResult result) {

			test=extent.createTest(result.getTestClass().getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.FAIL, "Test case failed is: "+result.getName());
			test.log(Status.INFO, result.getThrowable().getMessage());
			
			try {
				String imgPath=new BaseClass().captureScreen(result.getName());
				test.addScreenCaptureFromPath(imgPath);
				
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		public void onFinish(ITestContext context) {
			
			extent.flush();
			
			String pathofExtentReport =System.getProperty("user.dir")+"\\reports\\"+repName;
			File extentReport=new File(pathofExtentReport);
			
			try {
				Desktop.getDesktop().browse(extentReport.toURI());
				
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		




}
