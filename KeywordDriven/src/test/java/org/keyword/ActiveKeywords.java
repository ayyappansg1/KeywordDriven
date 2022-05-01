package org.keyword;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActiveKeywords {

	static WebDriver driver;

	public static void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\java files\\KeywordDriven\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	public static void goToUrl() {
		driver.get("https://www.amazon.in");
	}
	public static void searchIPhone() {
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys("i phone\n");
	}
	public static void firstIphone() {
		WebElement firstphone = driver.findElement(By.xpath("(//span[contains(text(),'Apple iPhone 12 (128GB)')])[1]"));
		firstphone.click();

	}
	public static void switchWindowToPrint() {
		String current = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			driver.switchTo().window(string);
		}
		WebElement title = driver.findElement(By.xpath("//span[@id='productTitle']"));
		System.out.println(title.getText());
	}
	public static void addToCart() {
		WebElement cart = driver.findElement(By.id("add-to-cart-button"));
		cart.click();	
	}



}
