package tests;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;



import java.util.concurrent.TimeUnit;

import page.classes.LoginPage;
import page.classes.SearchPage;
import page.classes.ExistingAssignee;
import page.classes.NewAssignee;

public class GENERICAssigneeProgramCopy {
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
			FileUtils.copyFile(source, new File("./Screenshots/GenericProgramCopy/" + screenshotname + ".png"));
		} catch (Exception e) {
			System.out.println("Exception during screenshot" + e.getMessage());
		}
	}

	@Before
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\avl7353\\eclipse-workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://setstgen.sirvarelocation.com";
		;
		driver.manage().window().maximize();

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
		Thread.sleep(1500);
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	/**LOGIN **/
	LoginPage.userid(driver).sendKeys("kaan.perk@sirva.com");
	LoginPage.passwd(driver).sendKeys("Nov321@@");
	LoginPage.login(driver);
	  WebDriverWait wait = new WebDriverWait(driver,3);
	 Thread.sleep(35000);
	 driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	 
		/*
		 * if
		 * (driver.findElement(By.xpath("//th[@id='did_confirm_title']")).isEnabled()) {
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//input[@value='OK']")).click(); }
		 */

		(new WebDriverWait(driver, 2))
		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='did_appframe']")));
		(new WebDriverWait(driver, 2))
	    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='cp_display']")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("cp_display"));
		takeScreenshot(driver,"1.Homepage");
		  SearchPage.AsgneFldrClick(driver); 
		  driver.switchTo().parentFrame();
		  driver.switchTo().parentFrame(); driver.switchTo().parentFrame();
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
		  driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
	 /**SEARCH ASSIGNEE**/	  
	//	  SearchPage.statusINIT(driver); 
		  SearchPage.AdvancedSearchClick(driver);
		  SearchPage.clientname(driver).sendKeys("20");
		  driver.switchTo().parentFrame();
		  takeScreenshot(driver,"2.Search");	
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("svc_select_btns")); 
		  SearchPage.SearchClick(driver);
		  Thread.sleep(3500);
		  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		  driver.switchTo().parentFrame(); driver.switchTo().parentFrame();
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_bottom")); 
		  takeScreenshot(driver,"2.SearchResults");	
		  Thread.sleep(1500);
		  driver.findElement(By.xpath("//*[@id=\"did_results\"]/form/table/tbody/tr[2]/td[1]/a")).click();
		  Thread.sleep(4000);
		  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		  if (isAlertPresent()) {
 			 driver.switchTo().alert().accept();
 			 driver.switchTo().defaultContent();
 			 }
	/**ASSIGNEE PROFILE**/	  		
		  Thread.sleep(5000);
		  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
		  Thread.sleep(2500);
		  takeScreenshot(driver,"3.Assigneeprofile");
		  NewAssignee.centerofexcellence(driver).selectByIndex(1);
		  driver.switchTo().defaultContent();
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
	         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myBar"));
	         Thread.sleep(1500);
	         NewAssignee.SaveClick(driver);
		  Thread.sleep(4000);
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
          
     /**PROGRAM MFs**/    
		  driver.switchTo().defaultContent();
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("summaryButtons"));
          ExistingAssignee.ProgramTitleClick(driver);
          Thread.sleep(3000);
          driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
          driver.switchTo().defaultContent();
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_task_gadget_iframe"));
          ExistingAssignee.MasterFieldClick(driver);
          driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
          driver.switchTo().defaultContent();
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
	         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 	
          ExistingAssignee.masterfield1(driver).sendKeys("masterfields1");
          ExistingAssignee.masterfield2(driver).sendKeys("masterfields1");
          ExistingAssignee.masterfield15(driver).selectByIndex(1);
          driver.switchTo().defaultContent();
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myBar"));
          ExistingAssignee.SaveClick(driver);
          Thread.sleep(3000);
           takeScreenshot(driver,"4.MF1");	
          driver.switchTo().defaultContent();
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("summaryDetails"));
           driver.findElement(By.xpath(" //td[contains(@id,'did_info_title')]")).click(); 
           driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
           driver.switchTo().defaultContent();
           wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
	         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
	         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 	
          ExistingAssignee.MoreClick(driver);
          Thread.sleep(2000);
          driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
          takeScreenshot(driver,"5.MF2");	
          driver.switchTo().parentFrame();
          driver.switchTo().parentFrame();
          driver.switchTo().parentFrame();
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1")); 	
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 	
          ExistingAssignee.ProgramnewClick(driver);
          Thread.sleep(2000);
          driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
          driver.switchTo().parentFrame();
          driver.switchTo().parentFrame();
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_2")); 	
          wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 	
          ExistingAssignee.programnewselect(driver).selectByIndex(2);
          ExistingAssignee.OKClick(driver);
          driver.switchTo().defaultContent();
          ExistingAssignee.YESClick(driver);               
          Thread.sleep(14000);    
          driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);	
        	  takeScreenshot(driver,"6.Program copy fields message");
 			 }
	        
 

	@After
	public void teardown() throws Exception {
		// driver.quit();
	}

}
