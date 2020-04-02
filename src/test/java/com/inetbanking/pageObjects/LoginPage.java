package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "uid")
	@CacheLookup
	WebElement txtusername;

	@FindBy(name = "password")
	@CacheLookup
	WebElement txtpassword;

	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement Loginbtn;

	@FindBy(name = "btnReset")
	@CacheLookup
	WebElement Resetbtn;

	@FindBy(how = How.XPATH, using = "//a[text()='Log out']")
	@CacheLookup
	WebElement lnkLogout;

	public void setusername(String uname) {
		txtusername.sendKeys(uname);
	}

	public void setpassword(String password) {
		txtpassword.sendKeys(password);
	}

	public void clicklogin() {
		Loginbtn.click();
	}

	public boolean validatetitle() {

		System.out.println(ldriver.getTitle());
		return ldriver.getTitle() != null;

	}

	public void clickLogout() {
		lnkLogout.click();
	}

}
