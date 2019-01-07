package main;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The Class LogoutPage.
 */
public class LogoutPage {

	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new logout page.
	 *
	 * @param driver
	 *            the driver
	 */
	Logger logger = Logger.getLogger("LogoutPage");
	
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		PropertyConfigurator.configure("log4j.properties");
	}

	/** The link log out. */
	/*
	 * UI Maps for Logout Page.
	 */
	@FindBy(xpath = "//span[@class='uiImage']//img[@class='icon noicon' and @title='User']/ancestor::span[@class='photoContainer forceSocialPhoto']")
	public WebElement linkimagelogout;

	
	/** The btn yes. */
	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	public WebElement linkLogout;

	/**
	 * Logout.
	 */
	/*
	 * This method will log out of BioConnect.
	 */
	public void logout() {
		try {		
			BaseTest.waitforElement(linkimagelogout, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(linkLogout, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.SHORTWAIT.get());
			logger.info("Logout is successfull");
			driver.close();
			driver.quit();
		} catch (Exception logoutissue) {
			System.out.println(logoutissue.getMessage());
			logger.info("The exception is : " + logoutissue.getMessage());
			
		}
	}
}
