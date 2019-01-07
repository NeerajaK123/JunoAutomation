package main;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * The Class LoginPage.
 */
public class LoginPage {

	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new login page.
	 *
	 * @param driver
	 *            the driver
	 */
	Logger logger = Logger.getLogger("LoginPage");
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		PropertyConfigurator.configure("log4j.properties");
	}
	/*
	 * UI Maps on Login Page.
	 */
	/** The user name. */
	@FindBy(id = "username")
	public WebElement userName;

	/** The password. */
	@FindBy(id = "password")
	public WebElement passWord;

	/** The login button. */
	@FindBy(id = "Login")
	public WebElement loginButton;

	@FindBy(xpath = "//span[@title='JuPTR+']")
	public WebElement juPTR;

	@FindBy(xpath = "//div[@class='slds-icon-waffle']")
	public WebElement appLauncher;

	@FindBy(xpath = "//div[@title='Search']/div[1]/label/following-sibling::input")
	public WebElement search_AppLauncher;

	@FindBy(xpath = "//div[@class='slds-spinner_container slds-grid slds-hide']")
	public WebElement Loader;

	//div[@class='slds-spinner_container slds-grid slds-hide']
	/*
	 * This method will log into MedConnect.
	 */

	/**
	 * Login.
	 *
	 * @param uName
	 *            the user name
	 * @param passwd
	 *            the password
	 * @throws InterruptedException
	 *             the interrupted exceptions
	 */
	public void login(String uName, String passwd) throws InterruptedException {
		try {				
			BaseTest.waitforElement(userName, Config.timeouts.SHORTWAIT.get()).sendKeys(uName);
			BaseTest.waitforElement(passWord, Config.timeouts.SHORTWAIT.get()).sendKeys(passwd);
			BaseTest.waitforElement(loginButton, Config.timeouts.SHORTWAIT.get()).click();				
			logger.info("Login is Successfull");
								
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			Assert.fail();			
		} catch (NoSuchElementException e1) {
			System.out.println(e1.getMessage());
			logger.info("The exception is : " + e1.getMessage());
			Assert.fail();
		} catch (Exception e) {
			System.out.println(e);
			logger.info("The exception is : " + e.getMessage());
		}
	}
/*
 * Method is to launch Med Connect
 */
	public void electra_launch(String Electra) throws InterruptedException {
		try {
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(appLauncher, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(search_AppLauncher, Config.timeouts.MEDIUMWAIT.get()).click();
			BaseTest.waitforElement(search_AppLauncher, Config.timeouts.MEDIUMWAIT.get()).sendKeys(Electra);	
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(driver.findElement(By.xpath("//mark[contains(text(),'" + Electra + "')]")), Config.timeouts.LONGWAIT.get()).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
	public void appSelection_Applauncher(String app) throws InterruptedException {
		try {
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(appLauncher, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(search_AppLauncher, Config.timeouts.MEDIUMWAIT.get()).click();
			BaseTest.waitforElement(search_AppLauncher, Config.timeouts.MEDIUMWAIT.get()).sendKeys(app);	
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(driver.findElement(By.xpath("//mark[contains(text(),'" + app + "')]")), Config.timeouts.LONGWAIT.get()).click();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
}
