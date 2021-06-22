package Selenium.Automation2;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import resources.base;


public class myTest extends base {
	public WebDriver driver ;
	public static Logger log = LogManager.getLogger(Test.class.getName());

	

	@Test()
	public void addElements() throws InterruptedException {
		
			System.out.println("okkkkkkk=============================");
	}

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		log.info("URL launched" + prop.getProperty("url"));
		
	}
	
	@AfterTest
	public void teardown() {

		driver.close();

	}

}
