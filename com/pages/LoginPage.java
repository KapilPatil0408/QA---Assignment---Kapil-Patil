package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utility.BaseClass;

public class LoginPage extends BaseClass {

	WebElement usernameTxtbox = driver.findElement(By.id("username"));
	WebElement passwordTxtbox = driver.findElement(By.id("password"));
	WebElement loginBtn = driver.findElement(By.id("login-button"));
	WebElement forgotPswdLink = driver.findElement(By.xpath("//*[@text='Forgot Password']"));
	WebElement errorMessage = driver.findElement(By.xpath("//*[@text='Please Enter Valid Credentials']"));
 
	
	public void enterUserName(String str) {
		enterText(usernameTxtbox, str);
	}

	public void enterPassword(String str) {
		enterText(passwordTxtbox, str);
	}

	public HomePage clickLoginBtn() {
		clickOnElement(loginBtn);
		return new HomePage();
	}

	public PasswordRecoveryPage clickForgotPswrdLink() {
		clickOnElement(forgotPswdLink);
		return new PasswordRecoveryPage();
	}

	public boolean loginBtnEnabled() {
		return buttonEnabled(loginBtn);
	}

	public String errorMsgText() {
		return getElementTxt(errorMessage);
	}

	public String userNameTxtboxValue() {
		return getAttribute(usernameTxtbox, "Value");
	}

	public String passwordTxtboxValue() {
		return getAttribute(passwordTxtbox, "Value");
	}
}
