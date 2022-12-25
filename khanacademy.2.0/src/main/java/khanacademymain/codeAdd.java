package khanacademymain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class codeAdd {
	
	//1)declare var globally
	
	@FindBy(xpath="//input[@class='_q92ef6']")private WebElement addcode;
	
	@FindBy(xpath="//button[@type='button']")private WebElement continues;
	
	//2)initialise var with constructor
	public codeAdd(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//3)create method
	public void entercode() {
		addcode.sendKeys("12345678");
	}
	public void clickoncontinue() {
		continues.click();
	}
	
	

}
