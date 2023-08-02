package com.CucumberCraft.StepDefinitions;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.CucumberCraft.SupportLibraries.DriverUtils;
import com.CucumberCraft.SupportLibraries.Helper;
import com.CucumberCraft.SupportLibraries.ScenarioContext;
import com.CucumberCraft.SupportLibraries.TestController;
import com.CucumberCraft.SupportLibraries.Util;
import com.CucumberCraft.SupportLibraries.WebDriverUtils;

import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonSteps extends MasterStepDefs {

	private WebDriver driver = TestController.getWebDriver();
	private DriverUtils driverUtils = new WebDriverUtils(driver);
	private Helper helper = TestController.getHelper();

	@And("^user launches application under test$")
	public void userLaunchesApplicationUnderTest() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driverUtils.launchAUT();
	}

	@And("^\"([^\"]*)\" shows up$")
	public void pageShowUp(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driverUtils.assertPageShowUp(arg1);
	}

	@And("^user clicks on \"([^\"]*)\"$")
	public void userClicksOnElement(String arg1) throws Throwable {
		try {
			// Write code here that turns the phrase above into concrete actions
			Thread.sleep(3000);
			driverUtils.clickOnElement(arg1);
		}
		catch(Exception e) {
			Thread.sleep(5000);
			driverUtils.clickOnElement(arg1);
		  //  Block of code to handle errors
		}

	}

	@And("^user submits form \"([^\"]*)\"$")
	public void userSubmitsForm(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driverUtils.submitForm(arg1);
	}

	@And("^user types \"([^\"]*)\" into \"([^\"]*)\"$")
	public void userTypesTextIntoElement(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		arg1 = helper.loadTestDataIntoParam(arg1);
		driverUtils.typeTextIntoElement(arg1, arg2);
	}

	@And("^\"([^\"]*)\" is present$")
	public void elementIsPresent(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driverUtils.assertElementIsPresent(arg1);
	}

	@And("^\"([^\"]*)\" is not present$")
	public void elementIsNotPresent(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driverUtils.assertElementIsNotPresent(arg1);
	}

	@And("^\"([^\"]*)\" shows up in (\\d+) seconds$")
	public void pageShowsUpInSeconds(String arg1, int arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driverUtils.assertPageShowUpInGivenTimeSeconds(arg1, arg2);
	}

	@And("^\"([^\"]*)\" is present in (\\d+) seconds$")
	public void elementIsPresentInSeconds(String arg1, int arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driverUtils.assertElementIsPresentInGivenTimeSeconds(arg1, arg2);
	}

	@And("^\"([^\"]*)\" is not present in (\\d+) seconds$")
	public void elementIsNotPresentInSeconds(String arg1, int arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driverUtils.assertElementIsNotPresentInGivenTimeSeconds(arg1, arg2);
	}

	@And("^\"([^\"]*)\" shows text \"([^\"]*)\"$")
	public void elementShowsText(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		arg2 = helper.loadTestDataIntoParam(arg2);
		driverUtils.assertElementShowText(arg1, arg2);
	}

	@And("^\"([^\"]*)\" contains text \"([^\"]*)\"$")
	public void elementContainsText(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		arg2 = helper.loadTestDataIntoParam(arg2);
		driverUtils.assertElementContainText(arg1, arg2);
	}

	@And("^\"([^\"]*)\" has attribute \"([^\"]*)\" with value \"([^\"]*)\"$")
	public void elementAttributeWithValue(String arg1, String arg2, String arg3) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		arg3 = helper.loadTestDataIntoParam(arg3);
		driverUtils.assertElementAttributeHasValue(arg1, arg2, arg3);
	}

	@And("^\"([^\"]*)\" has attribute \"([^\"]*)\" contain value \"([^\"]*)\"$")
	public void elementAttributeContainValue(String arg1, String arg2, String arg3) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		arg3 = helper.loadTestDataIntoParam(arg3);
		driverUtils.assertElementAttributeContainValue(arg1, arg2, arg3);
	}

	@And("^user waits for (\\d+) seconds$")
	public void userWaitForNSeconds(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		helper.delaySynchronization(arg1);
	}

	@And("^user refreshes current page$")
	public void userRefreshesCurrentPage() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driverUtils.refresh();
	}

	@And("^user navigates to \"([^\"]*)\"$")
	public void userNavigatesToUrl(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driverUtils.goToUrl(arg1);
	}

	@And("^user navigates back$")
	public void userNavigatesBack() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driverUtils.navigateBack();
	}

	@And("^user navigates forward$")
	public void userNavigateForward() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driverUtils.navigateForward();
	}

	@And("^user switches to default$")
	public void userSwitchToDefault() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driverUtils.switchToDefault();
		;
	}

	@And("^user switches to \"([^\"]*)\"$")
	public void userSwitchToIframe(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driverUtils.switchToIframe(arg1);
		;
	}

	@And("^user scrolls down (\\d+) pixel$")
	public void userScrollsDownPixel(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driverUtils.scrollDown(arg1);
	}

	@And("^user scrolls down (\\d+) pixel (\\d+) times$")
	public void userScrollsDownPixelTimes(int arg1, int arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driverUtils.scrollDownNTimes(arg1, arg2);
	}

	@And("^user scrolls to \"([^\"]*)\"$")
	public void userScrollsToElement(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driverUtils.scrollToElement(arg1);
	}

	@And("^user presses ENTER key$")
	public void userPressesENTERKey() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driverUtils.pressEnterKey();
	}

	@And("^user clicks on \"([^\"]*)\" by JS$")
	public void userClicksOnElementByJS(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driverUtils.clickOnElementByJS(arg1);
	}

	@And("^user clicks on menu following orders \"([^\"]*)\"$")
	public void user_clicks_on_menu_following_orders_will_be_removed(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String[] arr = arg1.split(">");
		String locator = null;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				locator = "//section[@class='bn-header__extra']//child::a[normalize-space(text())='" + arr[i].trim()
						+ "']";
			} else {
				locator = "//section[@class='layout-grid__hero tpl-banner__hero']//child::a[normalize-space(text())='"
						+ arr[i].trim() + "']";
			}
			driver.findElement(By.xpath(locator)).click();
			helper.delaySynchronization(5);
		}
	}

	@And("^user login with valid username and password$")
	public void userLoginWithValidUsernameAndPassword() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String userName = helper.getConfig("web.username");
		String password = helper.getConfig("web.password");

		driverUtils.typeTextIntoElement(userName, "LOGIN_PAGE_USERNAME_INPUT");
		driverUtils.typeTextIntoElement(password, "LOGIN_PAGE_PASSWORD_INPUT");
		driverUtils.getElement("LOGIN_PAGE_LOGIN_FORM").submit();
	}

	@When("^user select \"([^\"]*)\" as \"([^\"]*)\"$")
	public void user_select_as(String dropdown, String item) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement elem = driverUtils.getElement(dropdown);
		Select fruits = new Select(elem);
		fruits.selectByVisibleText(item.trim());
	}

	@Then("^user export weather data into test report$")
	public void user_export_weather_data_into_test_report() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String fileSeparator = Util.getFileSeparator();
		StringBuilder builder = new StringBuilder();
		FileUtils.cleanDirectory(new File(System.getProperty("user.dir") + fileSeparator + "src" + fileSeparator
				+ "test" + fileSeparator + "resources" + fileSeparator + "output"));
		String output = System.getProperty("user.dir") + fileSeparator + "src" + fileSeparator + "test" + fileSeparator
				+ "resources" + fileSeparator + "output" + fileSeparator + "WeatherData.txt";
		File myObj = new File(output);
		myObj.createNewFile();

		Scenario currentScenario1 = ((Scenario) helper.getScenarioContext().getContext("CURRENT_SCENARIO"));
		helper.delaySynchronization(5);

		String title = driverUtils.getElement("PAST_WEATHER_PAGE_SUB_TITLE_LABEL").getText().trim();
		currentScenario1.write("----------" + title + "----------");
		builder.append("----------" + title + "----------");
		builder.append(System.getProperty("line.separator"));

		String locator = "(//div[@class='weatherLinks'])[1]//child::a";
		String dateTime = "//div[@class='weatherTooltip']//child::div[@class='date']";
		String tempDesc = "//div[@class='tempblock']";
		String midDesc = "//div[@class='mid__block']";
		String windDesc = "//div[@class='right__block']";
		String value = "";

		List<WebElement> weatherLinks = driver.findElements(By.xpath(locator));
		// for (WebElement link : weatherLinks) {
		try {
		for (int i = weatherLinks.size() - 1; i >= 0; i--) {
			weatherLinks.get(i).click();
			helper.delaySynchronization(1);

			value = driver.findElement(By.xpath(dateTime)).getText().trim();
			currentScenario1.write("dateTime = " + value);
			builder.append("dateTime = " + value);
			builder.append(System.getProperty("line.separator"));
			value = driver.findElement(By.xpath(tempDesc + "//child::div[1]")).getText().trim();
			currentScenario1.write("tempDesc(1) = " + value);
			builder.append("tempDesc(1) = " + value);
			builder.append(System.getProperty("line.separator"));
			value = driver.findElement(By.xpath(tempDesc + "//child::div[2]")).getText().trim();
			currentScenario1.write("tempDesc(2) = " + value);
			builder.append("tempDesc(2) = " + value);
			builder.append(System.getProperty("line.separator"));
			value = driver.findElement(By.xpath(midDesc + "//child::div[1]")).getText().trim();
			currentScenario1.write("humidity = " + value.replace("Humidity:", "").trim());
			builder.append("humidity = " + value.replace("Humidity:", "").trim());
			builder.append(System.getProperty("line.separator"));
			value = driver.findElement(By.xpath(midDesc + "//child::div[2]")).getText().trim();
			currentScenario1.write("barometer = " + value.replace("Barometer:", "").trim());
			builder.append("barometer = " + value.replace("Barometer:", "").trim());
			builder.append(System.getProperty("line.separator"));
			value = driver.findElement(By.xpath(windDesc + "//child::div[1]")).getText().trim();
			currentScenario1.write("windDesc(1) = " + value);
			builder.append("windDesc(1) = " + value);
			builder.append(System.getProperty("line.separator"));
			value = driver.findElement(By.xpath(windDesc + "//child::div[2]")).getText().trim();
			currentScenario1.write("windDesc(2) = " + value.replace("Wind:", "").trim());
			builder.append("windDesc(2) = " + value.replace("Wind:", "").trim());
			builder.append(System.getProperty("line.separator"));
			currentScenario1.write("------------------------------------");
			builder.append("------------------------------------");
			builder.append(System.getProperty("line.separator"));
			helper.delaySynchronization(2);
		}
			helper.writeToTextFile(output, builder.toString());
		}
		catch(Exception e) {
		  //  Block of code to handle errors
		}
	}
}
