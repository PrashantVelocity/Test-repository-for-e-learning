package khanacademymain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
	//1)globally var declare
	@FindBy(xpath="//span[@class='_wozql4 _13hnk7qk']") private WebElement profile ;
	
	@FindBy(xpath="//span[text()='Log out']") private WebElement logout;
	//2)initialise with constructor
	
	public Logout(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//3)method creation
	public void profileclick() {
		profile.click();
	}
	public void logoutclick() {
		logout.click();
	}

}
