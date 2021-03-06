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
/**
 * @author nkandikuppa
 *
 */
public class JAMSAccount {

	WebDriver driver;
public String onboardingid;
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
	
	@FindBy(xpath = "//div[contains(text(),'Creation of onboarding templates for apheresis center account types only')]")
	public WebElement Radiobtn_ApheresisOBT;	

	@FindBy(xpath = "//span[contains(text(),'Onboarding Template Name')]/ancestor::label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/following-sibling::input")
	public WebElement textbox_OnboardingTemplate;
	
	@FindBy(xpath = "//span[contains(text(),'Active')]/ancestor::label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/following-sibling::input[@type='checkbox']")
	public WebElement checkbox_Active_onboarding;
	
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

	@FindBy(xpath = "//span[contains(text(),'Actual Treatment Auto Assign')]/ancestor::label/following-sibling::input")
	public WebElement ChkBox_ActualTreatmentAutoAssign;

	@FindBy(xpath = "//span[contains(text(),'Reservation Treatment Auto Assign')]/ancestor::label/following-sibling::input")
	public WebElement ChkBox_ReservationTreatmentAutoAssign;

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

	@FindBy(xpath = "//span[contains(text(),'Product Version Name')]/ancestor::label/following-sibling::input")
	public WebElement TxtBox_ProductversionName;

	@FindBy(xpath = "//span[contains(text(),'Dose Level Name')]/ancestor::label/following-sibling::input")
	public WebElement TxtBox_DoseLevelName;

	@FindBy(xpath = "//span[contains(text(),'Dose Schedule Name')]/ancestor::label/following-sibling::input")
	public WebElement TxtBox_DoseScheduleName;

	@FindBy(xpath = "//span[contains(text(),'Product Version ID')]/ancestor::label/following-sibling::input")
	public WebElement TxtBox_ProductversionID;

	@FindBy(xpath = "//span[contains(text(),'Country')]/ancestor::span/following-sibling::div/div/div/div/a[contains(text(),'--None--')]")
	public WebElement Picklist_country_organisation;

	@FindBy(xpath = "//li[@role='presentation']//a[@title='Albania']")
	public WebElement Picklist_country_Albania;

	@FindBy(xpath = "//span[contains(text(),'Email')]/ancestor::div[@class='uiInput uiInputEmail uiInput--default uiInput--input']/input")
	public WebElement txtbox_EmailManSite;

	@FindBy(xpath = "//span[contains(text(),'Account Status')]/ancestor::span/following-sibling::div/div/div/div/a[contains(text(),'Draft')]")
	public WebElement Picklist_AccountStatus;

	@FindBy(xpath = "//a[@title='Approved']")
	public WebElement Picklist_Approve;
	
	@FindBy(xpath = "//a[@title='Verified']")
	public WebElement Picklist_verified_Onboarding;
	

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

	@FindBy(xpath = "//div[contains(text(),'Juno Manufacturing Sites')]")
	public WebElement Radiobtn_ManufacturingSite;

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

	@FindBy(xpath = "//button[3]/span[contains(text(),'Save')]")
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

	@FindBy(xpath = "//div[@data-value='Apheresis Pickup']")
	public WebElement Select_ApheresisPickup;	
	
	@FindBy(xpath = "//div[@class='uiInput uiAutocomplete uiInput--default']/input[@title='Search Salesforce']")
	public WebElement globalSearch;

	@FindBy(xpath = "//tbody/tr/th/span/a")
	public WebElement globalsearchResult;
	
	

	@FindBy(xpath = "(//span[contains(text(),'Protocol Assignments')]/ancestor::h2/ancestor::div[@class='slds-media__body']/ancestor::header/following-sibling::div/div/ul/li/a[@title='New'])")
	public WebElement btn_New_PPV;

	@FindBy(xpath = "(//span[contains(text(),'Dose Levels')]/ancestor::h2/ancestor::div[@class='slds-media__body']/ancestor::header/following-sibling::div/div/ul/li/a[@title='New'])")
	public WebElement btn_New_DL;
	
	@FindBy(xpath = "//span[@class='slds-card__header-title slds-truncate slds-m-right--xx-small' and contains(text(),'Dose Levels')]")
	public WebElement span_DoseLevel;

