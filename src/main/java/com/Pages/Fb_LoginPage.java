package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.FunctionalityLibrary;

public class Fb_LoginPage extends FunctionalityLibrary {
	
	public Fb_LoginPage() {
	PageFactory.initElements(driver.get() , this);
	}
	
	@FindBy(id ="email" )
	WebElement emailOrPhone_txt;
	
	@FindBy(id = "pass")
	WebElement password_txt;
	
	@FindBy(name = "login")
	WebElement login_Btn;
	
	
	public void loginFb(String email,String password) {
		FunctionalityLibrary.setText(emailOrPhone_txt, email, "Email or Phone No");
		FunctionalityLibrary.setText(password_txt, password, "Password");
		FunctionalityLibrary.click(login_Btn, "Login Button");
	}
	

}
