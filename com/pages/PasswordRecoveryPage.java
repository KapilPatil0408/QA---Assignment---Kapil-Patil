package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utility.BaseClass;

public class PasswordRecoveryPage extends BaseClass {

	WebElement emailTxtbox = driver.findElement(By.id("Enter Registered Mail"));
	WebElement recoverPswrdBtn = driver.findElement(By.id("Btn"));
	WebElement pageTitle = driver.findElement(By.name("title"));
	WebElement pswdRecoverySucessMsg = driver.findElement(By.xpath("//*[contains('@text','Sucess Message')]"));

	public void enterRegisteredEmail(String str) {
		enterText(emailTxtbox, str);
	}

	public void clickRecoverPswrdBtn() {
		clickOnElement(recoverPswrdBtn);
	}

	public String getPagetitle() {
		return getElementTxt(pageTitle);
	}

	public String getSucessMsg() {
		return getElementTxt(pswdRecoverySucessMsg);
	}

}
