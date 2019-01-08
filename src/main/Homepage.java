package main;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	WebDriver driver;

	/**
	 * Instantiates a new page.
	 * 
	 * @param driver
	 *            the driver
	 */
	
	Logger logger = Logger.getLogger("CaseCreation Page");
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		PropertyConfigurator.configure("log4j.properties");
	}
	/*
	 * UI maps 
	 */
	
	@FindBy(xpath = "")
	public WebElement app_Launcher;
	
	/*
	 * Reusable Methods
	 */
	
	public void contactCreation()
	{
		
	}
}
