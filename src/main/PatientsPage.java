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

public class PatientsPage {
	WebDriver driver;
	public String enrollment;

	/**
	 * Instantiates a new Treatments page.
	 * 
	 * @param driver the driver
	 */
	Logger logger = Logger.getLogger("PatientsPage");
	
	

	public PatientsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;		
		PropertyConfigurator.configure("log4j.properties");
	}

	/*
	 * UI maps for Patients Page 
	 */

	//Patient and Enrollment 
	@FindBy(xpath = "//li[@class='slds-button slds-button--neutral slds-truncate']/a[@title='New']")
	public WebElement Btn_New;
	
	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//iframe")
	public WebElement iframe;	

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//input[@id='input-3']")
	public WebElement txtbx_FirstName;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//input[@id='input-4']")
	public WebElement txtbx_LastName;
	
	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//input[@id='input-5']")
	public WebElement txtbx_DOB;
	
	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='selectEnrollmentType']")
	public WebElement select_EnrollmentType;
	
	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//input[@id='input-19']")
	public WebElement txtbx_SubjectNum;
	
	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='protocol']")
	public WebElement select_Protocol;	

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
	
	@FindBy(xpath = "//div[@class='slds-button-group slds-align_absolute-center']//button[text()='Save']")
	public WebElement btn_Save;	

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
	 * Reusable Methods for Patients Page.
	 */
	
	/* This method covers creation Patient and Enrollment
	 */

	public String patient_Enrollment_Creation(String FName, String LName,String SubjectNum) {
		try {			
			BaseTest.waitforElement(Btn_New, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());			
			driver.switchTo().frame(iframe);
			BaseTest.waitforElement(txtbx_FirstName, Config.timeouts.LONGWAIT.get()).sendKeys(FName);
			BaseTest.waitforElement(txtbx_LastName, Config.timeouts.LONGWAIT.get()).sendKeys(LName);
			BaseTest.waitforElement(txtbx_DOB, Config.timeouts.LONGWAIT.get()).sendKeys("22-JAN-1992");
			BaseTest.waitforElement(select_EnrollmentType, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(select_EnrollmentType);
			Utilities.selectfromdropdownwebelement(select_EnrollmentType,"Clinical");
			BaseTest.waitforElement(txtbx_SubjectNum, Config.timeouts.LONGWAIT.get()).sendKeys(SubjectNum);
			Utilities.selectfromdropdownwebelement(select_Protocol,"AutomationProtocol");
			Utilities.selectfromdropdownwebelement(select_SiteOfCare,"AutomationSite");
			Utilities.selectfromdropdownwebelement(select_primaryContact,"Automatin_NonPrescriber");
			BaseTest.waitforElement(Chkbx_Verify, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(Chkbx_Verify);
			BaseTest.waitforElement(Chkbx_Verify, Config.timeouts.LONGWAIT.get()).click();
			Utilities.selectfromdropdownwebelement(select_VerifierName,"005m0000002coR7AAI");
			BaseTest.waitforElement(Chkbx_ReadyToVerify, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_Patient_UploadFiles, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			String workingDir = System.getProperty("user.dir");
			Runtime.getRuntime()
					.exec(workingDir+"\\src\\resources\\JunoUploadFile.exe");
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(btn_Save, Config.timeouts.LONGWAIT.get()).click();			
			driver.switchTo().parentFrame();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());				
			BaseTest.waitforElement(txt_Enrollment, Config.timeouts.LONGWAIT.get());		
			Assert.assertTrue(txt_Enrollment.isDisplayed());
			enrollment = driver.findElement(By.xpath(
					"//div[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO,"Created Patient Enrollment name is : " + enrollment);	
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO,"The exception is : " + e.getMessage());
			Assert.fail();			
		}
		
		return enrollment;
	}
	
	/* This method covers patient, Enrollment Approval
	 */

	public void patient_Enrollment_Approval(String FName, String LName,String SubjectNum, String EnrollmentNum, String Username, String Password) {
		try {			
			BaseTest.waitforElement(combobx_GlobalSearch, Config.timeouts.LONGWAIT.get()).sendKeys(EnrollmentNum);
			BaseTest.waitforElement(combobx_GlobalSearch, Config.timeouts.LONGWAIT.get()).sendKeys(Keys.ENTER);
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(link_EnrollmentNum, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());			
			BaseTest.waitforElement(btn_Verify, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());			
			driver.switchTo().frame(iframe);
			BaseTest.waitforElement(txtbx_FirstName_Verify, Config.timeouts.LONGWAIT.get()).sendKeys(FName);
			BaseTest.waitforElement(txtbx_LastName_Verify, Config.timeouts.LONGWAIT.get()).sendKeys(LName);
			BaseTest.waitforElement(txtbx_DOB_Verify, Config.timeouts.LONGWAIT.get()).sendKeys("22-JAN-1992");			
			BaseTest.waitforElement(txtbx_SubjectNum_Verify, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(txtbx_SubjectNum_Verify);			
			BaseTest.waitforElement(txtbx_SubjectNum_Verify, Config.timeouts.LONGWAIT.get()).sendKeys(SubjectNum);			
			Utilities.selectfromdropdownwebelement(select_Protocol,"AutomationProtocol");			
			BaseTest.waitforElement(btn_Verify_Enroll, Config.timeouts.LONGWAIT.get()).click();	
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txtbx_Username, Config.timeouts.LONGWAIT.get()).sendKeys(Username);	
			BaseTest.waitforElement(txtbx_Password, Config.timeouts.LONGWAIT.get()).sendKeys(Password);
			BaseTest.waitforElement(btn_Authenticate, Config.timeouts.LONGWAIT.get()).click();	
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(btn_Sign, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			driver.switchTo().parentFrame();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());				
			BaseTest.waitforElement(txt_Enrollment, Config.timeouts.LONGWAIT.get());		
			Assert.assertTrue(txt_Enrollment.isDisplayed());			
			ExtentTestManager.getTest().log(LogStatus.INFO,"Patient and Enrollment are verified");				
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO,"The exception is : " + e.getMessage());
			Assert.fail();			
		}
	}	
}
