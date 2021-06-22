package Selenium.Automation2;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.addElementsToCart;
import pageObjects.locators_homepage;
import resources.base;

@Test
public class Homepage_DataProvider extends base {
	public WebDriver driver;
	locators_homepage L = new locators_homepage(driver);

	@BeforeTest
	public void initialize() throws IOException
	{

		driver =initializeDriver();
		driver.manage().window().maximize();
		//driver.get(prop.getProperty("url"));


	}
	@Test(dataProvider="name_quantity_index")
	public void addElements(String name,int quantity, int itemAtIndex) throws InterruptedException {

		//driver.findElement(By.xpath("//")).click();
		addElementsToCart add= new addElementsToCart();
		add.addtoCart(driver,name, quantity,itemAtIndex);



	}

	@AfterTest
	public void teardown() {

		driver.close();

	}

	@DataProvider(name="name_quantity_index")
	public Object[][] getDataFromDataprovider(){
		return new Object[][]
				{
			{ "BAT", 1,7 },
			{ "Ball", 1 ,1},
			{ "Projector", 1 ,3},
			{"Toy",3,11}
				};

	}



}



