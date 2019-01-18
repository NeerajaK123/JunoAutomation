package main;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import extentReports.ExtentTestManager;
import listeners.TestListener;

public class ManufacturingScheduleConfigurationPage {
	WebDriver driver;
	

	/**
	 * Instantiates a new Manufacturing Schedule Configuration page.
	 * 
	 * @param driver the driver
	 */
	Logger logger = Logger.getLogger("ManufacturingScheduleConfigurationPage");
	
	

	public ManufacturingScheduleConfigurationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;		
		PropertyConfigurator.configure("log4j.properties");
	}

	/*
	 * UI maps for Manufacturing Schedule Configuration Page 
	 */

	//Manufacturing Schedule Configuration
	@FindBy(xpath = "//li[@class='slds-button slds-button--neutral slds-truncate']/a[@title='New']")
	public WebElement Btn_New;
	
	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//iframe")
	public WebElement iframe;	
	
	@FindBy(xpath = "//input[@title='Search Protocols']")
	public WebElement combobx_Protocol;
	
	@FindBy(xpath = "//span[contains(text(),'in Protocols')]")
	public WebElement search_Protocol;
	
	@FindBy(xpath = "//table[@class='forceRecordLayout slds-table slds-table_cell-buffer slds-table_bordered uiVirtualDataGrid--default uiVirtualDataGrid']//tr[1]//td[1]//a")
	public WebElement link_Protocol;
	
	@FindBy(xpath = "//input[@title='Search Product Versions']")
	public WebElement combobx_ProductVersion;
	
	@FindBy(xpath = "//span[contains(text(),'in Product Versions')]")
	public WebElement search_ProductVersion;
	
	@FindBy(xpath = "//table[@class='forceRecordLayout slds-table slds-table_cell-buffer slds-table_bordered uiVirtualDataGrid--default uiVirtualDataGrid']//tr[1]//td[1]//a")
	public WebElement link_ProductVersion;
	
	@FindBy(xpath = "//input[@title='Search Accounts']")
	public WebElement combobx_ManufacturingSite;
	
	@FindBy(xpath = "//span[contains(text(),'in Accounts')]")
	public WebElement search_ManufacturingSite;
	
	@FindBy(xpath = "//table[@class='forceRecordLayout slds-table slds-table_cell-buffer slds-table_bordered uiVirtualDataGrid--default uiVirtualDataGrid']//tr[1]//td[1]//a")
	public WebElement link_ManufacturingSite;	
	
	@FindBy(xpath = "(//a[@class='datePicker-openIcon display'])[2]")
	public WebElement date_EffectiveStart;
	
	@FindBy(xpath = "//a[@title='Go to previous month']")
	public WebElement date_PreviousMonth;
	
	@FindBy(xpath = "(//td[@class='uiDayInMonthCell'])[15]")
	public WebElement datePrev_day;	
	
	@FindBy(xpath = "(//a[@class='datePicker-openIcon display'])[1]")
	public WebElement date_EffectiveEnd;	
	
	@FindBy(xpath = "//a[@title='Go to next month']")
	public WebElement date_NextMonth;
	
	@FindBy(xpath = "(//td[@class='uiDayInMonthCell'])[15]")
	public WebElement dateNext_day;
	
	@FindBy(xpath = "//span[contains(text(),'Status')]/ancestor::span/following-sibling::div/div/div/div/a[contains(text(),'Draft')]")
	public WebElement picklist_Staus;
	
	@FindBy(xpath = "//li[@role='presentation']//a[@title='Approved']")
	public WebElement picklist_Staus_Approved;
	
	@FindBy(xpath = "//span[text()='Active']//parent::label[@class='label inputLabel uiLabel-left form-element__label uiLabel']//following-sibling::input")
	public WebElement checkbx_Active;
	
	@FindBy(xpath = "//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']")
	public WebElement btn_Save;
	
	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//span[text()='Manufacturing Schedule Configuration']")
	public WebElement txt_ManufacturingScheduleConfiguration;	
	
	
	
	
	
	
	
	

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='site']")
	public WebElement select_SiteOfCare;
	
	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='primaryContactLookup']")
	public WebElement select_primaryContact;

	@FindBy(xpath = "//label[@class='slds-checkbox__label']//span[text()='I verify that I have reviewed the patient and enrollment information in JuPTR+ against the source document.']//preceding-sibling::span")
	public WebElement Chkbx_Verify;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='verifierName']")
	public WebElement select_VerifierName;
	
	@FindBy(xpath = "//label[@class='slds-checkbox__label']//span[text()='Ready To Verify?']//preceding-sibling::span")
	public WebElement Chkbx_ReadyToVerify;
	
	@FindBy(xpath = "//span[@class='slds-file-selector__button slds-button slds-button_neutral']")
	public WebElement btn_Patient_UploadFiles;
	
	

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//span[text()='Enrollment']")
	public WebElement txt_Enrollment;	
	
	// Patient and Enrollment Approval
	@FindBy(xpath = "//input[@class='slds-input slds-text-color_default slds-p-left--none slds-size--1-of-1 input default input uiInput uiInputTextForAutocomplete uiInput--{remove}']")
	public WebElement combobx_GlobalSearch;	
	
	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//table//tbody//tr[1]//th[1]//a")
	public WebElement link_EnrollmentNum;
	
	@FindBy(xpath = "//div[text()='Verify']")
	public WebElement btn_Verify;	
	
	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//input[@id='input-4']")
	public WebElement txtbx_FirstName_Verify;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//input[@id='input-5']")
	public WebElement txtbx_LastName_Verify;
	
	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//input[@id='input-6']")
	public WebElement txtbx_DOB_Verify;
	
	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//input[@id='input-22']")
	public WebElement txtbx_SubjectNum_Verify;
	
	@FindBy(xpath = "//div[@class='slds-button-group slds-align_absolute-center']//button[text()='Verify']")
	public WebElement btn_Verify_Enroll;	
	
	@FindBy(xpath = "//span[text()='Username']//parent::label//following::input[1]")
	public WebElement txtbx_Username;
	
	@FindBy(xpath = "//span[text()='Password']//parent::label//following::input[1]")
	public WebElement txtbx_Password;
	
	@FindBy(xpath = "//button[text()='Authenticate']")
	public WebElement btn_Authenticate;
	
	@FindBy(xpath = "//button[text()='Sign']")
	public WebElement btn_Sign;
	
	
	
	/*
	 * Reusable Methods for Manufacturing Schedule Configuration Page.
	 */
	
	/* This method covers creation Manufacturing Schedule Configuration
	 */

	public void Manufacturing_Schedule_Configuration_Creation(String ProtocolName, String ProductVersion,String ManufacturingSite) {
		try {			
			BaseTest.waitforElement(Btn_New, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());	
			BaseTest.waitforElement(combobx_Protocol, Config.timeouts.LONGWAIT.get()).sendKeys(ProtocolName);
			BaseTest.waitforElement(search_Protocol, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(link_Protocol, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(combobx_ProductVersion, Config.timeouts.LONGWAIT.get()).sendKeys(ProductVersion);
			BaseTest.waitforElement(search_ProductVersion, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(link_ProductVersion, Config.timeouts.LONGWAIT.get()).click();			
			BaseTest.waitforElement(combobx_ManufacturingSite, Config.timeouts.LONGWAIT.get()).sendKeys(ManufacturingSite);
			BaseTest.waitforElement(search_ManufacturingSite, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(link_ManufacturingSite, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(date_EffectiveStart, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(date_PreviousMonth, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(datePrev_day, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(date_EffectiveEnd, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(date_NextMonth, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(dateNext_day, Config.timeouts.LONGWAIT.get()).click();			
			BaseTest.waitforElement(picklist_Staus, Config.timeouts.LONGWAIT.get()).click();
			picklist_Staus_Approved.click();
			BaseTest.waitforElement(checkbx_Active, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_Save, Config.timeouts.LONGWAIT.get()).click();			
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());				
			BaseTest.waitforElement(txt_ManufacturingScheduleConfiguration, Config.timeouts.LONGWAIT.get());		
			Assert.assertTrue(txt_ManufacturingScheduleConfiguration.isDisplayed());
			String ManufacturingScheduleConfiguration = driver.findElement(By.xpath(
					"//div[@class='windowViewMode-normal oneContent active lafPageHost']//div[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO,"Created Manufacturing Schedule Configuration name is : " + ManufacturingScheduleConfiguration);			
					
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO,"The exception is : " + e.getMessage());
			Assert.fail();			
		}
	}
		
	
}
