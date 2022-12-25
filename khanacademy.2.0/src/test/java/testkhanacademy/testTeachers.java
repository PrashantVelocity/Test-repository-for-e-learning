package testkhanacademy;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.Utils;

import khanacademymain.Login;
import khanacademymain.Logout;
import khanacademymain.codeAdd;
import khanacademymain.teachers;

public class testTeachers {
	WebDriver driver;
	Login login;
	codeAdd codeAdd;
	teachers teachers;
	Logout logout;
	SoftAssert soft;
	int testID;
	
	@BeforeClass
	public void beforeclass() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.khanacademy.org/");
		
	}
	
	@BeforeMethod
	public void beforemethod() throws InterruptedException {
		
		
		Thread.sleep(2000);
	
		
		 login=new Login(driver);
		login.clickLog();
		//Thread.sleep(10000);
		 
		
		login.email();
		login.password();
		//Thread.sleep(2000);
		login.loginbutton();
		 soft=new SoftAssert();
	
		
	}
	
	@Test 
	public void teachers() throws InterruptedException {
	 testID=121;
		 teachers= new teachers(driver);
		teachers.Teach();
		String url = driver.getCurrentUrl();
		boolean result = url.equals("https://www.khanacademy.org/profile/me/teachers");
		Assert.assertTrue(result);//true---->passed
		//Assert.assertEquals(url, "https://www.khanacademy.org/profile/me/teachers","url not found");
		//Assert.assertNotEquals(url, "https://www.khanacademy.org/profile/me/teacher");
		/*if(url.equals("https://www.khanacademy.org/profile/me/teacher")) {
			System.out.println("teachers is passed");
		}
		else {
			System.out.println("teachers is failed");
		}
		*/
		//Thread.sleep(2000);
		//driver.navigate().back();
		
	}
     @Test
     public void profile() throws InterruptedException {
    	 testID=122;
    	  teachers=new teachers(driver);
    	  teachers.profileclick();
    	  Thread.sleep(2000);
    	  String url1 = driver.getCurrentUrl();
    soft.assertEquals(url1, "https://www.khanacademy.org/profile/m/");//create object of softassert
    	  
    	  /*if(url1.equals("https://www.khanacademy.org/profile/me/")) {
    		  System.out.println("profile is passed");}
    		  else {
    			  System.out.println("profile is failed");
    		  }*/
    	  String title = driver.getTitle();
    	  System.out.println("actual title= "+title);
    	  boolean result = title.equals("Dashboard | Khan Academ");
    	  soft.assertTrue(result);
    	  soft.assertAll();
    	  
    	  }
    	
		
    @Test
     public void progress() throws InterruptedException {
    	testID=123;
    	  teachers=new teachers(driver);
    	  teachers.progressclick();
    	 // Thread.sleep(2000);
    	  String url2 = driver.getCurrentUrl();
    	  if(url2.equals("https://www.khanacademy.org/profile/me/progress")) {
    		  System.out.println("progress is passed");}
    		  else {
    			  System.out.println("progress is failed");
    		  }
    	  }
     
	

	@AfterMethod
	
	public void aftermethod(ITestResult result ) throws InterruptedException, IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			utility.Utils.takeScreenshots(driver, testID);
		}
		 logout=new Logout(driver);
		logout.profileclick();

		//Thread.sleep(2000);
		logout.logoutclick();
		//Thread.sleep(2000);
		
		
	}
	
	@AfterClass
	public void afterclass() throws InterruptedException {
		//Thread.sleep(2000);
		driver.close();
		
	}
	
}
