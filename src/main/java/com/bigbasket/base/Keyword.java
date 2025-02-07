package com.bigbasket.base;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Keyword {
	public static RemoteWebDriver driver;

	@Parameters("browser-name")
	public void openBrowser(@Optional String browserName) {
		if (browserName == null) {
			System.out.println("Launching Chrome by default");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid browser name");
		}

		System.out.println("Launched " + browserName + " browser");

	}

	public void launchUrl(String url) {
			driver.get(url);
	}

	public void clickOn(WebElement element) {
		element.click();
	}

	public void closeBrowser() {
			driver.close();
	}

	public void quitBrowser() {
		driver.quit(); // This properly closes the browser and ends the WebDriver session
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void print(String string) {
		System.out.println(string);
	}

	public static void sendkeys(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void sendKeys(WebElement element, Keys enter) {
		element.sendKeys(enter);

	}

	public void mouseHoverOn(WebElement element) {
		Actions actions = new Actions(Keyword.driver);
		actions.moveToElement(element).perform();
	}

	public void switchToChildWindowHandle() {
		Set<String> windowHandles = driver.getWindowHandles();
		String originalWindow = driver.getWindowHandle();
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

	}

	public void switchToWindowByTitle(String expectedTitleSubstring) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String handle : allWindows) {
			String currentTitle = driver.switchTo().window(handle).getTitle();
			if (currentTitle.contains(expectedTitleSubstring)) {
				System.out.println("Switched to window with title: " + currentTitle);
				break;
			}
		}
	}

	public List<WebElement> getWebElements(String locator) {
		String locatorType = locator.split("##")[0];
		locator = locator.split("##")[1];

		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElements(By.id(locator));
		} else if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElements(By.name(locator));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElements(By.xpath(locator));
		} else if (locatorType.equalsIgnoreCase("linktext")) {
			return driver.findElements(By.linkText(locator));
		} else if (locatorType.equalsIgnoreCase("partial")) {
			return driver.findElements(By.partialLinkText(locator));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElements(By.cssSelector(locator));
		} else if (locatorType.equalsIgnoreCase("classname")) {
			return driver.findElements(By.className(locator));
		} else
			return null;
	}

	public WebElement getWebElement(String locator) {

		String locatorType = locator.split("##")[0];
		locator = locator.split("##")[1];

		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(locator));
		} else if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElement(By.name(locator));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(locator));
		} else if (locatorType.equalsIgnoreCase("linktext")) {
			return driver.findElement(By.linkText(locator));
		} else if (locatorType.equalsIgnoreCase("partial")) {
			return driver.findElement(By.partialLinkText(locator));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElement(By.cssSelector(locator));
		} else if (locatorType.equalsIgnoreCase("classname")) {
			return driver.findElement(By.className(locator));
		} else
			return null;

	}

}
