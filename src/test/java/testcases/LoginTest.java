package testcases;

import org.testng.annotations.Test;

import Pages.CreateProject;
import Pages.LoginPage;
import Pages.ManageProject;
import testbase.TestBase;
import utilities.Constants;
import utilities.ExcelUtility;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	WebDriver drvr;
	TestBase tb;
	LoginPage lp;
	CreateProject cp;
	ManageProject mp;
	
	
  @Test(description="Create New Project", priority=1, enabled=true)
  public void creatNewProject() throws InterruptedException {
	  String username=ExcelUtility.getCellData("userInfo", "username", 1);
	  String password=ExcelUtility.getCellData("userInfo", "password", 2);
	  lp.loginToPage(username,password);
	  assertTrue(cp.verifyDashboard());
	  cp.clickOnNewPoject();
	  assertTrue(cp.verifyCreateProjectScreean());
	  cp.enterBasicProjectDetails();
	  String address = ExcelUtility.getCellData("ProjectData", "address", 0);
	  String area = ExcelUtility.getCellData("ProjectData", "area", 1);
	  String country = ExcelUtility.getCellData("ProjectData", "Country", 2);
	  String state = ExcelUtility.getCellData("ProjectData", "State", 3);
	  String city = ExcelUtility.getCellData("ProjectData", "City", 4);
	  String date = ExcelUtility.getCellData("ProjectData", "Bid Date", 5);
	  System.out.println("Address:"+address+"\n"+
			  "Date:"+date+"\n"+
			  "City:"+city+"\n"+
			  "State:"+state+"\n"+
			  "Country:"+country+"\n"+
			  "Area:"+area);
	  int a = (int) Double.parseDouble(area);
	  cp.otherBasicDetails(address,date, city, state, country, String.valueOf(a));
	  cp.clickNext();
	  cp.selectBuildingClass();
	  cp.clickNext();
	  cp.clickOnFinish();
	  assertTrue(mp.verifyProjectCreated());
	  System.out.println("Code: "+cp.readProjectName()+"\n"+"APP: "+mp.getProjectNameFromApp());
	  assertEquals(cp.readProjectName(),mp.getProjectNameFromApp());
  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  tb = new TestBase();
	  drvr=tb.getInstance();
	  lp=new LoginPage(drvr);
	  cp=new CreateProject(drvr);
	  mp=new ManageProject(drvr);
  }

  @AfterMethod
  public void afterMethod() {

  }

}
