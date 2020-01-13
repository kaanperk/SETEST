package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.classes.LoginPage;
import page.classes.SearchPage;
import page.classes.NewAssignee;


public class NewAssigneeHoneywell {
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
			FileUtils.copyFile(source, new File("./Screenshots/HONEYWELLProfile-Screenshots/" + screenshotname + ".png"));
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
			FileInputStream ip=new FileInputStream("/Users/avl7353/git/SETEST/SETEST/src/page/classes/config.properties");

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

			
			  if
			  (driver.findElement(By.xpath("//th[@id='did_confirm_title']")).isEnabled()) {
			  driver.findElement(By.xpath("//input[@value='OK']")).click(); }
    
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("cp_display"));
	    takeScreenshot(driver,"1.Homepage");	
	    SearchPage.AsgneFldrClick(driver); 
	    Thread.sleep(3000);
	    driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        driver.switchTo().parentFrame();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
        NewAssignee.AddNewAsgneClick(driver);
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
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
			       NewAssignee.orgname(driver).sendKeys("Honeywell - ACS");
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
			       NewAssignee.OrgresultHONClick(driver);
			       driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			       driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			       NewAssignee.programdropdown(driver).selectByIndex(1);
			       Thread.sleep(1000);
			       takeScreenshot(driver,"2.Honeywell New Assignee Profile");
			       NewAssignee.NextButtonClick(driver);
			       Thread.sleep(1000);
			       driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         driver.switchTo().parentFrame();
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			    
			       driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			     
			         takeScreenshot(driver,"3.Honeywell New Assignee Profile");
		
			         NewAssignee.employeeid(driver).sendKeys("1234567");
			         NewAssignee.asgmttypeselect(driver).selectByVisibleText("Long Term");
			         NewAssignee.relostatus(driver).selectByIndex(1);
			         NewAssignee.RC(driver).selectByIndex(1);
			         NewAssignee.MC(driver).selectByIndex(1);
			         NewAssignee.opsmgr(driver).selectByIndex(1);
			         Thread.sleep(1500);
			         NewAssignee.AssigneetypeHONClick(driver);
					  driver.switchTo().parentFrame();
					  driver.switchTo().parentFrame(); 
					  driver.switchTo().parentFrame();
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1")); 
					  NewAssignee.AsgneSel1Click(driver);
					  Thread.sleep(1000);
					  NewAssignee.OKClick(driver); driver.switchTo().parentFrame();
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
			         
		
		  NewAssignee.custminame(driver).sendKeys("middle");
		  NewAssignee.custsalutation(driver).selectByVisibleText("Mr.");
		  NewAssignee.custsuffix(driver).selectByIndex(2);
		  NewAssignee.custprefsalutation(driver).selectByIndex(3);
		  NewAssignee.custpreffname(driver).sendKeys("kaan");
		  NewAssignee.custprefminame(driver).sendKeys("prefmi");
		  NewAssignee.custpreflname(driver).sendKeys("test");
		  NewAssignee.custprefsalutation(driver).selectByIndex(2);
		  NewAssignee.custprefsuffix(driver).selectByIndex(3);
		  
		/*
		 * NewAssignee.maritalstatus(driver).selectByVisibleText("Married");
		 * NewAssignee.citizenshipcountry(driver).selectByVisibleText("United States");
		 * 
		 * NewAssignee.dualcitizenshipcountry(driver).selectByVisibleText("Germany");
		 * NewAssignee.custpassportnbr(driver).sendKeys("258465");
		 * NewAssignee.custpassportnbr(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.pasprtissuedate(driver).sendKeys("1/1/2015");
		 * NewAssignee.pasprtissuedate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.pasprtexpiredate(driver).sendKeys("1/1/2020");
		 * NewAssignee.pasprtexpiredate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.visatype(driver).sendKeys("visa type");
		 * NewAssignee.visastatus(driver).sendKeys("visa stat");
		 * NewAssignee.visaissuedate(driver).sendKeys("1/1/2019");
		 * NewAssignee.visaissuedate(driver).sendKeys(Keys.ESCAPE); Thread.sleep(1500);
		 * NewAssignee.visaexpdateHON(driver).sendKeys("1/15/2021");
		 * NewAssignee.visaexpdateHON(driver).sendKeys(Keys.ESCAPE);
		 * 
		 * NewAssignee.CustLanguagesClick(driver); driver.switchTo().parentFrame();
		 * driver.switchTo().parentFrame(); driver.switchTo().parentFrame();
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
		 * "did_dmode_frame_1"));
		 * waitForElementToBeVisible(driver,NewAssignee.English(driver),3);
		 * NewAssignee.LanguageEnglishClick(driver); NewAssignee.OKClick(driver);
		 * driver.switchTo().parentFrame();
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")
		 * ); wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
		 * Thread.sleep(2000);
		 * 
		 * NewAssignee.birthdate(driver).sendKeys("7/15/1976");
		 * NewAssignee.birthdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.birthcountry(driver).selectByVisibleText("United States");
		 * NewAssignee.birthstate(driver).selectByVisibleText("Illinois");
		 * NewAssignee.birthcity(driver).sendKeys("Chicago");
		 * NewAssignee.familysizeonasgnmt(driver).sendKeys("4");
		 * NewAssignee.familysize(driver).sendKeys("5");
		 */
		  
		  NewAssignee.custemail(driver).sendKeys("test@sirva.com");
		  NewAssignee.pfdcm(driver).selectByVisibleText("Email");
		//  NewAssignee.cust2email(driver).sendKeys("test2@sirva.com");
		  
		  NewAssignee.phnetype1dropdown(driver).selectByIndex(1);
		  NewAssignee.phne1country(driver).sendKeys("+1");
		  NewAssignee.phne1areacode(driver).sendKeys("312");
		  NewAssignee.phne1nbr(driver).sendKeys("4567890");
		/*
		 * NewAssignee.phnetype2dropdown(driver).selectByIndex(2);
		 * NewAssignee.phne2country(driver).sendKeys("+44");
		 * NewAssignee.phne2areacode(driver).sendKeys("55");
		 * NewAssignee.phne2nbr(driver).sendKeys("123456789");
		 * NewAssignee.phnetype3dropdown(driver).selectByIndex(3);
		 * NewAssignee.phne3country(driver).sendKeys("+23");
		 * NewAssignee.phne3areacode(driver).sendKeys("67");
		 * NewAssignee.phne3nbr(driver).sendKeys("35790863");
		 * NewAssignee.phnetype4dropdown(driver).selectByIndex(4);
		 * NewAssignee.phne4country(driver).sendKeys("+67");
		 * NewAssignee.phne4areacode(driver).sendKeys("3");
		 * NewAssignee.phne4nbr(driver).sendKeys("56709342");
		 */
		//  NewAssignee.newtitle(driver).sendKeys("New Title");
		  NewAssignee.asgmtbegindate(driver).sendKeys("1/1/2019");
		  NewAssignee.asgmtbegindate(driver).sendKeys(Keys.ESCAPE);
		  NewAssignee.asgmtenddate(driver).sendKeys("1/1/2020");
		  NewAssignee.asgmtenddate(driver).sendKeys(Keys.ESCAPE);
		/*
		 * NewAssignee.dtextstartdate(driver).sendKeys("5/1/2020");
		 * NewAssignee.dtextstartdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.dtextenddate(driver).sendKeys("12/30/2020");
		 * NewAssignee.dtextenddate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.actualstartdate(driver).sendKeys("4/15/2019");
		 * NewAssignee.actualstartdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.actualenddate(driver).sendKeys("5/15/2021");
		 * NewAssignee.actualenddate(driver).sendKeys(Keys.ESCAPE);
		 */
		  NewAssignee.custreferuid(driver) .selectByIndex(2);
		 
		  NewAssignee.SBU(driver).selectByIndex(1);
		  NewAssignee.SBE(driver).selectByIndex(1);
		  NewAssignee.hyperioncode(driver).selectByIndex(1);
		  NewAssignee.curasgmtcountry(driver).selectByVisibleText("United States");
			 NewAssignee.curcity(driver).sendKeys("Chicago");
			  NewAssignee.newasgmtcountry(driver).selectByVisibleText("United States");
			  NewAssignee.newcity(driver).sendKeys("Boston");
			  
			  
			  NewAssignee.custaddr1(driver).sendKeys("321 test ave");
			  NewAssignee.custaddr2(driver).sendKeys("addr2 test");
			  NewAssignee.custprefcity(driver).sendKeys("Chicago");
			  NewAssignee.zip(driver).sendKeys("60601"); 
			  takeScreenshot(driver,"4.Honeywell New Assignee Profile");
			  

		//	  NewAssignee.specialneeds(driver).sendKeys("Special Needs");
		
	
			  

		/*
		 * NewAssignee.DependentaccompYES(driver);
		 * NewAssignee.dependentrelation(driver).selectByVisibleText("Spouse");
		 * NewAssignee.dependentprefix(driver).selectByVisibleText("Mrs.");
		 * NewAssignee.dependentfirstname(driver).sendKeys("Spouse first");
		 * NewAssignee.dependentmidname(driver).sendKeys("midname");
		 * NewAssignee.dependentlastname(driver).sendKeys("lastname");
		 * NewAssignee.dependentsuffix(driver).selectByVisibleText("Sr.");
		 * NewAssignee.dependentprefprefix(driver).selectByVisibleText("Dr.");
		 * NewAssignee.dependentpreffname(driver).sendKeys("pref fname");
		 * NewAssignee.dependentprefmidname(driver).sendKeys("pmid");
		 * NewAssignee.dependentpreflname(driver).sendKeys("preflast");
		 * NewAssignee.dependentprefsuffix(driver).selectByVisibleText("V");
		 * 
		 * 
		 * 
		 * NewAssignee.dependentphonetype1(driver).selectByVisibleText("Other");
		 * NewAssignee.dependentphone1country(driver).sendKeys("1");
		 * NewAssignee.dependentphone1areacode(driver).sendKeys("657");
		 * NewAssignee.dependentphone1nbr(driver).sendKeys("35674125");
		 * NewAssignee.dependentphonetype2(driver).selectByVisibleText("Dest Home");
		 * NewAssignee.dependentphone2country(driver).sendKeys("1");
		 * NewAssignee.dependentphone2areacode(driver).sendKeys("657");
		 * NewAssignee.dependentphone2nbr(driver).sendKeys("35674125");
		 * 
		 * 
		 * 
		 * NewAssignee.dependentbirthdate(driver).sendKeys("3/21/1985");
		 * NewAssignee.dependentbirthdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.dependentemail(driver).sendKeys("dep1@sirva.com");
		 * NewAssignee.dependentcitizenship(driver).selectByVisibleText("United States"
		 * );
		 * NewAssignee.dependentdualcitizenship(driver).selectByVisibleText("Germany");
		 * NewAssignee.dependentgender(driver).selectByVisibleText("Female");
		 * Thread.sleep(1500); NewAssignee.DependentLanguagesClick(driver);
		 * driver.switchTo().parentFrame(); driver.switchTo().parentFrame();
		 * driver.switchTo().parentFrame();
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
		 * "did_dmode_frame_1")); NewAssignee.LanguageGermanClick(driver);
		 * NewAssignee.OKClick(driver); driver.switchTo().parentFrame();
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")
		 * ); wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
		 * 
		 * NewAssignee.depspecialneedsHON(driver).sendKeys("Dependent special needs");
		 * 
		 * 
		 * NewAssignee.PetsaccompYES(driver);
		 * NewAssignee.petnbr(driver).selectByVisibleText("2");
		 * NewAssignee.pettypes(driver).sendKeys("dogs, cat, bird");
		 * NewAssignee.petweights(driver).sendKeys("dog 15lbs, cat 10lbs, bird 8lbs");
		 * NewAssignee.petcomments(driver).sendKeys("pet comments");
		 * 
		 * NewAssignee.homesalary(driver).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.
		 * END),"245000");
		 * NewAssignee.homesalarycurrency(driver).selectByVisibleText("US Dollar");
		 * NewAssignee.miscallowance(driver).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,
		 * Keys.END),"7500.00");
		 * NewAssignee.miscallowancecurrency(driver).selectByIndex(5);
		 * NewAssignee.housingallowance(driver).sendKeys(Keys.HOME,
		 * Keys.chord(Keys.SHIFT,Keys.END),"10000.00");
		 * NewAssignee.housingallowancecurrency(driver).selectByIndex(3);
		 * NewAssignee.utilityallowance(driver).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT
		 * ,Keys.END),"8000.00");
		 * NewAssignee.utilityallowancecurrency(driver).selectByIndex(4);
		 * 
		 * NewAssignee.arrivalinhostcountrydate(driver).sendKeys("3/1/2019");
		 * NewAssignee.arrivalinhostcountrydate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.permhousingmoveindate(driver).sendKeys("3/15/2019");
		 * NewAssignee.permhousingmoveindate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.permhousingmoveoutdate(driver).sendKeys("9/15/2020");
		 * NewAssignee.permhousingmoveoutdate(driver).sendKeys(Keys.ESCAPE);
		 */

			
		        
		 NewAssignee.gac(driver).selectByVisibleText("Perk, Kaan");
	//	  NewAssignee.previousgac(driver).selectByIndex(1);
		  NewAssignee.centerofexcellence(driver).selectByIndex(1);
	      NewAssignee.custauthdate(driver).sendKeys("11/1/2019");
		/*
		 * NewAssignee.custauthdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.initialcontactdate(driver).sendKeys("10/15/2019");
		 * NewAssignee.initialcontactdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.initialcontacttime(driver).sendKeys("8:45");
		 * NewAssignee.initiationcalldate(driver).sendKeys("11/5/2018");
		 * NewAssignee.initiationcalldate(driver).sendKeys(Keys.ESCAPE);
		 */
		
		  NewAssignee.wtid(driver).sendKeys("222333");
		
		//  NewAssignee.surveydate(driver).sendKeys("02/15/2019");
		  NewAssignee.surveydate(driver).sendKeys(Keys.ESCAPE);
		  
		 

		  driver.switchTo().parentFrame(); 
		  driver.switchTo().parentFrame();
		  driver.switchTo().parentFrame();
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myBar"));
		  
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
	   		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'javascript:popup_custom_SIRVA')]")));
	   		Thread.sleep(1500);
	   	 takeScreenshot(driver,"5.Honeywell Profile Completed");
		  } else {
			     driver.switchTo().defaultContent();
	        //	 driver.findElement(By.xpath("//input[@value='Yes']")).click();
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
	   		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'javascript:popup_custom_SIRVA')]")));
	   		Thread.sleep(1500);
	   		takeScreenshot(driver,"5.Honeywell Profile Completed");
		  }  
		   Thread.sleep(1500);
		   driver.switchTo().defaultContent(); 
			  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
			  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
			  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
	         
		   driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	          WebElement element =    driver.findElement(By.xpath("//input[@name='dt_new_assignment_begin']"));
		         Actions actions = new Actions(driver);
		         actions.moveToElement(element);
		         actions.perform();
		         takeScreenshot(driver,"6.Honeywell Profile Completed");
		         Thread.sleep(1500);
		   
		         
		          WebElement element2 =    	   driver.findElement(By.xpath("//input[@name='cust_address1_1']"));
			         Actions actions2 = new Actions(driver);
			         actions2.moveToElement(element2);
			         actions2.perform();
			         takeScreenshot(driver,"7.Honeywell Profile Completed");
			         Thread.sleep(1500);
		   
			         WebElement element3 =    	  driver.findElement(By.xpath("//input[@name='cust_authorized_date']"));
			         Actions actions3 = new Actions(driver);
			         actions3.moveToElement(element3);
			         actions3.perform();
			         takeScreenshot(driver,"8.Honeywell Profile Completed");
			         Thread.sleep(1500);
		   

	     
	     
				  
}					  
  
			     
			     @After
			     public void teardown() throws Exception{
			    	// driver.quit(); 
			     }
				
			}