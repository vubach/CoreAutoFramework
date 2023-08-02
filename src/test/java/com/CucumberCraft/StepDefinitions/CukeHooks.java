package com.CucumberCraft.StepDefinitions;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.log4j.Logger;

import com.CucumberCraft.SupportLibraries.Settings;
import com.CucumberCraft.SupportLibraries.TestController;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CukeHooks extends MasterStepDefs {

	static Logger log = Logger.getLogger(CukeHooks.class);
	static Properties properties = Settings.getInstance();
	static String ExecutionMode = TestController.getTestParameters().getExecutionMode().toString();

	@Before
	public void setUp(Scenario scenario) {
		try {
			currentScenario = scenario;
			propertiesFileAccess = properties;
			currentTestParameters = TestController.getTestParameters();
			currentTestParameters.setScenarioName(scenario.getName());
			TestController.getHelper().getScenarioContext().setContext("SCENARIO_NAME", scenario.getName());
			TestController.getHelper().getScenarioContext().setContext("CURRENT_SCENARIO", scenario);
		} catch (Throwable e) {
			log.error("Error at Before Scenario " + e.getMessage());
			TestController.getHelper().writeStepFAIL();
		}
	}

	@After
	public void embedScreenshot(Scenario scenario) throws Throwable {
		switch (ExecutionMode) {
		case "WEB":
			currentScenario.write("-> Browser: " + TestController.getTestParameters().getBrowser());
			break;

		case "MOBILE":
		case "SEETEST":
			currentScenario.write(
					"-> MobileExecutionPlatform: " + TestController.getTestParameters().getMobileExecutionPlatform());
			currentScenario.write("-> DeviceName: " + TestController.getTestParameters().getDeviceName());
			currentScenario.write("-> OsVersion: " + TestController.getTestParameters().getMobileOSVersion());
			break;
		}
		try {
			currentScenario.write("-> TestData: " + "\n" + TestController.getHelper().printCurrentTestData());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			currentScenario.write("-> TestData: N/A");
		}
		update(scenario);
	}

	private void update(Scenario scenario) throws Throwable {
		if (scenario.isFailed()) {
			byte[] screenshot = null;

			switch (ExecutionMode) {
			case "WEB":
				screenshot = ((TakesScreenshot) TestController.getWebDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
				break;

			case "MOBILE":
			case "SEETEST":
				screenshot = ((TakesScreenshot) TestController.getAppiumDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
				break;
			}
		}
	}
}