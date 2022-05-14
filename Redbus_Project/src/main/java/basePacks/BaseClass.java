package basePacks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.ImportFromExcel;
import utilities.readPropertyFile;


public class BaseClass {
	
	public readPropertyFile rpf = new  readPropertyFile() ;
	public String URL = rpf.getDataFromPropertyFile("baseURL");
	public String browser;
	public static WebDriver driver;
	public static Logger logger;
	
	//@Parameters({"browsers"})
	@BeforeClass
	public void setup() throws IOException {
	  
		String browserName=rpf.getDataFromPropertyFile("browser");
		logger = Logger.getLogger("RedBus");
		PropertyConfigurator.configure("log4j.properties");
		
		logger.info("Starting "+browserName+" browser" );
		if (browserName.equalsIgnoreCase("Chrome")) {
			String driverPath = rpf.getDataFromPropertyFile("chromePath");
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			String driverPath = rpf.getDataFromPropertyFile("firefoxPath");
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else {
			String driverPath = rpf.getDataFromPropertyFile("chromePath");
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		//Deleting all the cookies
		driver.manage().deleteAllCookies();
		//Specifiying pageLoadTimeout and Implicit wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.info("Getting "+URL);
		try {
		driver.get(URL); // Navigates to the web page
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	//method to wait for the element
	public WebElement WaitForElement(WebElement elementQuery) {
		
		WebElement element = null;
		try {
		WebDriverWait wait  = new WebDriverWait(driver, 500);
		element = wait.until(ExpectedConditions.visibilityOf(elementQuery));
	    wait.until(ExpectedConditions.elementToBeClickable(elementQuery));
		}catch(Exception e) {
			System.out.println("Getting Exception while wait "+e.getMessage());
		}
		return element;
	}
	
	//method to click the element
	public void clickTheElement(WebElement elementQuery) {		
		try {
			WebElement element = WaitForElement(elementQuery);
			if(!(element == null)) {
				element.click();
			}
			else {
				System.out.println("Element not found");
			}
		}catch(Exception e) {
			System.out.println("Getting Exception while click "+e.getMessage());
		}
	}
	
	//method to click the element
		public void SendKeysToElement(WebElement elementQuery) {		
			try {
				WebElement element = WaitForElement(elementQuery);
				if(!(element == null)) {
					element.sendKeys(Keys.ENTER);
				}
				else {
					System.out.println("Element not found");
				}
			}catch(Exception e) {
				System.out.println("Getting Exception while click "+e.getMessage());
			}
		}
	
	//method to enter value in  the element
    public void enterInputInElement(WebElement elementQuery , String Value) {
		
		try {
			WebElement element = WaitForElement(elementQuery);
			if(!(element == null)) {
				element.sendKeys(Value + Keys.ENTER);
				
			}
			else {
				System.out.println("Element not found");
			}
		}catch(Exception e) {
			System.out.println("Getting Exception while entering data "+e.getMessage());
		}
	}
    
    //method to clear the text in the element(Text Box)
   public void clearTextBox(WebElement elementQuery) {
		
		try {
			WebElement element = WaitForElement(elementQuery);
			if(!(element == null)) {
				element.clear();
			}
			else {
				System.out.println("Element not found");
			}
		}catch(Exception e) {
			System.out.println("Getting Exception while clearing data "+e.getMessage());
		}
	}
 //method to get text in the element
   public String getTextofElement(WebElement elementQuery) {
		String text = null;
	   try {
			WebElement element = WaitForElement(elementQuery);
			if(!(element == null)) {
				text = element.getText();
			}
			else {
				System.out.println("Element not found");
			}
		}catch(Exception e) {
			System.out.println("Getting Exception while getting data "+e.getMessage());
		}
	   return text;
	}
   //method to get attribute value
   public String getAttributeValueofElement(WebElement elementQuery , String value) {
		
		String text = null;
	   try {
			WebElement element = WaitForElement(elementQuery);
			if(!(element == null)) {
				text = element.getAttribute(value);
			}
			else {
				
			}
		}catch(Exception e) {
			System.out.println("Getting Exception while getting data "+e.getMessage());
		}
	   return text;
	}
	//method to capture screenshot
	public static void captureScreen(String screenshotName){
		
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		
		try {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") +"\\Screenshots\\"+screenshotName+".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		} catch (Exception e) {
			
			System.out.println("Exception while taking Screenshot"+e.getMessage());
		} 
	}
	
	
	//method to close the browser
	 @AfterClass 
	 public void Close()
	 { 
		// driver.quit(); 
	 }
	 

}
