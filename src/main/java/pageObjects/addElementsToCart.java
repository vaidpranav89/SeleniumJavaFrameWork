package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class addElementsToCart {
	public WebDriver driver;
	locators_homepage L = new locators_homepage(driver);
	public void addtoCart(WebDriver driver, String[] name, int[] quantity,int[] ProductOnPage) throws InterruptedException {


		for (int n=0;n<name.length;n++) {

			String ItemToBeSearched=name[n];
			int Itemquantity= quantity[n];
			int ItemonPage= ProductOnPage[n];


			L.gdprAccept(driver);

			Actions a = new Actions(driver);

			//WebElement move= driver.findElement(By.cssSelector("#nav-link-accountList"));
			//a.moveToElement(L.searchBox(driver)).click().keyDown(Keys.SHIFT).sendKeys("Cricket").keyUp(Keys.SHIFT).sendKeys("Bat").sendKeys(Keys.RETURN).build().perform();
			//WebElement searchBox = new  WebDriverWait (driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(L.searchBox(driver)));

			a.moveToElement(L.searchBox(driver)).doubleClick().keyDown(Keys.SHIFT).sendKeys(ItemToBeSearched).keyUp(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
			//System.out.println(L.searchedItems(driver));
			;
			L.searchedItematIndex(driver, ItemonPage);
			//a.moveToElement(move).click().build().perform();

			//System.out.println(L.item_Size_quanity_present(driver));

			if (L.item_Size_quanity_present(driver)==true) {
				L.item_Size_quanity_selectbyValue(driver, "10");
				//Thread.sleep(4000L);
				L.item_Size_quanity_selectbyIndex(driver, Itemquantity);

			}
			L.checkCoupon(driver);



			driver.navigate().back();
		}
	}
	public void addtoCart(WebDriver driver, String name, int quantity, int itemAtIndex) throws InterruptedException {
		// TODO Auto-generated method stub

		L.gdprAccept(driver);

		Actions a = new Actions(driver);

		//WebElement move= driver.findElement(By.cssSelector("#nav-link-accountList"));
		//a.moveToElement(L.searchBox(driver)).click().keyDown(Keys.SHIFT).sendKeys("Cricket").keyUp(Keys.SHIFT).sendKeys("Bat").sendKeys(Keys.RETURN).build().perform();
		a.moveToElement(L.searchBox(driver)).doubleClick().keyDown(Keys.SHIFT).sendKeys(name).keyUp(Keys.SHIFT).sendKeys(Keys.RETURN).build().perform();
		//System.out.println(L.searchedItems(driver));
		L.searchedItematIndex(driver, itemAtIndex);
		//a.moveToElement(move).click().build().perform();

		//System.out.println(L.item_Size_quanity_present(driver));

		if (L.item_Size_quanity_present(driver)==true) {
			L.item_Size_quanity_selectbyValue(driver, "10");
			//Thread.sleep(4000L);
			L.item_Size_quanity_selectbyIndex(driver, quantity);

		}
		L.checkCoupon(driver);



		driver.navigate().back();

	}

}


