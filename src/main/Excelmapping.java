package main;

/**
 * The Class Excelmapping.
 */
public class Excelmapping {
	/**
	 * The Enum Login.
	 */
	public enum Login {

		MI_SR_USERNAME("MI_SR_Username"),
		PASSWORD("Password"),
		APP("appToLaunch"), 
		PCM_BA_USERNAME("PCM_BA_USERNAME"),
		PCM_GLOBALMANAGER_USERNAME("PCM_GLOBALMANAGER_USERNAME"),
		Deployment_Username("Deployment_Username"),
		Deployment_Password("Deployment_Password");

		/** The value. */
		private String value;

		/**
		 * Instantiates a new login.
		 *
		 * @param value
		 *            the value
		 */
		private Login(String value) {
			this.value = value;
		}

		/**
		 * Gets the.
		 *
		 * @return the string
		 */
		public String get() {
			return value;
		}
	}

	/**
	 * The Enum readMasterTestData.
	 */
	public enum readMasterTestData {

		/** The testcasename. */
		TESTCASENAME("TestCase_Name"),
		/** The sheetname. */
		SHEETNAME("Sheet Name"),
		/** The environmenturl. */
		ENVIRONMENTURL("Environment URL"),
		/** The testdatasheetpath. */
		TESTDATASHEETPATH("TestDataSheetPath"),
		/** The browser. */
		BROWSER("Browser"),
		/** The rowid. */
		ROWID("Row_ID");

		/** The value. */
		private String value;

		/**
		 * Instantiates a new read master test data.
		 *
		 * @param value
		 *            the value
		 */
		private readMasterTestData(String value) {
			this.value = value;
		}

		/**
		 * Gets the.
		 *
		 * @return the string
		 */
		public String get() {
			return value;
		}
	}

	public enum MasterCaseCreation {

		STRMASTERCASENUMBER("MasterCaseNumber"), STRCONTACTNAME("ContactName");

		private String value;

		private MasterCaseCreation(String value) {
			this.value = value;
		}

		public String get() {
			return value;
		}
	}

	public enum DataCreation {

		STRPERSONACCOUNTLASTNAME("PersonAccountName"),
		STRANONYMOUSACCOUNTLASTNAME("AnonymousAccountName"),
		STRINSTITUTIONACCOUNTNAME("InstitutionAccountName"),		
		STRPRODUCTNAME("ProductName"),
		STRDOSAGEFORM("DosageForm"),
		STRROLEINFORMATION_PCM("RoleInformation_PCM"),
		STRSUBCASE_PCM("Subcase_PCM"),
		STRSUBCASE_SR("Subcase_SR"),
		STRROLEINFORMATION_SR("RoleInformation_SR"),
		STRADMIN("Admin"),
		STRADMINPWD("Admin_pwd"),
		STRPCMMEDDEVICE("PCM_Medical Device"),
		STRPCMASSESMENTNAME("PCMAssesmentName"),
		STRINVESTIGATIONSITE("PCMInvestigationAssessmentSite"),
		STRINVESTIGATIONDEPT("PCMInvestigationAssessmentDepartment"),
		STRPCMASSESMENTCREATED("PCMAssesmentCreated");

		private String value;

		private DataCreation(String value) {
			this.value = value;
		}

		public String get() {
			return value;
		}
	}
}