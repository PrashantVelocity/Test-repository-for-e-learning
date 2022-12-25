package testkhanacademy;





import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import khanacademymain.Login;
import khanacademymain.Logout;
import khanacademymain.Login;
import khanacademymain.codeAdd;
import khanacademymain.teachers;


public class testkhanacademy {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.khanacademy.org/login");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		Login login=new Login(driver);
		//loginpage.clickLog();
		
		login.email();
		login.password();
		Thread.sleep(2000);
		login.loginbutton();
		
		teachers teachers= new teachers(driver);
		teachers.Teach();
		teachers.enterclasscode();
		
		codeAdd codeAdd=new codeAdd(driver);
		codeAdd.entercode();
		codeAdd.clickoncontinue();
		Thread.sleep(2000);
		driver.navigate().back();
		
		Logout logout=new Logout(driver);
		logout.profileclick();
		logout.logoutclick();
		Thread.sleep(2000);
		driver.close();
		
		
		
	
}
}