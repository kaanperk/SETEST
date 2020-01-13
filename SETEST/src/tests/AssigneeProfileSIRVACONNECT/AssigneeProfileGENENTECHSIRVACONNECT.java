package tests.AssigneeProfileSIRVACONNECT;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.classes.LoginPage;
import page.classes.SearchPage;
import page.classes.NewAssignee;

public class AssigneeProfileGENENTECHSIRVACONNECT {
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
			FileUtils.copyFile(source, new File("./Screenshots/SIRVACONNECT-GENENTECH/" + screenshotname + ".png"));
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
		
		SearchPage.AsgneFldrClick(driver);
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
		NewAssignee.AddNewAsgneClick(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
		NewAssignee.custfname(driver).sendKeys("kaan");
		NewAssignee.custlname(driver).sendKeys("test");
		NewAssignee.OrgClick(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
		NewAssignee.orgname(driver).sendKeys("Genentech - Candidate");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("svc_select_btns"));
		NewAssignee.OrgSrchBtnClick(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[contains(@name,'work_bottom')]")));
		NewAssignee.OrgresultGNEClick(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
		NewAssignee.programdropdown(driver).selectByIndex(1);
		Thread.sleep(1000);
		
		NewAssignee.NextButtonClick(driver);
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));

		NewAssignee.AsgneTypeClick(driver);
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1"));
		NewAssignee.AsgneSel1Click(driver);
		NewAssignee.OKClick(driver);
		driver.switchTo().parentFrame();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));

		NewAssignee.asgmttypeselect(driver).selectByVisibleText("Long Term");
	//	NewAssignee.custsalutation(driver).selectByVisibleText("Mr.");
	//	NewAssignee.custminame(driver).sendKeys("middle");
	//	NewAssignee.custsuffix(driver).selectByIndex(2);
	//	NewAssignee.custprefsalutation(driver).selectByIndex(3);
		NewAssignee.custpreffname(driver).sendKeys("kaan");
	//	NewAssignee.custprefminame(driver).sendKeys("prefmi");
		NewAssignee.custpreflname(driver).sendKeys("test");
	//	NewAssignee.custprefsalutation(driver).selectByIndex(2);
	//	NewAssignee.custprefsuffix(driver).selectByIndex(3);
		

		NewAssignee.phnetype1dropdown(driver).selectByIndex(1);
		NewAssignee.phne1country(driver).sendKeys("+1");
		NewAssignee.phne1areacode(driver).sendKeys("312");
		NewAssignee.phne1nbr(driver).sendKeys("4567890");
		//NewAssignee.phnetype2dropdown(driver).selectByIndex(2);
		/*
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
		Thread.sleep(1000);
		takeScreenshot(driver, "3.Genentech New Assignee Profile");
		

		NewAssignee.custemail(driver).sendKeys("test@sirva.com");
		NewAssignee.pfdcm(driver).selectByVisibleText("Email");
	//	NewAssignee.cust2email(driver).sendKeys("test2@sirva.com");

		/*
		 * NewAssignee.custssn(driver).sendKeys("123456789");
		 * NewAssignee.gender(driver).selectByVisibleText("Male");
		 * NewAssignee.maritalstatus(driver).selectByVisibleText("Married");
		 * NewAssignee.birthdate(driver).sendKeys("7/15/1976");
		 * NewAssignee.birthdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.birthcountry(driver).selectByVisibleText("United States");
		 * NewAssignee.birthstate(driver).selectByVisibleText("Illinois");
		 * NewAssignee.birthcity(driver).sendKeys("Chicago");
		 */

		NewAssignee.custaddr1(driver).sendKeys("321 test ave");
		NewAssignee.custaddr2(driver).sendKeys("addr2 test");
		NewAssignee.custprefcity(driver).sendKeys("Chicago");
		NewAssignee.zip(driver).sendKeys("60601");

		

		/*
		 * NewAssignee.custtitle(driver).sendKeys("old title");
		 * NewAssignee.mgrname(driver).sendKeys("Bob Smith");
		 */
		NewAssignee.curasgmtcountry(driver).selectByVisibleText("United States");
		NewAssignee.curasgmtstate(driver).selectByVisibleText("Illinois");
		NewAssignee.curcity(driver).sendKeys("Chicago");

	//	NewAssignee.newtitle(driver).sendKeys("New Title");
		NewAssignee.asgmtbegindate(driver).sendKeys("1/1/2019");
		NewAssignee.asgmtbegindate(driver).sendKeys(Keys.ESCAPE);
		NewAssignee.asgmtenddate(driver).sendKeys("1/1/2020");
		NewAssignee.asgmtenddate(driver).sendKeys(Keys.ESCAPE);
		/*
		 * NewAssignee.actualstartdate(driver).sendKeys("4/15/2019");
		 * NewAssignee.actualstartdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.actualenddate(driver).sendKeys("5/15/2021");
		 * NewAssignee.actualenddate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.newmanager(driver).sendKeys("Sam Adams");
		 */
		NewAssignee.newasgmtcountry(driver).selectByVisibleText("United States");
		NewAssignee.newcity(driver).sendKeys("Boston");
		Thread.sleep(1000);
		takeScreenshot(driver, "4.Genentech New Assignee Profile");

		/*
		 * NewAssignee.newcostcenter(driver).sendKeys("432123");
		 * NewAssignee.newcostcenter2(driver).sendKeys("5555555");
		 * NewAssignee.PO(driver).sendKeys("PO123456");
		 * NewAssignee.employeeid(driver).sendKeys("112233");
		 * NewAssignee.personelid(driver).sendKeys("personnel id");
		 * NewAssignee.persistid(driver).sendKeys("persist id");
		 * NewAssignee.compcode(driver).selectByIndex(1);
		 * NewAssignee.jobofferaccepteddate(driver).sendKeys("2/15/2019");
		 * NewAssignee.jobofferaccepteddate(driver).sendKeys(Keys.ESCAPE);
		 * Thread.sleep(1500); NewAssignee.joboffracceptedY(driver);
		 * NewAssignee.joboffertype(driver).selectByIndex(1);
		 */

		/*
		 * NewAssignee.homefilingstatus(driver).selectByIndex(1);
		 * NewAssignee.homefilingcountry(driver).selectByIndex(1); Thread.sleep(1500);
		 * NewAssignee.homefilingstate(driver).selectByIndex(1);
		 * NewAssignee.homefilingcity(driver).sendKeys("Chicago");
		 * NewAssignee.homesalary(driver).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT,
		 * Keys.END), "245000");
		 * NewAssignee.homesalarycurrency(driver).selectByVisibleText("US Dollar");
		 * NewAssignee.perdiemmoney(driver).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT,
		 * Keys.END), "3500"); NewAssignee.perdiemcurrency(driver).selectByIndex(1);
		 * NewAssignee.overallbudget(driver).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT,
		 * Keys.END), "35000.00");
		 * NewAssignee.overallbudgetcurrency(driver).selectByIndex(2);
		 * NewAssignee.housingallowance(driver).sendKeys(Keys.HOME,
		 * Keys.chord(Keys.SHIFT, Keys.END), "10000.00");
		 * NewAssignee.housingallowancecurrency(driver).selectByIndex(3);
		 * NewAssignee.utilityallowance(driver).sendKeys(Keys.HOME,
		 * Keys.chord(Keys.SHIFT, Keys.END), "8000.00");
		 * NewAssignee.utilityallowancecurrency(driver).selectByIndex(4);
		 * NewAssignee.miscallowance(driver).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT,
		 * Keys.END), "7500.00");
		 * NewAssignee.miscallowancecurrency(driver).selectByIndex(5);
		 * NewAssignee.arrivalinhostcountrydate(driver).sendKeys("3/1/2019");
		 * NewAssignee.arrivalinhostcountrydate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.permhousingmoveindate(driver).sendKeys("3/15/2019");
		 * NewAssignee.permhousingmoveindate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.permhousingmoveoutdate(driver).sendKeys("9/15/2020");
		 * NewAssignee.permhousingmoveoutdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.specialneeds(driver).sendKeys("Special Needs");
		 */

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
		 * NewAssignee.dependentphonetype1(driver).selectByVisibleText("Other");
		 * NewAssignee.dependentphone1country(driver).sendKeys("1");
		 * NewAssignee.dependentphone1areacode(driver).sendKeys("657");
		 * NewAssignee.dependentphone1nbr(driver).sendKeys("35674125");
		 * NewAssignee.dependentphonetype2(driver).selectByVisibleText("Dest Home");
		 * NewAssignee.dependentphone2country(driver).sendKeys("1");
		 * NewAssignee.dependentphone2areacode(driver).sendKeys("657");
		 * NewAssignee.dependentphone2nbr(driver).sendKeys("35674125");
		 * 
		 * NewAssignee.dependentssn(driver).sendKeys("1230456");
		 * NewAssignee.dependentoccup(driver).sendKeys("dep occup");
		 * NewAssignee.DependentLanguagesClick(driver); driver.switchTo().parentFrame();
		 * driver.switchTo().parentFrame(); driver.switchTo().parentFrame();
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
		 * "did_dmode_frame_1")); NewAssignee.LanguageGermanClick(driver);
		 * NewAssignee.OKClick(driver); driver.switchTo().parentFrame();
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")
		 * ); wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
		 * NewAssignee.dependentgender(driver).selectByVisibleText("Female");
		 * NewAssignee.dependentbirthdate(driver).sendKeys("3/21/1985");
		 * NewAssignee.dependentbirthdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.dependentbirthcountry(driver).selectByVisibleText("United States"
		 * ); NewAssignee.dependentemail(driver).sendKeys("dep1@sirva.com");
		 * NewAssignee.dependentcitizenship(driver).selectByVisibleText("United States"
		 * ); NewAssignee.dependentlocated(driver).selectByIndex(1);
		 * NewAssignee.dependentfrom(driver).sendKeys("1/1/2000");
		 * NewAssignee.dependentfrom(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.dependenttill(driver).sendKeys("1/15/2020");
		 * NewAssignee.dependenttill(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.dependentneeds(driver).sendKeys("dependent needs");
		 * 
		 * NewAssignee.PetsaccompYES(driver);
		 * NewAssignee.petnbr(driver).selectByVisibleText("2");
		 * NewAssignee.pettypes(driver).sendKeys("dogs, cat, bird");
		 * NewAssignee.petweights(driver).sendKeys("dog 15lbs, cat 10lbs, bird 8lbs");
		 * NewAssignee.petcomments(driver).sendKeys("pet comments");
		 */

		NewAssignee.custreferuid(driver).selectByIndex(2);
		/*
		 * NewAssignee.othercontact(driver).sendKeys("other contact");
		 * NewAssignee.hiredate(driver).sendKeys("3/15/2015");
		 * NewAssignee.hiredate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.execofficer(driver).selectByVisibleText("No");
		 * NewAssignee.hirestatus(driver).selectByVisibleText("Transfer");
		 * NewAssignee.hirecountry(driver).selectByVisibleText("United States");
		 */

		/*
		 * NewAssignee.PreviousassignmentYES(driver);
		 * NewAssignee.CountriesVisitedClick(driver); driver.switchTo().parentFrame();
		 * driver.switchTo().parentFrame(); driver.switchTo().parentFrame();
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
		 * "did_dmode_frame_1")); waitForElementToBeVisible(driver,
		 * NewAssignee.countryARG(driver), 3); NewAssignee.CountryARGselected(driver);
		 * NewAssignee.OKClick(driver); driver.switchTo().parentFrame();
		 * driver.switchTo().parentFrame(); driver.switchTo().parentFrame();
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")
		 * ); wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
		 * Thread.sleep(2000);
		 */

		NewAssignee.gac(driver).selectByVisibleText("Perk, Kaan");
	//	NewAssignee.previousgac(driver).selectByIndex(1);
		NewAssignee.centerofexcellence(driver).selectByIndex(1);
		 Select s = new Select(driver.findElement(By.xpath("//select[@id='ddlb_Authorizefor']")));
		 List<WebElement> dd_options= s.getOptions();
		 int i =1;
		 System.out.println("GENENTECH PROFILE");
		 for (WebElement e:dd_options) {
			 System.out.println(i+ " - "+e.getText());
			 i++;
		 }
		 System.out.println("");
		 
		Thread.sleep(1000);
		takeScreenshot(driver, "5.Genentech New Assignee Profile");
		
	
		  driver.switchTo().parentFrame(); 
		  driver.switchTo().parentFrame();
		  driver.switchTo().parentFrame();
		 
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myBar"));

		NewAssignee.SaveClick(driver);
		 if (isAlertPresent()) {
	   		  driver.switchTo().alert().accept(); 
	   		  driver.switchTo().parentFrame(); 
	   		  driver.switchTo().parentFrame();
	   		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
	   		  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myBar"));
	   		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS); 
	   		  driver.switchTo().parentFrame(); 
	   		  driver.switchTo().parentFrame();
	   		  driver.switchTo().parentFrame(); 
	   		  driver.findElement(By.xpath("//input[@value='Yes']")).click(); 
	   		  driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	   		 Thread.sleep(1500);
	   		takeScreenshot(driver, "6.Genentech Profile Completed");
	   		  }

	         driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS); 
	         driver.switchTo().parentFrame();
	         driver.switchTo().parentFrame();
	         driver.switchTo().parentFrame();
	         driver.switchTo().parentFrame();
	    if (driver.findElement(By.xpath("//th[@id='did_confirm_title']")).isEnabled()) {
	        	 driver.findElement(By.xpath("//input[@value='Yes']")).click();	 
	         }
	         driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS); 
	         Thread.sleep(1500);
		       driver.switchTo().defaultContent();
				  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work")); 
			         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top")); 
			     	takeScreenshot(driver, "6.Genentech Profile Completed");
			         
			     	  driver.switchTo().defaultContent();
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
					 
					  WebElement element7 = driver.findElement(By.xpath("//select[@id='ddlb_Authorizefor']"));
					  Actions actions7 = new Actions(driver); 
					  actions7.moveToElement(element7);
					  actions7.perform(); 

					  NewAssignee.authorizefor(driver).selectByIndex(3);
					  
					  driver.switchTo().parentFrame();
					  driver.switchTo().parentFrame();
					  driver.switchTo().parentFrame();
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myBar"));
					  NewAssignee.SaveClick(driver); 
					  Thread.sleep(2000);
					  
					  Alert alert = driver.switchTo().alert();
					  alert.accept();
					  	    
					  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
					  
					  driver.switchTo().parentFrame();
					  driver.switchTo().parentFrame();
					  driver.switchTo().parentFrame();
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
					  
					  WebElement element8 = driver.findElement(By.xpath("//a[contains(.,'Employee Portal Info')]"));
					  Actions actions8 = new Actions(driver); 
					  actions8.moveToElement(element8);
					  actions8.perform(); 
					  
					  takeScreenshot(driver,"2. Authorize For selected");
					  Thread.sleep(1500);
					  
					  
					  NewAssignee.EmployeePortalClick(driver);
					  Thread.sleep(2000);
					  takeScreenshot(driver,"3. Employee Portal Info");
					  Thread.sleep(2000);
					  driver.switchTo().defaultContent();
					  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1")); 
					 
					  System.out.println("AFTER SIRVA Connect Employee Portal AUTHORIZED");
				      System.out.println(driver.findElement(By.xpath("//*[@id=\"form1\"]/div/table[1]/tbody/tr/td")).getText());
					  
					// Get all the table row elements from the table 
					  List<WebElement> allRows = driver.findElements(By.xpath("//*[@id=\"form1\"]/div/table[2]/tbody/tr")); 

					  // And iterate over them and get all the cells 
					  for (WebElement row : allRows) { 
					      List<WebElement> cells = row.findElements(By.tagName("td")); 

					      // Print the contents of each cell
					      for (WebElement cell : cells) {         

					      System.out.println(cell.getText());
					      }
					    }
					  
					  Thread.sleep(2000);
					  driver.switchTo().defaultContent();
					  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
						(new WebDriverWait(driver, 2))
						  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='did_modbox_title_1']")));
			           NewAssignee.DmodcloseClick(driver);   

					    Thread.sleep(1500);
					    
					    driver.switchTo().parentFrame();
						  driver.switchTo().parentFrame();
						  driver.switchTo().parentFrame();
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
					    
					    NewAssignee.authorizefor(driver).selectByIndex(2);
					    driver.switchTo().parentFrame();
						  driver.switchTo().parentFrame();
						  driver.switchTo().parentFrame();
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myBar"));
						  
						  NewAssignee.SaveClick(driver); 
						  Thread.sleep(1000);  
						  
						  alert.accept();
						  Thread.sleep(1500);
						  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
						  
						  driver.switchTo().parentFrame();
						  driver.switchTo().parentFrame();
						  driver.switchTo().parentFrame();
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
						  WebElement element9 = driver.findElement(By.xpath("//a[contains(.,'Employee Portal Info')]"));
						  Actions actions9 = new Actions(driver); 
						  actions9.moveToElement(element9);
						  actions9.perform(); 
						  takeScreenshot(driver,"4. Authorize For selected2");
					  
						  
						   driver.switchTo().parentFrame();
							  driver.switchTo().parentFrame();
							  driver.switchTo().parentFrame();
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
						  
						  NewAssignee.EmployeePortalClick(driver);
						  Thread.sleep(2000);
						  takeScreenshot(driver,"5. Employee Portal Info2");
						  Thread.sleep(1000);
						  driver.switchTo().defaultContent();
						  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1")); 
						 
						  System.out.println("AFTER IMOVE Portal AUTHORIZED");
					      System.out.println(driver.findElement(By.xpath("//*[@id=\"form1\"]/div/table[1]/tbody/tr/td")).getText());
						  
						// Get all the table row elements from the table 
						  List<WebElement> allRows2 = driver.findElements(By.xpath("//*[@id=\"form1\"]/div/table[2]/tbody/tr")); 

						  // And iterate over them and get all the cells 
						  for (WebElement row : allRows2) { 
						      List<WebElement> cells = row.findElements(By.tagName("td")); 

						      // Print the contents of each cell
						      for (WebElement cell : cells) {         

						      System.out.println(cell.getText());
						     
						  }
						      
						  }
						  
						  Thread.sleep(2000);
						  driver.switchTo().defaultContent();
						  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
							(new WebDriverWait(driver, 2))
							  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='did_modbox_title_1']")));
				           NewAssignee.DmodcloseClick(driver);   

						    Thread.sleep(1500);
						    
						    driver.switchTo().parentFrame();
							  driver.switchTo().parentFrame();
							  driver.switchTo().parentFrame();
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
						    
						    NewAssignee.authorizefor(driver).selectByIndex(1);
						    driver.switchTo().parentFrame();
							  driver.switchTo().parentFrame();
							  driver.switchTo().parentFrame();
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myBar"));
							  
							  NewAssignee.SaveClick(driver); 
							  Thread.sleep(1500);  
							  
							  alert.accept();
							  Thread.sleep(1500);
							  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
							  
							  driver.switchTo().parentFrame();
							  driver.switchTo().parentFrame();
							  driver.switchTo().parentFrame();
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
							  
							  WebElement element10 = driver.findElement(By.xpath("//a[contains(.,'Employee Portal Info')]"));
							  Actions actions10 = new Actions(driver); 
							  actions10.moveToElement(element10);
							  actions10.perform(); 
							  takeScreenshot(driver,"6. Authorize For selected3");
						  
							  
							   driver.switchTo().parentFrame();
								  driver.switchTo().parentFrame();
								  driver.switchTo().parentFrame();
								  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe")); 
								  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work"));
								  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("work_top"));
							  
							  NewAssignee.EmployeePortalClick(driver);
							  Thread.sleep(2000);
							  takeScreenshot(driver,"7. Employee Portal Info3");
							  Thread.sleep(1000);
							  driver.switchTo().defaultContent();
							  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_dmode_frame_1")); 
							 
							  System.out.println("AFTER IMOVE Portal + LUMPSUM AUTHORIZED");
						      System.out.println(driver.findElement(By.xpath("//*[@id=\"form1\"]/div/table[1]/tbody/tr/td")).getText());
							  
							// Get all the table row elements from the table 
							  List<WebElement> allRows3 = driver.findElements(By.xpath("//*[@id=\"form1\"]/div/table[2]/tbody/tr")); 

							  // And iterate over them and get all the cells 
							  for (WebElement row : allRows3) { 
							      List<WebElement> cells = row.findElements(By.tagName("td")); 

							      // Print the contents of each cell
							      for (WebElement cell : cells) {         

							      System.out.println(cell.getText());
							     
							  }
							      
							  }
						  
						  
				         
					}
					  
				   
						

							@After
						     public void teardown() throws Exception{
						  //  driver.quit(); 
						     }
							
						}