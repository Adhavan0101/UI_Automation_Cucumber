package com.step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;

import com.utilities.Common_Utilities;

import constant.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import page_objects.New_Account_Page;

public class New_Account_Step_Defi {

	private static final Logger LOGGER = (Logger) LogManager.getLogger(New_Account_Step_Defi.class);

	@Given("user enter the customer id")
	public void user_enter_the_customer_id() {

		try {

			New_Account_Page.getNewAccountIsstance().clickNewAccount();
			New_Account_Page.getNewAccountIsstance().enterCustomerID(Constants.CUSTOMER_ID);

			LOGGER.info("The user enters the customer ID");
		} catch (Exception e) {

			LOGGER.error(e);
			
			Assert.fail(e.getMessage());
		}
	}

	@Given("User select the account type {string} from the dropdown {string}")
	public void user_select_the_account_type_from_the_dropdown(String accountType, String howTo) {

		try {

			Common_Utilities.getInstance()
					.selectFromDropDown(New_Account_Page.getNewAccountIsstance().getACCOUNT_TYPE(), howTo, accountType);
			LOGGER.info("The user select the account type");

		} catch (Exception e) {
			LOGGER.error(e);
			
			Assert.fail(e.getMessage());
		}
	}

	@Given("User enter the deposit amount")
	public void user_enter_the_deposit_amount() {

		try {

			New_Account_Page.getNewAccountIsstance().enterInitialDeposit(Constants.INITIAL_DEPOSIT);
			LOGGER.info("The user enter initial deposit amount");

		} catch (Exception e) {
			LOGGER.error(e);
			
			Assert.fail(e.getMessage());
		}
	}

	@Then("Uesr click the submit button")
	public void uesr_click_the_submit_button() {

		try {

			New_Account_Page.getNewAccountIsstance().clickSubmit();
			LOGGER.info("The user click the submit button");

		} catch (Exception e) {
			LOGGER.error(e);
			
			Assert.fail(e.getMessage());
		}
	}
}
