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

public class TreatmentsPage {
	WebDriver driver;
	public String ActualTreatment;
	/**
	 * Instantiates a new Treatments page.
	 * 
	 * @param driver
	 *            the driver
	 */
	Logger logger = Logger.getLogger("TreatmentsPage");

	public TreatmentsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		PropertyConfigurator.configure("log4j.properties");
	}

	/*
	 * UI maps for Treatments Page
	 */

	// Actual,Product order,Reservation
	@FindBy(xpath = "//div[@class='uiInput uiAutocomplete uiInput--default']/input[@title='Search Salesforce']")
	public WebElement globalSearch;

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//input[@name='search-input']")
	public WebElement conbobx_Search;

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']//tr[1]//th[1]//span//a")
	public WebElement link_Element;

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//a[@title='Show 6 more actions']")
	public WebElement btn_showmore_trt;

	@FindBy(xpath = "//a[@title='Verify Dose Assignments']")
	public WebElement btn_VerifyDoseAssignments;

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//a[@title='Related']")
	public WebElement tab_Related;

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//a[@title='Details']")
	public WebElement tab_Details;

	@FindBy(xpath = "//span[@class='slds-card__header-title slds-truncate slds-m-right--xx-small' and text()='Treatments']")
	public WebElement link_Treatments;

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//div[text()='New Actual Treatment']")
	public WebElement btn_NewActualTreatment;

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//div[text()='Submit']")
	public WebElement btn_Submit;

	@FindBy(xpath = "//span[@class='slds-card__header-title slds-truncate slds-m-right--xx-small' and text()='Product Orders']")
	public WebElement link_ProductOrders;

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//div[text()='New Product Order']")
	public WebElement btn_NewProductOrder;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='department']")
	public WebElement select_delvLocation;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='deliveryAddress']")
	public WebElement select_deliveryAddress;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='deliveryContact']")
	public WebElement select_deliveryContact;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']//input[@name='plannedDPPackagingDate']")
	public WebElement datepicker_plannedDPPackagingDate;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']//input[@name='plannedDPPickupDate']")
	public WebElement datepicker_plannedDPPickupDate;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']//input[@name='plannedDPPackageExpiry']")
	public WebElement datepicker_plannedDPPackageExpiry;

	@FindBy(xpath = "//button[@class='slds-button slds-button_icon-container']//span[text()='Next Month']//preceding-sibling::lightning-primitive-icon")
	public WebElement datepicker_NextMonth;

	@FindBy(xpath = "//table[@class='slds-datepicker__month']//tr[2]//td[3]//span")
	public WebElement datepicker_day;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='cryoport']")
	public WebElement select_cryoport;

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//span[text()='Product Order']")
	public WebElement txt_ProductOrder;

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//span[text()='Product Order Status']")
	public WebElement txt_ProductOrderStaus_Scheduling;

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//div[text()='Confirm']")
	public WebElement btn_Confirm;

	@FindBy(xpath = "//button[text()='Confirm']")
	public WebElement btn_Confirm1;

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//div[text()='Edit']")
	public WebElement btn_Edit;

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//span[text()='Edit Product Order']")
	public WebElement txt_EditProductOrder;

	@FindBy(xpath = "(//input[@name='actualDPPackageDate'])[1]")
	public WebElement datepicker_actualDPPackageDate;

	@FindBy(xpath = "(//input[@name='actualDPPickupDate'])[1]")
	public WebElement datepicker_actualDPPickupDate;

	@FindBy(xpath = "(//input[@name='actualDPDeliveryDate'])[1]")
	public WebElement datepicker_actualDPDeliveryDate;

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//a[@class='slds-grid slds-grid--vertical-align-center slds-grid--align-center sldsButtonHeightFix']//lightning-icon")
	public WebElement btn_Moreoptions;

	@FindBy(xpath = "//a[@title='Cancel Product Order']")
	public WebElement link_CancelProductOrder;

	@FindBy(xpath = "//h4[text()='Error']")
	public WebElement txt_Error;

	@FindBy(xpath = "//button[@title='Close this window']")
	public WebElement btn_Closethiswindow;

	@FindBy(xpath = "//li[@class='slds-button slds-button--neutral slds-truncate']/a[@title='New']")
	public WebElement Btn_New;

	@FindBy(xpath = "(//div[@class='windowViewMode-normal oneContent active lafPageHost']//iframe)[1]")
	public WebElement iframe;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='siteOfCare']")
	public WebElement select_SiteOfCare;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='primaryCenter']")
	public WebElement select_primaryCenter;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='protocol']")
	public WebElement select_Protocol;

	@FindBy(xpath = "//span[text()='New Actual Treatment']")
	public WebElement txt_NewActualTreatment;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='apheresisCenter']")
	public WebElement select_apheresisCenter;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='collectionPickupLocation']")
	public WebElement select_collectionPickupLocation;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='collectionPickupContact']")
	public WebElement select_collectionPickupContact;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='preference']")
	public WebElement select_preference;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']//input[@name='collectionAppointment']")
	public WebElement datepicker_collectionAppointment;

	@FindBy(xpath = "//button[text()='Today']")
	public WebElement btn_Today;

	@FindBy(xpath = "(//td[@aria-current='date']/following-sibling::td)[1]")
	public WebElement btn_Todays_NextDay;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='manufacturingSite']")
	public WebElement select_manufacturingSite;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='manufacturingSite2']")
	public WebElement select_manufacturingSite2;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']//input[@name='MFGDelivery']")
	public WebElement datepicker_MFGDelivery;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='productVersion']")
	public WebElement select_productVersion;

	@FindBy(xpath = "//div[@class='slds-button-group slds-align_absolute-center slds-custom-button']//button[text()='Save']")
	public WebElement btn_Save;

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//span[text()='Treatment']")
	public WebElement txt_Treatment;

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//span[text()='Edit Treatment']")
	public WebElement txt_EditTreatment;

	@FindBy(xpath = "//div[contains(text(),'JOIN Details')]")
	public WebElement tab_JoinDetails;

	@FindBy(xpath = "//span[contains(text(),'JOIN Details')]")
	public WebElement tab_TrtPageJoinDetails;

	@FindBy(xpath = "//span[contains(text(),'Dose Assignment Status')]/ancestor::div[@class='test-id__field-label-container slds-form-element__label']/following-sibling::div/span/span[contains(text(),'Draft')]")
	public WebElement DoseAssignmentStatus_Draft;

	@FindBy(xpath = "//span[contains(text(),'Dose Assignment Status')]/ancestor::div[@class='test-id__field-label-container slds-form-element__label']/following-sibling::div/span/span[contains(text(),'Pending Verification')]")
	public WebElement DoseAssignmentStatus_PendingVerification;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='doseLevel']")
	public WebElement select_doseLevel;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='doseSchedule']")
	public WebElement select_doseSchedule;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='doseVerifier']")
	public WebElement select_verifier;

	@FindBy(xpath = "(//input[@name='MFGDelivery'])[1]")
	public WebElement date_MFGDelivery;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='reasonForChange']")
	public WebElement select_reasonForChange;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='CauseOfChange']")
	public WebElement select_CauseOfChange;

	@FindBy(xpath = "//a[@class='slds-grid slds-grid--vertical-align-center slds-grid--align-center sldsButtonHeightFix']//lightning-icon[@class='slds-button__icon slds-icon-utility-down slds-icon_container forceIcon']//lightning-primitive-icon")
	public WebElement btn_showmore;

	@FindBy(xpath = "//a[@title='Convert Treatment']")
	public WebElement link_ConvertTreatment;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='patientLookup']")
	public WebElement select_patientLookup;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']//select[@name='enrollmentLookup']")
	public WebElement select_enrollmentLookup;

	@FindBy(xpath = "//article[@class='slds-card']//button[text()='Save']")
	public WebElement btn_Save_ActualPatient;

	// Submit treatment for manual join
	@FindBy(xpath = "//label[text()='* JOIN']//parent::lightning-input//input")
	public WebElement txtbx_Join;

	@FindBy(xpath = "//select[@name='verifierLookup']")
	public WebElement select_verifierLookup;

	@FindBy(xpath = "//button[text()='Save']")
	public WebElement btn_SaveJoin;

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//span[text()='Details']//parent::a")
	public WebElement link_Details;

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//div[@class='test-id__field-label-container slds-form-element__label']//span[text()='JOIN Status']")
	public WebElement txt_JOINStatus;

	// Treatment manual join approval
	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//lightning-icon[@class='slds-button__icon slds-icon-utility-down slds-icon_container forceIcon']")
	public WebElement link_moreoptions;

	@FindBy(xpath = "//a[@title='Verify JOIN']")
	public WebElement link_verifyJoin;

	@FindBy(xpath = "//input[@name='red']")
	public WebElement txtbx_verifyJoinName;

	@FindBy(xpath = "//button[text()='Verify']")
	public WebElement btn_Verify;

	@FindBy(xpath = "//input[@class='slds-input input' and @type='text']")
	public WebElement txtbx_admin;

	@FindBy(xpath = "//input[@class='slds-input input' and @type='password']")
	public WebElement txtbx_password;

	@FindBy(xpath = "//button[text()='Authenticate']")
	public WebElement btn_Authenticate;

	@FindBy(xpath = "//button[text()='Sign']")
	public WebElement btn_Sign;

	/*
	 * Reusable Methods for Treatments Page.
	 */

	/*
	 * This method covers creation of Actual treatment, Change Reason and Product
	 * order
	 */

	public void actualTreatment_ChangeReason_ProductOrder(String Apheresis, String EnrollmentNum, String Site,
			String NonPrescriber, String manufacturingSite, String ProductVersion, String Department, String Address) {
		try {
			BaseTest.waitforElement(conbobx_Search, Config.timeouts.LONGWAIT.get()).sendKeys(EnrollmentNum);
			BaseTest.waitforElement(conbobx_Search, Config.timeouts.LONGWAIT.get()).sendKeys(Keys.ENTER);
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(link_Element, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(tab_Related, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(link_Treatments, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(btn_NewActualTreatment, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(iframe, Config.timeouts.LONGWAIT.get());
			driver.switchTo().frame(iframe);
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txt_NewActualTreatment, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.scrolldowntoVisibility(select_apheresisCenter);
			Utilities.selectfromdropdownwebelement(select_apheresisCenter, Apheresis);
			String pickuplocation = Site + " " + "||" + " " + Address;
			Utilities.selectfromdropdownwebelement(select_collectionPickupLocation, pickuplocation);
			Utilities.selectfromdropdownwebelement(select_collectionPickupContact, NonPrescriber);
			Utilities.selectfromdropdownwebelement(select_preference, "Preference 1");
			BaseTest.waitforElement(datepicker_collectionAppointment, Config.timeouts.LONGWAIT.get()).click();
			btn_Today.click();
			BaseTest.waitforElement(select_manufacturingSite, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(select_manufacturingSite);
			Utilities.selectfromdropdownwebelement(select_manufacturingSite, manufacturingSite);
			Utilities.selectfromdropdownwebelement(select_manufacturingSite2, manufacturingSite);
			BaseTest.waitforElement(datepicker_MFGDelivery, Config.timeouts.LONGWAIT.get()).click();
			btn_Today.click();
			Utilities.selectfromdropdownwebelement(select_productVersion, ProductVersion);
			BaseTest.waitforElement(btn_Save, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			driver.switchTo().parentFrame();
			BaseTest.waitforElement(txt_Treatment, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(txt_Treatment.isDisplayed());
			String ActualTreatment = driver.findElement(By.xpath(
					"//div[@class='windowViewMode-normal oneContent active lafPageHost']//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Created Actual Treatment name is : " + ActualTreatment);
			BaseTest.waitforElement(btn_Submit, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(txt_Treatment, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(txt_Treatment.isDisplayed());
			Thread.sleep(3000);
			String Join = driver.findElement(By.xpath(
					"//div[@class='windowViewMode-normal oneContent active lafPageHost']//span[text()='JOIN']//parent::div//div[@class='slds-form-element__static slds-truncate']/span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Auto Assigned JOIN is : " + Join);
			BaseTest.waitforElement(btn_Edit, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txt_EditTreatment, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(date_MFGDelivery, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(datepicker_NextMonth, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(datepicker_day, Config.timeouts.LONGWAIT.get()).click();
			Utilities.selectfromdropdownwebelement(select_reasonForChange, "Scheduling Conflict");
			Utilities.selectfromdropdownwebelement(select_CauseOfChange, "Courier");
			BaseTest.waitforElement(btn_Save, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txt_Treatment, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(txt_Treatment.isDisplayed());
			ExtentTestManager.getTest().log(LogStatus.INFO, "Treatment change reason is performed");
			// Product order
			BaseTest.waitforElement(tab_Related, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(link_ProductOrders, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(btn_NewProductOrder, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			driver.switchTo().frame(iframe);
			BaseTest.waitforElement(select_delvLocation, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(select_delvLocation);
			// Utilities.selectfromdropdownwebelement(select_delvLocation,Department);
			BaseTest.waitforElement(select_delvLocation, Config.timeouts.LONGWAIT.get()).click();
			;
			WebElement delvLocation = driver.findElement(By.xpath("//option[contains(@label,'" + Department + "')]"));
			delvLocation.click();
			BaseTest.pleasewait(Config.timeouts.SHORTWAIT.get());
			String DelvAddress = Department + " " + "||" + " " + Address;
			BaseTest.waitforElement(select_deliveryAddress, Config.timeouts.LONGWAIT.get()).click();
			WebElement delvadd = driver.findElement(By.xpath("//option[contains(@label,'" + DelvAddress + "')]"));
			delvadd.click();
			// Utilities.selectfromdropdownwebelement(,DelvAddress );
			BaseTest.waitforElement(select_deliveryContact, Config.timeouts.LONGWAIT.get()).click();
			WebElement delvcontact = driver.findElement(By.xpath("//option[contains(@label,'" + NonPrescriber + "')]"));
			delvcontact.click();
			// Utilities.selectfromdropdownwebelement(, "003m0000017QlLhAAK");
			Utilities.selectfromdropdownwebelement(select_manufacturingSite, manufacturingSite);
			BaseTest.waitforElement(datepicker_plannedDPPackagingDate, Config.timeouts.LONGWAIT.get()).click();
			btn_Today.click();
			BaseTest.waitforElement(datepicker_plannedDPPickupDate, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(datepicker_plannedDPPickupDate);
			BaseTest.waitforElement(datepicker_plannedDPPickupDate, Config.timeouts.LONGWAIT.get()).click();
			btn_Today.click();
			BaseTest.waitforElement(datepicker_plannedDPPackageExpiry, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(datepicker_NextMonth, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(datepicker_day, Config.timeouts.LONGWAIT.get()).click();
			Utilities.selectfromdropdownwebelement(select_cryoport, "No");
			BaseTest.waitforElement(btn_Save, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			driver.switchTo().parentFrame();
			BaseTest.waitforElement(txt_ProductOrder, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(txt_ProductOrder.isDisplayed());
			String ProductOrder = driver.findElement(By.xpath(
					"//div[@class='windowViewMode-normal oneContent active lafPageHost']//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Created Product Order name is : " + ProductOrder);
			Assert.assertTrue(txt_ProductOrderStaus_Scheduling.isDisplayed());
			String ProductOrderStaus = driver.findElement(By.xpath(
					"//div[@class='windowViewMode-normal oneContent active lafPageHost']//span[text()='Product Order Status']//parent::div//following-sibling::div//span//span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Created Product Order Status is : " + ProductOrderStaus);
			BaseTest.waitforElement(btn_Confirm, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_Confirm1, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txt_ProductOrderStaus_Scheduling, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(txt_ProductOrderStaus_Scheduling);
			Assert.assertTrue(txt_ProductOrderStaus_Scheduling.isDisplayed());
			String ProductOrderStausConfirm = driver.findElement(By.xpath(
					"//div[@class='windowViewMode-normal oneContent active lafPageHost']//span[text()='Product Order Status']//parent::div//following-sibling::div//span//span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Created Product Order Status after confirm is : " + ProductOrderStausConfirm);

			BaseTest.waitforElement(btn_Edit, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txt_EditProductOrder, Config.timeouts.LONGWAIT.get()).click();

			BaseTest.waitforElement(datepicker_actualDPPackageDate, Config.timeouts.LONGWAIT.get()).click();
			btn_Today.click();
			BaseTest.waitforElement(btn_Save, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txt_ProductOrderStaus_Scheduling, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(txt_ProductOrderStaus_Scheduling);
			Assert.assertTrue(txt_ProductOrderStaus_Scheduling.isDisplayed());
			String ProductOrderStausPakaged = driver.findElement(By.xpath(
					"//div[@class='windowViewMode-normal oneContent active lafPageHost']//span[text()='Product Order Status']//parent::div//following-sibling::div//span//span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Created Product Order Status after Changing Actual DP Packaging Date is :"
							+ ProductOrderStausPakaged);

			BaseTest.waitforElement(btn_Edit, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(select_manufacturingSite, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(select_manufacturingSite);
			BaseTest.waitforElement(datepicker_actualDPPickupDate, Config.timeouts.LONGWAIT.get()).click();
			btn_Today.click();
			BaseTest.waitforElement(btn_Save, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txt_ProductOrderStaus_Scheduling, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(txt_ProductOrderStaus_Scheduling);
			Assert.assertTrue(txt_ProductOrderStaus_Scheduling.isDisplayed());
			String ProductOrderStausDPTrans = driver.findElement(By.xpath(
					"//div[@class='windowViewMode-normal oneContent active lafPageHost']//span[text()='Product Order Status']//parent::div//following-sibling::div//span//span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Created Product Order Status after Changing Actual DP Pickup Date is : "
							+ ProductOrderStausDPTrans);

			BaseTest.waitforElement(btn_Edit, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(select_manufacturingSite, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(select_manufacturingSite);
			BaseTest.waitforElement(datepicker_actualDPDeliveryDate, Config.timeouts.LONGWAIT.get()).click();
			btn_Todays_NextDay.click();
			BaseTest.waitforElement(btn_Save, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txt_ProductOrderStaus_Scheduling, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(txt_ProductOrderStaus_Scheduling);
			Assert.assertTrue(txt_ProductOrderStaus_Scheduling.isDisplayed());
			String ProductOrderStausDPDelivered = driver.findElement(By.xpath(
					"//div[@class='windowViewMode-normal oneContent active lafPageHost']//span[text()='Product Order Status']//parent::div//following-sibling::div//span//span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Created Product Order Status after Changing Actual DP Delivery Date is : "
							+ ProductOrderStausDPDelivered);

			BaseTest.waitforElement(btn_Moreoptions, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(link_CancelProductOrder, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			Assert.assertTrue(txt_Error.isDisplayed());
			String ProductOrderCancelled = driver.findElement(By.xpath("//div[@class='bBody']")).getText();
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"When Product Order is cancelled the following Error message is displayed : "
							+ ProductOrderCancelled);
			BaseTest.waitforElement(btn_Closethiswindow, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}
	/*
	 * This method covers creation of Actual treatment with validation of dose
	 * verification status
	 */

public String actualTreatment_DoseLevelDoseScheduleStatus(String Apheresis, String EnrollmentNum, String Site,
		String NonPrescriber,String manufacturingSite,String ProductVersion,String Department, String Address,String DL,String DS,String verifier)
{
	
		try {
			BaseTest.waitforElement(conbobx_Search, Config.timeouts.LONGWAIT.get()).sendKeys(EnrollmentNum);
			BaseTest.waitforElement(conbobx_Search, Config.timeouts.LONGWAIT.get()).sendKeys(Keys.ENTER);
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(link_Element, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(tab_Related, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(link_Treatments, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(btn_NewActualTreatment, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(iframe, Config.timeouts.LONGWAIT.get());
			driver.switchTo().frame(iframe);
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txt_NewActualTreatment, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.scrolldowntoVisibility(select_apheresisCenter);
			Utilities.selectfromdropdownwebelement(select_apheresisCenter, Apheresis);
			String pickuplocation = Site+" "+"||"+" "+Address;
			Utilities.selectfromdropdownwebelement(select_collectionPickupLocation, pickuplocation);
			Utilities.selectfromdropdownwebelement(select_collectionPickupContact, NonPrescriber);
			Utilities.selectfromdropdownwebelement(select_preference, "Preference 1");
			BaseTest.waitforElement(datepicker_collectionAppointment, Config.timeouts.LONGWAIT.get()).click();
			btn_Today.click();
			BaseTest.waitforElement(select_manufacturingSite, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(select_manufacturingSite);
			Utilities.selectfromdropdownwebelement(select_manufacturingSite,manufacturingSite);
			Utilities.selectfromdropdownwebelement(select_manufacturingSite2, manufacturingSite);
			BaseTest.waitforElement(datepicker_MFGDelivery, Config.timeouts.LONGWAIT.get()).click();
			btn_Today.click();
			Utilities.selectfromdropdownwebelement(select_productVersion,ProductVersion);
			BaseTest.waitforElement(btn_Save, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			driver.switchTo().parentFrame();
			BaseTest.waitforElement(txt_Treatment, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(txt_Treatment.isDisplayed());
			ActualTreatment = driver.findElement(By.xpath(
					"//div[@class='windowViewMode-normal oneContent active lafPageHost']//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Created Actual Treatment name is : " + ActualTreatment);
			BaseTest.waitforElement(btn_Submit, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(txt_Treatment, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(txt_Treatment.isDisplayed());
			String Join = driver.findElement(By.xpath(
					"//div[@class='windowViewMode-normal oneContent active lafPageHost']//span[text()='JOIN']//parent::div//div[@class='slds-form-element__static slds-truncate']/span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Auto Assigned JOIN is : " + Join);
			BaseTest.waitforElement(btn_Edit, Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(btn_Edit, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txt_EditTreatment, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.scrolldowntoVisibility(tab_JoinDetails);
			Utilities.selectfromdropdownwebelement(select_doseLevel,DL);
			BaseTest.waitforElement(btn_Save, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(tab_Details, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(tab_TrtPageJoinDetails, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(tab_TrtPageJoinDetails);
			Assert.assertTrue(DoseAssignmentStatus_Draft.isDisplayed());
			String DoseAssignmnetStatus_Draft = driver.findElement(By.xpath(
					"//span[contains(text(),'Dose Assignment Status')]/ancestor::div[@class='test-id__field-label-container slds-form-element__label']/following-sibling::div/span/span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Dose Verification Status with DL and Without DS: "
							+ DoseAssignmnetStatus_Draft);
			BaseTest.waitforElement(btn_Edit, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txt_EditTreatment, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(tab_JoinDetails, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(tab_JoinDetails);
			Utilities.selectfromdropdownwebelement(select_doseSchedule,DS);
			Utilities.selectfromdropdownwebelement(select_verifier,verifier);
			BaseTest.waitforElement(btn_Save, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(tab_Details, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(tab_TrtPageJoinDetails, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.scrolldowntoVisibility(tab_TrtPageJoinDetails);		
			Assert.assertTrue(DoseAssignmentStatus_PendingVerification.isDisplayed());
			String DoseAssignmentStatus_PendingVerification = driver.findElement(By.xpath(
					"//span[contains(text(),'Dose Assignment Status')]/ancestor::div[@class='test-id__field-label-container slds-form-element__label']/following-sibling::div/span/span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Dose Verification Status with DL,DS,Verifier is: "
							+ DoseAssignmentStatus_PendingVerification);	
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
		return ActualTreatment;
}

	public void doseapproval(String Treatment) {
		try {
			BaseTest.waitforElement(conbobx_Search, Config.timeouts.LONGWAIT.get()).sendKeys(Treatment);
			BaseTest.waitforElement(conbobx_Search, Config.timeouts.LONGWAIT.get()).sendKeys(Keys.ENTER);
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(link_Element, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(btn_showmore_trt, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_VerifyDoseAssignments, Config.timeouts.LONGWAIT.get()).click();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}

	/*
	 * This method covers creation of Actual treatment Manual Join
	 */
	public void actualTreatment_ManualJoin(String EnrollmentNum, String ProductVersion, String JoinName,
			String Apheresis, String Site, String Address, String manufacturingSite, String NonPrescriber) {
		try {
			BaseTest.waitforElement(conbobx_Search, Config.timeouts.LONGWAIT.get()).sendKeys(EnrollmentNum);
			BaseTest.waitforElement(conbobx_Search, Config.timeouts.LONGWAIT.get()).sendKeys(Keys.ENTER);
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(link_Element, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(tab_Related, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(link_Treatments, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(btn_NewActualTreatment, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(iframe, Config.timeouts.LONGWAIT.get());
			driver.switchTo().frame(iframe);
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txt_NewActualTreatment, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.scrolldowntoVisibility(select_apheresisCenter);
			Utilities.selectfromdropdownwebelement(select_apheresisCenter, Apheresis);
			String pickuplocation = Site + " " + "||" + " " + Address;
			Utilities.selectfromdropdownwebelement(select_collectionPickupLocation, pickuplocation);
			Utilities.selectfromdropdownwebelement(select_collectionPickupContact, NonPrescriber);
			Utilities.selectfromdropdownwebelement(select_preference, "Preference 1");
			BaseTest.waitforElement(datepicker_collectionAppointment, Config.timeouts.LONGWAIT.get()).click();
			btn_Today.click();
			BaseTest.waitforElement(select_manufacturingSite, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(select_manufacturingSite);
			Utilities.selectfromdropdownwebelement(select_manufacturingSite, manufacturingSite);
			Utilities.selectfromdropdownwebelement(select_manufacturingSite2, manufacturingSite);
			BaseTest.waitforElement(datepicker_MFGDelivery, Config.timeouts.LONGWAIT.get()).click();
			btn_Today.click();
			Utilities.selectfromdropdownwebelement(select_productVersion, ProductVersion);
			BaseTest.waitforElement(btn_Save, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			driver.switchTo().parentFrame();
			BaseTest.waitforElement(txt_Treatment, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(txt_Treatment.isDisplayed());
			String ActualTreatment = driver.findElement(By.xpath(
					"//div[@class='windowViewMode-normal oneContent active lafPageHost']//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Created Actual Treatment name is : " + ActualTreatment);
			BaseTest.waitforElement(btn_Submit, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txtbx_Join, Config.timeouts.LONGWAIT.get()).sendKeys(JoinName);
			Utilities.selectfromdropdownwebelement(select_verifierLookup, "Vaibhav Agnihotri");
			BaseTest.waitforElement(btn_SaveJoin, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txt_Treatment, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(txt_Treatment.isDisplayed());
			BaseTest.waitforElement(link_Details, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txt_JOINStatus, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(txt_JOINStatus);
			String JoinStus = driver.findElement(By.xpath(
					"//div[@class='windowViewMode-normal oneContent active lafPageHost']//span[text()='JOIN Status']//parent::div//following-sibling::div//span//span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Actual Treatment Manual JOIN status after submit is : " + JoinStus);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}

	/*
	 * This method covers creation of Actual treatment Manual Join Approval
	 */
	public void actualTreatment_ManualJoin_Approval(String JoinName, String admin, String password) {
		try {
			BaseTest.waitforElement(globalSearch, Config.timeouts.LONGWAIT.get()).sendKeys(JoinName);
			BaseTest.waitforElement(globalSearch, Config.timeouts.LONGWAIT.get()).sendKeys(Keys.ENTER);
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(link_Element, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(link_moreoptions, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(link_verifyJoin, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txtbx_verifyJoinName, Config.timeouts.LONGWAIT.get()).sendKeys(JoinName);
			BaseTest.waitforElement(btn_Verify, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txtbx_admin, Config.timeouts.LONGWAIT.get()).sendKeys(admin);
			BaseTest.waitforElement(txtbx_password, Config.timeouts.LONGWAIT.get()).sendKeys(password);
			BaseTest.waitforElement(btn_Authenticate, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(btn_Sign, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txt_Treatment, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(txt_Treatment.isDisplayed());
			BaseTest.waitforElement(link_Details, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txt_JOINStatus, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(txt_JOINStatus);
			String JoinStus = driver.findElement(By.xpath(
					"//div[@class='windowViewMode-normal oneContent active lafPageHost']//span[text()='JOIN Status']//parent::div//following-sibling::div//span//span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Actual Treatment Manual JOIN status after Approval is : " + JoinStus);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}

	/*
	 * This method covers creation of Reservation treatment and conversion to Actual
	 * treatment
	 */

	public void reservationTreatment_To_Actual(String LName, String EnrollmentNum,String Site,String NonPrescriber,String Protocol,String Apheresis,String manufacturingSite,String ProductVersion,String Address) {
		try {
			BaseTest.waitforElement(Btn_New, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			Utilities.selectfromdropdownwebelement(select_SiteOfCare, Site);
			Utilities.selectfromdropdownwebelement(select_primaryCenter, NonPrescriber);
			Utilities.selectfromdropdownwebelement(select_Protocol, Protocol);
			BaseTest.waitforElement(select_apheresisCenter, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(select_apheresisCenter);
			Utilities.selectfromdropdownwebelement(select_apheresisCenter, Apheresis);
			String pickuplocation = Site + " " + "||" + " " + Address;
			Utilities.selectfromdropdownwebelement(select_collectionPickupLocation, pickuplocation);
			Utilities.selectfromdropdownwebelement(select_collectionPickupContact, NonPrescriber);
			Utilities.selectfromdropdownwebelement(select_preference, "Preference 1");
			BaseTest.waitforElement(datepicker_collectionAppointment, Config.timeouts.LONGWAIT.get()).click();
			btn_Today.click();
			BaseTest.waitforElement(select_manufacturingSite, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(select_manufacturingSite);
			Utilities.selectfromdropdownwebelement(select_manufacturingSite, manufacturingSite);
			Utilities.selectfromdropdownwebelement(select_manufacturingSite2, manufacturingSite);
			BaseTest.waitforElement(datepicker_MFGDelivery, Config.timeouts.LONGWAIT.get()).click();
			btn_Today.click();
			Utilities.selectfromdropdownwebelement(select_productVersion, ProductVersion);
			BaseTest.waitforElement(btn_Save, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txt_Treatment, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(txt_Treatment.isDisplayed());
			String ReservationTreatment = driver.findElement(By.xpath(
					"//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Created Reservation Treatment name is : " + ReservationTreatment);
			BaseTest.waitforElement(btn_showmore, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(link_ConvertTreatment, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(select_patientLookup, Config.timeouts.LONGWAIT.get()).click();
			String Patient = driver.findElement(By.xpath("//option[contains(text(),'" + LName + "')]")).getText();
			Utilities.selectfromdropdownwebelement(select_patientLookup, Patient);
			BaseTest.waitforElement(select_enrollmentLookup, Config.timeouts.LONGWAIT.get()).click();
			String Enrollment = driver.findElement(By.xpath("//option[contains(text(),'" + EnrollmentNum + "')]"))
					.getText();
			Utilities.selectfromdropdownwebelement(select_enrollmentLookup, Enrollment);
			BaseTest.waitforElement(btn_Save_ActualPatient, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			driver.switchTo().frame(iframe);
			Utilities.selectfromdropdownwebelement(select_apheresisCenter, Apheresis);
			Utilities.selectfromdropdownwebelement(select_collectionPickupLocation, pickuplocation);
			Utilities.selectfromdropdownwebelement(select_collectionPickupContact, NonPrescriber);
			Utilities.selectfromdropdownwebelement(select_preference, "Preference 1");
			BaseTest.waitforElement(datepicker_collectionAppointment, Config.timeouts.LONGWAIT.get()).click();
			btn_Today.click();
			BaseTest.waitforElement(select_manufacturingSite, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(select_manufacturingSite);
			Utilities.selectfromdropdownwebelement(select_manufacturingSite, manufacturingSite);
			Utilities.selectfromdropdownwebelement(select_manufacturingSite2, manufacturingSite);
			BaseTest.waitforElement(datepicker_MFGDelivery, Config.timeouts.LONGWAIT.get()).click();
			btn_Today.click();
			Utilities.selectfromdropdownwebelement(select_productVersion, ProductVersion);
			BaseTest.waitforElement(btn_Save, Config.timeouts.LONGWAIT.get()).click();
			driver.switchTo().parentFrame();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(txt_Treatment, Config.timeouts.LONGWAIT.get());
			Assert.assertTrue(txt_Treatment.isDisplayed());
			String ActualTreatment = driver.findElement(By.xpath(
					"//div[@class='windowViewMode-normal oneContent active lafPageHost']//h1[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Converted Reservation Treatment to Actual Treatment name is : " + ActualTreatment);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			Assert.fail();
		}
	}

}
