package com.step_definitions;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.driver_manager.Driver_Manager;
import com.utilities.Common_Utilities;

import constant.Constants;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import page_objects.Login_Page;

public class Common_Step_Defi {

	private static final Logger LOGGER = LogManager.getLogger(Common_Step_Defi.class);

	private static String scenerioName = null;

	public static String getScenerioName() {
		return scenerioName;
	}

	@Before
	public void beforeScenerio(Scenario scenario) {

		LOGGER.info("Execution started");

		try {
			scenerioName = scenario.getName();
			LOGGER.info("Common utilities initializing");

			LOGGER.info("Propety file intializing");
			Common_Utilities.getInstance().loadPropertyFile();

			LOGGER.info("Driver available or not ");
			if (Driver_Manager.getDriver() == null) {
				Driver_Manager.launchBrowser();
				Common_Utilities.getInstance().intiWebElements();
				login();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void login() {

		try {
			Driver_Manager.getDriver().manage().window().maximize();
			Driver_Manager.getDriver().get(Constants.WEB_URL);

			LOGGER.info("The user is on login pages");

			Login_Page.getInstance().enterEmail(Constants.USER_NAME);
			Login_Page.getInstance().enterPassword(Constants.PASSWORD);

			LOGGER.info("The user enters valid username & Password");

			Login_Page.getInstance().clickSignin();

			LOGGER.info("The user Clicks on the login buttons");

		} catch (Exception e) {
			LOGGER.error(e);

		}
	}

	@AfterStep
	public void attachScreenshot(Scenario scenario) {

		try {
			if (scenario.isFailed()) {

				byte[] screenshotTaken = ((TakesScreenshot) Driver_Manager.getDriver())
						.getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshotTaken, "image/png", "error screen");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
