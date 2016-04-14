package com.omgeo.about;
 
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
 
public class OmgeoAboutTest {
                WebDriver driver;
  @Test(priority=1)
  public void verifyAboutOmgeoPage() {
                  driver.findElement(By.xpath(".//a[@href = '/aboutomgeo']")).click();
                  String expectedTitle = "Post-Trading Solutions for the Global Investment Industry | Omgeo";
                  String actualTitle = "";
                  actualTitle = driver.getTitle();
                  if (actualTitle.contentEquals(expectedTitle)){
          System.out.println("Omgea About Page opened");
      } else {
          System.out.println("Omgea About Page is not opened");
      }
                 
  }
 
  @Test(priority=2)
  public void verifyOmgeoAlertPage() {
                 
                  Select select = new Select(driver.findElement(By.xpath(".//ul[@class='chzn-results']")));
      select.selectByVisibleText("ALERT");               
      String expectedTitle = "Online Account & Standing Settlement Instructions (SSI) | Omgeo ALERT";
                  String actualTitle = "";
                  actualTitle = driver.getTitle();
                  if (actualTitle.contentEquals(expectedTitle)){
          System.out.println("Omgea Alert Page opened");
      } else {
          System.out.println("Omgea Alert Page is not opened");
      }
     
  }
 
  @Test(priority=3)
  public void verifyLeadershipTeamPage(){
                  Actions actions = new Actions(driver);
                  WebElement aboutMenu = driver.findElement(By.xpath(".//a[@href = '/aboutomgeo']"));
                  actions.moveToElement(aboutMenu).moveToElement(driver.findElement(By.xpath(".//a[@href = '/leadership_team']"))).click().build().perform();
                  String expectedURL = "http://www.omgeo.com/leadership_team";
                  String actualURL = "";
                  actualURL = driver.getCurrentUrl();
                  if (actualURL.contentEquals(expectedURL)){
          System.out.println("Omgea Leadership Team Page opened");
      } else {
          System.out.println("Omgea Leadership Team Page is not opened");
      }
                 
                  //click executive team member
                  driver.findElement(By.xpath(".//span/a[@href = 'javascript:openModal('/page/paula_arthus', 500, 600);'")).click();
                  //switch to frame
                  driver.switchTo().frame(0);
                  String bodyText = driver.findElement(By.tagName("body")).getText();
                  Assert.assertTrue(bodyText.contains("Paula Arthus"),"Paula Arthus is present");            
  }
 
  @BeforeClass
  public void beforeTest() {
                  driver = new FirefoxDriver();
                  driver.get("http://www.omgeo.com/");
                  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
 
  @AfterClass
  public void afterTest() {
                  driver.quit();
  }
 
}