	@FindBy(xpath = "//span[contains(text(),'Total Cell Amount (10^6)')]/ancestor::label/following-sibling::input")
	public WebElement TxtBox_TotalcellAmount;

	@FindBy(xpath = "//span[contains(text(),'Target Dose Amount (10^6)')]/ancestor::label/following-sibling::input")
	public WebElement TxtBox_TargetDoseAmount;

	@FindBy(xpath = "(//a[@class='datePicker-openIcon display'])[1]")
	public WebElement datePicker_Effective_Start_DL;

	@FindBy(xpath = "//span[@class='today slds-show--inline-block slds-text-link slds-p-bottom--x-small']")
	public WebElement Effective_Start_today;

	@FindBy(xpath = "(//a[@class='datePicker-openIcon display'])[2]")
	public WebElement datePicker_Effective_End_DL;

	@FindBy(xpath = "//a[@title='Go to next month']")
	public WebElement Effective_EndDate_NextMonth_Arrow;

	@FindBy(xpath = "(//td[@class='uiDayInMonthCell'])[15]")
	public WebElement Effective_EndDate_Fifteenthday_NextMonth;

	@FindBy(xpath = "//span[@class='slds-card__header-title slds-truncate slds-m-right--xx-small' and contains(text(),'Dose Levels')]")
	public WebElement btn_New_DS;
	
	@FindBy(xpath = "//span[@class='slds-card__header-title slds-truncate slds-m-right--xx-small' and contains(text(),'Dose Schedules')]")
	public WebElement span_DoseSchedules;
	
	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//div[@class='slds-truncate' and text()='New']")
	public WebElement btn_NewDoseSchedule;

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

	@FindBy(xpath = "(//span[contains(text(),'Protocol Assignments')]/ancestor::h2/ancestor::div[@class='slds-media__body']/ancestor::header/following-sibling::div/div/ul/li/a[@title='New'])")
	public WebElement btn_NewProtocolAssignment;

	@FindBy(xpath = "(//span[contains(text(),'Child Accounts')]/ancestor::h2/ancestor::div[@class='slds-media__body']/ancestor::header/following-sibling::div/div/ul/li/a[@title='New'])")
	public WebElement btn_NewChildAccountAssignment;

	@FindBy(xpath = "(//span[contains(text(),'Affiliated Sites')]/ancestor::h2/ancestor::div[@class='slds-media__body']/ancestor::header/following-sibling::div/div/ul/li/a[@title='New'])")
	public WebElement btn_NewAffiliatedSiteAssignment;

	@FindBy(xpath = "//input[@title='Search Protocols']")
	public WebElement Search_Protocols;

	@FindBy(xpath = "//table[@class='forceRecordLayout slds-table slds-table_cell-buffer slds-table_bordered uiVirtualDataGrid--default uiVirtualDataGrid']//tr[1]//td[1]//a")
	public WebElement link_ProtocolsResult;

	@FindBy(xpath = "//span[contains(text(),'Specification Number')]/ancestor::label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/following-sibling::input")
	public WebElement txtbox_SpecificationNumber;

	@FindBy(xpath = "//span[contains(text(),'Collection Description')]/ancestor::label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/following-sibling::input")
	public WebElement txtbox_CollectionDescription;

	@FindBy(xpath = "//span[contains(text(),'Actual Treatment Channel')]/ancestor::span[@class='label inputLabel uiPicklistLabel-left form-element__label uiPicklistLabel']/following-sibling::div/div/div/div/a")
	public WebElement dd_ATChannel;

	@FindBy(xpath = "//li[@role='presentation']//a[@title='Clinical']")
	public WebElement ATChanel_Clinical;

	@FindBy(xpath = "//span[contains(text(),'Actual Treatment JOIN Prefix')]/ancestor::label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/following-sibling::input")
	public WebElement txtbox_ATJoinPrefix;

	@FindBy(xpath = "//span[contains(text(),'Reservation Treatment JOIN Prefix')]/ancestor::label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/following-sibling::input")
	public WebElement txtbox_RTJoinPrefix;

