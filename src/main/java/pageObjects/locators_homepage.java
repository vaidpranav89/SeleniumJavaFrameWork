package pageObjects;



import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class locators_homepage {
	public WebDriver driver;

	private By gdpr = By.xpath("//input[@id='sp-cc-accept']");
	private By searchBox = By.cssSelector("#twotabsearchtextbox");

	public By searchedItems= By.xpath("//span[contains(@class,'a-size-base-plus a-color-base a-text-normal')]");
	public By searchedItems2=By.xpath("//span[contains(@class,'a-size-medium a-color-base a-text-normal')]");
	private By add_size_quantity= By.xpath("//span[@class='a-dropdown-container']");
	private By item_Size_quanity = By.xpath("(//span[@class='a-dropdown-container']/select)[1]");
	private By clickCheckbox = By.cssSelector("[class$='ApplyCoupon']");


	public  locators_homepage(WebDriver driver) {
		this.driver=driver;

	}



	public void gdprAccept(WebDriver driver) {

		boolean eleSelected= driver.findElements(gdpr).size()!=0;
		if(eleSelected) {

			driver.findElement(gdpr).click();
		}


	}


	public WebElement searchBox(WebDriver driver) {

		return driver.findElement(searchBox);
	}

	public int searchedItems(WebDriver driver) {

		int size1=driver.findElements(searchedItems).size();
		int size2=driver.findElements(searchedItems2).size();
		if (size1>size2) {
			return size1;
		}else {
			return size2;
		}

	}

	public void searchedItematIndex(WebDriver driver,int index) {
		By searchedItematIndex1= By.xpath("(//span[contains(@class,'a-size-base-plus a-color-base a-text-normal')])[position()=" + index +"]");
		By searchedItematIndex2= By.xpath("(//span[contains(@class,'a-size-medium a-color-base a-text-normal')])[position()=" + index +"]");

		int size1= driver.findElements(searchedItematIndex1).size();
		int size2= driver.findElements(searchedItematIndex2).size();

		size1=driver.findElements(searchedItems).size();
		size2=driver.findElements(searchedItems2).size();


		if(size1>size2) {
			driver.findElement(searchedItematIndex1).click();
		}else {
			driver.findElement(searchedItematIndex2).click();
		}

	}


	public boolean item_Size_quanity_present(WebDriver driver) {
		boolean eleSelected= driver.findElements(add_size_quantity).size()>1;
		if (eleSelected) {
			return true;
		}else {
			return false;
		}}

	public void item_Size_quanity_selectbyValue(WebDriver driver,String value) {
		WebElement dropdown= driver.findElement(item_Size_quanity);

		Select s = new Select(dropdown);
		List<WebElement> elementsList = driver.findElements(item_Size_quanity);


		String originalList = elementsList.stream().map(q -> q.getText()).collect(Collectors.toList()).toString();
		originalList=originalList.replace("[", "").replace("]", "");




		List<String> items = Arrays.asList(originalList.split("\\n"));
		String lastItem = items.get(items.size()-1);
		//			System.out.println(items);

		if (items.contains(value)) {
			//				System.out.println("in");

			s.selectByVisibleText(value);

		}else {
			s.selectByVisibleText(lastItem);
		}




	}
	public void item_Size_quanity_selectbyIndex(WebDriver driver,int index) {
		WebElement dropdown= driver.findElement(item_Size_quanity);
		int dropdownSize = driver.findElements(item_Size_quanity).size();
		Select s = new Select(dropdown);
		if (index>dropdownSize) {
			s.selectByIndex(dropdownSize);
		}else {
			s.selectByIndex(index);
		}


	}

	public void checkCoupon(WebDriver driver) throws InterruptedException {

		boolean eleSelected= driver.findElements(clickCheckbox).size()!=0;
		//Thread.sleep(3000);
		if (eleSelected) {
			//			System.out.println("i am in2");
			driver.findElement(clickCheckbox).click();
		}



	}

}






