package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import extentReports.ExtentTestManager;
import main.BaseTest;
import main.Config;
import main.Excelmapping;
import main.Utilities;
import resources.ExcelReader;

/**
 * @author gSandeep
 *
 */

public class TC_CongaTemplates_ActualTreatment  extends BaseTest {

	BaseTest baseTest;
	ExcelReader excel;
	public String testDataPath;
	public String sheetName;
	public String rowId;
	public String browser;
	public String testCaseName;
	public String environmentURL;
	public String applicationServerUrl;

	public TC_CongaTemplates_ActualTreatment() {
	}

	@Test(description ="Creation Of Conga Template of object type ActualTreatment")
	public void CongaTemplates_ActualTreatment_Creation() {
		try {
			BaseTest objbaseTest = new BaseTest();
			String sClassname = getClass().toString();
			String[] objectsname = sClassname.split("\\.");
			String strClassName = objectsname[1];
			String[] mastertestdata = objbaseTest.readMasterTestDatasheet(strClassName);
			testCaseName = mastertestdata[0];
			sheetName = mastertestdata[1];
			environmentURL = mastertestdata[2];
			testDataPath = mastertestdata[3];
			browser = mastertestdata[4];
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
		try {
			step01(browser);
			step02();
			step03();
			step04(browser);
			step05();
			step06();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
 
	/**
	 * Step 01. Login with Super User
	 */
	public void step01(String strBrowser) throws Exception {
		excel = new ExcelReader(testDataPath, sheetName, rowId = strBrowser);
		excel.RExcelWriter(Excelmapping.CongaTemplateCreation.CONGATEMPLATENAME.get(),Utilities.generateRandomNameWithTimestamp());
		baseTest = new BaseTest(environmentURL, strBrowser);
		System.out.println("*****Starting to execute: TC_CongaTemplates_ActualTreatment****");
		try {
			baseTest.loginPage.login(excel.RExcelReader(Excelmapping.Login.SUPER_USERNAME.get()),
					excel.RExcelReader(Excelmapping.Login.SUPER_PASSWORD.get()));
			ExtentTestManager.getTest().log(LogStatus.INFO,"Login as Super User is successful");	
			baseTest.loginPage.appSelection_Applauncher(excel.RExcelReader(Excelmapping.Login.APP_LAUCH.get()));
			baseTest.loginPage.appSelection_Applauncher(excel.RExcelReader(Excelmapping.Login.APP_LAUNCHER.get())); 
		} catch (Exception e) {
			System.out.println("There was an unexpected reason" + e.getMessage());
		}
	}

	/**
	 * Step 02. Case congaTemplates ActualTreatment Creation and submitting for Approval 
	 */

	public void step02() throws Exception {
		try {
			BaseTest objbasetest = new BaseTest();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			objbasetest.congaTemplatesPage.congaTemplates_ActualTreatment(					
					excel.RExcelReader(Excelmapping.CongaTemplateCreation.CONGATEMPLATENAME.get()));
			} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}

	/**
	 * Step 03 Logout With Super User
	 */

	public void step03() throws Exception {
		try {
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			baseTest.logoutPage.logout();			
			ExtentTestManager.getTest().log(LogStatus.INFO,"Logout as Super User is successful");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("*****Ending to execute: TC_CongaTemplates_ActualTreatment*****");
		}
	}
	
	/**
	 * Step 04. Login with business admin
	 */
	public void step04(String strBrowser) throws Exception {
		excel = new ExcelReader(testDataPath, sheetName, rowId = strBrowser);		
		baseTest = new BaseTest(environmentURL, strBrowser);
		System.out.println("*****Starting to execute: TC_CongaTemplates_ActualTreatment****");
		try {
			baseTest.loginPage.login(excel.RExcelReader(Excelmapping.Login.ADMIN_USERNAME.get()),
					excel.RExcelReader(Excelmapping.Login.ADMIN_PASSWORD.get()));
			ExtentTestManager.getTest().log(LogStatus.INFO,"Login as Bussiness Admin for Approval is successful");
			baseTest.loginPage.appSelection_Applauncher(excel.RExcelReader(Excelmapping.Login.APP_LAUCH.get()));
			baseTest.loginPage.appSelection_Applauncher(excel.RExcelReader(Excelmapping.Login.APP_LAUNCHER.get())); 
		} catch (Exception e) {
			System.out.println("There was an unexpected reason" + e.getMessage());
		}
	}
	
	/**
	 * Step 05. Case congaTemplates ActualTreatment Approval
	 */

	public void step05() throws Exception {
		try {
			BaseTest objbasetest = new BaseTest();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			objbasetest.congaTemplatesPage.congaTemplates_ActualTreatment_Approval(					
					excel.RExcelReader(Excelmapping.CongaTemplateCreation.CONGATEMPLATENAME.get()));
			} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}
	
	/**
	 * Step 06 Logout With business admin
	 */

	public void step06() throws Exception {
		try {
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			baseTest.logoutPage.logout();
			ExtentTestManager.getTest().log(LogStatus.INFO,"Logout as Bussiness Admin is successful");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("*****Ending to execute: TC_CongaTemplates_ActualTreatment*****");
		}
	}
}
