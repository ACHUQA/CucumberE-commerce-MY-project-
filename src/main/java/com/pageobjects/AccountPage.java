package com.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

	private WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	// By locators
	By headingforaccount = By.xpath("//h1[@class='page-heading' or text()='My account']");
	By acctlist = By.xpath("//ul[@class='myaccount-link-list']/li");

	public List<String> getaccountsSection() throws InterruptedException {
		Thread.sleep(1000);

		List<String> actuallist = new ArrayList<>();

		List<WebElement> accountlist = driver.findElements(acctlist);

		for (WebElement a : accountlist) {
			String text = a.getText();
			System.out.println(text);

			actuallist.add(text);

		}
		return actuallist;

	}

	public int acctsectionsize() {
		int actualcount = driver.findElements(acctlist).size();
		return actualcount;
	}

}
