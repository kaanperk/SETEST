package tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import page.classes.LoginPage;
import page.classes.SearchPage;
import page.classes.NewAssignee;


public class NewAssigneeApple{
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
			FileUtils.copyFile(source, new File("./Screenshots/APPLEProfile-Screenshots/" + screenshotname + ".png"));
		} catch (Exception e) {
			System.out.println("Exception during screenshot" + e.getMessage());
		}
	}

	@Before
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\avl7353\\eclipse-workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://setstgen.sirvarelocation.com";
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
		 * driver.findElement(By.xpath("//input[@value='OK']")).click(); }
		 */
		(new WebDriverWait(driver, 2))
		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='did_appframe']")));
		(new WebDriverWait(driver, 2))
	    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='cp_display']")));
		   takeScreenshot(driver,"1.Homepage");	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("cp_display"));
	    SearchPage.AsgneFldrClick(driver); 
	    Thread.sleep(2000);
	    driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        driver.switchTo().parentFrame();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
        NewAssignee.AddNewAsgneClick(driver);
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
			       driver.switchTo().parentFrame();
			       driver.switchTo().parentFrame();
			       driver.switchTo().parentFrame();
			       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
			       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
			       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			       NewAssignee.custfname(driver).sendKeys("kaan");
			       NewAssignee.custlname(driver).sendKeys("test");
			       NewAssignee.OrgClick(driver);
			       driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			       driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			       NewAssignee.orgname(driver).sendKeys("Apple");
			       driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			       driver.switchTo().parentFrame();
			       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("svc_select_btns"));
			       NewAssignee.OrgSrchBtnClick(driver);
			       driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1"));
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
			         driver.switchTo().frame(driver.findElement(By.xpath("//frame[contains(@name,'work_bottom')]")));
			       NewAssignee.OrgResultAppleClick(driver);
			       driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			       driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			       NewAssignee.programdropdown(driver).selectByIndex(1);
			       Thread.sleep(1000);
			       takeScreenshot(driver,"2.Apple New Assignee");	
			       NewAssignee.NextButtonClick(driver);
			       Thread.sleep(5000);
			       driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			       driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			       driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		/*
		 * driver.switchTo().parentFrame(); driver.switchTo().parentFrame();
		 * driver.switchTo().parentFrame();
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")
		 * ); wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
		 */
			      
			       NewAssignee.AsgneTypeClick(driver);
			       driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1")); 
			       NewAssignee.AsgneSel1Click(driver); 
			       NewAssignee.OKClick(driver);
			       takeScreenshot(driver,"3.Apple New Assignee");
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			        NewAssignee.asgmttypeselect(driver).selectByVisibleText("Long Term");
			        NewAssignee.custpreffname(driver).sendKeys("kaan");
			        NewAssignee.custpreflname(driver).sendKeys("test");
			        NewAssignee.phnetype1dropdown(driver).selectByIndex(1);
			        NewAssignee.phne1country(driver).sendKeys("+44");
			        NewAssignee.phne1areacode(driver).sendKeys("312");
			        NewAssignee.phne1nbr(driver).sendKeys("4567890");
			        NewAssignee.custemail(driver).sendKeys("test@sirva.com"); 
			       NewAssignee.custaddr1(driver).sendKeys("321 test ave");
			       NewAssignee.custprefcity(driver).sendKeys("Chicago");
			       NewAssignee.zip(driver).sendKeys("60601");
			       takeScreenshot(driver,"4.Apple New Assignee");
			       NewAssignee.highlevelsob(driver).selectByIndex(1);
			       NewAssignee.sublob(driver).selectByIndex(1);
			       driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
			       NewAssignee.svpvp(driver).selectByIndex(1);
			       NewAssignee.curasgmtcountry(driver).selectByIndex(1);
			       NewAssignee.curasgmtstate(driver).selectByIndex(1);
			       NewAssignee.curcity(driver).sendKeys("New York");
			       NewAssignee.asgmtbegindate(driver).sendKeys("1/1/2019");
			       NewAssignee.asgmtbegindate(driver).sendKeys(Keys.ESCAPE);
			       NewAssignee.asgmtenddate(driver).sendKeys("1/1/2020");
			       NewAssignee.asgmtenddate(driver).sendKeys(Keys.ESCAPE);
			       NewAssignee.newasgmtcountry(driver).selectByIndex(2);
			       NewAssignee.newcity(driver).sendKeys("test");
			       takeScreenshot(driver,"5.Apple New Assignee");	
			       NewAssignee.custreferuid(driver).selectByIndex(2);
			       NewAssignee.gac(driver).selectByIndex(1);
			       NewAssignee.centerofexcellence(driver).selectByIndex(1);
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myBar"));
			         takeScreenshot(driver,"6.Apple New Assignee");
			         NewAssignee.SaveClick(driver);
			         Thread.sleep(2000);
					  if (isAlertPresent()) {
					  driver.switchTo().alert().accept(); 
					  driver.switchTo().parentFrame(); 
					  driver.switchTo().parentFrame();
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myBar"));
					  Thread.sleep(2000);
					  driver.switchTo().parentFrame(); 
					  driver.switchTo().parentFrame();
					  driver.switchTo().parentFrame(); 
					  driver.findElement(By.xpath("//input[@value='Yes']")).click(); 
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
				       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("summaryButtons"));  	
					  Thread.sleep(8000);
					  (new WebDriverWait(driver, 2))
					  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@id='did_program_title_1']")));
					  driver.switchTo().defaultContent();
				   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
				         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
				         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
				   		  Thread.sleep(8000);
				   		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
				   		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Assignee Types')]")));
				        takeScreenshot(driver,"7.Apple Profile Completed");
					  } else {
						     driver.switchTo().defaultContent();
				        	 driver.findElement(By.xpath("//input[@value='Yes']")).click();
				        	  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
				   	       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("summaryButtons"));  	
				   		  Thread.sleep(15000);
				   		  (new WebDriverWait(driver, 3))
				   		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@id='did_program_title_1']")));
				   		  driver.switchTo().defaultContent();
				   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
				         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
				         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
				   		  Thread.sleep(8000);
				   		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
				   		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Assignee Types')]")));
				   	      takeScreenshot(driver,"7.Apple Profile Completed");
					  }
			         Thread.sleep(300);
					  driver.switchTo().defaultContent();
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
				         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
				         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
						         WebElement element =   driver.findElement((By.xpath("//select[@name = 'cust_Curr_Worksite_Location'] ")));
						         Actions actions = new Actions(driver);
						         actions.moveToElement(element);
						         actions.perform();
						         takeScreenshot(driver,"8.Apple Profile Completed");
						         Thread.sleep(1000);
							  	
						       
						         
						         WebElement element11 =     driver.findElement(By.xpath("//select[@name='home_country']"));
						         Actions actions11 = new Actions(driver);
						         actions11.moveToElement(element11);
						         actions11.perform();
						         takeScreenshot(driver,"9.Apple Profile Completed");
						         Thread.sleep(1000);
						         
						         
						         WebElement    element1 =     driver.findElement(By.xpath("//textarea[@name='special_needs']"));
						         Actions actions1 = new Actions(driver);
						         actions1.moveToElement(element1);
						         actions1.perform();
						         takeScreenshot(driver,"10.Apple Profile Completed");
						         Thread.sleep(1000);


						         WebElement    element2 =   driver.findElement((By.xpath("//textarea[@name = 'cust_oth_special_needs_1']")));
						         Actions actions2 = new Actions(driver);
						         actions2.moveToElement(element2);
						         actions2.perform();
						         takeScreenshot(driver,"11.Apple Profile Completed");
						         Thread.sleep(1000);
						        
						         WebElement    element3 =    driver.findElement(By.xpath("//input[@name='cust_authorized_date']"));
						         Actions actions3 = new Actions(driver);
						         actions3.moveToElement(element3);
						         actions3.perform();
						         takeScreenshot(driver,"12.Apple Profile Completed");
						         Thread.sleep(1000);
						         
						         WebElement    element4 =       driver.findElement(By.xpath("//input[@name='cust_box_number']"));
						         Actions actions4 = new Actions(driver);
						         actions4.moveToElement(element4);
						         actions4.perform();
						         takeScreenshot(driver,"13.Apple Profile Completed");
						         Thread.sleep(1000);
							  
		}					  
							  
			     
			     @After
			     public void teardown() throws Exception{
			    	 //driver.quit(); 
			     }
				
			}