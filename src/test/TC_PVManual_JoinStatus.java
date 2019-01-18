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

public class TC_PVManual_JoinStatus extends BaseTest {

	BaseTest baseTest;
	ExcelReader excel;
	public String testDataPath;
	public String sheetName;
	public String rowId;
	public String browser;
	public String testCaseName;
	public String environmentURL;
	public String applicationServerUrl;

	public TC_PVManual_JoinStatus() {
	}

	@Test(description = "Creation of PVManual and verification of Join Status")
	public void PVManual_JoinStatus() {
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
			step07(browser);
			step08();
			step09();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Step 01. Login as super user
	 */
	public void step01(String strBrowser) throws Exception {
		excel = new ExcelReader(testDataPath, sheetName, rowId = strBrowser);
		excel.RExcelWriter(Excelmapping.DataCreation.ProductVersionManulJoin.get(),
				Utilities.generatePVNameMJWithTimestamp());
			baseTest = new BaseTest(environmentURL, strBrowser);
		System.out.println("*****Starting to execute: TC_PVManual_JoinStatus****");
		try {
			baseTest.loginPage.login(excel.RExcelReader(Excelmapping.Login.SUPER_USERNAME.get()),
					excel.RExcelReader(Excelmapping.Login.SUPER_PASSWORD.get()));
			ExtentTestManager.getTest().log(LogStatus.INFO, "Login as super user is Successfull");
			baseTest.loginPage
					.appSelection_Applauncher(excel.RExcelReader(Excelmapping.DataCreation.APP_ProductVersion.get()));
		} catch (Exception e) {
			System.out.println("There was an unexpected reason" + e.getMessage());
		}
	}

	/**
	 * Step 02. Site creation
	 */

	public void step02() throws Exception {
		try {
			BaseTest objbasetest = new BaseTest();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			objbasetest.JAMSAccount.productversion_ManualJoin(
					excel.RExcelReader(Excelmapping.DataCreation.ProductVersionManulJoin.get()),
					excel.RExcelReader(Excelmapping.DataCreation.Product.get()),
					excel.RExcelReader(Excelmapping.DataCreation.Protocol.get()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}

	/**
	 * Step 03 Logout
	 */

	public void step03() throws Exception {
		try {
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			baseTest.logoutPage.logout();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Logged out as super user is Successfull");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			System.out.println("*****Ending to execute: TC_PVManual_JoinStatus*****");
		}
	}

	/**
	 * Step 01. Login as admin user
	 */
	public void step04(String strBrowser) throws Exception {
		excel = new ExcelReader(testDataPath, sheetName, rowId = strBrowser);
		baseTest = new BaseTest(environmentURL, strBrowser);
		System.out.println("*****Starting to execute: TC_PVManual_JoinStatus****");
		try {
			baseTest.loginPage.login(excel.RExcelReader(Excelmapping.Login.ADMIN_USERNAME.get()),
					excel.RExcelReader(Excelmapping.Login.ADMIN_PASSWORD.get()));
			baseTest.loginPage.appSelection_Applauncher(excel.RExcelReader(Excelmapping.DataCreation.APP_JUPTR.get()));
			ExtentTestManager.getTest().log(LogStatus.INFO, "Logged in as Admin for approval is Successfull");
		} catch (Exception e) {
			System.out.println("There was an unexpected reason" + e.getMessage());
		}
	}

	public void step05() throws Exception {
		try {
			BaseTest objbasetest = new BaseTest();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			objbasetest.JAMSAccount.approvingPPV_PV(excel.RExcelReader(Excelmapping.DataCreation.ProductVersionManulJoin.get()));
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			objbasetest.JAMSAccount.accountApprovalJams(excel.RExcelReader(Excelmapping.DataCreation.ProductVersionManulJoin.get()));			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}

	public void step06() throws Exception {
		try {
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			baseTest.logoutPage.logout();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Logged out as Admin is Successfull");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			System.out.println("*****Ending to execute: TC_PVManual_JoinStatus*****");
		}
	}
	
	/**
	 * Step 01. Login as admin user
	 */
	public void step07(String strBrowser) throws Exception {
		excel = new ExcelReader(testDataPath, sheetName, rowId = strBrowser);
		baseTest = new BaseTest(environmentURL, strBrowser);
		System.out.println("*****Starting to execute: TC_PVManual_JoinStatus****");
		try {
			baseTest.loginPage.login(excel.RExcelReader(Excelmapping.Login.ADMIN_USERNAME.get()),
					excel.RExcelReader(Excelmapping.Login.ADMIN_PASSWORD.get()));
			baseTest.loginPage.appSelection_Applauncher(excel.RExcelReader(Excelmapping.DataCreation.APP_JUPTR.get()));
			baseTest.loginPage.appSelection_Applauncher(excel.RExcelReader(Excelmapping.DataCreation.APP_MSC.get()));
			ExtentTestManager.getTest().log(LogStatus.INFO, "Logged in as Admin for approval is Successfull");
		} catch (Exception e) {
			System.out.println("There was an unexpected reason" + e.getMessage());
		}
	}

	public void step08() throws Exception {
		try {
			BaseTest objbasetest = new BaseTest();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			objbasetest.manufacturingScheduleConfigurationPage.Manufacturing_Schedule_Configuration_Creation(excel.RExcelReader(Excelmapping.DataCreation.Protocol.get()),
					excel.RExcelReader(Excelmapping.DataCreation.ProductVersionManulJoin.get()),
					excel.RExcelReader(Excelmapping.DataCreation.ManufacturingSite.get()));			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}

	public void step09() throws Exception {
		try {
			BaseTest.pleasewait(Config.timeouts.MEDIUMWAIT.get());
			baseTest.logoutPage.logout();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Logged out as Admin is Successfull");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExtentTestManager.getTest().log(LogStatus.INFO, "The exception is : " + e.getMessage());
			System.out.println("*****Ending to execute: TC_PVManual_JoinStatus*****");
		}
	}
}
