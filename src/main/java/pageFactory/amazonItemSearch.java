package pageFactory;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class amazonItemSearch {
	public  WebDriver driver;
	@FindBy(xpath = "//input[@id='sp-cc-accept']")
	private List<WebElement> gdpr;

	@FindBy(css = "#twotabsearchtextbox")

	private WebElement searchBox;

	@FindBy(xpath = "//span[contains(@class,'a-size-base-plus a-color-base a-text-normal')]")
	private List<WebElement> searchedItems;

	@FindBy(xpath = "//span[contains(@class,'a-size-medium a-color-base a-text-normal')]")
	private List<WebElement> searchedItems2;

	@FindBy(xpath = "//span[@data-a-color='base']")
	private List<WebElement> price;




	public amazonItemSearch(WebDriver driver)

	{

		this.driver=driver;

		PageFactory.initElements(driver, this);
		System.out.println(this.driver);

	}

	public void gdprAccept() {

		System.out.println(driver);
		boolean eleSelected = gdpr.size() != 0;
		if (eleSelected) {
			gdpr.get(0).click();
		}
	}


	public void searchItem(String ItemToBeSearched) {

		Actions a = new Actions(driver);
		a.moveToElement(searchBox).doubleClick().keyDown(Keys.SHIFT).sendKeys(ItemToBeSearched).keyUp(Keys.SHIFT)
		.sendKeys(Keys.RETURN).build().perform();

	}

	public List<String> searchedItems() {

		int size1 = searchedItems.size();
		int size2 = searchedItems2.size();
		List<String> itemsOnPage;
		System.out.println(size1 + "--- " + size2);
		if (size1 > size2) {
			itemsOnPage = searchedItems.stream().map(a -> a.getText()).collect(Collectors.toList());
			/*
			 * //List<String> priceofItems= price.stream().map(a->
			 * a.getText()).collect(Collectors.toList());
			 *
			 * for (int i=0;i <itemsOnPage.size();i++) {
			 *
			 * String myItems = itemsOnPage.get(i);
			 *
			 * //String priceitem=priceofItems.get(i);
			 *
			 *
			 * System.out.println(myItems ); //System.out.println(priceitem);
			 *
			 * }
			 */



		} else {

			itemsOnPage = searchedItems2.stream().map(a -> a.getText()).collect(Collectors.toList());
			/*
			 * //List<String> priceofItems= price.stream().map(a->
			 * a.getText()).collect(Collectors.toList());
			 *
			 * System.out.println(itemsOnPage); System.out.println(itemsOnPage.size());
			 *
			 * for (int i=0;i <itemsOnPage.size();i++) {
			 *
			 * String myItems = itemsOnPage.get(i); //String priceitem=priceofItems.get(i);
			 *
			 *
			 * System.out.println(myItems ); //System.out.println(priceitem); }
			 */

		}
		return itemsOnPage;
	}

	public void searchAndInsertFoundItemsToExcel() {
		// TODO Auto-generated method stub

	}

}
