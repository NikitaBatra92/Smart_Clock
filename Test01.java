package projectPremiumLearnings;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Test01 {
	WebDriver driver;
	
  @Test(dataProvider="data")
  public void testcalculator(Integer height, Integer weight) throws InterruptedException {
	  String ht = String.valueOf(height);
	  String wt = String.valueOf(weight);
	  driver.findElement(By.xpath("//input[@id='inputHeight-H-20']")).sendKeys(ht);
	  driver.findElement(By.xpath("//input[@id='inputWeight-W-20']")).sendKeys(wt);
	  driver.findElement(By.xpath("//button[@class='slds-button slds-button_stretch slds-button slds-button_neutral custom-button']")).click();
	  System.out.println("OutPut: "+driver.findElement(By.xpath("/html[1]/body[1]/webruntime-app[1]/lwr-router-container[1]/webruntime-inner-app[1]/dxp_data_provider-user-data-provider[1]/dxp_data_provider-data-proxy[1]/community_byo-scoped-header-and-footer[1]/main[1]/webruntime-router-container[1]/dxp_data_provider-user-data-provider[1]/dxp_data_provider-data-proxy[1]/community_layout-slds-flexible-layout[1]/div[1]/community_layout-section[1]/div[3]/community_layout-column[1]"
		  		+ "/div[1]/c-wellness-calculator-code[1]/div[1]/div[1]/section[1]/h2[1]")).getText()+" "+driver.findElement(By.xpath("/html[1]/body[1]/webruntime-app[1]/lwr-router-container[1]/webruntime-inner-app[1]/dxp_data_provider-user-data-provider[1]/dxp_data_provider-data-proxy[1]/community_byo-scoped-header-and-footer[1]/main[1]/webruntime-router-container[1]/dxp_data_provider-user-data-provider[1]/dxp_data_provider-data-proxy[1]/community_layout-slds-flexible-layout[1]/div[1]/community_layout-section[1]/div[3]/community_layout-column[1]/div[1]/c-wellness-calculator-code[1]"
		  				+ "/div[1]/div[1]/section[1]/h2[2]")).getText());
Thread.sleep(3000);
	  Boolean refresh= driver.findElement(By.xpath("//button[@class='slds-button slds-button_stretch slds-button slds-button_neutral custom-button']")).isDisplayed();
	  if(refresh)
	  {
		  driver.findElement(By.xpath("//button[@class='slds-button slds-button_stretch slds-button slds-button_neutral custom-button']")).click();
	  }
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }


 @DataProvider
  public Object[][] data() {
    return new Object[][] {
      new Object[] { 157,56 },
      new Object[] { 100, 5 },
      new Object[] { 200, 0},
      new Object[] { 100, 300},
      new Object[] { 169, 23 },
    };
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  driver= new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("https://wellnesscalculator-dev-ed.develop.my.site.com/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 Thread.sleep(4000);
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
