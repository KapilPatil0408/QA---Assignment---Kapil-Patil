package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utility.BaseClass;

public class EmailInboxPage extends BaseClass{
	
	WebElement resetPasswordMail = driver.findElement(By.xpath("//*[@text='mail']"));
	WebElement passwordRecoveryLink = driver.findElement(By.tagName("a"));
	

	public void openMailInboxUrl() {
		newOpenUrlInTab("inbox url");
	}
	
	public void openPasswordRecoveryMail() {
		clickOnElement(resetPasswordMail);
	}
	
	public void clickpasswordRecoveryLink() {
		clickOnElement(passwordRecoveryLink);
	}
	
	
	
	
}
