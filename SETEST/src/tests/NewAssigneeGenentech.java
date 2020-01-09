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

public class NewAssigneeGenentech {
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
			FileUtils.copyFile(source, new File("./Screenshots/GENENTECHProfile-Screenshots/" + screenshotname + ".png"));
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
		} // try
		catch (Exception e) {
			return false;
		} // catch
	}

	@Test
	public void test() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/** LOGIN **/
		LoginPage.userid(driver).sendKeys("kaan.perk@sirva.com");
		LoginPage.passwd(driver).sendKeys("Dec321@@");
		LoginPage.login(driver);
		WebDriverWait wait = new WebDriverWait(driver, 3);
		Thread.sleep(23000);
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		/*
		 * boolean confirmalert =
		 * driver.findElement(By.xpath("//th[@id='did_confirm_title']")).isEnabled(); if
		 * (confirmalert = true) {
		 * driver.findElement(By.xpath("//input[@value='OK']")).click(); }
		 */
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("did_appframe"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("cp_display"));
		takeScreenshot(driver, "1.Homepage");
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
		takeScreenshot(driver, "2.Genentech New Assignee Profile");
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
		Thread.sleep(1000);
		takeScreenshot(driver, "5.Genentech New Assignee Profile");
		
		/*
		 * NewAssignee.initialcontactdate(driver).sendKeys("10/15/2019");
		 * NewAssignee.initialcontactdate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.initialcontacttime(driver).sendKeys("8:45");
		 * NewAssignee.initiationcalldate(driver).sendKeys("11/5/2018");
		 * NewAssignee.initiationcalldate(driver).sendKeys(Keys.ESCAPE);
		 * NewAssignee.ccid(driver).sendKeys("111222");
		 * NewAssignee.wtid(driver).sendKeys("222333");
		 * NewAssignee.payrollcode(driver).sendKeys("159753");
		 * NewAssignee.primarypayrollid(driver).sendKeys("555666");
		 * NewAssignee.secondarypayrollid(driver).sendKeys("777888");
		 * NewAssignee.surveydate(driver).sendKeys("02/15/2019");
		 * NewAssignee.surveydate(driver).sendKeys(Keys.ESCAPE);
		 */
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
			         
			         
			         WebElement element =   driver.findElement(By.xpath("//input[@name='cust_ref_nbr']"));
			         Actions actions = new Actions(driver);
			         actions.moveToElement(element);
			         actions.perform();
			     	takeScreenshot(driver, "7.Genentech Profile Completed");
			         Thread.sleep(1500);
				  						 
			         WebElement    element1 =     driver.findElement(By.xpath("//textarea[@name='special_needs']"));
			         Actions actions1 = new Actions(driver);
			         actions1.moveToElement(element1);
			         actions1.perform();
			     	takeScreenshot(driver, "8.Genentech Profile Completed");
			         Thread.sleep(1500);


			         WebElement    element2 =   driver.findElement((By.xpath("//textarea[@name = 'cust_oth_special_needs_1']")));
			         Actions actions2 = new Actions(driver);
			         actions2.moveToElement(element2);
			         actions2.perform();
			     	takeScreenshot(driver, "9.Genentech Profile Completed");
			         Thread.sleep(1500);
			         
			         WebElement    element3 =    driver.findElement(By.xpath("//input[@name='cust_authorized_date']"));
			         Actions actions3 = new Actions(driver);
			         actions3.moveToElement(element3);
			         actions3.perform();
			     	takeScreenshot(driver, "10.Genentech Profile Completed");
			         Thread.sleep(1500);
			  
				  
	}			  
				  
	@After
	public void teardown() throws Exception {
		// driver.quit();
	}

}