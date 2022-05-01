package org.video8;

import org.openqa.selenium.By;

public class Locators {
	
	public static By getID(String locatorvalue) {
		return By.id(locatorvalue);
	}
	
	public static By getXpath(String locatorvalue) {
		return By.xpath(locatorvalue);
	}

}
