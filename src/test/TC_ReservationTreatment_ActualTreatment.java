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

public class TC_ReservationTreatment_ActualTreatment  extends BaseTest {

	BaseTest baseTest;
	ExcelReader excel;
	public String testDataPath;
	public String sheetName;
	public String rowId;
	public String browser;
	public String testCaseName;
	public String environmentURL;
	public String applicationServerUrl;

	public TC_ReservationTreatment_ActualTreatment() {
	}

	@Test(description ="Creation Of Reservation Treatment and converting to Actual Treatment")
	public void ReservationTreatmentCreationAndConvertiongToActualTreatment() {
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
	 * Step 01. Login with Super User
	 */
	public void step01(String strBrowser) throws Exception {
		excel = new ExcelReader(testDataPath, sheetName, rowId = strBrowser);		
		baseTest = new BaseTest(environmentURL, strBrowser);
		System.out.println("*****Starting to execute: TC_Patient_Enrollment_Approval****");
		try {
			baseTest.loginPage.login(excel.RExcelReader(Excelmapping.Login.SUPER_USERNAME.get()),
					excel.RExcelReader(Excelmapping.Login.SUPER_PASSWORD.get()));
			ExtentTestManager.getTest().log(LogStatus.INFO,"Login as Super User is successful");
			baseTest.loginPage.appSelection_Applauncher(excel.RExcelReader(Excelmapping.DataCreation.APP_JUPTR.get()));
			baseTest.loginPage.appSelection_Applauncher(excel.RExcelReader(Excelmapping.Login.APP_TREATMENTS.get())); 
		} catch (Exception e) {
			System.out.println("There was an unexpected reason" + e.getMessage());
		}
	}

	/**
	 * Step 02. Case Patient and Enrollment creation 
	 */

	public void step02() throws Exception {
		try {
			BaseTest objbasetest = new BaseTest();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
		    objbasetest.treatmentsPage.reservationTreatment_To_Actual(					
					excel.RExcelReader(Excelmapping.PatientEnrollmentCreation.LNAME.get()),					
					excel.RExcelReader(Excelmapping.PatientEnrollmentCreation.ENROLLMENTNUM.get()),
					excel.RExcelReader(Excelmapping.DataCreation.Site.get()),
					excel.RExcelReader(Excelmapping.DataCreation.NonPrescriber.get()),
					excel.RExcelReader(Excelmapping.DataCreation.Protocol.get()),
					excel.RExcelReader(Excelmapping.DataCreation.Apheresis.get()),
					excel.RExcelReader(Excelmapping.DataCreation.ManufacturingSite.get()),
					excel.RExcelReader(Excelmapping.DataCreation.ProductVersionAutoJoin.get()),
					excel.RExcelReader(Excelmapping.DataCreation.Address.get()));		
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
			System.out.println("*****Ending to execute: TC_Patient_Enrollment_Approval*****");
		}
	}
}
