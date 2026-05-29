package testWeb;

import java.time.Duration;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderPractice {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("#datepicker")).click();
		selectDate("December 2027", "27");
	}

	public static void selectDate(String expectedMonthYear, String day) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);
		YearMonth expected = YearMonth.parse(expectedMonthYear, formatter);

		while (true) {
			String actualMonthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
			YearMonth actual = YearMonth.parse(actualMonthYear, formatter);
			if (actual.equals(expected)) {
				break;
			}
			if (actual.compareTo(expected) < 0) {
				driver.findElement(By.xpath("//a[@title='Next']")).click();
			} else {
				driver.findElement(By.xpath("//a[@title='Prev']")).click();
			}
		}
		driver.findElement(By.linkText(day)).click();
	}

}
