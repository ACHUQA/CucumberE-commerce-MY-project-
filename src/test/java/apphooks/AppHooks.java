package apphooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {

	private WebDriver driver;
	private ConfigReader configreader;
	private DriverFactory driverfactory;
	private Properties prop;

	@Before(order = 0)
	public void getProperty() {
		configreader = new ConfigReader();
		prop = configreader.init_prop();
	}

	@Before(order = 1)
	public void launchbrowser() {

		String browserName = prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver = driverfactory.init_driver(browserName);

	}

	@After(order = 0)
	public void quit_browsers() {
		driver.quit();
	}

	@After(order = 1)
	public void tear_down(Scenario scenario) {

		// Take screenshot....
		if (scenario.isFailed()) {
			String ScreenshotName = scenario.getName().replaceAll(" ", "_");
			TakesScreenshot tks = (TakesScreenshot) driver;
			// BYTES (it will be used if we are executing in CI(continuous integration tool)
			// We cannot give it as FIle for output type with jenkins ..so keep it as bytes
			byte[] sourcepath = tks.getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", ScreenshotName);

		}

	}
}
