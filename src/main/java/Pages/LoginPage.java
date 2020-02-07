package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

	private WebDriver drvr;
	public LoginPage(WebDriver driver){
		this.drvr=driver;
		PageFactory.initElements(drvr, this);
	}
	
	@FindBy(css="[name='username']")
	private WebElement user;
	
	@FindBy(css="[name='password']")
	private WebElement passwd;
	
	@FindBy(css="button[type='submit'] > span")
	private WebElement login;
	

	public void loginToPage(String username, String pass)
	{
		waitForElementVisible(user);
		user.sendKeys(username);
		passwd.sendKeys(pass);
		login.click();
	}
	
public void waitForElementClickable(WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(drvr, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
public void waitForElementVisible(WebElement element) {
	
	WebDriverWait wait=new WebDriverWait(drvr, 10);
	wait.until(ExpectedConditions.visibilityOf(element));
}
}