	@FindBy(xpath = "//a[@title='Show 2 more actions']")
	public WebElement Accordion_Apheresis_Showmore;
	

	@FindBy(xpath = "//a[@title='Show 3 more actions']")
	public WebElement Accordion_Apheresis_Showmore_Admin;
	
	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//a[contains(text(),'APA-')]")
	public WebElement hyperLnk_APA;
	
	@FindBy(xpath = "(//span[contains(text(),'Protocol Assignments')])[1]")
	public WebElement tab_protocolAssignment_Aph;	
	
	
	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//a[@title='Edit']")
	public WebElement btn_EditAPA;

	@FindBy(xpath = "//input[@title='Search Onboardings']")
	public WebElement searchbox_onboardings;
	
	
	@FindBy(xpath = "//tbody//tr//td/a[contains(@title,'OB-')]")
	public WebElement search_result_onboarding;
	

	@FindBy(xpath = "//div[contains(text(),'Active Onboarding Templates')]")
	public WebElement tab_ActiveOnboardingTemplate;

	@FindBy(xpath = "//li[@role='presentation']/a[@title='Onboard']")
	public WebElement Lnk_Onboard;
	
	@FindBy(xpath = "//li[@role='presentation']/a[@title='Approve']")
	public WebElement Lnk_ApproveAph;
	
	@FindBy(xpath = "//button[contains(text(),'Approve')]")
	public WebElement btn_ApproveAphAdmin;
	

	@FindBy(xpath = "//div[@class='modal-footer slds-modal__footer slds-size_1-of-1']/button[contains(text(),'Submit')]")
	public WebElement submit_Onboard;

	@FindBy(xpath = "//a[contains(text(),'OB-')]")
	public WebElement hyperlnk_OnboardingID;

	@FindBy(xpath = "//a[contains(text(),'PPV-')]")
	public WebElement hyperlnk_PPVID;

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//div[@title='Edit']")
	public WebElement btn_EditOnboardingID;
	
	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//a[@title='Submit for Approval']")
	public WebElement btn_SubmitforApproval;
	
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement btn_submitApproval_Submit;
	
	
	@FindBy(xpath = "//a[contains(text(),'Draft')]")
	public WebElement lkup_draft;

	@FindBy(xpath = "//li[@role='presentation']//a[@title='Verified']")
	public WebElement lkupresult_verifed;

	@FindBy(xpath = "(//ul[@class='slds-listbox slds-listbox_vertical']/li[@role='presentation']//span[@title='Study specific PA'])")
	public WebElement selectContractType;

	@FindBy(xpath = "//span[contains(text(),'Contract Type')]//ancestor::div[@class='slds-form-element slds-form-element_readonly slds-form-element_edit slds-grow slds-hint-parent override--slds-form-element']/div[2]/button/lightning-primitive-icon")
	public WebElement editPen_ContractType;

	@FindBy(xpath = "//span[contains(text(),'Save')]")
	public WebElement btnSave_onb;
	
	@FindBy(xpath = "//nav[@class='entityNameTitle']//span[contains(text(),'Onboarding')]/ancestor::nav/following-sibling::h1/span")
	public WebElement onboardingID;
	
	
	/*
	 * Reusable Methods
	 */

