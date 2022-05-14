package pageObjects;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePacks.BaseClass;

public class searchPage extends BaseClass {
	
	WebDriver ldriver;
	
	public searchPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"bookFlightTab\"]/form/div[2]/div[2]/label/label")
	@CacheLookup
	WebElement roundTripBtn;
	
	@FindBy(xpath = "//*[@id=\"bookFlightTab\"]/form/div[3]/div[1]/div[1]/div/div/input")
	@CacheLookup
	WebElement From;
	
	@FindBy(xpath = "//*[@id=\"bookFlightTab\"]/form/div[3]/div[1]/div[2]/div/div/input")
	@CacheLookup
	WebElement To;
	
	@FindBy(xpath = "//*[@id=\"bookFlightTab\"]/form/div[3]/div[2]/div[1]/div/input")
	@CacheLookup
	WebElement date;
	
	@FindBy(xpath = "//a[@class = \"ui-state-default\"][@href=\"#\"][text()[contains(.,20)]]")
	@CacheLookup
	WebElement dateSelect;
	
	@FindBy(xpath = "//a[@class = \"btn btn-primary dateClose\"]")
	@CacheLookup
	WebElement done;
	
	@FindBy(xpath = "//*[@id=\"bookFlightTab\"]/form/div[5]/div[1]/div[1]/input")
	@CacheLookup
	WebElement pass;
	
	@FindBy(xpath = "//*[@id=\"bookFlightTab\"]/form/div[5]/div[1]/div[2]/ul/li[1]/div[1]/button[2]")
	@CacheLookup
	WebElement count;
	
	@FindBy(xpath = "//*[@id=\"bookFlightTab\"]/form/div[5]/div[1]/div[2]/div[4]/button")
	@CacheLookup
	WebElement done2;
	
	
	@FindBy(xpath = "//*[@id=\"bookFlightTab\"]/form/div[7]/div[9]/button/span[1]")
	@CacheLookup
	WebElement clickSearch;
	
	//method to click round btn in web page
		public void clickRoundBtn() throws IOException, InterruptedException {
			
			clickTheElement(roundTripBtn);
			
		}
	
	//method to set from in web page
	public void setFrom(String data) throws IOException, InterruptedException {
		
		clearTextBox(From);
		enterInputInElement(From , data);
		
		
	}
	//method to set to in web page
	public void setTo(String data) throws IOException, InterruptedException {
		clearTextBox(To);
		enterInputInElement(To , data);
	}
	//method to click date
	public void clickdate() throws IOException, InterruptedException {
		
		clickTheElement(date);
		
	}
	//method to select date
	public void selectDate() throws InterruptedException {

		//String date = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
		Calendar cal = GregorianCalendar.getInstance();
    	SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
    	Date currentMonth = new Date();
    	cal.setTime(currentMonth);
    	// current month
    	String currentMonthAsSting = df.format(cal.getTime());

    	// future date
	    cal.set(Calendar.DATE, cal.get(Calendar.DATE)+8);
   	    String nextDateAsString = df.format(cal.getTime());
		 // clickTheElement(calender);
		  clickTheElement(dateSelect);
		  clickTheElement(done);
	}
	public void SelectPass() throws IOException, InterruptedException {
        clickTheElement(pass);
        clickTheElement(count);
        clickTheElement(done2);
	}
	public void clickSearch() throws IOException, InterruptedException {
        clickTheElement(clickSearch);
	}

	

}
