package Selenium.Automation2;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.addElementsToCart;
import pageObjects.locators_homepage;
import resources.base;

public class Homepage extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Homepage.class.getName());

	locators_homepage L = new locators_homepage(driver);

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.manage().window().maximize();


	}

	@Test()
	public void addElements() throws InterruptedException {

		/*
		 * String[] name = { "BAT", "Ball", "Projector", "Toy" }; int[] quantity = { 2,
		 * 1, 1, 7 }; int[] itemAtIndex = { 7, 1, 1, 11 };
		 */

		String[] name = { "BAT" };
		int[] quantity = { 2};
		int[] itemAtIndex = { 7};
		addElementsToCart add = new addElementsToCart();
		add.addtoCart(driver, name, quantity, itemAtIndex);

	}



	@AfterTest
	public void teardown() {

		driver.close();

	}

}
