package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utility.BaseClass;

public class HomePage extends BaseClass {

	WebElement pageElement = driver.findElement(By.name("title"));

	public String getElementText() {
		return getElementTxt(pageElement);
	}
}
