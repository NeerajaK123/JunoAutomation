package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import main.BaseTest;
import main.Config;
import main.Excelmapping;
import resources.ExcelReader;

public class TC_NonPrescriber  extends BaseTest {

	BaseTest baseTest;
	ExcelReader excel;
	public String testDataPath;
	public String sheetName;
	public String rowId;
	public String browser;
	public String testCaseName;
	public String environmentURL;
	public String applicationServerUrl;

	public TC_NonPrescriber() {
	}

	@Test(description="Creation of NonPrescriber")
	public void NonPrescriber() {
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
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
 
	/**
	 * Step 01. Login
	 */
	public void step01(String strBrowser) throws Exception {
		excel = new ExcelReader(testDataPath, sheetName, rowId = strBrowser);
	
		baseTest = new BaseTest(environmentURL, strBrowser);
		System.out.println("*****Starting to execute: TC_NonPrescriber****");
		try {
			baseTest.loginPage.login(excel.RExcelReader(Excelmapping.Login.ADMIN_USERNAME.get()),
					excel.RExcelReader(Excelmapping.Login.ADMIN_PASSWORD.get()));
		} catch (Exception e) {
			System.out.println("There was an unexpected reason" + e.getMessage());
		}
	}

	/**
	 * Step 02. Case Contact Creation
	 */

	public void step02() throws Exception {
		try {
			BaseTest objbasetest = new BaseTest();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			
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
			driver.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("*****Ending to execute: TC_NonPrescriber*****");
		}
	}
}
