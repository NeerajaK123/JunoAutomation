package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import resources.ExcelReader;

/**
 * The Class Utilities.
 */
public class Utilities {

	/** The monthint. */
	public static Integer monthint;

	/** The formatter. */
	public static DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

	/** The date. */
	public static Date date;

	/** The nextday. */
	public static Date nextday = null;

	/** The dayafternextday. */
	public static Date dayafternextday = null;

	/** The dayafternextnextday. */
	public static Date dayafternextnextday = null;

	/** The stringarrayofformatteddates. */
	public static String[] stringarrayofformatteddates = new String[3];

	/** The current date. */
	public static String currentDate;

	private static WebElement objdropdown;
	public static boolean flag;

	/**
	 * Format date to string.
	 *
	 * @param dueDate
	 *            the due date
	 * @return the string
	 */
	public static String formatdatetoString(String dueDate) {
		String[] dueArray = dueDate.split(" ");
		return dueArray[2] + " " + dueArray[1] + " " + dueArray[5];
	}

	/**
	 * Mov template creation date format.
	 *
	 * @param sysDate
	 *            the sys date
	 * @return the string
	 */
	public static String templateceation_dateformat(String sysDate) {
		String[] dueArray = sysDate.split(" ");
		return dueArray[1] + " " + dueArray[2] + "," + " " + dueArray[5] + " " + dueArray[3] + " " + "AM";
	}

	public static String StartDate_dateformat(String startdate) {
		String[] dueArray = startdate.split(" ");
		return dueArray[1] + " " + dueArray[2] + "," + " " + dueArray[5] + " " + dueArray[3] + " " + "AM";
	}

	public static String EndDate_dateformat(String enddate) {
		String[] dueArray = enddate.split(" ");
		return dueArray[1] + " " + dueArray[2] + "," + " " + dueArray[5] + " " + dueArray[3] + " " + "PM";
	}

	/**
	 * Timestamp.
	 *
	 * @param sysDate
	 *            the sys date
	 * @return the string
	 */
	public static String timestamp(String sysDate) {
		String[] dueArray = sysDate.split(" ");
		String[] mtimestamparray = dueArray[3].split(":");
		return dueArray[0] + dueArray[1] + dueArray[2] + mtimestamparray[0] + mtimestamparray[1] + mtimestamparray[2]
				+ dueArray[5];
	}

	/**
	 * Dynamic email.
	 *
	 * @param sysDate
	 *            the sys date
	 * @return the string
	 */
	public static String dynamicemail(String sysDate) {
		String[] dueArray = sysDate.split(" ");
		String[] mtimestamparray = dueArray[3].split(":");
		return dueArray[0] + dueArray[1] + dueArray[2] + mtimestamparray[0] + mtimestamparray[1] + mtimestamparray[2]
				+ dueArray[5] + "@email.com";
	}

	/**
	 * Generate lubes order upload file element PO Number.
	 *
	 * @param sysDate
	 *            the sys date
	 * @return the string
	 */
	/*
	 * public static String generateLubesOrderUploadFileElementPONUmber(String
	 * sysDate) { int sTART = 0; int eND = 9; int randomPONumber = 0; Random random
	 * = new Random(); randomPONumber = showRandomInteger(sTART, eND, random);
	 * String[] dueArray = sysDate.split(" "); String[] mtimestamparray =
	 * dueArray[3].split(":"); String purchaseOrderNumber = dueArray[0] +
	 * (randomPONumber); System.out.println(purchaseOrderNumber); return
	 * purchaseOrderNumber; }
	 */

