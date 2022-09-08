package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	// 1. constructor for page class Login
	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	// 2. By locators
	private By email = By.id("email");
	private By password = By.id("passwd");
	private By signin = By.xpath("//span[normalize-space()='Sign in']");
	private By forgotpwd = By.linkText("Forgot your password?");
	private By SignInbutton = By.xpath("//a[@class='login' or text()='Sign in']");

	// 3. Page Actions

	public String getPageTitle() {
		return driver.getTitle();
	}

	public boolean isforgotpwdLinkExist() {
		boolean status_of_forgotpwdlink = driver.findElement(forgotpwd).isDisplayed();
		return status_of_forgotpwdlink;
	}

	public void enterUserName(String username) throws InterruptedException {
		Thread.sleep(10000);

		driver.findElement(SignInbutton).click();
		driver.findElement(email).sendKeys(username);

	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clicklogin_button() {
		driver.findElement(signin).click();
	}

	public AccountPage loginforaccountspage(String username, String pwd) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(SignInbutton).click();
		Thread.sleep(2000);
		driver.findElement(email).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signin).click();
		Thread.sleep(4000);
		return new AccountPage(driver);

	}

}
