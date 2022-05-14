package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import basePacks.BaseClass;
import pageObjects.searchPage;
import utilities.ImportFromExcel;

public class TC01 extends BaseClass {
	
	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		searchPage sp = new searchPage(driver);
		logger.info("Importing data from excel" );
		sp.clickRoundBtn();
		ImportFromExcel ife = new ImportFromExcel();
		String from = ife.getdata("From");
		sp.setFrom(from);
		String to = ife.getdata("To");
		sp.setTo(to);
		sp.clickdate();
		sp.selectDate();
		sp.SelectPass();
		sp.clickSearch();
		captureScreen("goIndigo");
		//sp.geBusData();
	}

}
