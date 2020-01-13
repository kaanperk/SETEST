package tests;

import org.testng.annotations.Test;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import page.classes.ExistingAssignee;
import page.classes.Fees;
import page.classes.LoginPage;
import page.classes.SearchPage;


public class AddFeeTest {
	private WebDriver driver;
	private String baseUrl;

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
	
	@BeforeMethod
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\avl7353\\eclipse-workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://setstgen.sirvarelocation.com";
		//driver.manage().window().maximize();

	}
	
	
	  public boolean isAlertPresent() {
			 try {
			 driver.switchTo().alert();
			 return true;
			 }// try
			 catch (Exception e) {
			 return false;
			 }// catch
			 }

	@Test	
 public void test() throws Exception {	
	driver.get(baseUrl);
	Thread.sleep(2000);
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	/**LOGIN **/
	LoginPage.userid(driver).sendKeys("kaan.perk@sirva.com");
	LoginPage.passwd(driver).sendKeys("Dec321@@");
	LoginPage.login(driver);
 WebDriverWait wait = new WebDriverWait(driver,3);
 Thread.sleep(5000);
 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		  if
		  (driver.findElement(By.xpath("//th[@id='did_confirm_title']")).isEnabled()) {
		  driver.findElement(By.xpath("//input[@value='OK']")).click(); }
		 
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
