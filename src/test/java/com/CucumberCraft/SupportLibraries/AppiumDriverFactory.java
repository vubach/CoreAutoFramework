package com.CucumberCraft.SupportLibraries;

import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.log4j.Logger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class AppiumDriverFactory {

	private static Properties mobileProperties;
	static Logger log = Logger.getLogger(AppiumDriverFactory.class);

	private AppiumDriverFactory() {
	}

	@SuppressWarnings("rawtypes")
	public static AppiumDriver getAppiumDriver(MobileExecutionPlatform executionPlatform, String deviceName,
			String version, Boolean installApp) throws Exception {

		AppiumDriver driver = null;
		mobileProperties = Settings.getInstance();
		String appiumServerPort = mobileProperties.getProperty("appium.server.port");

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		switch (executionPlatform) {
		case ANDROID:
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("deviceName", deviceName);
			desiredCapabilities.setCapability("udid", deviceName);
			desiredCapabilities.setCapability("platformVersion", version);
			desiredCapabilities.setCapability("appPackage",
					mobileProperties.getProperty("android.application.package.name"));
			desiredCapabilities.setCapability("appActivity",
					mobileProperties.getProperty("android.application.mainactivity.name"));
			desiredCapabilities.setCapability("noReset", "true");
			desiredCapabilities.setCapability("noSign", "true");
			desiredCapabilities.setCapability("autoGrantPermissions", "true");
			desiredCapabilities.setCapability("automationName",
					mobileProperties.getProperty("android.automation.name"));
			desiredCapabilities.setCapability("autoDismissAlerts", true);

			driver = new AndroidDriver(new URL("http://0.0.0.0:" + appiumServerPort + "/wd/hub"), desiredCapabilities);
			break;

		case IOS:
			desiredCapabilities.setCapability("platformName", "ios");
			desiredCapabilities.setCapability("platformVersion", version);
			desiredCapabilities.setCapability("deviceName", deviceName);
			desiredCapabilities.setCapability("udid", deviceName);
			desiredCapabilities.setCapability("bundleId", mobileProperties.getProperty("iPhoneBundleID"));
			desiredCapabilities.setCapability("newCommandTimeout", 120);

			driver = new IOSDriver(new URL("http://0.0.0.0:" + appiumServerPort + "/wd/hub"), desiredCapabilities);
			break;

		case WEB_ANDROID:
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("deviceName", deviceName);
			// desiredCapabilities.setCapability("udid",deviceName);
			desiredCapabilities.setCapability("platformVersion", version);
			desiredCapabilities.setCapability("browserName", "chrome");

			driver = new AndroidDriver(new URL("http://0.0.0.0:" + appiumServerPort + "/wd/hub"), desiredCapabilities);
			break;

		case WEB_IOS:
			desiredCapabilities.setCapability("platformName", "ios");
			desiredCapabilities.setCapability("platformVersion", version);
			desiredCapabilities.setCapability("deviceName", deviceName);
			// desiredCapabilities.setCapability("udid",deviceName);
			desiredCapabilities.setCapability("automationName", "Appium");
			desiredCapabilities.setCapability("browserName", "Safari");

			driver = new IOSDriver(new URL("http://0.0.0.0:" + appiumServerPort + "/wd/hub"), desiredCapabilities);
			break;

		default:
			log.warn("No such Execution Platform implementation available");
		}
		
		log.info("AppiumDriver was created successfully");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
