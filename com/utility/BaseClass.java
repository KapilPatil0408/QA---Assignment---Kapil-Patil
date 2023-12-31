package com.utility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected WebDriver driver;

	public void setUpBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("Url of Web Application");
		driver.manage().window().maximize();
	}

	public void waitForVisibility(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void clickOnElement(WebElement e) {
		waitForVisibility(e);
		e.click();
	}

	public void enterText(WebElement e, String str) {
		waitForVisibility(e);
		e.sendKeys(str);
	}
	
	public boolean buttonEnabled(WebElement e) {
		waitForVisibility(e);
		return e.isEnabled();
	}
	
	public String getElementTxt(WebElement e) {
		waitForVisibility(e);
		return e.getText();
	}
	
	public void newOpenUrlInTab(String url) {
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(url);
	}
	
	public String getAttribute(WebElement e, String attribute) {
		waitForVisibility(e);
		return e.getAttribute(attribute);
	}
	
	public void switchTab(int n) {
	
		Set<String> allwindowIds= driver.getWindowHandles();
		List<String> windowList= new ArrayList(allwindowIds);
		
		String childWindowID = windowList.get(n);
		driver.switchTo().window(childWindowID);		
		}
	}

