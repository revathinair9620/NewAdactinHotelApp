package com.adactinhotel.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactinhotel.qa.base.TestBase;

public class SelectHotelPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"radiobutton_0\"]")
	WebElement selectHotelBtn;

	@FindBy(xpath = "//*[@id=\"continue\"]")
	WebElement continueBtn;

	// Initializing the Page Objects:
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateSelectHotelPageTitle() {
		return driver.getTitle();
	}

	public void selectHotel() {
		selectHotelBtn.click();
	}

	public BookAHotelPage submit() {
		continueBtn.click();
		return new BookAHotelPage();
	}

}
