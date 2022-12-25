package khanacademymain;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class teachers {// multiple test cases 
	//1) declare var globally
	
		@FindBy(xpath="//span[text()='Teachers']") private WebElement teacher;
		
		@FindBy(xpath="//a[@role='button']") private WebElement enterclasscode;
		
		@FindBy(xpath="//span[text()='Profile']") private WebElement profile;
		
		@FindBy(xpath="//span[text()='Progress']") private WebElement progress;
		
		
		//2)initialise var
		 public teachers (WebDriver driver){
				PageFactory.initElements(driver,this);
		
		 }
		//3)create methods
	     public void Teach() {
	    	 teacher.click();
	     }
	     
	     public void enterclasscode() {
	    	 enterclasscode.click();
	     }
	     
	     public void profileclick() {
	    	 profile.click();
	     }
	     
	     public void progressclick() {
	    	 progress.click();
	     }
	    
	    
	     
		
		

}
