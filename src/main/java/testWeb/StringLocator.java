package testWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StringLocator {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		Thread.sleep(1000);

		String fName = "input-firstname";
		String lName = "lastname";
		String eMail = "form-control";
		String telephone = "#input-telephone";
		String password = "//input[@id='input-password']";

//		getElement(getBy("Id", fName)).sendKeys("Prasad");
//		getElement(getBy("Name", lName)).sendKeys("Raut");
//		getElement(getBy("ClassName", eMail)).sendKeys("test@test.com");
//		getElement(getBy("CSSSelector", telephone)).sendKeys("6438829");
//		getElement(getBy("xpath", password)).sendKeys("Prasasad");

		getElement("id", fName).sendKeys("tetdgc");
		Thread.sleep(1000);
		driver.quit();
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue));
	}

	public static By getBy(String locatorType, String locatorValue) {
		By locator = null;
		switch (locatorType.toUpperCase()) {
		case "ID":
			locator = By.id(locatorValue);
			break;
		case "NAME":
			locator = By.name(locatorValue);
			break;
		case "CLASSNAME":
			locator = By.className(locatorValue);
			break;
		case "TAGNAME":
			locator = By.tagName(locatorValue);
			break;
		case "LINKTEXT":
			locator = By.linkText(locatorValue);
			break;
		case "PARTIALLINKTEXT":
			locator = By.partialLinkText(locatorValue);
			break;
		case "XPATH":
			locator = By.xpath(locatorValue);
			break;
		case "CSSSELECTOR":
			locator = By.cssSelector(locatorValue);
			break;
		default:
			throw new RuntimeException("===INVALIDSELECTOREXCEPTION===");
		}
		return locator;
	}
}
