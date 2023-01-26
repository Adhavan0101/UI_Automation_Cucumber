package page_objects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver_manager.Driver_Manager;
import com.step_definitions.New_Account_Step_Defi;
import com.utilities.Common_Utilities;

public class New_Account_Page {

	private static final Logger LOGGER = (Logger) LogManager.getLogger(New_Account_Page.class);
	
	private static New_Account_Page newAccountInstance;
		
	WebDriver driver = Driver_Manager.getDriver();

	private New_Account_Page() {

	}

	public static New_Account_Page getNewAccountIsstance() {

		if (newAccountInstance == null) {
			newAccountInstance = new New_Account_Page();
		}

		return newAccountInstance;
	}

	// Using Page Factory

	/*
	 * @FindBy(linkText = "New Account") public WebElement NEW_ACCOUNT;
	 * 
	 * @FindBy(name = "cusid") private WebElement CUSTOMER_ID;
	 * 
	 * @FindBy(name = "selaccount") private WebElement ACCOUNT_TYPE;
	 * 
	 * @FindBy(name = "inideposit") private WebElement INITIAL_DEPOSIT;
	 * 
	 * @FindBy(name = "button2") private WebElement SUBMIT;
	 */
	@FindBy(name = "selaccount")
	private WebElement ACCOUNT_TYPE;
	
	// Using Locators

	By NEW_ACCOUNT = By.linkText("New Account");
	By CUSTOMER_ID = By.name("cusid");
	// By ACCOUNT_TYPE = By.name("selaccount");
	By INITIAL_DEPOSIT = By.name("inideposit");
	By SUBMIT = By.name("button2");

	public WebElement getACCOUNT_TYPE() {
		return ACCOUNT_TYPE;
	}

	public void clickNewAccount() {

		try {

			Common_Utilities.getInstance().highlightWebelement(driver.findElement(NEW_ACCOUNT));
			driver.findElement(NEW_ACCOUNT).click();

		} catch (Exception e) {
			LOGGER.info("Element not found, Wait for explicit wait");

			try {

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
				wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_ACCOUNT));

			} catch (Exception e2) {
				LOGGER.info("Element not found, Please check your locator");
			}
		}
	}

	public void enterCustomerID(String customerID) {

		try {

			Common_Utilities.getInstance().highlightWebelement(driver.findElement(CUSTOMER_ID));
			driver.findElement(CUSTOMER_ID).sendKeys(customerID);

		} catch (Exception e) {
			LOGGER.info("Element not found, Wait for explicit wait");

			try {

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
				wait.until(ExpectedConditions.visibilityOfElementLocated(CUSTOMER_ID));

			} catch (Exception e2) {
				LOGGER.info("Element not found, Please check your locator");
			}
		}
	}

	/*
	 * public void selectAccountType() {
	 * Common_Utilities.getInstance().highlightWebelement(ACCOUNT_TYPE);
	 * 
	 * }
	 */

	public void enterInitialDeposit(String initialDeposit) {

		try {

			Common_Utilities.getInstance().highlightWebelement(driver.findElement(INITIAL_DEPOSIT));
			driver.findElement(INITIAL_DEPOSIT).sendKeys(initialDeposit);

		} catch (Exception e) {
			LOGGER.info("Element not found, Wait for explicit wait");

			try {

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
				wait.until(ExpectedConditions.visibilityOfElementLocated(INITIAL_DEPOSIT));

			} catch (Exception e2) {
				LOGGER.info("Element not found, Please check your locator");
			}
		}
	}

	public void clickSubmit() {
		try {

			Common_Utilities.getInstance().highlightWebelement(driver.findElement(SUBMIT));
			driver.findElement(SUBMIT).submit();

		} catch (Exception e) {
			LOGGER.info("Element not found, Wait for explicit wait");

			try {

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
				wait.until(ExpectedConditions.visibilityOfElementLocated(SUBMIT));

			} catch (Exception e2) {
				LOGGER.info("Element not found, Please check your locator");
			}
		}
	}
}
