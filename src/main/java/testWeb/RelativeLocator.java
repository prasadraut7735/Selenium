package testWeb;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocator {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://dev24x.steepgraph.com/3dspace");

		Thread.sleep(5000);
		driver.findElement(By.id("username")).sendKeys("3DEXP01");

		WebElement ele = driver.findElement(By.id("password"));
		ele.sendKeys("Passport1");
		driver.findElement(with(By.tagName("input")).below(ele)).click();

		Thread.sleep(5000);
		WebElement ele1 = driver.findElement(By.xpath(
				"//div[contains(@class,'add') and contains(@class,'topbar-menu-item') and contains(@class,'topbar-cmd')][ancestor::div[normalize-space()='3D EXP01Common Space']][preceding-sibling::div[contains(@class,'profile') and contains(@class,'topbar-menu-item') and contains(@class,'topbar-cmd')]][following-sibling::div[contains(@class,'share') and contains(@class,'topbar-menu-item') and contains(@class,'topbar-cmd')]]"));
		driver.findElement(with(By.tagName("div")).toLeftOf(ele1)).click();

		Thread.sleep(3000);
		driver.quit();
	}
}
