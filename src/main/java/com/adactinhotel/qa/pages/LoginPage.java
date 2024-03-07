package com.adactinhotel.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactinhotel.qa.base.TestBase;

public class LoginPage extends TestBase {

	// pagefactory OR

	@FindBy(xpath = "//*[@id=\"username\"]")
	WebElement username;

	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement password;

	@FindBy(xpath = "//*[@id=\"login\"]")
	WebElement loginBtn;

	@FindBy(xpath = "//a[contains(text(),'New User Register Here')]")
	WebElement NewUserRegBtn;

	@FindBy(xpath = "/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/img[1]")
	WebElement logo;
	// adding all webelemnts

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateImage() {
		return logo.isDisplayed();
	}

	public SearchHotelPage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new SearchHotelPage();
	}

}
