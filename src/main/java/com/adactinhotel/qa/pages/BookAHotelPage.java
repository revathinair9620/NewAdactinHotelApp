package com.adactinhotel.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.adactinhotel.qa.base.TestBase;

public class BookAHotelPage extends TestBase {

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstname;

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lastname;

	@FindBy(xpath = "//textarea[@id='address']")
	WebElement address;

	@FindBy(xpath = "//input[@id='cc_num']")
	WebElement creditcardno;

	@FindBy(xpath = "//select[@id='cc_type']")
	WebElement creditCardType;

	@FindBy(xpath = "//select[@id='cc_exp_month']")
	WebElement expiryMonth;

	@FindBy(xpath = "//select[@id='cc_exp_year']")
	WebElement expiryYear;

	@FindBy(xpath = "//input[@id='cc_cvv']")
	WebElement cvvno;

	@FindBy(xpath = "//input[@id='book_now']")
	WebElement bookNowBtn;

	// Initializing the Page Objects:
	public BookAHotelPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateBookAHotelPageTitle() {
		return driver.getTitle();
	}

	public void enterBookingDetails(String ftname, String ltname, String addr, String ccno, String cvv) {
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		address.sendKeys(addr);
		creditcardno.sendKeys(ccno);
		cvvno.sendKeys(cvv);

	}

	public void select_creditCardDetails() {
		Select creditcardtype = new Select(creditCardType);
		creditcardtype.selectByValue("VISA");
		Select expirymon = new Select(expiryMonth);
		expirymon.selectByIndex(1);
		Select expiryyear = new Select(expiryYear);
		expiryyear.selectByValue("2027");
	}

	public BookingConfirmationPage submit() {
		bookNowBtn.click();
		return new BookingConfirmationPage();
	}

}
