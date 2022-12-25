package testkhanacademy;


	
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import khanacademymain.Login;
	import khanacademymain.Logout;
	import khanacademymain.Login;
	import khanacademymain.codeAdd;
	import khanacademymain.teachers;


	public class TestTeachersCross {
		
		WebDriver driver;
		Login login;
		codeAdd codeAdd;
		teachers teachers;
		Logout logout;
		SoftAssert soft;
		
		@Parameters ("browser")
		 
		@BeforeTest
		 public void openbrowser(String browsername) {
			System.out.println(browsername);
			if(browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();
			}
			if(browsername.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\HP\\Downloads\\geckodriver.exe");
				 driver = new FirefoxDriver();
				}
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://www.khanacademy.org/");
			 
		 }
		 
		
		@BeforeClass
		public void beforeclass() {
			 login=new Login(driver);
			 teachers= new teachers(driver);
			  logout=new Logout(driver);
		}
		
		@BeforeMethod
		public void beforemethod() throws InterruptedException {
			
			
			Thread.sleep(2000);
		
			
			
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
	    	  
	    	  teachers.profileclick();
	    	  Thread.sleep(2000);
	    	  String url1 = driver.getCurrentUrl();
	    	  soft.assertEquals(url1, "https://www.khanacademy.org/profile/me/");
	    	  soft.assertAll();
	    	  /*if(url1.equals("https://www.khanacademy.org/profile/me/")) {
	    		  System.out.println("profile is passed");}
	    		  else {
	    			  System.out.println("profile is failed");
	    		  }*/
	    	  }
	    	
			
	    @Test
	     public void progress() throws InterruptedException {
	    	
	    	  teachers.progressclick();
	    	 // Thread.sleep(2000);
	    	  String url2 = driver.getCurrentUrl();
	    	  
	          Assert.assertEquals(url2, "https://www.khanacademy.org/profile/me/progress");
	    	  
	    	 /* if(url2.equals("https://www.khanacademy.org/profile/me/progress")) {
	    		  System.out.println("progress is passed");}
	    		  else {
	    			  System.out.println("progress is failed");
	    		  }*/
	    	  }
	     
		

		@AfterMethod
		public void aftermethod() throws InterruptedException {
			 
			logout.profileclick();

			//Thread.sleep(2000);
			logout.logoutclick();
			//Thread.sleep(2000);
			
			
		}
		
		@AfterClass
		public void afterclass() throws InterruptedException {
			//Thread.sleep(2000);
			 login=null;
			 teachers=null;
			 
			  logout=null;
			
			
		}
		@AfterTest
		 public void aftertest() {
			driver.close();
			System.gc();
			 
		 }
}
