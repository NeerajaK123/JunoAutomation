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

	// Conga Template
	@FindBy(xpath = "//li[@class='slds-button slds-button--neutral slds-truncate']/a[@title='New']")
	public WebElement Btn_New;

	@FindBy(xpath = "//span[contains(text(),'Name')]/ancestor::label/following-sibling::input")
	public WebElement input_CongaTemplateName;

	@FindBy(xpath = "(//a[contains(text(),'--None--')])[1]")
	public WebElement PickList_object;
	
	@FindBy(xpath = "//li[@role='presentation']/a[@title='Treatment(Actual)']")
	public WebElement PickList_object_Treatment_Actual;
	
	@FindBy(xpath = "//li[@role='presentation']/a[@title='Product Order']")
	public WebElement PickList_object_Product_Order;
	
	@FindBy(xpath = "//li[@role='presentation']/a[@title='Shipment Authorization']")
	public WebElement PickList_object_Shipment_Authorization;
	
	@FindBy(xpath = "//li[@role='presentation']/a[@title='MNC Collection Procedure Record']")
	public WebElement PickList_object_MNC_Collection_Procedure_Record;	

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
	
	@FindBy(xpath = "//div[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span")
	public WebElement createdCongatemplate;
	
	
	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//a[@title='Related']")
	public WebElement tab_Related;
	
	@FindBy(xpath = "//span[text()='Notes & Attachments']")
	public WebElement link_NotesAndAttachments;
	
	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//div[text()='Upload Files']")
	public WebElement btn_UploadFiles;	
	
	@FindBy(xpath = "//span[text()='Done']")
	public WebElement btn_Done;
	
	@FindBy(xpath = "//a[@title='Submit for Approval']")
	public WebElement btn_SubmitforApproval;
	
	@FindBy(xpath = "//div[@class='forceModalActionContainer--footerAction forceModalActionContainer']/button[2]/span[contains(text(),'Submit')]")
	public WebElement btn_Submit;
	
	// Conga Template Approval
	@FindBy(xpath = "//input[@class='slds-input slds-text-color_default slds-p-left--none slds-size--1-of-1 input default input uiInput uiInputTextForAutocomplete uiInput--{remove}']")
	public WebElement combobx_GlobalSearch;
	
	@FindBy(xpath = "//span[contains(text(),'in Conga Templates')]")
	public WebElement Search_InCongaTemplate;
	
	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//table//tbody//tr[1]//th[1]//a")
	public WebElement link_CongaTemplate;
	
	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//span[@class='slds-card__header-title slds-truncate slds-m-right--xx-small' and text()='Approval History']")
	public WebElement link_ApprovalHistory;
	
	@FindBy(xpath = "//div[@class='windowViewMode-normal oneContent active lafPageHost']//div[text()='Approve']")
	public WebElement btn_Approve;
	
	@FindBy(xpath = "//span[text()='Approve']")
	public WebElement btn_Approvewithcomments;
	
	
	/*
	 * Reusable Methods for CongaTemplates Page.
	 */
	
	/* This method covers creation of Conga Templates -> ObjectType_ActualTreatment creation and submit for Approval 
	 */

	public void congaTemplates_ActualTreatment(String Name) {
		try {			
			BaseTest.waitforElement(Btn_New, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(input_CongaTemplateName, Config.timeouts.LONGWAIT.get()).sendKeys(Name);
			BaseTest.waitforElement(PickList_object, Config.timeouts.LONGWAIT.get()).click();
			PickList_object_Treatment_Actual.click();
			BaseTest.waitforElement(PickList_Group, Config.timeouts.LONGWAIT.get()).click();			
			PickList_Group_ScheduleConfirmationForm.click();
			//BaseTest.waitforElement(Chkbx_ActiveConga, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(span_Country, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_MoveselectiontoChosen, Config.timeouts.LONGWAIT.get()).click();			
			BaseTest.waitforElement(Chkbx_ContinueConga, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(Chkbx_ContinueConga);								
			BaseTest.waitforElement(Chkbx_ContinueConga, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_Save_CongaTemplate, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(txt_CongaTemplate, Config.timeouts.LONGWAIT.get());		
			Assert.assertTrue(txt_CongaTemplate.isDisplayed());
			String congaTemplate = createdCongatemplate.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO,"Created Conga Template Treatment(Actual) name is : " + congaTemplate);
						
			BaseTest.waitforElement(tab_Related, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(link_NotesAndAttachments, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(btn_UploadFiles, Config.timeouts.LONGWAIT.get()).click();			
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			String workingDir = System.getProperty("user.dir");
			Runtime.getRuntime()
					.exec(workingDir+"\\src\\resources\\JunoUploadFile.exe");
			Thread.sleep(7000);
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(btn_Done, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.SHORTWAIT.get());
			ExtentTestManager.getTest().log(LogStatus.INFO,"File is uploaded in Notes & Attachments");
			driver.navigate().back();
			BaseTest.waitforElement(btn_SubmitforApproval, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(btn_Submit, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			ExtentTestManager.getTest().log(LogStatus.INFO,"Submitted for Approval");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO,"The exception is : " + e.getMessage());
			Assert.fail();			
		}
	}
	
	/* This method covers creation of Conga Templates -> ObjectType_ActualTreatment Approval 
	 */

	public void congaTemplates_ActualTreatment_Approval(String Name) {
		try {			
			BaseTest.waitforElement(combobx_GlobalSearch, Config.timeouts.LONGWAIT.get()).sendKeys(Name);
			BaseTest.waitforElement(Search_InCongaTemplate, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(link_CongaTemplate, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(tab_Related, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(link_ApprovalHistory, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(btn_Approve, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(btn_Approvewithcomments, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			ExtentTestManager.getTest().log(LogStatus.INFO,"Conga Template is Approved");
			
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
			BaseTest.waitforElement(Btn_New, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(input_CongaTemplateName, Config.timeouts.LONGWAIT.get()).sendKeys(Name);
			BaseTest.waitforElement(PickList_object, Config.timeouts.LONGWAIT.get()).click();
			PickList_object_Product_Order.click();
			BaseTest.waitforElement(PickList_Group, Config.timeouts.LONGWAIT.get()).click();			
			PickList_Group_ScheduleConfirmationForm.click();			
			BaseTest.waitforElement(span_Country, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_MoveselectiontoChosen, Config.timeouts.LONGWAIT.get()).click();			
			BaseTest.waitforElement(Chkbx_ContinueConga, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(Chkbx_ContinueConga);
			BaseTest.pleasewait(Config.timeouts.SHORTWAIT.get());						
			BaseTest.waitforElement(Chkbx_ContinueConga, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_Save_CongaTemplate, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(txt_CongaTemplate, Config.timeouts.LONGWAIT.get());		
			Assert.assertTrue(txt_CongaTemplate.isDisplayed());
			String congaTemplate = driver.findElement(By.xpath(
					"//div[@class='slds-page-header__title slds-m-right--small slds-truncate slds-align-middle']/span"))
					.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO,"Created Conga Template Product Order name is : " + congaTemplate);
						
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
			BaseTest.waitforElement(Btn_New, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(input_CongaTemplateName, Config.timeouts.LONGWAIT.get()).sendKeys(Name);
			BaseTest.waitforElement(PickList_object, Config.timeouts.LONGWAIT.get()).click();
			PickList_object_Shipment_Authorization.click();
			BaseTest.waitforElement(PickList_Group, Config.timeouts.LONGWAIT.get()).click();			
			PickList_Group_ScheduleConfirmationForm.click();			
			BaseTest.waitforElement(span_Country, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_MoveselectiontoChosen, Config.timeouts.LONGWAIT.get()).click();			
			BaseTest.waitforElement(Chkbx_ContinueConga, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(Chkbx_ContinueConga);
			BaseTest.pleasewait(Config.timeouts.SHORTWAIT.get());					
			BaseTest.waitforElement(Chkbx_ContinueConga, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_Save_CongaTemplate, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(txt_CongaTemplate, Config.timeouts.LONGWAIT.get());		
			Assert.assertTrue(txt_CongaTemplate.isDisplayed());
			String congaTemplate = createdCongatemplate.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO,"Created Conga Template Shipment Authorization name is : " + congaTemplate);
						
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO,"The exception is : " + e.getMessage());
			Assert.fail();			
		}
	}
	
	/* This method covers creation of Conga Templates -> ObjectType_MNCCollectionProcedureRecord
	 */

	public void congaTemplates_MNCCollectionProcedureRecord(String Name) {
		try {			
			BaseTest.waitforElement(Btn_New, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			BaseTest.waitforElement(input_CongaTemplateName, Config.timeouts.LONGWAIT.get()).sendKeys(Name);
			BaseTest.waitforElement(PickList_object, Config.timeouts.LONGWAIT.get()).click();
			PickList_object_MNC_Collection_Procedure_Record.click();
			BaseTest.waitforElement(PickList_Group, Config.timeouts.LONGWAIT.get()).click();			
			PickList_Group_ScheduleConfirmationForm.click();			
			BaseTest.waitforElement(span_Country, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_MoveselectiontoChosen, Config.timeouts.LONGWAIT.get()).click();			
			BaseTest.waitforElement(Chkbx_ContinueConga, Config.timeouts.LONGWAIT.get());
			BaseTest.scrolldowntoVisibility(Chkbx_ContinueConga);
			BaseTest.pleasewait(Config.timeouts.SHORTWAIT.get());					
			BaseTest.waitforElement(Chkbx_ContinueConga, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.waitforElement(btn_Save_CongaTemplate, Config.timeouts.LONGWAIT.get()).click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			BaseTest.waitforElement(txt_CongaTemplate, Config.timeouts.LONGWAIT.get());		
			Assert.assertTrue(txt_CongaTemplate.isDisplayed());
			String congaTemplate = createdCongatemplate.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO,"Created Conga Template MNC Collection Procedure Record name is : " + congaTemplate);
						
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("The exception is : " + e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO,"The exception is : " + e.getMessage());
			Assert.fail();			
		}
	}
	
}
