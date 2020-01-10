package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ELTC_004_LostPasswordPOM;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_004_LostPasswordTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private HomePOM homepom;
	private ELTC_004_LostPasswordPOM lostpasswordPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		homepom = new HomePOM(driver); 
		lostpasswordPOM = new ELTC_004_LostPasswordPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	//@AfterMethod
	//public void tearDown() throws Exception {
		//Thread.sleep(1000);
		//driver.quit();
//}
	
	@Test
	public void LostPasswordTest() throws InterruptedException {
		lostpasswordPOM.lostPassword();
		 
		screenShot.captureScreenShot("First");
		
	}
	
	
}
