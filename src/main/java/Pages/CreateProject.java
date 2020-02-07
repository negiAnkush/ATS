package Pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class CreateProject {

	WebDriver dr;
	public CreateProject(WebDriver driver){
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//*[starts-with(text(),'New Project')]")
	private WebElement newProject;
	
	@FindBy(xpath="//*[starts-with(text(),'Project Name')]/parent::div/descendant::input")
	private WebElement projectName;
	
	@FindBy(xpath="//h6[text()='Create New Project']")
	private WebElement createNewProject;
	
	
	@FindBy(xpath="//*[starts-with(text(),'Country')]/parent::div/descendant::input")
	private WebElement country;
	
	@FindBy(xpath="//*[contains(@id,'react-autowhatever-') and contains(@id,'item-0')]")
	private WebElement countryList;
	
	@FindBy(xpath="//*[starts-with(text(),'State')]/parent::div/descendant::input")
	private WebElement state;
	
	@FindBy(xpath="//*[contains(@id,'react-autowhatever-') and contains(@id,'item-0')]")
	private WebElement stateList;
	
	@FindBy(xpath="//*[starts-with(text(),'City')]/parent::div/descendant::input")
	private WebElement city;
	
	@FindBy(xpath="//*[contains(@id,'react-autowhatever-') and contains(@id,'item-0')]")
	private WebElement cityList;
	
	@FindBy(xpath="//*[starts-with(text(),'Address')]/parent::div/descendant::textarea[@aria-invalid='false']")
	private WebElement address;
	
	@FindBy(xpath="//*[starts-with(text(),'Bid Date')]/parent::div/descendant::input")
	private WebElement date;
	
	@FindBy(xpath="//button[@class='MuiButtonBase-root-934 MuiIconButton-root-976']//*[@class='MuiSvgIcon-root-938']")
	private WebElement datepicker;
	
	@FindBy(xpath="//*[starts-with(text(),'Area')]/parent::div/descendant::input")
	private WebElement area;
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	private WebElement next;
	
	@FindBy(xpath = "//span[contains(text(),'Finish')]")
	private WebElement finish;
	
	@FindBy(xpath="//*[@data-icon='building']/following-sibling::p")
	private WebElement commercialBuilding;
	
	@FindBy(xpath="//*[contains(@value,'Mall')]/parent::*")
	private WebElement mall;
	
	Faker faker = new Faker();
	private static String project;
	
	public void clickOnNewPoject(){
		newProject.click();
	}
	public void enterBasicProjectDetails(){
		projectName.sendKeys(getProjectName());
	} 
	
	public void enterBasicProjectDetails(String projectname){
		projectName.sendKeys(projectname);
	} 
	private String getProjectName(){
		project = faker.lastName()+" " + "Solution";
		return project;
	}
	public boolean verifyDashboard(){
		boolean b=false;
		try{
			b=newProject.isDisplayed();
		}catch(Exception e){
			
		}
			return b;
	}
	
	public boolean verifyCreateProjectScreean(){
		boolean b=false;
		try{
			waitForElementVisible(createNewProject);
			b=createNewProject.isDisplayed();
		}catch(Exception e){
			
		}
			return b;
	}
	
	
	public void enterCountry(String cut) 
	{

		country.sendKeys(Keys.chord(cut));
		waitForElementVisible(countryList);
		countryList.click();
	}
	
	public void enterState(String st)
	{

		state.sendKeys(Keys.chord(st));
		waitForElementVisible(stateList);
		stateList.click();
	}
	
	public void enterCity(String cty) throws InterruptedException
	{

		boolean b=false;
		city.sendKeys(Keys.chord(cty));
		
		try {
			waitForElementVisible(cityList);
			b=cityList.isDisplayed();
		}catch(Exception e) {}
		if(b==false) {
			new Actions(dr).sendKeys(Keys.BACK_SPACE);
		}
		waitForElementVisible(cityList);
		cityList.click();
		
	}
	
	public void enterDate(String dt)
	{

		Date dat=new Date();
		SimpleDateFormat sft = new SimpleDateFormat("yyyy/MM/dd");
		String s=sft.format(dat);
		date.sendKeys(s);
	}
	public void enterArea(String a) {
		area.sendKeys(a);
	}
	public void enterAddress(String addr) {
		address.sendKeys(addr);
	}
	public void otherBasicDetails(String addr,String date, String city,String state, String country, String a) throws InterruptedException {
		enterCountry(country);
		enterState(state);
		enterCity(city);
		enterAddress(addr);
		enterDate(date);
		enterArea(a);
	}
	
	public void clickNext() {
		next.click();
	}
	
	private void clickOnCommercialBuilding() {
		commercialBuilding.click();
	}
	private void clickOnMall() {
		mall.click();
	}
	
	public void selectBuildingClass() {
		clickOnCommercialBuilding();
		clickOnMall();
	}
	
	public void clickOnFinish() {
		waitForElementClickable(finish);
		new Actions(dr).pause(10000).perform();
		finish.click();
	}
	public void waitForElementVisible(WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(dr, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
public void waitForElementClickable(WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(dr, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
public String readProjectName() {
	return project;
}

}
