package Selenium.Automation2;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.amazonItemSearch;
import resources.base;
import resources.jdbcconnection;

public class dataFromJDBC extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(dataFromJDBC.class.getName());
	jdbcconnection jd = new jdbcconnection();


	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.manage().window().maximize();


	}

	@Test()
	public void addElementstoExcel() throws Exception  {
		amazonItemSearch Ais = new amazonItemSearch(driver);
		Ais.gdprAccept();
		String column1 ="item";
		String column2="itemfound1";
		String column3=null;
		String tablename= "items";
		String whereClause="item='Cricket'";
		String database= "seleniumtest";

		List<String> mylist = jd.getResult(database,column1,column2, column3, tablename, whereClause);
		System.out.println(mylist);
		System.out.println(mylist.size());

		for (int i=0;i<mylist.size();i++) {
			String myItemvalue = mylist.get(i);
			Ais.searchItem(myItemvalue);
			List<String>products=Ais.searchedItems();
			for(int l=0;l< products.size();l++) {
				String myItemis= products.get(l);
				System.out.println(myItemis);
			}



		}



	}






	@AfterTest public void teardown() {

		driver.close();

	}



}
