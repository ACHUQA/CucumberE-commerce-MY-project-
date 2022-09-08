package stepdefinitions;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.pageobjects.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	private static String title;
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private SoftAssert softassertion = new SoftAssert();

	@Given("user is on login page")
	public void user_is_on_login_page() {

		DriverFactory.getDriver().get("http://automationpractice.com/index.php?");

	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {

		title = loginpage.getPageTitle();
		System.out.println("Page title is :" + title);

	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		Assert.assertTrue(title.contentEquals(expectedTitle));
		System.out.println("Expected Title is verified:" + expectedTitle);

	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {

		boolean status = loginpage.isforgotpwdLinkExist();
		softassertion.assertTrue(status);

	}

	@When("user enters username {string}")
	public void user_enters_username(String username) throws InterruptedException {

		loginpage.enterUserName(username);

	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {
		loginpage.enterPassword(pwd);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginpage.clicklogin_button();

	}

}
