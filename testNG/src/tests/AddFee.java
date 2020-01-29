package tests;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import page.classes.ExistingAssignee;
import page.classes.Fees;
import page.classes.LoginPage;
import page.classes.SearchPage;


public class AddFee {
	private WebDriver driver;
	public static Properties prop;

	public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement webElement, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);

		WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));

		return element;
	}

	public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement webElement, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));

		return element;
	}

	public void takeScreenshot(WebDriver driver, String screenshotname) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/Add-Fees/" + screenshotname + ".png"));
		} catch (Exception e) {
			System.out.println("Exception during screenshot" + e.getMessage());
		}
	} 
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (Exception e) {
			return false;
		} // catch
	}

	public void initialization() throws InterruptedException {
		try {
			prop = new Properties();
			FileInputStream ip=new FileInputStream("/Users/avl7353/eclipse-workspace/Automation/src/page/classes/config.properties");
			

			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String browsername = prop.getProperty("browser");
		if (browsername.contentEquals("chrome")) {
			// System.setProperty("webdriver.chrome.driver","C:\\Users\\avl7353\\eclipse-workspace\\chromedriver.exe");
			
			System.setProperty("webdriver.chrome.driver",
					prop.getProperty("chromedriverpath"));

			driver = new ChromeDriver();
		} else if (browsername.contentEquals("ff")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxdriverpath"));
			driver = new FirefoxDriver();
		} else if (browsername.contentEquals("IE")) {
		//	System.setProperty("webdriver.ie.driver", "C:\\Users\\avl7353\\eclipse-workspace\\IEDriverServer.exe");
		//	driver = new InternetExplorerDriver();
			
			//USE IE 32 bit driver ---   ISSUES WITH IE 64BIT//
			System.setProperty("webdriver.ie.driver", prop.getProperty("IEdriverpath"));
			driver = new InternetExplorerDriver();
		
		}  		
		
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
//		    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		Thread.sleep(1000);
		LoginPage.userid(driver).clear();
		LoginPage.passwd(driver).clear();
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

	@Test	
 public void test() throws Exception {	
		initialization();

		LoginPage.userid(driver).sendKeys(prop.getProperty("username"));
		LoginPage.userid(driver).sendKeys(Keys.TAB);
		LoginPage.passwd(driver).clear();
		LoginPage.passwd(driver).sendKeys(prop.getProperty("password"));
		LoginPage.passwd(driver).sendKeys(Keys.TAB);
		LoginPage.loginbutton(driver).click();

		WebDriverWait wait = new WebDriverWait(driver, 3);
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		 
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"did_appframe\"]")));
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("cp_display"));
		  takeScreenshot(driver,"1.Homepage");
		  SearchPage.AsgneFldrClick(driver); 
		  driver.switchTo().parentFrame();
		  driver.switchTo().parentFrame(); 
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
		
	 /**SEARCH ASSIGNEE**/	  
		  SearchPage.statusACTIVE(driver); 
		  SearchPage.AdvancedSearchClick(driver);
		  SearchPage.clientname(driver).sendKeys("20");
		  takeScreenshot(driver,"2.Search by client");	
		  driver.switchTo().parentFrame();
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("svc_select_btns")); 
		  SearchPage.SearchClick(driver);
		  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		  driver.switchTo().parentFrame(); driver.switchTo().parentFrame();
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_bottom")); 
		  Thread.sleep(1500);
		  takeScreenshot(driver,"3.Search results");	
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//*[@id=\"did_results\"]/form/table/tbody/tr[2]/td[1]/a")).click();
		  Thread.sleep(5000);
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	/**ASSIGNEE PROFILE**/	  

          if (isAlertPresent()) {
 			 driver.switchTo().alert().accept();
 			 }
          Thread.sleep(3000);
		  driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	      driver.switchTo().defaultContent();
	  	(new WebDriverWait(driver, 2))
		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='did_appframe']")));
		(new WebDriverWait(driver, 2))
	    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
		(new WebDriverWait(driver, 2))
	    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("summaryButtons"));
		Thread.sleep(2000);
		takeScreenshot(driver,"4.Assignee Profile");	
          
		  ExistingAssignee.ProgramTitleClick(driver);
          driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
          driver.switchTo().defaultContent();
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_task_gadget_iframe"));
          
          ExistingAssignee.FeesClick(driver);
          driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
          driver.switchTo().defaultContent();
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
          
          /**/
          Fees.AddNewFeeClick(driver); 
          Thread.sleep(1500);
          driver.switchTo().defaultContent();
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame_detail"));
          driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
          Fees.feename(driver).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT,Keys.END),"Test Fee");
          (new WebDriverWait(driver, 2))
		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='DebitAccount_TextBoxMaster']")));
         // Fees.FeeDRacctClick(driver);
          Thread.sleep(1500);
          Fees.feeDRacct(driver).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT,Keys.END),"1020 - Relocation Allowance");
          Thread.sleep(1500);
          Fees.DR1020Click(driver);
          Thread.sleep(2000);
          Fees.feeCRacct(driver).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT,Keys.END),"20000 - Receivable Account");
          Thread.sleep(1500);
          Fees.CR20000Click(driver);
         // Fees.feeCRacct(driver).sendKeys(Keys.ENTER);
          //Fees.feeCRacct(driver).sendKeys(Keys.TAB);
          Fees.feeamount(driver).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT,Keys.END),"500");
          takeScreenshot(driver,"5.Fee");	
          Fees.PostNowClick(driver);
          driver.switchTo().defaultContent();
	         if ( driver.findElement(By.xpath("//th[@id='did_confirm_title']")).isEnabled()) {
	        	 driver.findElement(By.xpath("//input[@value='Yes']")).click();	 
	         }
	         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
	          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
	          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
	       Thread.sleep(8000);
	       takeScreenshot(driver,"6.Fee Posted");	
	         
	}
      

	@AfterMethod
	public void teardown() throws Exception {
		 driver.quit();
	}



}