	/**
	 * Generatenumber.
	 *
	 * @return the string
	 */
	public static String generatenumber() {
		Random r = new Random(System.currentTimeMillis());
		return Integer.toString((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}

	/**
	 * Show random integer.
	 *
	 * @param aStart
	 *            the a start
	 * @param aEnd
	 *            the a end
	 * @param aRandom
	 *            the a random
	 * @return the int
	 */
	public static int showRandomInteger(int aStart, int aEnd, Random aRandom) {
		if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		long range = (long) aEnd - (long) aStart + 1;
		long fraction = (long) (range * aRandom.nextDouble());
		int randomNumber = (int) (fraction + aStart);
		return randomNumber;
	}

	/**
	 * 
	 * To generate 16 digit credit card number for internal user.
	 */
	public static String generaterandom16digitnumber() {
		final long mAX_NUMBER_YOU_WANT_TO_HAVE = 9999999999999999L;
		final long mIN_NUMBER_YOU_WANT_TO_HAVE = 1000000000000000L;
		String actual = String.valueOf(Math.abs(
				Float.valueOf(new Random().nextFloat() * (mAX_NUMBER_YOU_WANT_TO_HAVE - mIN_NUMBER_YOU_WANT_TO_HAVE))
						.longValue()));
		return actual;
	}

	/**
	 * Generate lubes order upload file element current date.
	 *
	 * @param sysDate
	 *            the sys date
	 * @return the string
	 */
	public static String generateLubesOrderUploadFileElementCurrentDate(String sysDate) {
		String[] dueArray = sysDate.split(" ");
		getMonth(dueArray[1]);
		if (monthint < 10) {
			currentDate = dueArray[5] + "0" + monthint + dueArray[2];
		} else {
			currentDate = dueArray[5] + monthint + dueArray[2];
		}
		return currentDate;
	}

	/**
	 * Bannermessage name.
	 *
	 * @param sysDate
	 *            the sys date
	 * @return the string
	 */
	public static String bannermessagename(String sysDate) {
		String[] dueArray = sysDate.split(" ");
		String[] mtimestamparray = dueArray[3].split(":");
		return "BM_" + mtimestamparray[0] + mtimestamparray[1] + mtimestamparray[2] + dueArray[5] + dueArray[0]
				+ dueArray[1] + dueArray[2];
	}

	/**
	 * Mov template name.
	 *
	 * @param flag
	 *            the flag
	 * @return the string
	 * @throws ParseException
	 *             the parse exception
	 */
	public static String Dynamictemplatename(String flag) throws ParseException {

		if (flag == "MinOQ") {
			String stimestamp = timestamp(formatsysDate().toString());
			String templatenameminoq = "A" + stimestamp;
			return templatenameminoq;
		} else {
			String qtimestamp = timestamp(formatsysDate().toString());
			return "A" + qtimestamp;
		}

	}

	/**
	 *
	 * @return the string
	 * @throws ParseException
	 *             the parse exception
	 */
	public static String generateDynamicNumber() throws ParseException {
		String stimestamp = timestamp(formatsysDate().toString());
		return "T" + stimestamp;

	}
	
	
	
	/**
	 * Generate Three digit random number
	 * @return
	 * @throws ParseException
	 */
	public static String generateRandomNumber() throws ParseException {
		// initialize a Random object somewhere; you should only need one
		Random random = new Random();

		// generate a random integer from 0 to 899, then add 100
		int x = random.nextInt(900) + 100;
		String RandomNum = Integer.toString(x);
		return "T" +RandomNum;

	}
	
	/**
	 * Generate Three digit random number for Email
	 * @return
	 * @throws ParseException
	 */
	public static String emailGenerateRandomNumber() throws ParseException {
		// initialize a Random object somewhere; you should only need one
		Random random = new Random();

		// generate a random integer from 0 to 899, then add 100
		int x = random.nextInt(900) + 100;
		String RandomNum = Integer.toString(x);
		return "Auto" +RandomNum+ "@gmail.com";

	}
	
	/**
	 * Generate Three digit random number for LastName
	 * @return
	 * @throws ParseException
	 */
	public static String lastNameGenerateRandomNumber() throws ParseException {
		// initialize a Random object somewhere; you should only need one
		Random random = new Random();

		// generate a random integer from 0 to 899, then add 100
		int x = random.nextInt(9000) + 100;
		String RandomNum = Integer.toString(x);
		return "Auto_" +RandomNum;

	}

	/**
	 * Generate Three digit random number for Institution
	 * @return
	 * @throws ParseException
	 */
	public static String InstitutionGenerateRandomNumber() throws ParseException {
		// initialize a Random object somewhere; you should only need one
		Random random = new Random();

		// generate a random integer from 0 to 899, then add 100
		int x = random.nextInt(900) + 100;
		String RandomNum = Integer.toString(x);
		return "Kims" +RandomNum;

	}

	
	/**
	 * Format date.
	 *
	 * @param dueDate
	 *            the due date
	 * @return the date
	 */
	public static Date formatdate(String dueDate) {
		String[] dueArray = dueDate.split(" ");
		getMonth(dueArray[1]);
		String returnedDate = monthint + "/" + dueArray[0] + "/" + dueArray[2];
		try {
			date = formatter.parse(returnedDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * Format date to mm/dd/yyyy.
	 *
	 * @param dueDate
	 *            the due date
	 * @return the string
	 */
	public static String formatdatetommddyyyy(String dueDate) {
		String[] dueArray = dueDate.split(" ");
		getMonth(dueArray[1]);
		String returnedDate = monthint + "/" + dueArray[2] + "/" + dueArray[5];
		try {
			date = formatter.parse(returnedDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return returnedDate;
	}

	/**
	 * Gets the month.
	 *
	 * @param month
	 *            the month
	 * @return the month
	 */
	public static void getMonth(String month) {
		switch (month) {
		case "Jan":
			monthint = 1;
			break;
		case "Feb":
			monthint = 2;
			break;
		case "Mar":
			monthint = 3;
			break;
		case "Apr":
			monthint = 4;
			break;
		case "May":
			monthint = 5;
			break;
		case "Jun":
			monthint = 6;
			break;
		case "Jul":
			monthint = 7;
			break;
		case "Aug":
			monthint = 8;
			break;
		case "Sep":
			monthint = 9;
			break;
		case "Oct":
			monthint = 10;
			break;
		case "Nov":
			monthint = 11;
			break;
		case "Dec":
			monthint = 12;
			break;

		}

	}

	/**
	 * Change date and timezone.
	 *
	 * @param rdddateinCDT
	 *            the rdddatein CDT
	 * @param stimezone
	 *            the stimezone
	 * @param format
	 *            the format
	 * @return the string
	 * @throws ParseException
	 *             the parse exception
	 */
	public static String changedateandtimezone(Date rdddateinCDT, String stimezone, String format)
			throws ParseException {
		if (rdddateinCDT == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if (stimezone == null || "".equalsIgnoreCase(stimezone.trim())) {
			stimezone = Calendar.getInstance().getTimeZone().getID();
		}
		sdf.setTimeZone(TimeZone.getTimeZone(stimezone));
		return sdf.format(rdddateinCDT);
	}

	/**
	 * Format sys date.
	 *
	 * @return the date
	 * @throws ParseException
	 *             the parse exception
	 */
	public static Date formatsysDate() throws ParseException {
		return new Date();
	}

	/**
	 * Add days to mov calendar date.
	 *
	 * @return the date
	 * @throws Exception
	 *             the exception
	 */
	public static Date adddaystocalendardate() throws Exception {
		// Fri Jan 01 16:33:45 CST 2016
		Calendar c = Calendar.getInstance();
		c.setTime(formatsysDate()); // Now sysdate aug.
		c.add(Calendar.DATE, 1); // Adding 1 days
		String odate = formatter.format(c.getTime());
		return formatter.parse(odate);
	}

	public static Date addtwodaystocalendardate() throws Exception {
		Calendar c = Calendar.getInstance();
		c.setTime(formatsysDate()); // Now sysdate aug.
		c.add(Calendar.DATE, 3); // Adding 3 days
		String odate = formatter.format(c.getTime());
		return formatter.parse(odate);
	}

	/**
	 * Add days to mov calendar date.
	 *
	 * @param date
	 *            the date
	 * @return the date
	 * @throws Exception
	 *             the exception
	 */
	public static Date adddaystomovcalendardate(Date date) throws Exception {
		// Fri Jan 01 16:33:45 CST 2016
		Calendar c = Calendar.getInstance();
		c.setTime(date); // Now sysdate aug.
		c.add(Calendar.DATE, 1); // Adding 1 days
		String odate = formatter.format(c.getTime());
		return formatter.parse(odate);
	}

	/**
	 * Format min date.
	 *
	 * @param monthsint
	 *            the monthsint
	 * @return the date
	 * @throws ParseException
	 *             the parse exception
	 */
	public static Date formatminDate(int monthsint) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -(monthsint));
		return cal.getTime();
	}

	/**
	 * Select from dropdown.
	 *
	 * @param valuetoselect
	 *            the valuetoselect
	 */
	/*
	 * public static void selectfromdropdown(String xpathExpression,String
	 * valuetoselect) { Select select = new
	 * Select(BaseTest.waitforElement(BaseTest.getDriver().findElement(By.xpath(
	 * xpathExpression)),Config.timeouts.MEDIUMWAIT.get()));
	 * select.selectByVisibleText(valuetoselect);
	 * 
	 * }
	 */
	public static void selectfromdropdownwebelement(WebElement webElement, String valuetoselect) {
		Select select = new Select(BaseTest.waitforElement(webElement, Config.timeouts.MEDIUMWAIT.get()));
		select.selectByVisibleText(valuetoselect);
	}

	/**
	 * Select from drop down.
	 * 
	 * @param visibletext
	 *            the visibletext
	 * @param valuetoselect
	 *            the valuetoselect
	 * @param index
	 *            the index
	 * @param xpathobjdropdown
	 *            the xpathobjdropdown
	 * @throws NullPointerException
	 *             the null pointer exception
	 */
	public static void selectfromdropdown(String visibletext, String valuetoselect, int index, String xpathobjdropdown)
			throws NullPointerException {
		try {
			objdropdown = BaseTest.waitforElement(BaseTest.getDriver().findElement(By.id(xpathobjdropdown)),
					Config.timeouts.MEDIUMWAIT.get());
		} catch (Exception e) {
			System.out.println("ID is dynamic" + e);
		}
		try {
			objdropdown = BaseTest.waitforElement(BaseTest.getDriver().findElement(By.className(xpathobjdropdown)),
					Config.timeouts.MEDIUMWAIT.get());
		} catch (Exception e) {
			System.out.println("ID is dynamic" + e);
		}
		Select select = new Select(objdropdown);
		try {
			select.selectByVisibleText(visibletext);
		} catch (Exception exnull) {
			System.out.println(exnull.getMessage());
		}
		try {
			select.selectByIndex(index);
		} catch (Exception exnull) {
			System.out.println(exnull.getMessage());
		}
		try {
			select.selectByValue(valuetoselect);
		} catch (NullPointerException exnull) {
			System.out.println(exnull.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Select from results displayed.
	 *
	 * @param searchelementxpath
	 *            the searchelementxpath
	 * @param valuetoseectfromsearchresult
	 *            the valuetoseectfromsearchresult
	 */
	public static void selectfromresultsdisplayed(String searchelementxpath, String valuetoseectfromsearchresult) {
		try {
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			List<WebElement> webel = BaseTest.getDriver().findElements(By.xpath(searchelementxpath));
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			for (int i = 0; i < webel.size(); i++) {
				if (webel.get(i).getText().contains(valuetoseectfromsearchresult)) {
					webel.get(i).click();
					BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Drag and drop.
	 *
	 * @param sourcexpath
	 *            the sourcexpath
	 */
	public static void draganddrop(String sourcexpath) {
		List<WebElement> div = BaseTest.getDriver().findElements(By.xpath(sourcexpath));
		System.out.println(div.get(0).getText());
		Actions action = new Actions(BaseTest.getDriver());
		action.clickAndHold().dragAndDropBy(div.get(0), 0, 150).build().perform();
		action.release();
	}

	public static boolean click(WebElement elementtobeclicked) {
		try {
			flag = true;
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
			elementtobeclicked.click();
			BaseTest.pleasewait(Config.timeouts.LONGWAIT.get());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			flag = false;
		}

		return flag;

	}

	public void switchingtonexttab() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.getMessage();
		}
		@SuppressWarnings("unused")
		String parentHandle = BaseTest.getDriver().getWindowHandle();
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ArrayList tabs = new ArrayList(BaseTest.getDriver().getWindowHandles());
		BaseTest.getDriver().switchTo().window((String) tabs.get(1));
	}

}
