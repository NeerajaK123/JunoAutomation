package main;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

	@FindBy(xpath = "//a[@title='Accounts']")
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

	@FindBy(xpath = "//input[@title='Search Products']")
	public WebElement Lookup_Products;
	
	@FindBy(xpath = "//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']")
	public WebElement Lkup_accountSite_result;
	
	@FindBy(xpath = "(//span[contains(text(),'Account Assignments')]/ancestor::h2/ancestor::div[@class='slds-media__body']/ancestor::header/following-sibling::div/div/ul/li/a[@title='New'])")
	public WebElement Btn_New_SiteAccountAssignmnet_Protocol;
			
	@FindBy(xpath = "//span[@title='New Account']")
	public WebElement Btn_NewPrimaryParentAccount_contact;

	@FindBy(xpath = "//div[contains(text(),'Corporate profile for site, apheresis centers, and Service Providers')]")
	public WebElement RadioBtn_Organisation;

	@FindBy(xpath = "//span[contains(text(),'Account Name')]/ancestor::label/following-sibling::input")
	public WebElement TxtBox_AccountName;

	@FindBy(xpath = "//span[contains(text(),'Product Name')]/ancestor::label/following-sibling::input")
	public WebElement TxtBox_ProductName;
	
	
	@FindBy(xpath = "//span[contains(text(),'Protocol Name')]/ancestor::label/following-sibling::input")
	public WebElement TxtBox_ProtocolName;
	
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

	@FindBy(xpath = "//div[@data-value='BMT Unit']")
	public WebElement Select_Category_BMTUnit;

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
	
	@FindBy(xpath = "//div[contains(text(),'Apheresis Center profile for collection, commercial, clinical, and healthy donor')]")
	public WebElement Radiobtn_Apheresis;

	@FindBy(xpath = "//span[contains(text(),'Account Name')]/ancestor::label/following-sibling::input")
	public WebElement TxtBox_AccountName_Site;

	@FindBy(xpath = "(//span[contains(text(),'Addresses')]/ancestor::h2/ancestor::div[@class='slds-media__body']/ancestor::header/following-sibling::div/div/ul/li/a[@title='New'])")
	public WebElement Btn_Address_site;

	@FindBy(xpath = "//div[@data-value='Collection Pickup']")
	public WebElement SelectCollectionPickup;

	@FindBy(xpath = "//div[@data-value='DP Delivery']")
	public WebElement SelectDPDelivery;

	@FindBy(xpath = "//div[@data-value='Site Address']")
	public WebElement SelectSiteAddress;

	@FindBy(xpath = "//span[contains(text(),'Address Line 1')]/ancestor::label/following-sibling::input")
	public WebElement TxtBox_AddressLine1;

	@FindBy(xpath = "//span[contains(text(),'City')]/ancestor::label/following-sibling::input")
	public WebElement TxtBox_City;

	@FindBy(xpath = "//span[contains(text(),'Primary')]/ancestor::label/following-sibling::input")
	public WebElement ChckBox_Primary;

	@FindBy(xpath = "//span[contains(text(),'Active')]/ancestor::label/following-sibling::input")
	public WebElement ChckBox_Active;

	@FindBy(xpath = "//div[@class='forceModalActionContainer--footerAction forceModalActionContainer']/button[3]/span[contains(text(),'Save')]")
	public WebElement Btn_SaveAddress;

	@FindBy(xpath = "//ul[@class='branding-actions slds-button-group slds-m-left--xx-small oneActionsRibbon forceActionsContainer']/li[2]/a/div[contains(text(),'Submit for Approval')]")
	public WebElement Btn_SubmitForApproval;

	@FindBy(xpath = "//textarea[@name='Comment']")
	public WebElement txtbox_Comments;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement btn_Submit;

	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	public WebElement btn_ProductSubmit;

	@FindBy(xpath = "//span[contains(text(),'Account Status')]/following-sibling::div/div/span[contains(text(),'Pending Approval')]")
	public WebElement Status_PendingApproval;

	@FindBy(xpath = "//span[contains(text(),'Status')]/following-sibling::div/div/span[contains(text(),'Pending Approval')]")
	public WebElement JuptrStatus_PendingApproval;

	@FindBy(xpath = "//span[@class='slds-grid slds-grid--align-spread']//span[contains(text(),'Approved')]")
	public WebElement Status_Approved_ApprovalHistory;

	@FindBy(xpath = "//div[@title='Add Relationship']")
	public WebElement Btn_AddRelationShip_contact;

	@FindBy(xpath = "//input[@title='Search Contacts']")
	public WebElement Lkup_contact;

	@FindBy(xpath = "//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']")
	public WebElement Lkup_contact_result;

	@FindBy(xpath = "//div[@data-value='DP Delivery Primary']")
	public WebElement Select_DPDeliveryPrimary;

	@FindBy(xpath = "//div[@data-value='DP Delivery Alternate']")
	public WebElement Select_DPDeliveryAlternate;

	@FindBy(xpath = "//div[@class='uiInput uiAutocomplete uiInput--default']/input[@title='Search Salesforce']")
	public WebElement globalSearch;

	@FindBy(xpath = "//tbody/tr/th/span/a")
	public WebElement globalsearchResult;

	@FindBy(xpath = "//a[@title='Related']")
	public WebElement tab_Related;

	@FindBy(xpath = "//span[@title='Approval History']")
	public WebElement tab_ApprovalHistory;

	@FindBy(xpath = "(//ul[@class='branding-actions slds-button-group slds-m-left--xx-small small oneActionsRibbon forceActionsContainer']//li//a//div[contains(text(),'Approve')])[2]")
	public WebElement btn_Approve;

	@FindBy(xpath = "//div[@class='forceModalActionContainer--footerAction forceModalActionContainer']//button//span[contains(text(),'Approve')]")
	public WebElement btn_ConfirmApprove;

	@FindBy(xpath = "//div[contains(text(),'Department at Provider site')]")
	public WebElement RadioBtn_Department;

	@FindBy(xpath = "//span[contains(text(),'MNC Procedure Record Template')]/ancestor::span[@class='label inputLabel uiPicklistLabel-left form-element__label uiPicklistLabel']/following-sibling::div//div/a[contains(text(),'--None--')]")
	public WebElement Select_MNCTemplate;

	@FindBy(xpath = "//li[@role='presentation']//a[@title='JCAR017']")
	public WebElement Select_JCARMNCTemplate;

	@FindBy(xpath = "//span[contains(text(),'Protocol Type')]/ancestor::span[@class='label inputLabel uiPicklistLabel-left form-element__label uiPicklistLabel']/following-sibling::div//div/a[contains(text(),'--None--')]")
	public WebElement Select_ProtocolType_None;
	
	@FindBy(xpath = "//li[@role='presentation']//a[@title='Adults']")
	public WebElement Select_ProtocolType_Adults;
	
	
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
			BaseTest.waitforElement(TxtBox_AccountName, Config.timeouts.LONGWAIT.get()).sendKeys(Organisation);
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
			System.out.print("Created Site account is : " + NonPrescriber);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Created Non-Prescriber account is : " + NonPrescriber);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}

	public void siteCreation(String Site, String Address, String city, String NonPrescriber) {

		try {
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(Btn_NewAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Radiobtn_Site, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_NextAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(TxtBox_AccountName, Config.timeouts.LONGWAIT.get()).sendKeys(Site);
			BaseTest.waitforElement(Picklist_country_organisation, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Picklist_country_Albania, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.scrolldowntoVisibility(Select_Category_Acadamic_institution);
			BaseTest.waitforElement(Select_Category_Acadamic_institution, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(chooseOption, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_Save_Account, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(CreatedAccount, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(CreatedAccount.isDisplayed());
			String SiteCreated = driver.findElement(By.xpath(
					"//div[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			System.out.print("Created Site is : " + SiteCreated);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Created Site is : " + SiteCreated);
			addressCreation(Address, city);
			BaseTest.scrolldown(100);
			relatedContactCreation(NonPrescriber);
			BaseTest.waitforElement(Btn_SubmitForApproval, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(txtbox_Comments, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_Submit, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.scrollup(150);
			BaseTest.waitforElement(Status_PendingApproval, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(Status_PendingApproval.isDisplayed(), "Site status is not pending approval");

		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}

	}

	public void addressCreation(String Address, String city) {
		try {
			BaseTest objbasetest = new BaseTest();
			BaseTest.waitforElement(Btn_Address_site, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(SelectCollectionPickup, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(objbasetest.JAMSAccount.chooseOption, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(SelectDPDelivery, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(chooseOption, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(SelectSiteAddress, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(chooseOption, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(TxtBox_AddressLine1, Config.timeouts.LONGWAIT.get()).sendKeys(Address);
			BaseTest.waitforElement(TxtBox_City, Config.timeouts.LONGWAIT.get()).sendKeys(city);
			BaseTest.waitforElement(Picklist_country_organisation, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Picklist_country_Albania, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(ChckBox_Active, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(ChckBox_Primary, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_SaveAddress, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(driver.findElement(By.xpath("//a[contains(text(),'" + Address + "')]")),
					Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'" + Address + "')]")).isDisplayed());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}

	public void relatedContactCreation(String NonPrescriber) {
		try {
			BaseTest.waitforElement(Btn_AddRelationShip_contact, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Lkup_contact, Config.timeouts.LONGWAIT.get()).sendKeys(NonPrescriber);
			BaseTest.waitforElement(Lkup_contact_result, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Select_DPDeliveryPrimary, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(chooseOption, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Select_DPDeliveryAlternate, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(chooseOption, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_Save_Account, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(driver.findElement(By.xpath("//a[contains(text(),'" + NonPrescriber + "')]")),
					Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(
					driver.findElement(By.xpath("//a[contains(text(),'" + NonPrescriber + "')]")).isDisplayed());
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}

	public void accountApprovalJams(String account) {
		try {
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(globalSearch, Config.timeouts.LONGWAIT.get()).sendKeys(account);
			BaseTest.waitforElement(globalSearch, Config.timeouts.LONGWAIT.get()).sendKeys(Keys.ENTER);
			// WebElement globalsearchResult =
			// driver.findElement(By.xpath("//a[@title='"+account+"']"));
			BaseTest.waitforElement(globalsearchResult, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(tab_Related, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(tab_ApprovalHistory, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_Approve, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_ConfirmApprove, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Status_Approved_ApprovalHistory, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(Status_Approved_ApprovalHistory.isDisplayed());
			ExtentTestManager.getTest().log(LogStatus.INFO, "Account Approved is  : " + account);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}

	}

	public void departmentCreation(String Department, String Site, String Address, String city, String NonPrescriber) {
		try {
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(Btn_NewAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(RadioBtn_Department, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_NextAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(TxtBox_AccountName, Config.timeouts.LONGWAIT.get()).sendKeys(Department);
			BaseTest.waitforElement(Picklist_country_organisation, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Picklist_country_Albania, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Lookup_PrimaryParent, Config.timeouts.LONGWAIT.get()).sendKeys(Site);
			BaseTest.waitforElement(Lkup_accountSite_result, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.scrolldowntoVisibility(Select_Category_BMTUnit);
			BaseTest.waitforElement(Select_Category_BMTUnit, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(chooseOption, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_Save_Account, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(CreatedAccount, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(CreatedAccount.isDisplayed());
			String DepartmentCreated = driver.findElement(By.xpath(
					"//div[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			System.out.print("Created Department is : " + DepartmentCreated);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Created Department is : " + DepartmentCreated);
			addressCreation(Address, city);
			BaseTest.scrolldown(100);
			relatedContactCreation(NonPrescriber);
			BaseTest.waitforElement(Btn_SubmitForApproval, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_Submit, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.scrollup(150);
			BaseTest.waitforElement(Status_PendingApproval, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(Status_PendingApproval.isDisplayed(), "Department status is not pending approval");

		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}

	public void productCreation(String Product) {
		
		try {
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(Btn_NewAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_NextAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(TxtBox_ProductName, Config.timeouts.LONGWAIT.get()).sendKeys(Product);
			BaseTest.waitforElement(ChckBox_Active, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Select_MNCTemplate, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Select_JCARMNCTemplate, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_SaveAddress, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(driver.findElement(By.xpath(
					"//div[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span")),
					Config.timeouts.LONGWAIT.get());
			String ProductCreated = driver.findElement(By.xpath(
					"//div[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			System.out.print("Created Product is : " + ProductCreated);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Created Product is : " + ProductCreated);
			BaseTest.waitforElement(Btn_SubmitForApproval, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_ProductSubmit, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.scrollup(150);
			BaseTest.waitforElement(JuptrStatus_PendingApproval, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(JuptrStatus_PendingApproval.isDisplayed(), "Product status is not pending approval");

		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}

	}
	
	public void protocolCreation(String Protocol,String Product,String Site)
	{
				try {
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(Btn_NewAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_NextAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(TxtBox_ProtocolName, Config.timeouts.LONGWAIT.get()).sendKeys(Protocol);	
			BaseTest.waitforElement(ChckBox_Active, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Select_ProtocolType_None, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Select_ProtocolType_Adults, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Lookup_Products, Config.timeouts.LONGWAIT.get()).sendKeys(Product);
			BaseTest.waitforElement(Lkup_accountSite_result, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_SaveAddress, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_New_SiteAccountAssignmnet_Protocol, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Lookup_PrimaryParent, Config.timeouts.LONGWAIT.get()).sendKeys(Site);
			BaseTest.waitforElement(Lkup_accountSite_result, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_SaveAddress, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());		
			BaseTest.waitforElement(driver.findElement(By.xpath(
					"//div[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span")),
					Config.timeouts.LONGWAIT.get());
			String ProtocolCreated = driver.findElement(By.xpath(
					"//div[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			System.out.print("Created Protocol is : " + ProtocolCreated);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Created Protocol is : " + ProtocolCreated);
			BaseTest.waitforElement(Btn_SubmitForApproval, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_ProductSubmit, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.scrollup(150);
			BaseTest.waitforElement(JuptrStatus_PendingApproval, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(JuptrStatus_PendingApproval.isDisplayed(), "Product status is not pending approval");
				
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}
public void apheresisCreation(String Apheresis,String Address, String city, String NonPrescriber,String Protocol,String Site)
{
	
	try {
		BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
		BaseTest.waitforElement(Btn_NewAccount, Config.timeouts.LONGWAIT.get()).click();
		BaseTest.waitforElement(Radiobtn_Apheresis, Config.timeouts.LONGWAIT.get()).click();
		BaseTest.waitforElement(Btn_NextAccount, Config.timeouts.LONGWAIT.get()).click();
		BaseTest.waitforElement(TxtBox_AccountName, Config.timeouts.LONGWAIT.get()).sendKeys(Apheresis);
		BaseTest.waitforElement(Picklist_country_organisation, Config.timeouts.LONGWAIT.get()).click();
		BaseTest.waitforElement(Picklist_country_Albania, Config.timeouts.LONGWAIT.get()).click();
		
		BaseTest.waitforElement(Btn_Save_Account, Config.timeouts.LONGWAIT.get()).click();
		BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
		BaseTest.waitforElement(CreatedAccount, Config.timeouts.LONGWAIT.get());
		Assert.assertTrue(CreatedAccount.isDisplayed());
		String ApheresisCreated = driver.findElement(By.xpath(
				"//div[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
				.getText();
		System.out.print("Created Apheresis is : " + ApheresisCreated);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Created Apheresis is : " + ApheresisCreated);
		addressCreation(Address, city);
		BaseTest.scrolldown(100);
		relatedContactCreation(NonPrescriber);
		
		
	} catch (InterruptedException e) {
		System.out.println(e.getMessage());
		logger.info("The exception is : " + e.getMessage());
		ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
		Assert.fail();
	}
	
}
}
