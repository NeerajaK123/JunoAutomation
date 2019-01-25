package main;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import java.util.concurrent.TimeUnit;
import resources.ExcelReader;

/**
 * The Class BaseTest.
 */
/**
 * @author nkandikuppa
 *
 */
public class BaseTest {

	
	public LoginPage loginPage;
	public LogoutPage logoutPage;

	public JAMSAccount JAMSAccount;

	public CongaTemplatesPage congaTemplatesPage;
	
	
	public PatientsPage patientsPage;
	
	public TreatmentsPage treatmentsPage;
	
	public ManufacturingScheduleConfigurationPage manufacturingScheduleConfigurationPage;

	public static WebDriver driver;
	
	/** The master test data path. */
	public static String masterTestDataPath = "..\\JunoAutomation\\src\\resources\\Juno_TestDataSheet.xlsx";
	public static String masterTestSheetName = "MasterTestDataSheet";


	/**
	 * Instantiates a new base test.
	 *
	 * @param url
	 *            the url
	 * @param Browser
	 *            the browser
	 * @param modifyheaderUsername
	 *            the modifyheader username
	 */
	public BaseTest(String url, String Browser) {

		switch (Browser) {
		case "InternetExplorer":
			try {
				System.setProperty("webdriver.ie.driver", "..\\JunoAutomation\\src\\resources\\IEDriverServer.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
				driver = new InternetExplorerDriver(capabilities);
				driver.navigate().to(url);
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				while (driver.findElement(By.xpath("//a[@name='overridelink']")).isDisplayed()) {
					driver.get("javascript:document.getElementById('overridelink').click();");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				
				break;
			}
		case "GoogleChrome":
			try {
				ChromeOptions chrome = new ChromeOptions();
				chrome.addArguments("--start-maximized");
				System.setProperty("webdriver.chrome.driver",
						"..\\JunoAutomation\\\\src\\\\resources\\chromedriver.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability("ignoreZoomSetting", true);
				capabilities.setCapability(ChromeOptions.CAPABILITY, chrome);
				capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				driver = new ChromeDriver(capabilities);
				driver.manage().deleteAllCookies();
				driver.navigate().to(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "FireFox":
			try {
				FirefoxProfile profile = new FirefoxProfile();
				File file = new File(
						"..\\JunoAutomation\\src\\resources\\{b749fc7c-e949-447f-926c-3f4eed6accfe}.xpi");
				profile.setEnableNativeEvents(false);
				profile.addExtension(file);
				profile.setPreference("extensions.modify_headers.currentVersion", "0.7.1.1-fx");
				profile.setPreference("modifyheaders.headers.count", 1);
				profile.setPreference("modifyheaders.headers.action0", "Add");
				profile.setPreference("modifyheaders.headers.name0", "SM_USER");
				profile.setPreference("modifyheaders.headers.enabled0", true);
				profile.setPreference("modifyheaders.config.active", true);
				profile.setPreference("modifyheaders.config.alwaysOn", true);
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setBrowserName("firefox");
				capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
				capabilities.setCapability(FirefoxDriver.PROFILE, profile);
				driver = new FirefoxDriver(capabilities);
				driver.manage().deleteAllCookies();
				driver.navigate().to(url);
				try {
					driver.manage().window().maximize();
				} catch (Exception maximizeexception) {
					System.out.println("window already maximized :" + maximizeexception);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;

		case "Safari":
			try {
				driver = new SafariDriver();
				driver.navigate().to(url);
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		case "HtmlUnitdriver":
			try {
				driver = new HtmlUnitDriver(true);
				driver.navigate().to(url);
				driver.manage().deleteAllCookies();
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		loginPage = new LoginPage(driver);
		logoutPage = new LogoutPage(driver);
		JAMSAccount = new JAMSAccount(driver) ;
		congaTemplatesPage = new CongaTemplatesPage(driver);
		patientsPage = new PatientsPage(driver);
		treatmentsPage = new TreatmentsPage(driver);
		manufacturingScheduleConfigurationPage = new ManufacturingScheduleConfigurationPage(driver);
		
		
	}

	/**
	 * Instantiates a new base test.
	 */
	public BaseTest() {
		loginPage = new LoginPage(driver);
		logoutPage = new LogoutPage(driver);
		JAMSAccount = new JAMSAccount(driver) ;
		congaTemplatesPage = new CongaTemplatesPage(driver);
		patientsPage = new PatientsPage(driver);
		treatmentsPage = new TreatmentsPage(driver);
		manufacturingScheduleConfigurationPage = new ManufacturingScheduleConfigurationPage(driver);
	}

	/**
	 * Gets the driver.
	 *
	 * @return the driver
	 */
	public static WebDriver getDriver() {
		return driver;
	}

	/**
	 * Waitfor element.
	 *
	 * @param element
	 *            the element
	 * @param timeout
	 *            the timeout
	 * @return the web element
	 */
	public static WebElement waitforElement(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			// wait.until(ExpectedConditions.elementSelectionStateToBe(element,element.isEnabled()));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception ine) {
			System.out.println(ine.getMessage());
		}
		try {
			pleasewait(10);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		try {
			Assert.assertTrue(element.isDisplayed(), "Element not found");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		return element;
	}

	protected static boolean switchWindow(String title) throws IOException {

	    String currentWindow = driver.getWindowHandle();
	    Set<String> availableWindows = driver.getWindowHandles();
	    if (!availableWindows.isEmpty()) {
	    for (String windowId : availableWindows) {
	    if (driver.switchTo().window(windowId).getTitle().equals(title)) {
	    return true;
	    } else {
	        driver.switchTo().window(currentWindow);
	    }}}

	    return false;   
	    }
	
	
	public static WebElement FluentWait(WebElement element) {
        try {
            FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                    .withTimeout(30, TimeUnit.SECONDS).pollingEvery(3,
                            TimeUnit.SECONDS);
            fluentWait.until(ExpectedConditions.visibilityOf(element));
              } catch (Exception e) {
            System.out.println("Fluent wait failed due to = " + e.getMessage());
        }
		return element;
    }
	
	
	/**
	 * Waitfor elementtobeclickable.
	 *
	 * @param element
	 *            the element
	 * @param timeout
	 *            the timeout
	 * @return the web element
	 */
	public static WebElement waitforElementtobeclickable(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		try {
			pleasewait(timeout);
		} catch (InterruptedException e) {

		}
		try {
			Assert.assertTrue(element.isDisplayed(), "Element not found");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		return element;
	}
	
	public static WebElement waitforElementtobeVisible(WebElement element, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		try {
			Assert.assertTrue(element.isDisplayed(), "Element not found");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		return element;

		
	}

	/**
	 * To handle Element not visible exception
	 * 
	 * @param element
	 * @param timeout
	 * @return
	 */
	/**
	 * Wait for ajax.
	 *
	 * @param timeout
	 *            the timeout
	 * @throws InterruptedException
	 *             the interrupted exception
	 */

	public static void pleasewait(int timeout) throws InterruptedException {
		WebDriverWait wait1 = new WebDriverWait(driver, timeout);

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(
					By.xpath("//div[@class='auraLoadingBox oneLoadingBox loadingHide']")));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(
					By.xpath("//div[@class='slds-spinner_container slds-grid slds-hide']")));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			wait1.until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath("//div[@class='auraLoadingBox oneLoadingBox']")));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void waitForElementToBeInvisible(int timeout) {
		WebDriverWait wait1 = new WebDriverWait(driver, timeout);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			// wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element)));
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(
					By.xpath("//div[@class='slds-spinner_container slds-grid slds-hide']")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			// wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element)));
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(
					By.xpath("//div[@class='forceDotsSpinner']")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void handleElementNotVisibleExceptionforids(String id, int timeout) {
		WebDriverWait webdriverwait = new WebDriverWait(driver, timeout);
		try {
			List<WebElement> getObjects = driver.findElements(By.id(id));
			for (int l = 0; l <= getObjects.size(); l++) {
				try {
					getObjects.get(l).click();
				} catch (Exception exception) {
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void handleElementNotVisibleExceptionforxpath(String xpathExpression, int timeout) {
		WebDriverWait webdriverwait = new WebDriverWait(driver, timeout);
		try {
			List<WebElement> getObjects = driver.findElements(By.xpath(xpathExpression));
			for (int l = 0; l <= getObjects.size(); l++) {
				try {
					getObjects.get(l).click();
				} catch (Exception exception) {
				}
			}
		} catch (Exception e) {
		}
	}

	/*	*//**
			 * Wait for ajax back office.
			 *
			 * @param timeout
			 *            the timeout
			 * @throws InterruptedException
			 *             the interrupted exception
			 *//*
				 * // Processing wait public static void pleasewait_BackOffice(int timeout)
				 * throws InterruptedException { WebDriverWait wait1 = new WebDriverWait(driver,
				 * timeout);
				 * 
				 * try { Thread.sleep(2000); } catch (Exception e) { e.printStackTrace(); }
				 * 
				 * try { wait1.until( ExpectedConditions.invisibilityOfElementLocated(By.xpath(
				 * "//div[@class='z-loading-indicator']"))); } catch (Exception e) { //
				 * System.out.println(e.getMessage());
				 * 
				 * } try { wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
				 * "//div[@class='loader-message']"))); } catch (Exception e) {
				 * 
				 * } try { wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
				 * "//div[@class='loader']"))); } catch (Exception e) {
				 * 
				 * } try { wait1.until(ExpectedConditions .invisibilityOfElementLocated(By.
				 * xpath("//div[@class='autosuggest-loader autosuggest-list']"))); } catch
				 * (Exception e) {
				 * 
				 * } try { wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
				 * "//span[@class='progressTitle']"))); } catch (Exception e) {
				 * 
				 * }
				 * 
				 * }
				 */

	/**
	 * Wait for ajax.
	 *
	 * @param element
	 *            the element
	 * @param timeout
	 *            the timeout
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public static void pleasewait(WebElement element, int timeout) throws InterruptedException {
		WebDriverWait wait1 = new WebDriverWait(driver, timeout);

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (driver.findElement(By.xpath("//div[@class='slds-spinner_container slds-grid slds-hide']")) != null) {
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(
					By.xpath("//div[@class='slds-spinner_container slds-grid slds-hide']")));

		}

		try {
			wait1.until(ExpectedConditions.elementToBeClickable(element));

		} catch (Exception e) {
		}
	}

	/**
	 * Read master test datasheet.
	 *
	 * @param classname
	 *            the classname
	 * @return the string[]
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public String[] readMasterTestDatasheet(String classname) throws IOException {
		ExcelReader excel1 = new ExcelReader(masterTestDataPath, masterTestSheetName, classname);
		String strtestname = excel1.RExcelReader(Excelmapping.readMasterTestData.ROWID.get());
		String strsheetname = excel1.RExcelReader(Excelmapping.readMasterTestData.SHEETNAME.get());
		String strenvironmenturl = excel1.RExcelReader(Excelmapping.readMasterTestData.ENVIRONMENTURL.get());
		String strtestdatasheetpath = excel1.RExcelReader(Excelmapping.readMasterTestData.TESTDATASHEETPATH.get());
		String strbrowser = excel1.RExcelReader(Excelmapping.readMasterTestData.BROWSER.get());
		String arr[] = new String[5];
		arr[0] = strtestname;
		arr[1] = strsheetname;
		arr[2] = strenvironmenturl;
		arr[3] = strtestdatasheetpath;
		arr[4] = strbrowser;
		return arr;
	}

	/**
	 * Scrolldown.
	 *
	 * @param scroller
	 *            the scroller
	 */
	public static void scrolldown(int scroller) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + scroller + ")", "");

		// scroll down using Robot class:
		/*
		 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		 * robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		 */
	}

	public static void scrolldowntoVisibility(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", element);

	}

	/**
	 * Scrollup.
	 *
	 * @param scroller
	 *            the scroller
	 */
	public static void scrollup(int scroller) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-" + scroller + ")", "");
	}

	/**
	 * Scroll for A specific element.
	 *
	 * @param elementxpath
	 *            the elementxpath
	 * @throws Exception
	 *             the exception
	 */
	
	public static void scrollForASpecificElement(String elementxpath) throws Exception {
	/*	WebElement webelement = driver.findElement(By.xpath(elementxpath));
		Actions act = new Actions(driver);
		act.clickAndHold(driver.findElement(By.xpath(elementxpath)));*/
		JavascriptExecutor jse = (JavascriptExecutor) driver;
	//	Point hoverItem = driver.findElement(By.xpath(elementxpath)).getLocation();
		jse.executeScript("return window.title;");
		jse.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath(elementxpath)));
		// BaseTest.pleasewait_BackOffice(Config.timeouts.LONGWAIT.get());
		Thread.sleep(2000);
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView();",
		// driver.findElement(By.xpath("//div/div[2]/table[2]/tbody/tr/td/table/tbody/tr/td[1]/div[2]/div/div[1]/div/table[1]/tbody/tr[125]/td[1]/div/div/span")));

		// ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,
		// document.body.scrollHeight)");
	}

	
	/**
	 * Doubleclick.
	 *
	 * @param elementXpath
	 *            the element xpath
	 */
	public static void doubleclick(String elementXpath) {
		Actions a = new Actions(driver);
		a.doubleClick(driver.findElement(By.xpath(elementXpath))).perform();
	}

	/*
	 * public static void waitforbackofficelogin(int timeout) {
	 * FluentWait<WebDriver> wait = new
	 * FluentWait<WebDriver>(driver).withTimeout(timeout, TimeUnit.SECONDS)
	 * .pollingEvery(500,
	 * TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class); } public
	 * static void waitforSpecificElements(String elementXpath, int timeout) {
	 * WebDriverWait wait1 = new WebDriverWait(driver, timeout); try {
	 * Thread.sleep(2000); } catch (Exception e) {
	 * System.out.println(e.getMessage()); } try {
	 * wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	 * elementXpath)));
	 * 
	 * } catch (Exception e) { System.out.println(e.getMessage()); } }
	 */
	public static void todayDateSelection() {
		try {
			WebElement today = driver.findElement(By.xpath("//button[contains(text(),'Today')]"));
			today.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void screenShot() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY/hh/mm/ss");
		String tempDate = (dateFormat.format(date));
		String newDate = tempDate.replace("/", "");
		String path = System.getProperty("user.dir") + "/Screenshots/" + newDate + ".png";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String failedScreenShot() {		
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY/hh/mm/ss");
		String tempDate = (dateFormat.format(date));
		String newDate = tempDate.replace("/", "");
		String path = System.getProperty("user.dir") + "/Failed Screenshots/" +newDate+ ".png";
   	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);    	   
           try {
				FileUtils.copyFile(scrFile, new File(path));					 
			} catch (IOException e) {
				e.printStackTrace();
			}    
           return path;
   } 
	
	public static void selectfromdd()
	{
		
	}
}
