package khanacademymain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {//POM class for khanacademy Loginpage 
	//1) declare var globally
	
	@FindBy(xpath="//a[@id='login-or-signup']")private WebElement login;
	
	@FindBy(xpath="(//input[@class='_1azps1NaN'])[1]") private WebElement username;
	
	
	@FindBy(xpath="//input[@type='password']") private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']") private WebElement loginbutton;
	
	//2)initialise var
	 public Login(WebDriver driver){
			PageFactory.initElements(driver,this);
	
	 }
	//3)create methods
     public void clickLog() {
    	 login.click();
     }
     public void email() {
   
         username.sendKeys("prashantsapkal");
         }
     public void password() {
    	 password.sendKeys("Velocity");
    	 }
     public void loginbutton() {
    	 loginbutton.click();
     }
}
