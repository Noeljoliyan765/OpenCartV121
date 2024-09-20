package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver){	
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement fName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement lName;
	@FindBy(xpath="//input[@id='input-email']") WebElement email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement tel;
	@FindBy(xpath="//input[@id='input-password']") WebElement pwd;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement confpwd;
	@FindBy(xpath="//input[@value='Continue']") WebElement submit;
	@FindBy(xpath="//input[@name='agree']") WebElement privacy;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement mssg;
	
	public void fname(String first) {
		fName.sendKeys(first);
	}
	public void lname(String last) {
		lName.sendKeys(last);
	}
	public void email(String em) {
		email.sendKeys(em);
	}
	public void tel(String phone) {
		tel.sendKeys(phone);
	}
	public void pwd(String psswd) {
		pwd.sendKeys(psswd);
	}
	public void confpwd(String cpsswd) {
		confpwd.sendKeys(cpsswd);
	}
	public void submit() {
		submit.click();
	}
	public void privacy() {
		privacy.click();
	}
	public String message() {
		try {
			return (mssg.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
		
	}
	
	
	
}
	
	
	
