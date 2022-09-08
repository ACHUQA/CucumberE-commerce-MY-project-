package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.pageobjects.AccountPage;
import com.pageobjects.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private AccountPage acctpage;

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable logintable) throws InterruptedException {

		List<Map<String, String>> asMaps = logintable.asMaps();
		String uname = asMaps.get(0).get("username");
		String password = asMaps.get(0).get("password");
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?");

		acctpage = loginpage.loginforaccountspage(uname, password);

	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() throws InterruptedException {
		Thread.sleep(2000);

		String accountpagetitle = loginpage.getPageTitle();
		System.out.println("Account page Titile is : " + accountpagetitle);

	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable acctsectable) throws InterruptedException {

		List<String> actuallist = acctpage.getaccountsSection();
		System.out.println("Actual list is :" + actuallist);
		List<String> expectedList = acctsectable.column(0);
		System.out.println("Expected list:" + expectedList);
		Assert.assertTrue(expectedList.containsAll(actuallist));

	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedcount) {

		int actualcount = acctpage.acctsectionsize();
		Assert.assertTrue(expectedcount == actualcount);

	}

}
