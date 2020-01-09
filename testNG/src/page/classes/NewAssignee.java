package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAssignee {
	public static WebElement element = null;
	public static WebElement waitForElementToBeClickable(WebDriver driver,WebElement webElement,int seconds)
		{
			WebDriverWait wait = new WebDriverWait(driver,seconds);
			
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
			
			return element;
		}
	
	 /***GENERIC FIELDS**/
	 public static WebElement AsgnFldr(WebDriver driver){
		  element = driver.findElement(By.xpath("//span[contains(.,'Assignee')]"));
		  return element;
	  }
	 
	 
	 public static void AsgnFldrClick(WebDriver driver) {
		   element = AsgnFldr(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
	 
	 public static WebElement AddNewAsgneBtn(WebDriver driver){
		  element =  driver.findElement(By.xpath("//input[@value='Add New']"));
		  return element;
	  }
	 
	 
	 public static void AddNewAsgneClick(WebDriver driver) {
		   element = AddNewAsgneBtn(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
	 
	 public static WebElement custfname(WebDriver driver){
		  element =      driver.findElement(By.xpath("//input[@name='cust_fname']"));
		  return element;
	  }
	 
	 public static WebElement custminame(WebDriver driver){
		  element =      driver.findElement(By.xpath("//input[@name='cust_legal_middle_name_1']"));
		  return element;
	  }
	 
	 
	 public static WebElement custlname(WebDriver driver){
		  element =        driver.findElement(By.xpath("//input[@name='cust_lname']"));
		  return element;
	  }
	 
	 
	 public static WebElement custpreffname(WebDriver driver){
		  element =   driver.findElement(By.xpath("//input[@name='cust_pref_fname_asn_1']"));
		  return element;
	  }
	 
	 public static WebElement custprefminame(WebDriver driver){
		  element =   driver.findElement(By.xpath("//input[@name='cust_pref_minitial_asn_1']"));
		  return element;
	  }
	 
	 
	 public static WebElement custpreflname(WebDriver driver){
		  element =   driver.findElement(By.xpath("//input[@name='cust_pref_lname_asn_1']"));
		  return element;
	  }
	 
	
	
	 public static WebElement org(WebDriver driver){
		  element =   driver.findElement(By.xpath("//a[contains(.,'Client')]"));
		  return element;
	  }
	 
	 public static void OrgClick(WebDriver driver) {
		   element = org(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	
	 public static WebElement orgname(WebDriver driver){
		  element =  driver.findElement(By.xpath("//input[@name='org_name']"));
		  return element;
	  }
	 
		
	 public static WebElement orgnumber(WebDriver driver){
		  element =  driver.findElement(By.xpath("//input[@name='org_numb']"));
		  return element;
	  }
	 
	 
	 public static WebElement orgsrchbtn(WebDriver driver){
		  element =  driver.findElement(By.xpath(" //input[@value='Search']"));
		  return element;
	  }
	 
	 public static void OrgSrchBtnClick(WebDriver driver) {
		   element = orgsrchbtn(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
	 
	 public static WebElement orgresult(WebDriver driver){
		  element =  	 driver.findElement((By.xpath("//a[contains(.,'20th')]")));
		  return element;
	  }
	 
	 public static void OrgResultClick(WebDriver driver) {
		   element = orgresult(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 

	  
	 public static Select programdropdown(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown =  driver.findElement((By.xpath("//select[@name='tmp_program_template_hdr_uid']")));
	      element=new Select (element_dropdown);
		  return element;  
	 }
	 

	 
	 
	 public static WebElement nextbutton(WebDriver driver){
		  element =  	 driver.findElement(By.xpath("//input[@value='Next >>']"));
		  return element;
	  }
	 

	 public static void NextButtonClick(WebDriver driver){
		 element = nextbutton(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
		
	 public static WebElement asgnetypes(WebDriver driver){
		  element =   driver.findElement(By.xpath("//a[contains(.,'Assignee Types')]"));
		  return element;
	  }
	 

	 public static void AsgneTypeClick(WebDriver driver){
		  element = asgnetypes(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	 public static WebElement asgnetypesel1(WebDriver driver){
		 element =   driver.findElement(By.xpath("//input[@name='cust_type_1']"));
		 return element;
	  }
	 
	 public static void AsgneSel1Click(WebDriver driver){
		  element = asgnetypesel1(driver);
		   waitForElementToBeClickable(driver,element,5);
		   element.click();
	  }
	 
	
	 public static WebElement OK(WebDriver driver){
		 element =  driver.findElement(By.xpath("//input[@value='OK']"));
		 return element;
	  }
	 public static void OKClick(WebDriver driver){
		 element = OK(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	 public static Select asgmttypeselect(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement((By.xpath("//select[@name='cust_assignment_type']")));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 
	 public static WebElement assignedpolicy(WebDriver driver){
		 element =  driver.findElement(By.xpath("//input[@name='assigned_Policy']"));
		 return element;
	  }
	 
	 public static Select custsalutation(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement((By.xpath("//select[@name='cust_salutation']")));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 
	 public static Select custsuffix(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement((By.xpath("//select[@name='ddlb_SUFFIX_cust_legal_suffix_asn_1']")));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 
	 public static Select custprefsalutation(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement((By.xpath("//select[@name='ddlb_SALUTA_cust_pref_salutation_asn_1']")));
	      element=new Select (element_dropdown);
		  return element;
	  }

	 public static Select custprefsuffix(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement((By.xpath("//select[@name='ddlb_SUFFIX_cust_pref_suffix_asn_1']")));
	      element=new Select (element_dropdown);
		  return element;
	  }

    
	 public static Select phnetype1dropdown(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//*[@name='phone_type_1']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 
   
	 public static WebElement phne1country(WebDriver driver){
		  element =   driver.findElement(By.xpath("//input[@name='phone_country_1']"));
		  return element;
	  } 
	 
	 public static WebElement phne1areacode(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='phone_area_code_1']"));
		  return element;
	  }
	 
	 
	 public static WebElement phne1nbr(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='assignee_phone_1']"));
		  return element;
	  }
    
	 
	 public static Select phnetype2dropdown(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='phone_type_2']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 
   
	 public static WebElement phne2country(WebDriver driver){
		  element =   driver.findElement(By.xpath("//input[@name='phone_country_2']"));
		  return element;
	  } 
	 
	 public static WebElement phne2areacode(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='phone_area_code_2']"));
		  return element;
	  }
	 
	 
	 public static WebElement phne2nbr(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='assignee_phone_2']"));
		  return element;
	  }
    
	 public static Select phnetype3dropdown(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='phone_type_3']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 
   
	 public static WebElement phne3country(WebDriver driver){
		  element =   driver.findElement(By.xpath("//input[@name='phone_country_3']"));
		  return element;
	  } 
	 
	 public static WebElement phne3areacode(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='phone_area_code_3']"));
		  return element;
	  }
	 
	 
	 public static WebElement phne3nbr(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='assignee_phone_3']"));
		  return element;
	  }
	 
	 
	 public static Select phnetype4dropdown(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='phone_type_4']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 
   
	 public static WebElement phne4country(WebDriver driver){
		  element =   driver.findElement(By.xpath("//input[@name='phone_country_4']"));
		  return element;
	  } 
	 
	 public static WebElement phne4areacode(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='phone_area_code_4']"));
		  return element;
	  }
	 
	 
	 public static WebElement phne4nbr(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='assignee_phone_4']"));
		  return element;
	  }
	 
 
    
	 public static WebElement custemail(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='cust_email']"));
		  return element;
	  }
	 
	 
	 
	 public static Select pfdcm(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='pfd_cm']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	
	 public static WebElement cust2email(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='secondary_email']"));
		  return element;
	  }
	 

	 public static WebElement custssn(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='cust_ssn']"));
		  return element;
	  }
	
	 public static WebElement custpassportnbr(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='cust_emp_id']"));
		  return element;
	  }
	
	 
	 public static WebElement pasprtissuedate(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='dt_Passport_Issue_Date']"));
		  return element;
	  }
	 
	 public static WebElement pasprtexpiredate(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='dt_passport_expiration']"));
		  return element;
	  }
	
	 public static WebElement chkgreencardholder(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='chk_greenCardHolder']"));
		  return element;
	  }
	 
	 public static void ChkgrencardholdY(WebDriver driver){
		 element =    driver.findElement(By.xpath("//input[@name='chk_greenCardHolder'and @value='Y']"));
		   element.click();
	  }
	 
	 public static Select citizenshipcountry(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='citizenship_country']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 
	 public static Select dualcitizenshipcountry(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='dual_citizenship_country']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 
	 public static Select gender(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='cust_gender']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 
	 public static Select maritalstatus(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='cust_marital_status']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
			 
	 public static WebElement birthdate(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='dt_birth_date']"));
		  return element;
	  }	
			 
	 public static Select birthcountry(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='birth_country']"));
	      element=new Select (element_dropdown);
		  return element;
	  }	
			 
	 public static Select birthstate(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='birth_state']"));
	      element=new Select (element_dropdown);
		  return element;
	  }		
	 
	 public static WebElement birthcity(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='birth_city']"));
		  return element;
	  }		 
			
	 public static WebElement familysizeonasgnmt(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='cust_family_size_assig']"));
		  return element;
	  }		 
	 
	 
				 
	 public static WebElement familysize(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='nbr_family_size']"));
		  return element;
	  }		 	
			 
	 public static WebElement accompdependents(WebDriver driver){
		  element =    driver.findElement(By.xpath("	//input[@name='cust_accompanying_dependents']"));
		  return element;
	  }		 	
			 
	 public static WebElement splitfamilyNO(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='chk_splitFamily'and @value='N']"));
		  return element;
		  
		  
	  }		 			
			 
	 public static void SplitfamilyN(WebDriver driver){
		 element = splitfamilyNO(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }		
	 
	 public static WebElement visatype(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='cust_visa_type']"));
		  return element;
	  }		 			
		
	 public static WebElement visastatus(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='cust_visa_status']"));
		  return element;
	  }		 	
			 
	 public static WebElement visaissuedate(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='dt_Assignee_Visa_Issued_Date']"));
		  return element;
	  }		 	
	 
	 public static WebElement visaexpiredate(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='dt_cust_visa_date']"));
		  return element;
	  }		 			 
	
	 public static WebElement custlanguages(WebDriver driver){
		  element =    driver.findElement(By.xpath("//a[contains(.,'Languages Spoken')][1]"));
		  return element;
	  }		 
	 
	 public static void CustLanguagesClick(WebDriver driver){
		 element = custlanguages(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }			
	 
	 public static WebElement English(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='assignee_language_9']"));
		  return element;
	  }		
	 
	 public static WebElement German(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='dependents_language_1_13']"));
		  return element;
	  }		
	 
	 public static void LanguageEnglishClick(WebDriver driver){
		 element = English(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }			
	 
	 public static void LanguageGermanClick(WebDriver driver){
		 element = German(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }			
	 

	 /**ADDRESSES MORE **/ 
	 
	 public static WebElement addrmore(WebDriver driver){
		  element =    driver.findElement(By.xpath("//*[@id=\"form\"]/table/tbody/tr[13]/td/table/tbody/tr[3]/td[3]/a"));
		  return element;
	  }
	
	 
	 public static void MoreAddrClick(WebDriver driver){
		 element = addrmore(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }			
	 
	 public static WebElement addnewaddress(WebDriver driver){
		  element =    driver.findElement(By.xpath("//a[contains(@id,'addNewLink')]"));
		  return element;
	  }
	
	
	 public static void AddNewAddrClick(WebDriver driver){
		 element = addnewaddress(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }			
	 
	 public static Select  addrtype(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='address_type']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 
	 public static Select  country(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='country']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 
	 public static WebElement address1(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='address1']"));
		  return element;
	  }
	 
	 public static WebElement address2(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='address2']"));
		  return element;
	  }
	 
	 public static WebElement city(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='city']"));
		  return element;
	  }
	 
	 
	 public static WebElement OK2(WebDriver driver){
		 element =  driver.findElement(By.xpath("//input[contains(@id,'okbutton')][2]"));
		 return element;
	  }
	 public static void OK2Click(WebDriver driver){
		 element = OK2(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	 
	 
	 /********************/
	 
	 	 
	 
	 
	 
	 public static WebElement custaddr1(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='cust_address1_1']"));
		  return element;
	  }
   
	 public static WebElement custaddr2(WebDriver driver){
		  element =    driver.findElement(By.xpath("//input[@name='cust_address2_1']"));
		  return element;
	  }
	
	 	 
	 
	 public static WebElement custprefcity(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='txtPrefCitySearch']"));
		  return element;
	  }
	 
	 
	 public static Select  custprefstate(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='cust_state_1']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
  
	 public static WebElement zip(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_zip_1']"));
		  return element;
	  }
	 
	 

	 
	 public static WebElement custtitle(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_title']"));
		  return element;
	  }
	 
	 public static WebElement homehrmgrname(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='home_hr_manager_name']"));
		  return element;
	  }
	 
	 public static  WebElement homehrmgremail(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='home_hr_manager_email']"));
		  return element;
	  }
	 
	 public static WebElement mgrname(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cur_assignment_supervisor']"));
		  return element;
	  }
	 public static WebElement mgremail(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cur_assignment_supervisor_email']"));
		  return element;
	  }
	 
	
	 
	 public static Select curasgmtcountry(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='cur_assignment_country']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
		 
	 public static Select curasgmtstate(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='cust_state_1']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
     
	 public static WebElement curcity(WebDriver driver){
		  element =      driver.findElement(By.xpath("//input[@name='txtHomeCitySearch']"));
		  return element;
	  }
	 
	 public static WebElement custcostcenter(WebDriver driver){
		  element =      driver.findElement(By.xpath("//input[@name='cust_cost_center']"));
		  return element;
	  }
	 
	 public static WebElement MISC1(WebDriver driver){
		  element =      driver.findElement(By.xpath("//input[@name='MISC1']"));
		  return element;
	  }
	 
	 public static WebElement MISC2(WebDriver driver){
		  element =      driver.findElement(By.xpath("//input[@name='MISC2']"));
		  return element;
	  }
	
	 
	 
	 
	 public static WebElement wrksitelocation(WebDriver driver){
		  element =      driver.findElement(By.xpath("//input[@name='worksite_location']"));
		  return element;
	  }
	
	 public static WebElement businessunit(WebDriver driver){
		  element =      driver.findElement(By.xpath("//input[@name='business_unit_p']"));
		  return element;
	  }
	 
	 
	 public static Select billingcenter(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='billing_center']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 
	 public static WebElement sendinglegal(WebDriver driver){
		  element =      driver.findElement(By.xpath("	//input[@name='sending_legal']"));
		  return element;
	  }
	 
	 public static WebElement hosthrmgrname(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='hr_manager_name']"));
		  return element;
	  }
	 
	 public static WebElement hosthrmgremail(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='hr_manager_email']"));
		  return element;
	  }
	 
	 public static WebElement financemgrname(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='finance_managerCC']"));
		  return element;
	  }
	 
	 public static WebElement financemgremail(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='finance_managerCC_email']"));
		  return element;
	  }
	 
	 public static WebElement newtitle(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='new_assignment_job_title']"));
		  return element;
	  }
	 

	 public static WebElement asgmtbegindate(WebDriver driver){
		  element =   driver.findElement(By.xpath("//input[@name='dt_new_assignment_begin']"));
		  return element;
	  }
	 
	 public static WebElement asgmtenddate(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='dt_new_assignment_end']"));
		  return element;
	  }
	 
	 public static WebElement dtextstartdate(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='dt_ext_est_start']"));
		  return element;
	  }

	 public static WebElement dtextenddate(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='dt_ext_est_end']"));
		  return element;
	  }
	 
	 public static WebElement actualstartdate(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='TYCO_Actual_Start_Date']"));
		  return element;
	  }
	 
	 public static WebElement actualenddate(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='TYCO_Actual_End_Date']"));
		  return element;
	  }
	
	 public static WebElement newmanager(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='new_assignment_supervisor']"));
		  return element;
	  }

	 public static WebElement newmanageremail(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_New_Manager_Email']"));
		  return element;
	  }
 

	 public static Select newasgmtcountry(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='new_assignment_country']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
		 
	 public static Select newasgmtstate(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='new_assignment_state']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
     
	 public static WebElement newcity(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='txtHostCitySearch']"));
		  return element;
	  }
	 
	 public static WebElement custzip2(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_zip_2']"));
		  return element;
	  }
	 
	 
	 public static WebElement newbusunit(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='MISC3']"));
		  return element;
	  }
	 
	 public static WebElement newwrksitelocation(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_New_Worksite_Location']"));
		  return element;
	  }
	 
	 
	
	 
	 
	 
     public static Select divisionlevel(WebDriver driver){
	 Select element = null; 
	 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='divisionLevel']"));
      element=new Select (element_dropdown);
	  return element;
  }
	 
	 
	
	 public static WebElement extid(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='ExternalId']"));
		  return element;
	  }
	
	 public static WebElement newcostcenter(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='new_assignment_cost_center']"));
		  return element;
	  }
	
	 public static WebElement newcostcenter2(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='CostCentre_Other']"));
		  return element;
	  }
	
	 public static WebElement employeeid(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_ref_nbr']"));
		  return element;
	  }
	 
	 public static Select grade (WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='custom_option1']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	
	 

	 public static Select policy(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='TYCO_Policy']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 
	 public static WebElement auditcode(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='audit_code']"));
		  return element;
	  }

	 
	 public static Select joboffertype(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='job_offer_type']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 

	 public static WebElement joboffraccepted(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='chk_jobOfferAccepted']"));
		  return element;
	  }
	
	 public static void joboffracceptedY(WebDriver driver){
		 element = joboffraccepted(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	 public static WebElement jobofferaccepteddate(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='dt_offer_acceptance_date']"));
		  return element;
	  }
	
	 public static WebElement receivinglegal(WebDriver driver){
		  element =     driver.findElement(By.xpath("	//input[@name='receiving_legal']"));
		  return element;
	  }
	 
	 public static Select homefilingstatus(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='x_tax_filing_status']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 
	 public static Select homefilingcountry(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='home_country']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 
	 public static Select homefilingstate(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='home_state']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 
	 
	 public static WebElement homefilingcity(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='home_city']"));
		  return element;
	  }
	 
	 public static WebElement homesalary(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='mny_current_salary_home']"));
		  return element;
	  }
	 
	 
	 public static Select homesalarycurrency(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_CURNCY_current_salary_home_currency']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	
	 
	 public static WebElement payfreq(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='pay_frequency']"));
		  return element;
	  }
	 
	 public static WebElement homebasesalarypercentage(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='base_salary_home']"));
		  return element;
	  }
	 
	 public static WebElement perdiemmoney(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='mny_Per_Diem']"));
		  return element;
	  }
	 
	 public static Select perdiemcurrency(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_Per_Diem_Currency']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 
	
	 public static WebElement retireplanpercent(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='retirement_plan']"));
		  return element;
	  }
	
	 public static WebElement retireeligibleY(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='ret_eligibile' and @value='Y']"));
		  return element;
	  }
	 
	 public static void RetireeligibleYES(WebDriver driver){
		 element = retireeligibleY(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
	 
	 public static WebElement taxequalcity(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='tax_equalization_city']"));
		  return element;
	  }
	
	 
	 public static WebElement taxequalstate(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='tax_equalization_state']"));
		  return element;
	  }
	
	 public static WebElement taxequalbonusY(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='radio_tax_eq_on_bonus' and @value='Y']"));
		  return element;
	  }
	 
	 public static void TaxequalbonusYES(WebDriver driver){
		 element = taxequalbonusY(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }
			 
	 public static WebElement bonuspercent(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='TYCO_Bonus_Percentage']"));
		  return element;
	  }	
			 
	 public static WebElement annualbonus(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='Annual_bonus']"));
		  return element;
	  }			 
			
					 
	 public static WebElement bonusrange(WebDriver driver){
		  element =   driver.findElement(By.xpath("//input[@name='bonus_Range']"));
		  return element;
	  }						
					 
	 public static WebElement overallbudget(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='mny_assignment_overallbudget']"));
		  return element;
	  }								 
					
	 public static Select overallbudgetcurrency(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_CURNCY_overallbudget']"));
	      element=new Select (element_dropdown);
		  return element;
	  }			 
					 
	 public static WebElement housingallowance(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='mny_housing']"));
		  return element;
	  }							
					 
	 public static Select housingallowancecurrency(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_CURNCY_monthly_housing_allowance']"));
	      element=new Select (element_dropdown);
		  return element;
	  }			 			 
					
	 public static WebElement utilityallowance(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='mny_Utilities_Allowance']"));
		  return element;
	  }							 
					 
	 public static Select utilityallowancecurrency(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_Utilities_Allowance_Currency']"));
	      element=new Select (element_dropdown);
		  return element;
	  }			 				
					 
	 public static WebElement miscallowance(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='mny_miscellaneous_relocation_allowance']"));
		  return element;
	  }						 

	 public static Select miscallowancecurrency(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_CURNCY_miscellaneous_relocation_allowance']"));
	      element=new Select (element_dropdown);
		  return element;
	  }			 				 
					 
	 
	 public static Select miscexptype(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_exp_pay_type']"));
	      element=new Select (element_dropdown);
		  return element;
	  }			
	 
	 public static Select homeownerorselling(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_Selling_residence']"));
	      element=new Select (element_dropdown);
		  return element;
	  }			
	 

					 
	 public static Select delegauthcecurrency(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_CURNCY_Delegation_Authority_Currency']"));
	      element=new Select (element_dropdown);
		  return element;
	  }			 					
					
	 public static WebElement delegofauthority(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='mny_delegation_of_authority']"));
		  return element;
	  }				 
					
					 
	 public static WebElement deleggrantedY(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[contains(@name,'Granted') and @value='Y']"));
		  return element;
	  }						
					 
					
	 public static void DeleggrantedYES(WebDriver driver){
		 element = deleggrantedY(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }			 
					 
	 public static WebElement arrivalinhostcountrydate(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='dt_Arrival_in_Host_Country_Date']"));
		  return element;
	  }			
	 
	 public static WebElement permhousingmoveindate(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='dt_Date_Moved_into_Perm_Housing']"));
		  return element;
	  }		
							 
	 public static WebElement permhousingmoveoutdate(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='dt_Date_Moved_out_of_Perm_Housing']"));
		  return element;
	  }							 
							
	 public static WebElement specialneeds(WebDriver driver){
		  element =     driver.findElement(By.xpath("//textarea[@name='special_needs']"));
		  return element;
	  }								 
							
	 public static WebElement LOUsentdate(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='dt_IAG_Approval_Fidelity']"));
		  return element;
	  }								 
							
					
	 public static WebElement LOUsigneddate(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='dt_Return_Signed_Fidelity']"));
		  return element;
	  }							
						
	 public static WebElement LOUcomments(WebDriver driver){
		  element =     driver.findElement(By.xpath("//textarea[@name='LOH_comments']"));
		  return element;
	  }			
	 
	 public static WebElement CEsentdate(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='dt_ce_sent']"));
		  return element;
	  }		
	
	 public static WebElement CEapproveddate(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='dt_ce_approved']"));
		  return element;
	  }				
	 
	 
	 
	 /****DEPENDENTS****/
							
	 public static WebElement dependentaccompY(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='DependentWilAccom_1' and @value='Y']"));
		  return element;
	  }							 
							
	 public static void DependentaccompYES(WebDriver driver){
		 element = dependentaccompY(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }								 
							
	 public static Select dependentrelation(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_RELATE_cust_oth_relationship_1']"));
	      element=new Select (element_dropdown);
		  return element;
	  }			 						 
							
	 public static Select dependentprefix(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='cust_oth_salutation_1']"));
	      element=new Select (element_dropdown);
		  return element;
	  }			 					 
		
	 public static WebElement dependentfirstname(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_oth_fname_1']"));
		  return element;
	  }				
									
	 public static WebElement dependentmidname(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_oth_minitial_1']"));
		  return element;
	  }									 
									
									 
	 public static WebElement dependentlastname(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_oth_lname_1']"));
		  return element;
	  }										
									 
	 public static Select dependentsuffix(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_SUFFIX_cust_legal_suffix_1']"));
	      element=new Select (element_dropdown);
		  return element;
	  }			 								
									 
	 public static Select dependentprefprefix(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_SALUTA_cust_pref_salutation_1']"));
	      element=new Select (element_dropdown);
		  return element;
	  }										 
									

	 public static WebElement dependentpreffname(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_pref_fname_1']"));
		  return element;
	  }				

	 public static WebElement dependentprefmidname(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_pref_minitial_1']"));
		  return element;
	  }				
							
	 public static WebElement dependentpreflname(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_pref_lname_1']"));
		  return element;
	  }			
									
	 public static Select dependentprefsuffix(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_SUFFIX_cust_pref_suffix_1']"));
	      element=new Select (element_dropdown);
		  return element;
	  }			
									
	 public static Select dependentphonetype1(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='cust_oth_phone_type_1_1']"));
	      element=new Select (element_dropdown);
		  return element;
	  }			
									
	 public static WebElement dependentphone1country(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_oth_phone_country_1_1']"));
		  return element;
	  }		
									
	 public static WebElement dependentphone1areacode(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_oth_phone_area_code_1_1']"));
		  return element;
	  }		
									
	 public static WebElement dependentphone1nbr(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_oth_assignee_phone_1_1']"));
		  return element;
	  }		
									

	 public static Select dependentphonetype2(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='cust_oth_phone_type_2_1']"));
	      element=new Select (element_dropdown);
		  return element;
	  }			
									
	 public static WebElement dependentphone2country(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_oth_phone_country_2_1']"));
		  return element;
	  }		
									
	 public static WebElement dependentphone2areacode(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_oth_phone_area_code_2_1']"));
		  return element;
	  }		
									
	 public static WebElement dependentphone2nbr(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_oth_assignee_phone_2_1']"));
		  return element;
	  }									
									

	 public static WebElement dependentssn(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_oth_ssn_1']"));
		  return element;
	  }				
	 
	 
	 public static WebElement dependentpassptnbr(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_oth_emp_id_1']"));
		  return element;
	  }			

	 public static WebElement dependentpassptissuedate(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='dt_cust_oth_Passport_Issue_Date_1']"));
		  return element;
	  }									

	 public static WebElement dependentpassptexpiredate(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='dt_cust_oth_passport_expiration_1']"));
		  return element;
	  }											

	 public static WebElement dependentgcholderY(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_d_greencard_holder_1' and @value='Y']"));
		  return element;
	  }										

	 public static void DependentgcholderYES(WebDriver driver){
		 element = dependentgcholderY(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }										

	 public static Select dependentcitizenship(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='cust_oth_citizenship_country_1']"));
	      element=new Select (element_dropdown);
		  return element;
	  }			
											

	 public static Select dependentdualcitizenship(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='cust_oth_dual_citizenship_country_1']"));
	      element=new Select (element_dropdown);
		  return element;
	  }			
	
	 public static Select dependentgender(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='cust_oth_gender_1']"));
	      element=new Select (element_dropdown);
		  return element;
	  }			
   
	 public static WebElement dependentbirthdate(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='dt_cust_oth_birth_date_1']"));
		  return element;
	  }			
	 
	 public static Select dependentbirthcountry(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='cust_oth_birth_country_1']"));
	      element=new Select (element_dropdown);
		  return element;
	  }			
									
	 public static WebElement dependentemail(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_oth_email_1']"));
		  return element;
	  }		
									
	 public static WebElement dependentfulltimestudentN(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_oth_full_time_student_1' and @value='N']"));
		  return element;
	  }		 

	 public static void DependentfulltimestudentNO(WebDriver driver){
		 element = dependentfulltimestudentN(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }			

	 public static WebElement dependentoccup(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_oth_occupation_1']"));
		  return element;
	  }		 								


	 public static WebElement dependentlanguages(WebDriver driver){
		  element =     driver.findElement(By.xpath("//a[contains(@href,'javascript:pop_dependents_language_spoken(1);')]"));
		  return element;
	  }		 
	 
	
	 public static void DependentLanguagesClick(WebDriver driver){
		 element = dependentlanguages(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }		
	
	 public static Select dependentlocated(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_ADDTYP_cust_oth_currently_located_1']"));
	      element=new Select (element_dropdown);
		  return element;
	  }			
	
	 public static WebElement dependentfrom(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='dt_cust_dependent_from_1']"));
		  return element;
	  }		

	 public static WebElement dependenttill(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='dt_cust_dependent_till_1']"));
		  return element;
	  }		

	 public static WebElement dependentneeds(WebDriver driver){
		  element =     driver.findElement(By.xpath("//textarea[@name='cust_oth_special_needs_1']"));
		  return element;
	  }								
	 
	 
	 public static WebElement dependentaddnew(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='btn_add_new']"));
		  return element;
	  }			
	 
	 
	 public static void DependentAddNewClick(WebDriver driver){
		 element = dependentaddnew(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }		
	 
	 public static WebElement dependent2accompY(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='DependentWilAccom_2' and @value='Y']"));
		  return element;
	  }										

	 public static void Dependent2AccompYES(WebDriver driver){
		 element = dependent2accompY	(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }								
	 
	 public static Select dependent2relation(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_RELATE_cust_oth_relationship_2']"));
	      element=new Select (element_dropdown);
		  return element;
	  }			 
	 
	 public static WebElement dependent2firstname(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_oth_fname_2']"));
		  return element;
	  }				
									
	 public static WebElement dependent2midname(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_oth_minitial_2']"));
		  return element;
	  }									 
									
									 
	 public static WebElement dependent2lastname(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_oth_lname_2']"));
		  return element;
	  }										
	 
	 
	 
	 /******************************/

	 public static WebElement petsaccompY(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_petWA' and @value='Y']"));
		  return element;
	  }		
	 
	 public static void PetsaccompYES(WebDriver driver){
		 element = petsaccompY(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }		

	 
	 public static Select petnbr(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_CNT5_number_of_pets']"));
	      element=new Select (element_dropdown);
		  return element;
	  }			
	 
	 public static WebElement pettypes(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='type_of_pets']"));
		  return element;
	  }		
	 
	 public static WebElement petweights(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_petWeight']"));
		  return element;
	  }	
	 
	 public static WebElement petcomments(WebDriver driver){
		  element =     driver.findElement(By.xpath("//textarea[@name='pet_comments']"));
		  return element;
	  }	
	

	 public static Select custreferuid(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='cust_referring_uid']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
							
	
	 public static WebElement othercontact(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_oth_contact']"));
		  return element;
	  }									

	 public static WebElement hiredate(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='dt_hire_date']"));
		  return element;
	  }			
									
	 public static Select execofficer(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_executive_officer']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
				

	 public static Select hirestatus(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_HIRSTA_hire_status']"));
	      element=new Select (element_dropdown);
		  return element;
	  }							

	 public static Select hirecountry(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='hire_country']"));
	      element=new Select (element_dropdown);
		  return element;
	  }									

	 public static WebElement previousassignmentY(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name = 'radio_previous_assignment' and @value='Y']"));
		  return element;
	  }			
	 
	 public static void PreviousassignmentYES(WebDriver driver){
		 element = previousassignmentY(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }									

	
	 public static WebElement countriesvisited(WebDriver driver){
		  element =     driver.findElement(By.xpath("//a[contains(@href,'javascript:pop_assignment_country();')]"));
		  return element;
	  }			
	 
	 public static void CountriesVisitedClick(WebDriver driver){
		 element = countriesvisited(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }		
	 		
	 public static WebElement countryARG(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='assignment_country_17']"));
		  return element;
	  }		
	 
	 public static void CountryARGselected(WebDriver driver){
		 element = countryARG(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	  }											
	

	 public static Select gac(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='tmp_cust_poc_uid']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 
	 public static Select previousgac(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='cust_prev_GAC_uid']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 

	 public static Select centerofexcellence(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_TEAM_center_of_excellence_05']"));
	      element=new Select (element_dropdown);
		  return element;
	  }
	 
	 public static WebElement custauthdate(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_authorized_date']"));
		  return element;
	  }	
	 
	 
	 public static WebElement initialcontactdate(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_effective_start_date']"));
		  return element;
	  }	
	 
	 public static WebElement initialcontacttime(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='cust_effective_start_time']"));
		  return element;
	  }	
	 
	 public static WebElement initiationcalldate(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='dt_date_of_intitial_call']"));
		  return element;
	  }								

									
	 public static WebElement ccid(WebDriver driver){
		  element =     driver.findElement(By.xpath("//input[@name='custom_C208_1']"));
		  return element;
	  }			
	 
	 
		
		public static WebElement wtid(WebDriver driver){
		element =     driver.findElement(By.xpath("//input[@name='custom_C209_1']"));
		return element;
		}			

		public static WebElement payrollcode(WebDriver driver){
			element =     driver.findElement(By.xpath("//input[@name='custom_C234_1']"));
			return element;
			}										

		public static WebElement primarypayrollid(WebDriver driver){
			element =     driver.findElement(By.xpath("//input[@name='custom_C270_1']"));
			return element;
			}									

		public static WebElement secondarypayrollid(WebDriver driver){
			element =     driver.findElement(By.xpath("//input[@name='custom_C271_1']"));
			return element;
			}			

		public static WebElement surveydate(WebDriver driver){
			element =     driver.findElement(By.xpath("//input[@name='dt_surveyDate']"));
			return element;
			}		
									

		public static WebElement archiveboxnbr(WebDriver driver){
			element =     driver.findElement(By.xpath("//input[@name='cust_box_number']"));
			return element;
			}	


		public static WebElement clientsystemid(WebDriver driver){
			element =     driver.findElement(By.xpath("//input[@id='client_system_id']"));
			return element;
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
	 
	//**3M PROFILE**//
	 public static WebElement custhomecompany(WebDriver driver){
		 element =    driver.findElement(By.xpath("//input[@name='cust_Host_Company_Name']"));
		  return element;
	 }
	
	  
	 public static WebElement custhostcompanycode(WebDriver driver){
		 element =    driver.findElement(By.xpath("//input[@name='cust_Host_Company_Code']"));
		  return element;
	 
  } 
	 public static WebElement custhomebusiness(WebDriver driver){
		 element =    driver.findElement(By.xpath("//input[@name='cust_Host_Business']"));
		  return element;
	 
  }	 

	 public static WebElement custhostdivision(WebDriver driver){
		 element =    driver.findElement(By.xpath("//input[@name='cust_Host_Division']"));
		  return element;
	 
  }

	 public static WebElement custhostdepartmentname(WebDriver driver){
		 element =    driver.findElement(By.xpath("//input[@name='cust_Host_Department_Name']"));
		  return element;
	 
  }

	 public static WebElement custhostdepartmentnbr(WebDriver driver){
		 element =    driver.findElement(By.xpath("//input[@name='cust_Host_Department_Number']"));
		  return element;
	 
  }
	
	 

	 public static WebElement orgresult3m(WebDriver driver){
		  element =  	 driver.findElement((By.xpath("//a[contains(.,'3M - EMEA Supply Chain Centre of Expertise- Bern Switzerland')]")));
		  return element;
	  }
	 
	 public static void OrgResult3mClick(WebDriver driver) {
		   element = orgresult3m(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 
	 /**DB FIELDS**/
	 
	 public static WebElement orgresultDB(WebDriver driver){
		  element =  	 driver.findElement((By.xpath("//a[contains(.,'Deutsche Bank (China) Co. Ltd Tianjin (B287) c/o SIRVA China')]")));
		  return element;
	  }
	 
	 public static void OrgResultDBClick(WebDriver driver) {
		   element = orgresultDB(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	}
	 public static Select countryfrom(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement((By.xpath("//select[@name='country_from']")));
	      element=new Select (element_dropdown);
		  return element; 
	  }
	 
	 public static Select countryto(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement((By.xpath("//select[@name='country_to']")));
	      element=new Select (element_dropdown);
		  return element; 
	  }
	 
	 
	 
	 
	 /**Amgen Fields**/
	 
	 public static WebElement orgresultAmgen(WebDriver driver){
		  element = driver.findElement((By.xpath("//a[contains(.,'Amgen (Asia) Limited - 1073')]")));
		  return element;
	  }
	 
	 public static void OrgResultAmgenClick(WebDriver driver) {
		   element = orgresultAmgen(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	 }
	 
	 
	 
	 
	 /**Apple Fields**/
	 public static WebElement orgresultApple(WebDriver driver){
		  element = driver.findElement((By.xpath("//a[contains(.,'Apple AC Wellness - 0034')]")));
		  return element;
	  }
	 
	 public static void OrgResultAppleClick(WebDriver driver) {
		   element = orgresultApple(driver);
		   waitForElementToBeClickable(driver,element,3);
		   element.click();
	 }
		
	   public static Select highlevelsob(WebDriver driver){
				 Select element = null; 
				 WebElement element_dropdown = driver.findElement((By.xpath("//select[contains(@onchange,'loadSubLOB(this.value);')]")));
			      element=new Select (element_dropdown);
				  return element; 
			  }
	   public static Select sublob(WebDriver driver){
			 Select element = null; 
			 WebElement element_dropdown = driver.findElement((By.xpath("//select[contains(@onchange,'loadSVPVP(this.value);')]")));
		      element=new Select (element_dropdown);
			  return element; 
		  }
	   
	 
	   public static Select svpvp(WebDriver driver){
			 Select element = null; 
			 WebElement element_dropdown = driver.findElement((By.xpath("//select[@name = 'MISC2'] ")));
		      element=new Select (element_dropdown);
			  return element; 
		  }
	    
		/**BKC**/
	
	  public static WebElement orgresultBKC(WebDriver driver){ 
	  element  = driver.findElement(By.xpath("//a[contains(.,'SIRVA')]"));
          return element; 
     }

	  public static void OrgresultBKCClick(WebDriver driver) { 
	   element =   orgresultBKC(driver); 
	   waitForElementToBeClickable(driver,element,3);
	    element.click(); 
	    }
	   	   

		
      /**Direct Delivery**/
    public static WebElement orgresultDD(WebDriver driver){ 
	  element  = driver.findElement(By.xpath("//a[contains(.,'DD Genentech, Inc. c/o SIRVA US (DE)')]"));
        return element; 
   }

	  public static void OrgresultDDClick(WebDriver driver) { 
	   element =   orgresultBKC(driver); 
	   waitForElementToBeClickable(driver,element,3);
	    element.click(); }
	   

/**Honeywell**/
	    public static WebElement orgresultHON(WebDriver driver){ 
	    	  element  = driver.findElement(By.xpath("//a[contains(.,'Honeywell - ACS')]"));
	    	    return element; 
	    	}

	    	  public static void OrgresultHONClick(WebDriver driver) { 
	    	   element =   orgresultHON(driver); 
	    	   waitForElementToBeClickable(driver,element,3);
	    	    element.click(); 
	    	  } 	   

public static Select relostatus(WebDriver driver){
	 Select element = null; 
	 WebElement element_dropdown = driver.findElement((By.xpath("//select[@name='ddlb_Relo_Status']")));
     element=new Select (element_dropdown);
	  return element; 
 }

public static Select RC(WebDriver driver){
	 Select element = null; 
	 WebElement element_dropdown = driver.findElement((By.xpath("//select[@name='ddlb_SPC']")));
    element=new Select (element_dropdown);
	  return element; 
}


public static Select MC(WebDriver driver){
	 Select element = null; 
	 WebElement element_dropdown = driver.findElement((By.xpath("//select[@name='ddlb_RMC']")));
   element=new Select (element_dropdown);
	  return element; 
}

public static Select opsmgr(WebDriver driver){
	 Select element = null; 
	 WebElement element_dropdown = driver.findElement((By.xpath("//select[@name='ddlb_Ops_Manager']")));
  element=new Select (element_dropdown);
	  return element; 
}


public static Select SBU(WebDriver driver){
	 Select element = null; 
	 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_SBU']"));
 element=new Select (element_dropdown);
	  return element; 
}



public static Select SBE(WebDriver driver){
	 Select element = null; 
	 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_SBE']"));
 element=new Select (element_dropdown);
	  return element; 
}

public static Select hyperioncode(WebDriver driver){
	 Select element = null; 
	 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='ddlb_hyperion_code']"));
element=new Select (element_dropdown);
	  return element; 
}

public static WebElement assigneetypeHON(WebDriver driver){
	  element = driver.findElement((By.xpath("//a[contains(@href,'javascript:popup_custom_SIRVA')]")));
	  return element;
}


public static void AssigneetypeHONClick(WebDriver driver) { 
	   element =   assigneetypeHON(driver); 
	   waitForElementToBeClickable(driver,element,3);
	    element.click(); 
	  } 	  


public static WebElement visaexpdateHON(WebDriver driver){
	  element = driver.findElement((By.xpath("//input[@name = 'dt_visa_expiration']")));
	  return element;
}


public static WebElement depspecialneedsHON(WebDriver driver){
	  element = driver.findElement((By.xpath("//textarea[@name = 'cust_oth_special_needs_1']")));
	  return element;
}


   /**Genentech**/

	public static WebElement orgresultGNE(WebDriver driver){ 
	element  = driver.findElement(By.xpath("//a[contains(.,'Genentech - Candidate')]"));
	return element; 
	}
	
	public static void OrgresultGNEClick(WebDriver driver) { 
	element =   orgresultGNE(driver); 
	waitForElementToBeClickable(driver,element,3);
	element.click(); 
	} 	   
	
	public static WebElement staffinfunction(WebDriver driver){ 
	element  = driver.findElement(By.xpath("//input[@name = 'department_name']"));
	return element; 
	}
	
	public static WebElement financemanagerGNE(WebDriver driver){ 
		element  = driver.findElement(By.xpath("//input[@name = 'finance_managerCC']"));
		return element; 
		}
	
	public static WebElement ecmember(WebDriver driver){ 
	element  = driver.findElement(By.xpath("//input[@name = 'ec_memberCC']"));
	return element; 
	}
	
	
	public static WebElement function(WebDriver driver){ 
	element  = driver.findElement(By.xpath("//input[@name = 'functionCC']"));
	return element; 
	}
	
	public static WebElement staffingconsul(WebDriver driver){ 
		element  = driver.findElement(By.xpath("//input[@name = 'Staffing_Consultant']"));
		return element; 
		}
 
	public static WebElement superfunctioncode(WebDriver driver){ 
		element  = driver.findElement(By.xpath("//input[@name = 'super_function_code']"));
		return element; 
		}

	public static WebElement gmc(WebDriver driver){ 
		element  = driver.findElement(By.xpath("//input[@name = 'GMC']"));
		return element; 
		}
	
	public static WebElement PO(WebDriver driver){ 
		element  = driver.findElement(By.xpath("//input[@name = 'cust_po_num']"));
		return element; 
		}
	
	public static WebElement personelid(WebDriver driver){ 
		element  = driver.findElement(By.xpath("//input[@name = 'cust_Personnel_ID']"));
		return element; 
		}

	public static WebElement persistid(WebDriver driver){ 
		element  = driver.findElement(By.xpath("//input[@name = 'cust_Persistent_ID']"));
		return element; 
		}

	public static Select compcode(WebDriver driver){
		 Select element = null; 
		 WebElement element_dropdown = driver.findElement(By.xpath("//select[@name='Company_Code']"));
	element=new Select (element_dropdown);
		  return element; 
	}
	
	 /**Metlife**/

		public static WebElement orgresultMetlife(WebDriver driver){ 
		element  = driver.findElement(By.xpath("//a[contains(.,'MetLife - Americas Region')]"));
		return element; 
		}
		
		public static void OrgresultMetlifeClick(WebDriver driver) { 
		element =   orgresultMetlife(driver); 
		waitForElementToBeClickable(driver,element,3);
		element.click(); 
		} 	   
		
		


	/**SAP**/ 
		public static WebElement orgresultSAP(WebDriver driver){ 
			element  = driver.findElement(By.xpath("//a[contains(.,'SAP Africa')]"));
			return element; 
			}
			
			public static void OrgresultSAPClick(WebDriver driver) { 
			element =   orgresultSAP(driver); 
			waitForElementToBeClickable(driver,element,3);
			element.click(); 
			} 	   
		
		
		
		
		
	
}