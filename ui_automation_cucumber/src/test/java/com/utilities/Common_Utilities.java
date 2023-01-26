package com.utilities;

import java.io.File;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.driver_manager.Driver_Manager;
import com.step_definitions.Common_Step_Defi;

import constant.Constants;
import page_objects.Login_Page;

public class Common_Utilities {
	
	private static final Logger LOGGER = (Logger) LogManager.getLogger(Common_Utilities.class);
	private static Common_Utilities commonUtilitiesinstance = null;

	public Common_Utilities() {

	}

	public static Common_Utilities getInstance() {

		if (commonUtilitiesinstance == null) {
			commonUtilitiesinstance = new Common_Utilities();
		}

		return commonUtilitiesinstance;
	}

	public void intiWebElements() {

		try {
			PageFactory.initElements(Driver_Manager.getDriver(), Login_Page.getInstance());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadPropertyFile() {

		try {

			Properties properties = new Properties();
			properties.load(getClass().getResourceAsStream("/config.properties"));

			Constants.WEB_URL = properties.getProperty("WEB_URL");
			Constants.BROWSER = properties.getProperty("BROWSER");
			Constants.USER_NAME = properties.getProperty("USER_NAME");
			Constants.PASSWORD = properties.getProperty("PASSWORD");

			Constants.CHROME_DRIVER_LOCATION = properties.getProperty("CHROME_DRIVER_LOCATION");
			Constants.FIREFOX_DRIVER_LOCATION = properties.getProperty("FIREFOX_DRIVER_LOCATION");
			Constants.EDGE_DRIVER_LOCATION = properties.getProperty("EDGE_DRIVER_LOCATION");

			Constants.CUSTOMER_ID = properties.getProperty("CUSTOMER_ID");
			Constants.INITIAL_DEPOSIT = properties.getProperty("INITIAL_DEPOSIT");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * public void takeScreenShot() {
	 * 
	 * try {
	 * 
	 * TakesScreenshot screenshot = (TakesScreenshot) Driver_Manager.getDriver();
	 * File sourceFile = screenshot.getScreenshotAs(OutputType.FILE); File
	 * fileLocation = new File(Common_Step_Defi.getScenerioName() + ".png");
	 * FileHandler.copy(sourceFile, fileLocation);
	 * 
	 * } catch (Exception e) { System.out.println(e.getMessage()); } }
	 */

	public void highlightWebelement(WebElement element) {

		try {

			JavascriptExecutor executor = (JavascriptExecutor) Driver_Manager.getDriver();
			executor.executeScript("arguments[0].setAttribute('style', 'border:3px solid blue');", element);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectFromDropDown(WebElement dropdown, String howTo, String value) {

		Select select = new Select(dropdown);

		switch (howTo) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
			
		case "text":
			select.selectByVisibleText(value);
			break;
			
		case "value":
			select.selectByValue(value);
			break;
			
		default:
			LOGGER.info(" Please select a valid selection - index, text, value");
			break;
		}
	}
}
