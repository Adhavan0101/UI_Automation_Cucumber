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
import com.utilities.Common_Utilities;

public class Login_Page {
	
	private static final Logger LOGGER = (Logger) LogManager.getLogger(Login_Page.class);

	private static Login_Page loginInstance;

	WebDriver driver = Driver_Manager.getDriver();

	private Login_Page() {

	}

	public static Login_Page getInstance() {

		if (loginInstance == null) {
			loginInstance = new Login_Page();
		}
		return loginInstance;

	}

	// Using Page Factory

	/*
	 * @FindBy(name = "uid") private WebElement EMAIL;
	 * 
	 * @FindBy(name = "password") private WebElement PASSWORD;
	 * 
	 * @FindBy(name = "btnLogin") private WebElement SIGNIN;
	 */

	// Using Locators

	By EMAIL = By.name("uid");
	By PASSWORD = By.name("password");
	By SIGNIN = By.name("btnLogin");

	/*
	 * public WebElement getEMAIL() { return EMAIL; }
	 * 
	 * public WebElement getPASSWORD() { return PASSWORD; }
	 * 
	 * public WebElement getSIGNIN() { return SIGNIN; }
	 */

	public void enterEmail(String userName) {

		try {
			Common_Utilities.getInstance().highlightWebelement(driver.findElement(EMAIL));
			driver.findElement(EMAIL).sendKeys(userName);

		} catch (Exception e) {

			LOGGER.info("Element not found, Wait for explicit wait");

			try {

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
				wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL));

			} catch (Exception e2) {

				LOGGER.info("Element not found, Please check the locators");
			}
		}
	}

	public void enterPassword(String password) {

		try {

			Common_Utilities.getInstance().highlightWebelement(driver.findElement(PASSWORD));
			driver.findElement(PASSWORD).sendKeys(password);

		} catch (Exception e) {
			LOGGER.info("Element not found, Wait for explicit wait");

			try {

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
				wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD));

			} catch (Exception e2) {
				LOGGER.info("Element not found, Please check the locators");
			}

		}

	}

	public void clickSignin() {

		try {

			Common_Utilities.getInstance().highlightWebelement(driver.findElement(SIGNIN));
			driver.findElement(SIGNIN).submit();

		} catch (Exception e) {
			LOGGER.info("Element not found, Wait for explicit wait");

			try {

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
				wait.until(ExpectedConditions.visibilityOfElementLocated(SIGNIN));

			} catch (Exception e2) {
				LOGGER.info("Element not found, Please check the locators");
			}
		}

	}
}
