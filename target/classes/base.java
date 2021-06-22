package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public static  WebDriver driver;
	//public WebDriver driver;
	public Properties prop;
	public static Logger log = LogManager.getLogger(base.class.getName());
	private String WebURL= "http://amazon.co.uk";
	public WebDriver initializeDriver() throws IOException
	{

		prop= new Properties();
		//System.getProperty("user.dir")
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		//mvn test -Dbrowser=chrome

		//String browserName=System.getProperty("browser");  // Uncomment this line if you are sending parameter from Maven
		String browserName=prop.getProperty("browser");// comment this line if you are sending parameter from Maven
		System.out.println(browserName);

		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
			ChromeOptions options =new ChromeOptions();
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver= new ChromeDriver(options);
			//execute in chrome driver

		}
		else if (browserName.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", "c://geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.contains("edge")) {
			System.setProperty("webdriver.edge.driver", "c://msedgedriver.exe");
			driver = new EdgeDriver();
		}




		/* driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); */

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver ;

	}


	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}
	public String getURL() {
		return WebURL;
	}

}
