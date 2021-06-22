package stepDefinations;

import java.util.List;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.amazonItemSearch;
import resources.base;

public class stepDefination extends base  {

	public WebDriver driver;

	amazonItemSearch Ais ;


	@Given("^I launch the chrome browser$")
	public void i_launch_the_chrome_browser() throws Throwable {

		driver = initializeDriver();
		Ais = new amazonItemSearch(driver);
	}

	@When("^I search for the product \"([^\"]*)\" on Search Bar$")
	public void i_search_for_the_product_something_on_search_bar(String strArg1) throws Throwable {

		Ais.gdprAccept();
		Ais.searchItem(strArg1);



	}

	@When("^I search for the (.+)  from table on Search Bar$")
	public void i_search_for_the_from_table_on_search_bar(String product) throws Throwable {
		Ais.gdprAccept();
		Ais.searchItem(product);

	}


	@Then("^I am able to see products searched$")
	public void i_am_able_to_see_products_searched() throws Throwable {


	}

	@And("^I navigate to \"([^\"]*)\" website$")
	public void i_navigate_to_something_website(String strArg1) throws Throwable {
		//System.out.println(driver + "-----------"+ strArg1);
		driver.get(strArg1);
		log.info("URL launched--" + strArg1);
		driver.manage().window().maximize();

	}

	@And("^I print list of all the products$")
	public void i_print_list_of_all_the_products() throws Throwable {

		List<String> products=Ais.searchedItems();
		System.out.println(products);

	}

	@And("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
		driver.close();
	}



}

