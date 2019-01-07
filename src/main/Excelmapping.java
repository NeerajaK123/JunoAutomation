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

	
}