package com.step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.driver_manager.Driver_Manager;
import com.utilities.Common_Utilities;

import constant.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.Login_Page;

public class Login_Guru99_Step_Defi {

	private static final Logger LOGGER = (Logger) LogManager.getLogger(Login_Guru99_Step_Defi.class);

	@Given("The user is on login pages")
	public void the_user_is_on_login_pages() {

		
	}

	@When("The user enters valid username & Password")
	public void the_user_enters_valid_username_password() {

		
	}

	@When("The user Clicks on the login buttons")
	public void the_user_clicks_on_the_login_buttons() {

	}

	@When("The user should be navigated to home pages")
	public void the_user_should_be_navigated_to_home_pages() {

		try {
			String actualURL = Driver_Manager.getDriver().getCurrentUrl();
			if (actualURL.contains("Managerhomepage")) {
			}

			LOGGER.info("The user should be navigated to home pages");

		} catch (Exception e) {
			LOGGER.error(e);
			
		}
	}

	@Then("The webpages should be closed")
	public void the_webpages_should_be_closed() {

		try {
			//Driver_Manager.getDriver().quit();

			//LOGGER.info("The webpages should be closed");

		} catch (Exception e) {
			LOGGER.error(e);
			
		}
	}

}
