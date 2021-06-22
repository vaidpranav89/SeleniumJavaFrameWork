package resources;

/*import java.text.SimpleDateFormat;*/


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	static ExtentReports extent;
		
		public static ExtentReports getReportObject() {
			String path =System.getProperty("user.dir")+"\\reports\\index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Automation Result");
			reporter.config().setDocumentTitle("Test Results");
			
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Pranav");
		
			/*
			 * SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			 * Date date = new Date(); extent.setSystemInfo("Date", formatter.format(date));
			 */
			return extent;
		
			
		}

}
