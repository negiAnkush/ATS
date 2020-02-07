package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageProject {

	WebDriver drvr;
	CreateProject c=new CreateProject(drvr);
	public ManageProject(WebDriver driver)
	{
		this.drvr=driver;
		PageFactory.initElements(drvr, this);
	}
	
	@FindBy(xpath="//*[@title='Manage Projects']/descendant::span[text()='Manage Projects']")
	private WebElement managePrjct;
	
	@FindBy(xpath="//table/tbody/tr/td/div/div/div/a[text()='Kozey Solution']")
	private WebElement prjctName;
	
	private void clickOnManageProject() {
		waitForElementClickable(managePrjct);
		//manageProject.click();
		new Actions(drvr).pause(5000).perform();
		new Actions(drvr).click(managePrjct).perform();
		}
	
	public boolean verifyProjectCreated() 
	{
		boolean flag=false;
		clickOnManageProject();
		WebElement readName=drvr.findElement(By.xpath("//table/tbody/tr/td/div/div/div/a[text()='"+c.readProjectName()+"']"));
		try {
			waitForElementVisible(readName);
			flag=readName.isDisplayed();
		}catch(Exception e) {}
		return flag;
		
	}
	
	public String getProjectNameFromApp() {
		return drvr.findElement(By.xpath("//table/tbody/tr/td/div/div/div/a[text()='"+c.readProjectName()+"']")).getText();
	}
	public void waitForElementVisible(WebElement element) 
	{			
				WebDriverWait wait=new WebDriverWait(drvr, 10);
				wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementClickable(WebElement element) 
	{
			WebDriverWait wait=new WebDriverWait(drvr, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}