	public void contactCreation(String Nonprescriber, String Organisation) {
		try {
			//BaseTest.waitforElement(tab_Account, Config.timeouts.LONGWAIT.get()).click();
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
			Thread.sleep(5000);
			BaseTest.waitforElement(Btn_Save_Account, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(CreatedAccount, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(CreatedAccount.isDisplayed());
			String NonPrescriber = driver.findElement(By.xpath(
					"//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			System.out.print("Created NonPrescriber account is : " + NonPrescriber);
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
					"//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			System.out.print("Created Site is : " + SiteCreated);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Created Site is : " + SiteCreated);
			addressCreation(Address, city);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Added address to the site is : " + Address);
			BaseTest.scrolldown(300);
			relatedContactCreation(NonPrescriber);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Contact added to the site is  : " + NonPrescriber);
			BaseTest.waitforElement(Btn_SubmitForApproval, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(txtbox_Comments, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_Submit, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.scrollup(2000);
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
			BaseTest.waitforElement(tab_Related, Config.timeouts.LONGWAIT.get()).click();
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
			BaseTest.waitforElement(Btn_AddRelationShip_contact, Config.timeouts.LONGWAIT.get());
			//BaseTest.waitforElement(driver.findElement(By.xpath("//a[contains(text(),'" + Address + "')]")),
					//Config.timeouts.LONGWAIT.get());
			//Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'" + Address + "')]")).isDisplayed());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}

	public void relatedContactCreation(String NonPrescriber) {
		try {
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(Btn_AddRelationShip_contact, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Lkup_contact, Config.timeouts.LONGWAIT.get()).sendKeys(NonPrescriber);
			//BaseTest.waitforElement(Lkup_contact, Config.timeouts.LONGWAIT.get()).sendKeys(Keys.ENTER);
			BaseTest.waitforElement(Lkup_contact_result, Config.timeouts.LONGWAIT.get()).click();
			//WebElement contactresult = driver.findElement(By.xpath("(//tbody/tr/td/a[contains(@title,'A_')])[1]"));
			//BaseTest.waitforElement(contactresult, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Select_DPDeliveryPrimary, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(chooseOption, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Select_DPDeliveryAlternate, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(chooseOption, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Select_ApheresisPickup, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(chooseOption, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_Save_Account, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			/*BaseTest.waitforElement(driver.findElement(By.xpath("//a[contains(text(),'" + NonPrescriber + "')]")),
					Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(
					driver.findElement(By.xpath("//a[contains(text(),'" + NonPrescriber + "')]")).isDisplayed());*/
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}

	public void relatedProtocolAssignment(String Protocol) {
		try {
			BaseTest.scrolldown(80);
			BaseTest.waitforElement(btn_NewProtocolAssignment, Config.timeouts.LONGWAIT.get()).click();
			;
			BaseTest.waitforElement(Search_Protocols, Config.timeouts.LONGWAIT.get()).sendKeys(Protocol);
			BaseTest.waitforElement(Search_Protocols, Config.timeouts.LONGWAIT.get()).sendKeys(Keys.ENTER);
			BaseTest.waitforElement(link_ProtocolsResult, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_SaveAddress, Config.timeouts.LONGWAIT.get()).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}

	public void Onboarding_APH(String onboardingTemplate) {
		try {
			BaseTest.waitforElement(Accordion_Apheresis_Showmore, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Lnk_Onboard, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(tab_ActiveOnboardingTemplate, Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(driver
					.findElement(By.xpath("//span[contains(text(),'" + onboardingTemplate + "')]")), Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(driver
					.findElement(By.xpath("//span[contains(text(),'" + onboardingTemplate + "')]")));
			BaseTest.waitforElement(driver
					.findElement(By.xpath("//span[contains(text(),'" + onboardingTemplate + "')]")), Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(submit_Onboard, Config.timeouts.LONGWAIT.get()).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}

	public String approvingOnboarding_APH(String Apheresis) {
		try {
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(globalSearch, Config.timeouts.LONGWAIT.get()).sendKeys(Apheresis);
			BaseTest.waitforElement(globalSearch, Config.timeouts.LONGWAIT.get()).sendKeys(Keys.ENTER);
			BaseTest.waitforElement(globalsearchResult, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.scrolldown(100);
			BaseTest.waitforElement(tab_Related, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(hyperlnk_OnboardingID, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(editPen_ContractType, Config.timeouts.LONGWAIT.get()).click();
			selectContractType.click();
			BaseTest.waitforElement(chooseOption, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.scrollup(200);
			BaseTest.waitforElement(lkup_draft, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Picklist_verified_Onboarding, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btnSave_onb, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.scrollup(2000);
			onboardingid  = onboardingID.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Created Onboarding ID i " + onboardingid );
			
			/*
			 * BaseTest.waitforElement(tab_Related, Config.timeouts.LONGWAIT.get()).click();
			 * BaseTest.waitforElement(hyperlnk_OnboardingID,
			 * Config.timeouts.LONGWAIT.get()).click();
			 * BaseTest.waitforElement(btn_EditOnboardingID,
			 * Config.timeouts.LONGWAIT.get()).click(); BaseTest.waitforElement(lkup_draft,
			 * Config.timeouts.LONGWAIT.get()).click();
			 * BaseTest.waitforElement(lkupresult_verifed,
			 * Config.timeouts.LONGWAIT.get()).click(); BaseTest.scrolldown(100);
			 * BaseTest.waitforElement(selectContractType,
			 * Config.timeouts.LONGWAIT.get()).click();
			 * BaseTest.waitforElement(chooseOption,
			 * Config.timeouts.LONGWAIT.get()).click();
			 * BaseTest.waitforElement(Btn_SaveAddress,
			 * Config.timeouts.LONGWAIT.get()).click();
			 */

		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
		return onboardingid;

	}

	public void approvingPPV_PV(String ProductVersion) {
		try {
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(globalSearch, Config.timeouts.LONGWAIT.get()).sendKeys(ProductVersion);
			BaseTest.waitforElement(globalSearch, Config.timeouts.LONGWAIT.get()).sendKeys(Keys.ENTER);
			BaseTest.waitforElement(globalsearchResult, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.scrolldown(100);
			BaseTest.waitforElement(tab_Related, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(hyperlnk_PPVID, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(btn_EditOnboardingID, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(lkup_draft, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Picklist_Approve, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_Save_Account, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());

		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}

	}

	public void relatedAffiliatedSiteAssignment(String Site) {
		try {

			BaseTest.waitforElement(btn_NewAffiliatedSiteAssignment, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Lookup_PrimaryParent, Config.timeouts.LONGWAIT.get()).sendKeys(Site);
			BaseTest.waitforElement(Lkup_accountSite_result, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_SaveAddress, Config.timeouts.LONGWAIT.get()).click();
		} catch (Exception e) {
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
					"//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
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
					"//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span")),
					Config.timeouts.LONGWAIT.get());
			String ProductCreated = driver.findElement(By.xpath(
					"//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
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

	public void protocolCreation(String Protocol, String Product, String Site) {
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
					"//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span")),
					Config.timeouts.LONGWAIT.get());
			String ProtocolCreated = driver.findElement(By.xpath(
					"//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
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

	public void apheresisCreation(String Apheresis, String Address, String city, String NonPrescriber, String Protocol,
			String Site, String onboardingTemplate) {
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
					"//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			System.out.print("Created Apheresis is : " + ApheresisCreated);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Created Apheresis is : " + ApheresisCreated);
			addressCreation(Address,city);
			BaseTest.waitforElement(Btn_Address_site, Config.timeouts.MEDIUMWAIT.get());
			BaseTest.scrolldowntoVisibility(Btn_Address_site);
			relatedContactCreation(NonPrescriber);
			relatedProtocolAssignment(Protocol);
			BaseTest.scrolldown(200);
			BaseTest.waitforElement(btn_NewProtocolAssignment, Config.timeouts.MEDIUMWAIT.get());
			BaseTest.scrolldowntoVisibility(btn_NewProtocolAssignment);
			relatedAffiliatedSiteAssignment(Site);
			BaseTest.scrollup(800);
			Onboarding_APH(onboardingTemplate);
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(Btn_SubmitForApproval, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_Submit, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.scrollup(300);
			BaseTest.waitforElement(Status_PendingApproval, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(Status_PendingApproval.isDisplayed(), "Apheresis status is not pending approval");

		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}

	public void manufacturingSiteCreation(String manufacturingSite, String Address, String city, String NonPrescriber,
			String Site) {
		try {
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(Btn_NewAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Radiobtn_ManufacturingSite, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_NextAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(TxtBox_AccountName, Config.timeouts.LONGWAIT.get()).sendKeys(manufacturingSite);
			BaseTest.waitforElement(Picklist_country_organisation, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Picklist_country_Albania, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(txtbox_EmailManSite, Config.timeouts.LONGWAIT.get()).sendKeys("abc@def.com");
			BaseTest.waitforElement(Btn_Save_Account, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(CreatedAccount, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(CreatedAccount.isDisplayed());
			String manufacturingSiteCreated = driver.findElement(By.xpath(
					"//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			System.out.print("Created manufacturingSite is : " + manufacturingSiteCreated);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Created manufacturingSite is : " + manufacturingSiteCreated);
			addressCreation(Address, city);
			BaseTest.scrolldowntoVisibility(Btn_Address_site);
			relatedContactCreation(NonPrescriber);
			relatedAffiliatedSiteAssignment(Site);
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(Btn_SubmitForApproval, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_Submit, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.scrollup(500);
			BaseTest.waitforElement(Status_PendingApproval, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(Status_PendingApproval.isDisplayed(),
					"Manufacturing site status is not pending approval");

		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}

	public void productversion_AutoJoin(String ProductVersion, String Product, String Protocol) {

		try {
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(Btn_NewAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_NextAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(TxtBox_ProductversionName, Config.timeouts.LONGWAIT.get()).sendKeys(ProductVersion);
			BaseTest.waitforElement(TxtBox_ProductversionID, Config.timeouts.LONGWAIT.get()).sendKeys("123");
			BaseTest.waitforElement(ChckBox_Active, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Lookup_Products, Config.timeouts.LONGWAIT.get()).sendKeys(Product);
			BaseTest.waitforElement(Lkup_accountSite_result, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(ChkBox_ActualTreatmentAutoAssign, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(ChkBox_ReservationTreatmentAutoAssign, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_SaveAddress, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			String productversionCreated = driver.findElement(By.xpath(
					"//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			System.out.print("Created productversion is : " + productversionCreated);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Created productversion is : " + productversionCreated);
			BaseTest.waitforElement(tab_Related, Config.timeouts.LONGWAIT.get()).click();
			protocolproductversion(Protocol);
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(Btn_SubmitForApproval, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_ProductSubmit, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.scrollup(500);
			BaseTest.waitforElement(JuptrStatus_PendingApproval, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(JuptrStatus_PendingApproval.isDisplayed(),
					"Product version status is not pending approval");

		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void productversion_ManualJoin(String ProductVersion, String Product, String Protocol) {

		try {
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(Btn_NewAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_NextAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(TxtBox_ProductversionName, Config.timeouts.LONGWAIT.get()).sendKeys(ProductVersion);
			BaseTest.waitforElement(TxtBox_ProductversionID, Config.timeouts.LONGWAIT.get()).sendKeys("123");
			BaseTest.waitforElement(ChckBox_Active, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Lookup_Products, Config.timeouts.LONGWAIT.get()).sendKeys(Product);
			BaseTest.waitforElement(Lkup_accountSite_result, Config.timeouts.LONGWAIT.get()).click();			
			BaseTest.waitforElement(Btn_SaveAddress, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			String productversionCreated = driver.findElement(By.xpath(
					"//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			System.out.print("Created productversion is : " + productversionCreated);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Created productversion is : " + productversionCreated);
			BaseTest.waitforElement(tab_Related, Config.timeouts.LONGWAIT.get()).click();
			protocolproductversion(Protocol);
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(Btn_SubmitForApproval, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_ProductSubmit, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.scrollup(500);
			BaseTest.waitforElement(JuptrStatus_PendingApproval, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(JuptrStatus_PendingApproval.isDisplayed(),
					"Product version status is not pending approval");
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}

	public void protocolproductversion(String Protocol) {
		try {
			BaseTest.waitforElement(btn_New_PPV, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Search_Protocols, Config.timeouts.LONGWAIT.get()).sendKeys(Protocol);
			BaseTest.waitforElement(Search_Protocols, Config.timeouts.LONGWAIT.get()).sendKeys(Keys.ENTER);
			BaseTest.waitforElement(link_ProtocolsResult, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(txtbox_SpecificationNumber, Config.timeouts.LONGWAIT.get()).sendKeys("123");
			BaseTest.waitforElement(txtbox_CollectionDescription, Config.timeouts.LONGWAIT.get())
					.sendKeys("TestAutoDescription");
			BaseTest.waitforElement(dd_ATChannel, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(ATChanel_Clinical, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(txtbox_ATJoinPrefix, Config.timeouts.LONGWAIT.get()).sendKeys("A");
			BaseTest.waitforElement(txtbox_RTJoinPrefix, Config.timeouts.LONGWAIT.get()).sendKeys("R");
			BaseTest.waitforElement(Btn_SaveAddress, Config.timeouts.LONGWAIT.get()).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}

	public void doseLevelCreation(String DoseLevel, String ProductVersion, String Protocol) {
		try {

			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(globalSearch, Config.timeouts.LONGWAIT.get()).sendKeys(ProductVersion);
			BaseTest.waitforElement(globalSearch, Config.timeouts.LONGWAIT.get()).sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			WebElement pvaj = driver.findElement(By.xpath("(//a[contains(@title,'A_PVAJ')])[2]"));
			BaseTest.waitforElement(pvaj, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(tab_Related, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_New_DL, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_NextAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(TxtBox_DoseLevelName, Config.timeouts.LONGWAIT.get()).sendKeys(DoseLevel);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Created Dose Level is : " + DoseLevel);
			BaseTest.waitforElement(Search_Protocols, Config.timeouts.LONGWAIT.get()).sendKeys(Protocol);
			BaseTest.waitforElement(Search_Protocols, Config.timeouts.LONGWAIT.get()).sendKeys(Keys.ENTER);
			BaseTest.waitforElement(link_ProtocolsResult, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(ChckBox_Active, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(lkup_draft, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Picklist_Approve, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(TxtBox_TotalcellAmount, Config.timeouts.LONGWAIT.get()).sendKeys("1");
			BaseTest.waitforElement(TxtBox_TargetDoseAmount, Config.timeouts.LONGWAIT.get()).sendKeys("2");
			BaseTest.waitforElement(datePicker_Effective_Start_DL, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Effective_Start_today, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(datePicker_Effective_End_DL, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Effective_EndDate_NextMonth_Arrow, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Effective_EndDate_Fifteenthday_NextMonth, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_Save_Account, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());

		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}

	}

	public void doseScheduleCreation(String ProductVersion, String DoseSchedule, String Protocol) {
		try {
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(globalSearch, Config.timeouts.LONGWAIT.get()).sendKeys(ProductVersion);
			BaseTest.waitforElement(globalSearch, Config.timeouts.LONGWAIT.get()).sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			WebElement pvaj = driver.findElement(By.xpath("(//a[contains(@title,'A_PVAJ')])[2]"));
			BaseTest.waitforElement(pvaj, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(tab_Related, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(span_DoseLevel, Config.timeouts.MEDIUMWAIT.get());
			BaseTest.scrolldowntoVisibility(span_DoseLevel);
			BaseTest.waitforElement(span_DoseSchedules, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(btn_NewDoseSchedule, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(Btn_NextAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(TxtBox_DoseScheduleName, Config.timeouts.LONGWAIT.get()).sendKeys(DoseSchedule);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Created Dose Schedule is : " + DoseSchedule);
			BaseTest.waitforElement(Search_Protocols, Config.timeouts.LONGWAIT.get()).sendKeys(Protocol);
			BaseTest.waitforElement(Search_Protocols, Config.timeouts.LONGWAIT.get()).sendKeys(Keys.ENTER);
			BaseTest.waitforElement(link_ProtocolsResult, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(ChckBox_Active, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(lkup_draft, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Picklist_Approve, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_Save_Account, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());

		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}
	
	public void apheresisOnboardingTemplate(String AphersisOBT)
	{
		try {
			BaseTest.waitforElement(Btn_NewAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Radiobtn_ApheresisOBT, Config.timeouts.LONGWAIT.get()).click();		
			BaseTest.waitforElement(Btn_NextAccount, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(textbox_OnboardingTemplate, Config.timeouts.LONGWAIT.get()).sendKeys(AphersisOBT);
			BaseTest.waitforElement(checkbox_Active_onboarding, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(Btn_Save_Account, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(driver.findElement(By.xpath("//h1[@title='"+AphersisOBT+"']")), Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(driver.findElement(By.xpath("//h1[@title='"+AphersisOBT+"']")).isDisplayed());
			System.out.print("Created Apheresis OnboardingTemplate is : " + AphersisOBT);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Created Apheresis OnboardingTemplate is : " + AphersisOBT);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}
}
