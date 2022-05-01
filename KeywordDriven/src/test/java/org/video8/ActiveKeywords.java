package org.video8;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActiveKeywords {

	static WebDriver driver;

	public static void launchBrowser() {
		if(ReadingExcel.testdatavalue.contains("chrome")) {
		System.setProperty("webdriver.chrome.driver", "E:\\java files\\KeywordDriven\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
	}
	public static void goToUrl() {
		driver.get(ReadingExcel.testdatavalue);
	}
	public static void searchIPhone() {
		WebElement searchbox = driver.findElement(Engine.locator);
		searchbox.sendKeys(ReadingExcel.testdatavalue);
		searchbox.submit();
	}
	public static void firstIphone() {
		WebElement firstphone = driver.findElement(Engine.locator);
		firstphone.click();

	}
	public static void switchWindowToPrint() {
		String current = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			driver.switchTo().window(string);
		}
		WebElement title = driver.findElement(Engine.locator);
		System.out.println(title.getText());
	}
	public static void addToCart() {
		WebElement cart = driver.findElement(Engine.locator);
		cart.click();	
	}



}
