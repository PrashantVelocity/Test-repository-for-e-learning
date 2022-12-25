package khanacademymain;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Profile {
	
	@FindBy(xpath="//span[text()='Profile']") private WebElement profile;

}
