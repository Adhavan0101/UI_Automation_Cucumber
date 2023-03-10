package com.driver_manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import constant.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver_Manager {

	private static WebDriver driver = null;
	private static final Logger LOGGER = LogManager.getLogger(Driver_Manager.class);

	public static void launchBrowser() {

		try {
			switch (Constants.BROWSER) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				LOGGER.info("Launching" + Constants.BROWSER);
				driver = new ChromeDriver();
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				LOGGER.info("Launching" + Constants.BROWSER);
				driver = new FirefoxDriver();
				break;

			case "edge":
				WebDriverManager.edgedriver().setup();
				LOGGER.info("Launching" + Constants.BROWSER);
				driver = new EdgeDriver();
				break;

			default:
				WebDriverManager.chromedriver().setup();
				LOGGER.info("Launching" + Constants.BROWSER);
				driver = new ChromeDriver();
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static WebDriver getDriver() {
		return driver;
	}
}
