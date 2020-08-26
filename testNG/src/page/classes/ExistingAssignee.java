package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExistingAssignee {
	public static WebElement element = null;

	 public static WebElement waitForElementToBeClickable(WebDriver driver,WebElement webElement,int seconds)
		{
			WebDriverWait wait = new WebDriverWait(driver,seconds);
			
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
			
			return element;
		}
	 
	
	 public static WebElement programtitle(WebDriver driver){
		  element = driver.findElement(By.xpath("//*[@id=\"did_program_title_1\"]")); 
		  return element;
	  }
	  
	 public static void ProgramTitleClick(WebDriver driver){
		  element = programtitle(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 

	 public static WebElement programcontrol(WebDriver driver){
		  element = driver.findElement(By.xpath("//*[contains(text(),'Program Control')]"));  
		  return element;
	  }
	  
	 public static void ProgramControlClick(WebDriver driver){
		  element = programcontrol(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	 
	 public static WebElement addnewservice(WebDriver driver){
		  element = driver.findElement(By.xpath("//a[@href='javascript:add_adhoc_service();'][contains(.,'Add New Service')]")); 
		  return element;
	  }
	  
	 public static void AddNewServiceClick(WebDriver driver){
		  element = addnewservice(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	 
	 
	 public static Select NewServiceSelect(WebDriver driver){
		  Select element = null;
		  WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='workflow_template_uid']"));
		    element = new Select(element_dropdown);  
	        return element;     
	  }
	 

	 
	
	
	 public static WebElement payments(WebDriver driver){
		  element = driver.findElement(By.xpath("//*[contains(text(),'Payments')]")); 
		  return element;
	  }
	 
	  
	 public static void PaymentsClick(WebDriver driver){
		  element = payments(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	 
	 public static WebElement fees(WebDriver driver){
		  element = driver.findElement(By.xpath("//*[contains(text(),'Fees')]")); 
		  return element;
	  }
	 
	 public static void FeesClick(WebDriver driver){
		  element = fees(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	 public static WebElement masterfields(WebDriver driver){
		  element = driver.findElement(By.xpath("	//*[@id=\"did_task_gadget_content\"]/div/div[2]/table/tbody/tr[1]/td[4]")); 
		  return element;
	  }
	 

	 
	 public static void MasterFieldClick(WebDriver driver){
		  element = masterfields(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 

	 
	 public static WebElement save(WebDriver driver){
		 element =    driver.findElement(By.xpath("//input[@value='Save']"));
		  return element;
	  }
	 public static void SaveClick(WebDriver driver) {
		   element = save(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
	 /**20TH CENTURY MFS**/
	 
	 public static WebElement masterfield1(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='md_value_0']")); 
		  return element;
	  }
	 
	 public static WebElement masterfield2(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='md_value_1']")); 
		  return element;
	  }
	
	 public static Select masterfield15(WebDriver driver){
		  Select element = null;
		  WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='md_value_15']"));
		    element = new Select(element_dropdown);  
	        return element;     
	  }
	 
	  
	
	 
	 public static WebElement more(WebDriver driver){
		  element = driver.findElement(By.xpath("//a[@href='javascript:pop_program();']")); 
		  return element;
	  }
	 
	 
	 public static void MoreClick(WebDriver driver) {
		   element = more(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	
	 
	 public static WebElement programnew(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@name='btn_new']")); 
		  return element;
	  }
	 
	 public static void ProgramnewClick(WebDriver driver) {
		   element = programnew(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	
	
	 
	  public static Select programnewselect(WebDriver driver)  { 
		  Select element = null;
		  WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='tmp_program_template_hdr_uid']"));
		    element = new Select(element_dropdown);  
	        return element ;
	  }
	 
	  public static WebElement OK(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@value='OK']")); 
		  return element;
	  }
	 
	  public static void OKClick(WebDriver driver) {
		   element = OK(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	  
	  public static WebElement YES(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@value='Yes']")); 
		  return element;
	  }

	  public static void YESClick(WebDriver driver) {
		   element = YES(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	
	 public static WebElement CrossCultService(WebDriver driver){
		  element = driver.findElement(By.xpath("//*[contains(text(),'Cross-Cultural')]")); 
		  return element;
	  }
	 
	 
	 public static WebElement CrossCultAuth(WebDriver driver){
		 element = driver.findElement(By.xpath("//nobr[contains(.,'Authorized')]")); 
		  return element;
	  }
	 

	 public static WebElement AncilliaryService(WebDriver driver){
		  element = driver.findElement(By.xpath("//*[contains(text(),'Ancillary')]")); 
		  return element;
	  }
	 
	 
	 public static WebElement AIGService(WebDriver driver){
		  element = driver.findElement(By.xpath("//*[contains(text(),'AIG Services')]")); 
		  return element;
	  }
	 
	 public static WebElement CrossCultUnassigned(WebDriver driver){
		 element = driver.findElement(By.xpath("//nobr[contains(.,'New Initiation (unassigned)')]"));
		  return element;
	  }


	 public static void CrossCultServiceClick(WebDriver driver) {
		   element = CrossCultService(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
	 public static void CrossCultAuthClick(WebDriver driver) {
		   element = CrossCultAuth(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
	 
	 public static void CrossCultInitFormOpen(WebDriver driver) {
		   element = CrossCultUnassigned(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}	 
	   

	 public static WebElement HomeSearchService(WebDriver driver){
		  element = driver.findElement(By.xpath("//*[contains(text(),'Home Search')]")); 
		  return element;
	  }
	 
		 
	 public static WebElement SettlingService(WebDriver driver){
		  element = driver.findElement(By.xpath("//*[contains(text(),'Settling-In Assistance')]")); 
		  return element;
	  }
	 
	 
	 
	 public static WebElement AppleTaxService(WebDriver driver){
		  element = driver.findElement(By.xpath("//td[@class='serviceButtonTextHover'][contains(.,'Apple Tax Service')]")); 
		  return element;
	  }
	
	public static WebElement StartService(WebDriver driver){
		  element = driver.findElement(By.xpath("//nobr[contains(.,'Start Service')]"));
		  return element;
	  }
	
	
	public static WebElement AppleTaxAuth(WebDriver driver){
		  element = driver.findElement(By.xpath("//nobr[contains(.,'Authorized')]"));
		  return element;
	  }
	
	public static WebElement AppleTaxUnassign(WebDriver driver){
		  element = driver.findElement(By.xpath("//nobr[contains(.,'Unassigned')]"));
		  return element;
	  }
	
	 public static void AppleTaxClick(WebDriver driver) {
		   element = AppleTaxService(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
	 public static void AppleTaxAuthClick(WebDriver driver) {
		   element = AppleTaxAuth(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
	 
	 public static void AppleTaxInitFormOpen(WebDriver driver) {
		   element = AppleTaxUnassign(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}	 
	   
	
	public static WebElement DepartureService(WebDriver driver){
		  element = driver.findElement(By.xpath("//span[contains(.,'Departure Service')]"));
		  return element;
	  }
	
	
	public static WebElement ServiceControl(WebDriver driver){
		  element = driver.findElement(By.xpath("//nobr[contains(.,'Service Control')]"));
		  return element;
	  }
	
	 
	
	
	 public static WebElement ServiceMoreOptions(WebDriver driver) {
		 element = driver.findElement(By.xpath("//nobr[contains(.,'More Options')]"));
		 return element;
	}	 
	 
	 public static WebElement StartAnotherService(WebDriver driver) {
		 element = driver.findElement(By.xpath("//nobr[contains(.,'Start Another Service')]"));
		 return element;
	}	 
		
	
	
	public static WebElement ExpMgmtService(WebDriver driver){
		  element = driver.findElement(By.xpath("//td[@class='serviceButtonTextHover'][contains(.,'Employee Expense Management')]"));
		  return element;
	  }
	
	public static WebElement ExpMgmtAuth(WebDriver driver){
		  element = driver.findElement(By.xpath("//nobr[contains(.,'>Authorized')]"));
		  return element;
	  }
	public static WebElement ExpMgmtUnassigned(WebDriver driver){
		  element = driver.findElement(By.xpath("//nobr[contains(text(),'Expense Authorization')]"));
		  return element;
	  }
	
	 public static void ExpMgmtClick(WebDriver driver) {
		   element = ExpMgmtService(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	
	 
	 public static void ExpMgmtAuthClick(WebDriver driver) {
		   element = ExpMgmtAuth(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
		   
	 }
	 
	 public static void ExpMgmtUnassignClick(WebDriver driver) {
		   element = ExpMgmtUnassigned(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
		  
	}
	
	public static WebElement Plussign(WebDriver driver){
		  element = driver.findElement((By.xpath("//img[@src='../images/plus.gif']")));
		  return element;
	  }
	
	public static WebElement Recipient(WebDriver driver){
		  element = driver.findElement((By.xpath("//a[contains(.,'Recipient')]")));
		  return element;
	  }
	
	
	public static WebElement To(WebDriver driver){
		  element = driver.findElement((By.xpath("//div[@id='did_to_name']")));
		  return element;
	  }
	
	public static WebElement SupplierSearchBtn(WebDriver driver){
		  element = driver.findElement(By.xpath("//input[@value='Custom Search']"));
		  return element;
	  }

	public static Select RoleDropdown(WebDriver driver){
		  Select element = null;
		  WebElement element_dropdown =  driver.findElement(By.id("Select1"));
		    element = new Select(element_dropdown);  
	        return element;     
	  }
	
	public static WebElement SuppCntctSrchBtn(WebDriver driver){
		  element =  driver.findElement(By.xpath("//input[@name='button1']"));
		  return element;
	  }
	
	public static WebElement SuppCntctResult(WebDriver driver){
		  element =  driver.findElement(By.xpath("//a[contains(.,'Authorizations, New')]"));
		  return element;
	  }	
	
	public static WebElement Acttoemail(WebDriver driver){
		  element =  driver.findElement(By.xpath("//input[@name='acttoemail']"));
		  return element;
	  }	
	
	public static WebElement ActStartbtn(WebDriver driver){
		  element =   driver.findElement(By.xpath("//input[@name='btn_send']"));
		  return element;
	  }	
	
	
	public static WebElement ActConfirm(WebDriver driver){
		  element =  driver.findElement((By.xpath("//input[@value='Yes']")));
		  return element;
	  }	
	
	public static WebElement ActConfirmNO(WebDriver driver){
		  element =  driver.findElement((By.xpath("//input[@value='No']")));
		  return element;
	  }			
	
	 public static void StartServiceClick(WebDriver driver) {
		   element = StartService(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
	

	   
	 public static void DepartureClick(WebDriver driver) {
		   element = DepartureService(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 

 
	 public static void PlusClick(WebDriver driver) {
		   element = Plussign(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
	 public static void RecipientClick(WebDriver driver) {
		   element = Recipient(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
	 public static void ToClick(WebDriver driver) {
		   element = To(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
	 public static void SuppSrchClick(WebDriver driver) {
		   element = SupplierSearchBtn(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
	 public static void RolesetSupplContct(WebDriver driver) {
		 Select element = RoleDropdown(driver);
		 element.selectByVisibleText("Supplier Contact");  
	}
	 
	 public static void SuppCntctSrchClick(WebDriver driver) {
		   element = SuppCntctSrchBtn(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
	 public static void SuppCntctResultClick(WebDriver driver) {
		   element = SuppCntctResult(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	
   
	 
		public static WebElement notes(WebDriver driver){
			  element =  driver.findElement((By.xpath("//span[@id='did_notes']")));
			  return element;
		  }	
		
	 
	 public static void NotesClick(WebDriver driver) {
		   element = notes(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
	 
		public static WebElement addnotes(WebDriver driver){
			  element =  driver.findElement((By.xpath("//button[contains(.,'+ Add Note')]")));
			  return element;
		  }	
		
	 
	 public static void AddNotesClick(WebDriver driver) {
		   element = addnotes(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
		
		public static WebElement notesubject(WebDriver driver){
			  element =  driver.findElement((By.xpath("//input[@formcontrolname='subject']")));
			  return element;
		  }	
	 
	 
		public static WebElement noteCritical(WebDriver driver){
			  element =  driver.findElement((By.xpath("//input[@formcontrolname='isCritical']")));
			  return element;
		  }	
	 
		

		public static WebElement notePrivate(WebDriver driver){
			  element =  driver.findElement((By.xpath("//input[@formcontrolname='isPrivate']")));
			  return element;
		  }	
	 

		public static Select notetype(WebDriver driver){
			  Select element = null;
			  WebElement element_dropdown =  driver.findElement(By.xpath("//select[@class='form-control']"));
			    element = new Select(element_dropdown);  
		        return element;     
		  }
		;
		
		public static WebElement notebody(WebDriver driver){
			  element =  driver.findElement((By.xpath("//textarea[@name='body']")));
			  return element;
		  }	
		
		public static WebElement notesave(WebDriver driver){
			  element =  driver.findElement((By.xpath("//button[contains(.,'Save')]")));
			  return element;
		  }	
		
		public static WebElement noteclose(WebDriver driver){
			  element =  driver.findElement((By.xpath("//button[contains(.,'Close')]")));
			  return element;
		  }	
		
		public static WebElement noteexit(WebDriver driver){
			  element =  driver.findElement((By.xpath("//div[@onclick='task_gadget_hide();'][contains(.,'x')]")));
			  return element;
		  }	
		
		
		 
		 public static WebElement documents(WebDriver driver){
			  element = driver.findElement(By.xpath("//*[contains(text(),'Documents')]")); 
			  return element;
		  }
		 
		 public static void DocumentsClick(WebDriver driver){
			  element = documents(driver);
			   waitForElementToBeClickable(driver,element,3);
			   element.click();
		  }
		
		
		 
		 
		 
		
		
	
	 
}