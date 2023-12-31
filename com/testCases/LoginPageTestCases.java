package com.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.EmailInboxPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PasswordRecoveryPage;
import com.pages.ResetPasswordPage;
import com.utility.BaseClass;

public class LoginPageTestCases extends BaseClass{
	
	LoginPage lp;
	HomePage hp;
	PasswordRecoveryPage pp;
	EmailInboxPage ep;
	ResetPasswordPage rp;
	
	@BeforeMethod
	public void beforeMethod() {
		lp= new LoginPage();
		hp= new HomePage();
		pp= new PasswordRecoveryPage();
		ep= new EmailInboxPage();
		rp= new ResetPasswordPage();
	}
	
	@Test 	// Test that the 'Login' button is disabled when both username and password fields are empty.
	public void validatedLoginBtnDisabled() { 
		boolean b1= lp.loginBtnEnabled();
		Assert.assertFalse(b1);
	}
	
	@Test   // Confirm that the 'Login' button is enabled only when both username and password fields are filled with valid input.
	public void validateLoginBtnEnabled() {  
		lp.enterUserName("Enter Valid Email Address");
		lp.enterPassword("Enter Valid Password");
		boolean b1= lp.loginBtnEnabled();
		Assert.assertTrue(b1);
	}
	
	@Test  //Validate that an error message is displayed when attempting to log in with invalid credentials.
	public void verifyErrorMsgLoginWithInvalidCredentials() {
		lp.enterUserName("Enter inValid Email Address");
		lp.enterPassword("Enter inValid Password");
		lp.clickLoginBtn();
		
		String expectedResult = "Please Enter Valid Credentials";
		String actualResult = lp.errorMsgText();
		
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test  // Ensure that the login page retains the entered username and password fields' values after a failed login attempt.
	public void verifyInvalidCredentialsRetained() {
		String expectedResult = lp.userNameTxtboxValue() + lp.passwordTxtboxValue();
		String actualResult = "Invalid username"+"Invalid password";
		
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test  // Verify that a user with valid credentials can successfully log in and access the system.
	public void verifySucessfullLogin() {
		lp.enterUserName("Enter Valid Email Address");
		lp.enterPassword("Enter Valid Password");
		lp.clickLoginBtn();
		
		String expectedResult = "Home Page";
		String actualResult = hp.getElementText();
		
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test  // Verify that clicking the 'Forgot Password' link redirects the user to the password recovery page.
	public void verifyNavigationToPasswordRecoveryPage() {
		lp.clickForgotPswrdLink();
		String expectedResult = "Password Recovery Page Title";
		String actualResult = pp.getPagetitle();
		
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	// Validate the password recovery functionality by following these steps
	
	@Test  // Verify that a success message is displayed indicating that an email with password recovery instructions has been sent.
	public void verifySucessMsgPasswordRecoveryFunctionality() {
		lp.clickForgotPswrdLink();
		pp.enterRegisteredEmail("Enter Registered Mail");
		pp.clickRecoverPswrdBtn();
		
		String actualResult= pp.getSucessMsg();
		String expectedResult= "Email sent to registered mail";
		Assert.assertEquals(actualResult, expectedResult);		
	}
	
	@Test //Ensure that after successfully resetting the password, the user is redirected to the login page.
	public void verifyNagigationToLoginPageAfterPasswordReset() {
		ep.openMailInboxUrl();
		ep.openPasswordRecoveryMail();
		ep.clickpasswordRecoveryLink();
		switchTab(1);
		rp.enterNewPassword("enter new password");
		rp.enterConfirmPassword("enter confirm password");
		rp.clickResetBtn();
		
		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "Login Page Title";
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
	}
	
	@Test  // Validate that the user can log in with the new password.
	public void verifyLoginWithNewPassword() {
		lp.enterUserName("Enter username");
		lp.enterPassword("Enter new password");
		lp.clickLoginBtn();
		
		String expectedResult = "Home Page";
		String actualResult = hp.getElementText();
		
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	
	
	
}
