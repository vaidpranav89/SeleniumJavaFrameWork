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
import pageObjects.locators_homepage;
import resources.base;
import resources.dataDrivenExcel;

public class dataDrivenTestFromExcel extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(dataDrivenTestFromExcel.class.getName());

	locators_homepage L = new locators_homepage(driver);


	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.manage().window().maximize();


	}

	@Test()
	public void addElementstoExcel() throws Exception  {
		amazonItemSearch Ais = new amazonItemSearch(driver);
		dataDrivenExcel excel = new dataDrivenExcel(System.getProperty("user.dir")+ "\\excelDataDriven.xlsx");
		excel.setSheetName("Input");
		int rowCount= excel.getRowCount();
		int colCount= excel.getColumnCount(0);
		System.out.println(rowCount);
		System.out.println(colCount);
		for (int k = 1; k<rowCount; k++){
			String myItemvalue= "";
			colCount=excel.getColumnCount(k);
			for (int j = 0; j<colCount;j++){
				myItemvalue= myItemvalue+excel.getCellValue( k, j);

			}
			Ais.gdprAccept();
			Ais.searchItem(myItemvalue);
			List<String> products=Ais.searchedItems();
			for(int l=0;l< products.size();l++) {
				String myItem= products.get(l);

				rowCount= excel.getRowCount();
				colCount= excel.getColumnCount(k);

				excel.setCellValue(k, colCount, myItem);
			}


		}





	}






	@AfterTest public void teardown() {

		driver.close();

	}



}
