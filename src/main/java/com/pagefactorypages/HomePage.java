package com.pagefactorypages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bigbasket.base.Keyword;
import com.bigbasket.base.WaitFor;

public class HomePage {
	Keyword keyword = new Keyword();

	@FindBy(css = "div.Header___StyledQuickSearch2-sc-19kl9m3-0 input.flex-1")
	WebElement searchText;

	public HomePage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	public void verifyUrlAfterSearch() {
		String currentURL = Keyword.driver.getCurrentUrl();
		assertTrue(currentURL.contains("https://www.bigbasket.com/ps"));

	}

	public void clickOnSearchText() {
		WaitFor.elementToBeClickable(searchText);
		searchText.click();
		System.out.println("Clicked on search text field.");

	}
	
	public void sendProductName() {
		WaitFor.untilUrlLoad("https://www.bigbasket.com/");
		WaitFor.elementToBeClickable(searchText);
		searchText.sendKeys("Amul Taaza Milk, 1 L Pouch");
		searchText.sendKeys(Keys.ENTER);
	}


	public void verifyWhenUserSearchProductAfterUrlWillChangedOnSameTab()  {
	    WaitFor.untilUrlLoad("/ps");
	    String currentURL = Keyword.driver.getCurrentUrl();
	    keyword.print("Current URL: " + currentURL);
	    assertTrue(currentURL.contains("/ps"), "URL is incorrect after search");
	}

	public void searchForProduct() throws InterruptedException {
		WaitFor.visibilityOfElement(searchText);
	    searchText.click();
	    searchText.sendKeys("Amul Taaza Milk, 1 L Pouch");
	    searchText.sendKeys(Keys.ENTER);
	}

}
