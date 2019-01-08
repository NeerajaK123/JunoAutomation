package main;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import extentReports.ExtentTestManager;

public class JAMSAccount {

	WebDriver driver;

	/**
	 * Instantiates a new page.
	 * 
	 * @param driver
	 *            the driver
	 */

	Logger logger = Logger.getLogger("CaseCreation Page");

	public JAMSAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		PropertyConfigurator.configure("log4j.properties");
	}
	/*
	 * UI maps
	 */

	@FindBy(xpath = "//div[@class='slds-grid slds-has-flexi-truncate navUL']/one-app-nav-bar-item-root[@data-id='Account']")
	public WebElement tab_Account;

	@FindBy(xpath = "//li[@class='slds-button slds-button--neutral slds-truncate']/a[@title='New']")
	public WebElement Btn_NewAccount;

	@FindBy(xpath = "//div[contains(text(),'Non Prescriber record type')]")
	public WebElement Radiobtn_NonPrescriber;

	@FindBy(xpath = "//div[@class='forceChangeRecordTypeFooter']/button[2]/span[contains(text(),'Next')]")
	public WebElement Btn_NextAccount;

	@FindBy(xpath = "//div[@class='salutation compoundTLRadius compoundTRRadius compoundBorderBottom form-element__row uiMenu']/div/div/div/a[contains(text(),'--None--')]")
	public WebElement Salutation;

	@FindBy(xpath = "//li[@role='presentation']//a[@title='Dr.']")
	public WebElement Salutation_Dr;

	@FindBy(xpath = "//span[contains(text(),'Last Name')]/ancestor::label/following-sibling::input")
	public WebElement TxtBox_LastName;

	@FindBy(xpath = "//span[contains(text(),'Contact Type')]/ancestor::span/following-sibling::div/div/div/div/a[contains(text(),'--None--')]")
	public WebElement Picklist_ContactType;

	@FindBy(xpath = "//li[@role='presentation']/a[@title='Pharmacist']")
	public WebElement Picklist_ContactType_pharmacist;

	@FindBy(xpath = "//input[@title='Search Accounts']")
	public WebElement Lookup_PrimaryParent;

	@FindBy(xpath = "//span[@title='New Account']")
	public WebElement Btn_NewPrimaryParentAccount_contact;

	@FindBy(xpath = "//div[contains(text(),'Corporate profile for site, apheresis centers, and Service Providers')]")
	public WebElement RadioBtn_Organisation;

	@FindBy(xpath = "//span[contains(text(),'Account Name')]/ancestor::label/following-sibling::input")
	public WebElement TxtBox_AccountName_Organisation;

	@FindBy(xpath = "//span[contains(text(),'Country')]/ancestor::span/following-sibling::div/div/div/div/a[contains(text(),'--None--')]")
	public WebElement Picklist_country_organisation;

	@FindBy(xpath = "//li[@role='presentation']//a[@title='Albania']")
	public WebElement Picklist_country_Albania;

	@FindBy(xpath = "//span[contains(text(),'Account Status')]/ancestor::span/following-sibling::div/div/div/div/a[contains(text(),'Draft')]")
	public WebElement Picklist_AccountStatus;

	@FindBy(xpath = "//a[@title='Approved']")
	public WebElement Picklist_Approve;

	@FindBy(xpath = "//div[@data-value='Academic Institution']")
	public WebElement Select_Category_Acadamic_institution;

	@FindBy(xpath = "//button[@title='Move selection to Chosen']")
	public WebElement chooseOption;

	@FindBy(xpath = "(//div[@class='forceModalActionContainer--footerAction forceModalActionContainer']//button[@title='Save'])[2]")
	public WebElement Btn_Save_OrganisationAccount;

	@FindBy(xpath = "//div[@class='forceModalActionContainer--footerAction forceModalActionContainer']//button[@title='Save']")
	public WebElement Btn_Save_Account;

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//span[text()='Account']")
	public WebElement CreatedAccount;
	
	@FindBy(xpath = "//div[contains(text(),'Provider Site profile for commercial and clinical')]")
	public WebElement Radiobtn_Site;

	/*
	 * Reusable Methods
	 */

	public void contactCreation(String Nonprescriber, String Organisation) {
		try {
			BaseTest.waitforElement(tab_Account, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_NewAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Radiobtn_NonPrescriber, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_NextAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Salutation, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Salutation_Dr, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(TxtBox_LastName, Config.timeouts.LONGWAIT.get()).sendKeys(Nonprescriber);
			BaseTest.waitforElement(Picklist_ContactType, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Picklist_ContactType_pharmacist, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Lookup_PrimaryParent, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_NewPrimaryParentAccount_contact, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(RadioBtn_Organisation, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_NextAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(TxtBox_AccountName_Organisation, Config.timeouts.LONGWAIT.get())
					.sendKeys(Organisation);
			BaseTest.waitforElement(Picklist_country_organisation, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Picklist_country_Albania, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Picklist_AccountStatus, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Picklist_Approve, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.scrolldowntoVisibility(Select_Category_Acadamic_institution);
			BaseTest.waitforElement(Select_Category_Acadamic_institution, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(chooseOption, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_Save_OrganisationAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_Save_Account, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(CreatedAccount, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(CreatedAccount.isDisplayed());
			String NonPrescriber = driver.findElement(By.xpath(
					"//div[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			System.out.print("Created Non-Prescriber account is : " + NonPrescriber);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Created Non-Prescriber account is : " + NonPrescriber);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void siteCreation(String Site)
	{
		BaseTest.waitforElement(tab_Account, Config.timeouts.LONGWAIT.get()).click();
		BaseTest.waitforElement(Btn_NewAccount, Config.timeouts.LONGWAIT.get()).click();
	}
}
