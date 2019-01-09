package main;

/**
 * The Class Excelmapping.
 */
public class Excelmapping {
	/**
	 * The Enum Login.
	 * 
	 *
	 */
	public enum Login {

		ADMIN_USERNAME("ADMIN_Username"), ADMIN_PASSWORD("ADMIN_Password"), APP_LAUNCHER("App");

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

	public enum CongaTemplateCreation {

		CONGATEMPLATENAME("Name");
		private String value;

		private CongaTemplateCreation(String value) {
			this.value = value;
		}

		public String get() {
			return value;
		}
	}

	public enum DataCreation {

		NonPrescriber("NonPrescriber"), Organisation("Organisation"), Site("Site");

		/** The value. */
		private String value;

		/**
		 * Instantiates a new login.
		 *
		 * @param value
		 *            the value
		 */
		private DataCreation(String value) {
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