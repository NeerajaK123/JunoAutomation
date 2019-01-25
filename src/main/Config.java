package main;

/**
 * The Class Config.
 */
/**
 * @author nkandikuppa
 *
 */
public class Config {

	/**
	 * The Enum timeout.
	 */
	public enum timeouts {

		/** The veryshortwait. */
		VERYSHORTWAIT(2000),
		/** The shortwait. */
		SHORTWAIT(4000),
		/** The mediumwait. */
		MEDIUMWAIT(6000),
		/** The longwait. */
		LONGWAIT(8000),
		/** The shortscrolldown. */
		SHORTSCROLLDOWN(250),
		/** The mediumscrolldown. */
		MEDIUMSCROLLDOWN(500),
		/** The longscrolldown. */
		LONGSCROLLDOWN(750),
		/** The longerscrolldown. */
		LONGERSCROLLDOWN(2750);

		/** The value. */
		private int value;

		/**
		 * Instantiates a new timeouts.
		 *
		 * @param value
		 *            the value
		 */
		private timeouts(int value) {
			this.value = value;
		}

		/**
		 * Gets the.
		 *
		 * @return the int
		 */
		public int get() {
			return value;
		}

	}
}