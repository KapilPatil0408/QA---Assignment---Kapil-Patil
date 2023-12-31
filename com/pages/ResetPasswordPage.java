package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utility.BaseClass;

public class ResetPasswordPage extends BaseClass{

	WebElement newPasswordTxtbox= driver.findElement(By.id("NewPassword"));
	WebElement confirmPasswordTxtbox= driver.findElement(By.id("ConfirmPassword"));
	WebElement resetBtn= driver.findElement(By.id("reset-btn")); 
	
	public void enterNewPassword(String newPassword) {
		enterText(newPasswordTxtbox, newPassword);
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		enterText(confirmPasswordTxtbox, confirmPassword);
	}
	
	public LoginPage clickResetBtn() {
		clickOnElement(resetBtn);
		return new LoginPage();
	}	
}
