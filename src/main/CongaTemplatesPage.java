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

public class CongaTemplatesPage {
	WebDriver driver;

	/**
	 * Instantiates a new Treatments page.
	 * 
	 * @param driver the driver
	 */
	Logger logger = Logger.getLogger("CongaTemplatesPage");
	
	

	public CongaTemplatesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;		
		PropertyConfigurator.configure("log4j.properties");
	}

	/*
	 * UI maps for CongaTemplates Page 
	 */

	// No Need To Register
	@FindBy(xpath = "//li[@class='slds-button slds-button--neutral slds-truncate']/a[@title='New']")
	public WebElement Btn_New;

	@FindBy(xpath = "//span[contains(text(),'Name')]/ancestor::label/following-sibling::input")
	public WebElement input_CongaTemplateName;

	@FindBy(xpath = "(//a[contains(text(),'--None--')])[1]")
	public WebElement PickList_object;
	
	@FindBy(xpath = "//li[@role='presentation']/a[@title='Treatment(Actual)']")
	public WebElement PickList_object_Treatment_Actual;

	@FindBy(xpath = "//a[contains(text(),'--None--')]")
	public WebElement PickList_Group;
	
	@FindBy(xpath = "//li[@role='presentation']/a[@title='Schedule Confirmation Form']")
	public WebElement PickList_Group_ScheduleConfirmationForm;

	@FindBy(xpath = "//span[contains(text(),'Active')]/ancestor::label/following-sibling::input")
	public WebElement Chkbx_ActiveConga;

	@FindBy(xpath = "//span[text()='United States']")
	public WebElement span_Country;
	
	@FindBy(xpath = "//button[@title='Move selection to Chosen']")
	public WebElement btn_MoveselectiontoChosen;
	
	@FindBy(xpath = "//a[contains(text(),'Draft')]")
	public WebElement PickList_Status;
	
	@FindBy(xpath = "//li[@role='presentation']/a[@title='Approved']")
	public WebElement PickList_Status_Approved;
	
	@FindBy(xpath = "//span[contains(text(),'Continue')]/ancestor::label/following-sibling::input")
	public WebElement Chkbx_ContinueConga;
	
	@FindBy(xpath = "//div[@class='forceModalActionContainer--footerAction forceModalActionContainer']/button[3]/span[contains(text(),'Save')]")
	public WebElement btn_Save_CongaTemplate;

	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//span[text()='Conga Template']")
	public WebElement txt_CongaTemplate;
	
	/*
	 * Reusable Methods for CongaTemplates Page.
	 */
	
	/* This method covers creation of Conga Templates -> ObjectType_ActualTreatment 
	 */

	public void congaTemplates_ActualTreatment(String Name) {
		try {
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(Btn_New, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(input_CongaTemplateName, Config.timeouts.LONGWAIT.get()).sendKeys(Name);
			BaseTest.waitforElement(PickList_object, Config.timeouts.LONGWAIT.get()).click();
			PickList_object_Treatment_Actual.click();
			BaseTest.waitforElement(PickList_Group, Config.timeouts.LONGWAIT.get()).click();			
			PickList_Group_ScheduleConfirmationForm.click();
			BaseTest.waitforElement(Chkbx_ActiveConga, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(span_Country, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_MoveselectiontoChosen, Config.timeouts.LONGWAIT.get()).click();			
			BaseTest.waitforElement(PickList_Status, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(PickList_Status);
			BaseTest.pleasewait(Config.timeouts.SHORTWAIT.get());
			BaseTest.waitforElement(PickList_Status, Config.timeouts.LONGWAIT.get()).click();
			PickList_Status_Approved.click();			
			BaseTest.waitforElement(Chkbx_ContinueConga, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_Save_CongaTemplate, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(txt_CongaTemplate, Config.timeouts.LONGWAIT.get());		
			Assert.assertTrue(txt_CongaTemplate.isDisplayed());
			String congaTemplate = driver.findElement(By.xpath(
					"//div[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO,"Created Conga Template Treatment(Actual) name is : " + congaTemplate);
						
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO,"The exception is : " + e.getMessage());
			Assert.fail();			
		}
	}
	
	/* This method covers creation of Conga Templates -> ObjectType_ProductOrder 
	 */

	public void congaTemplates_ProductOrder(String Name) {
		try {
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(Btn_New, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(input_CongaTemplateName, Config.timeouts.LONGWAIT.get()).sendKeys(Name);
			BaseTest.waitforElement(PickList_object, Config.timeouts.LONGWAIT.get()).click();
			PickList_object_Treatment_Actual.click();
			BaseTest.waitforElement(PickList_Group, Config.timeouts.LONGWAIT.get()).click();			
			PickList_Group_ScheduleConfirmationForm.click();
			BaseTest.waitforElement(Chkbx_ActiveConga, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(span_Country, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_MoveselectiontoChosen, Config.timeouts.LONGWAIT.get()).click();			
			BaseTest.waitforElement(PickList_Status, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(PickList_Status);
			BaseTest.pleasewait(Config.timeouts.SHORTWAIT.get());
			BaseTest.waitforElement(PickList_Status, Config.timeouts.LONGWAIT.get()).click();
			PickList_Status_Approved.click();			
			BaseTest.waitforElement(Chkbx_ContinueConga, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_Save_CongaTemplate, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(txt_CongaTemplate, Config.timeouts.LONGWAIT.get());		
			Assert.assertTrue(txt_CongaTemplate.isDisplayed());
			String congaTemplate = driver.findElement(By.xpath(
					"//div[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO,"Created Conga Template Treatment(Actual) name is : " + congaTemplate);
						
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO,"The exception is : " + e.getMessage());
			Assert.fail();			
		}
	}
	
	/* This method covers creation of Conga Templates -> ObjectType_ShipmentAuthorisation 
	 */

	public void congaTemplates_ShipmentAuthorisation(String Name) {
		try {
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(Btn_New, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(input_CongaTemplateName, Config.timeouts.LONGWAIT.get()).sendKeys(Name);
			BaseTest.waitforElement(PickList_object, Config.timeouts.LONGWAIT.get()).click();
			PickList_object_Treatment_Actual.click();
			BaseTest.waitforElement(PickList_Group, Config.timeouts.LONGWAIT.get()).click();			
			PickList_Group_ScheduleConfirmationForm.click();
			BaseTest.waitforElement(Chkbx_ActiveConga, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(span_Country, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_MoveselectiontoChosen, Config.timeouts.LONGWAIT.get()).click();			
			BaseTest.waitforElement(PickList_Status, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(PickList_Status);
			BaseTest.pleasewait(Config.timeouts.SHORTWAIT.get());
			BaseTest.waitforElement(PickList_Status, Config.timeouts.LONGWAIT.get()).click();
			PickList_Status_Approved.click();			
			BaseTest.waitforElement(Chkbx_ContinueConga, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_Save_CongaTemplate, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(txt_CongaTemplate, Config.timeouts.LONGWAIT.get());		
			Assert.assertTrue(txt_CongaTemplate.isDisplayed());
			String congaTemplate = driver.findElement(By.xpath(
					"//div[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO,"Created Conga Template Treatment(Actual) name is : " + congaTemplate);
						
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO,"The exception is : " + e.getMessage());
			Assert.fail();			
		}
	}
	
}
