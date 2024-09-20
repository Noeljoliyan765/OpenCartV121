package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver){		
		super(driver);	
	}
	
	@FindBy(xpath="//input[@id='input-email']") WebElement username;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//input[@value='Login']") WebElement login;
	
	public void username(String email) {
		username.sendKeys(email);
	}
	public void password(String pwd) {
		password.sendKeys(pwd);
	}
	public void loginbtn() {
		login.click();
	}

}
