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

		ADMIN_USERNAME("ADMIN_Username"), ADMIN_PASSWORD("ADMIN_Password"),SUPER_USERNAME("Super_Username"), SUPER_PASSWORD("Super_Password"), APP_LAUCH("App_J"),APP_LAUNCHER("App")
		,APP_TREATMENTS("App_Treatments"),APP_ENROLLMENTS("App_Enrollments");

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
	
	public enum PatientEnrollmentCreation {

		FNAME("FName"),
		LNAME("LName"),		
		SUBJECTNUM("SubjectNum"),
		ENROLLMENTNUM("EnrollmentNum"),
		USERNAME("ADMIN_Username"),
		PASSWORD("ADMIN_Password");
		private String value;

		private PatientEnrollmentCreation(String value) {
			this.value = value;
		}

		public String get() {
			return value;
		}
	}
	
	

	public enum DataCreation {

		NonPrescriber("NonPrescriber"),
		Organisation("Organisation"),
		Site("Site"),
		Address("Address"), 
		City("City"), 
		App_JAMS("App_JAMS"), 
		APP_JUPTR("APP_JUPTR"),
		Department("Department"), 
		APP_Product("APP_Product"),
		Product("Product"),
		APP_Protocols("APP_Protocols"),
		Protocol("Protocol"),
		Apheresis("Apheresis"),
		OnboardingTemplate("OnboardingTemplate"),
		ManufacturingSite("ManufacturingSite"),
		ProductVersionAutoJoin("ProductVersionAutoJoin"),
		ProductVersionManulJoin("ProductVersionManulJoin"),
		APP_ProductVersion("APP_ProductVersion"),
		App_Doselevel("App_DL"),
		App_DoseSchedule("App_DS"),
		DoseLevel("DoseLevel"),
		DoseSchedule("DoseSchedule"),
		APP_LAUNCHER("App"),
		APP_MSC("APP_msc"),
		App_Patients("App_Patients"),
		ENROLLMENTNUM("EnrollmentNum"),
		JOINNAME("Join Name"),
		APP_ENROLLMENTS("App_Enrollments");

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