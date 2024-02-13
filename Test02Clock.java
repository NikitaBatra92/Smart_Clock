package projectPremiumLearnings;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Test02Clock {
	WebDriver driver;
  @Test(priority= 1)
  public void setAlarm() throws InterruptedException 
  {
	  DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
      LocalTime currentTime = LocalTime.now().plusSeconds(20);
     
      String hourValue = String.format("%02d", currentTime.getHour()); // Ensure two-digit format
     
      Select hourSelect = new Select(driver.findElement(By.id("select-hours-21")));
      
      hourSelect.selectByVisibleText(hourValue);
      String minuteValue = String.format("%02d", currentTime.getMinute()); // Ensure two-digit format
      
      Select minuteSelect = new Select(driver.findElement(By.id("select-minutes-22")));
      minuteSelect.selectByVisibleText(minuteValue);
      
      String amOrPm = (currentTime.getHour() < 12) ? "AM" : "PM";
      
      new Select(driver.findElement(By.id("select-meridiems-23"))).selectByVisibleText(amOrPm);
      driver.findElement(By.xpath("/html[1]/body[1]/webruntime-app[1]/lwr-router-container[1]/webruntime-inner-app[1]/dxp_data_provider-user-data-provider[1]/dxp_data_provider-data-proxy[1]/community_byo-scoped-header-and-footer[1]/main[1]/webruntime-router-container[1]/dxp_data_provider-user-data-provider[1]/dxp_data_provider-data-proxy[1]/community_layout-slds-flexible-layout[1]/div[1]/community_layout-section[1]/div[3]"
  	  		+ "/community_layout-column[1]/div[1]/c-code-for-clock[1]/div[1]/button[1]")).click();
     Thread.sleep(10000);
      
  }
  @Test(priority= 2)
  public void stopAlarm()
  {
	  Boolean stop= driver.findElement(By.xpath("/html[1]/body[1]/webruntime-app[1]/lwr-router-container[1]/webruntime-inner-app[1]/dxp_data_provider-user-data-provider[1]/dxp_data_provider-data-proxy[1]/community_byo-scoped-header-and-footer[1]/main[1]/webruntime-router-container[1]/dxp_data_provider-user-data-provider[1]/dxp_data_provider-data-proxy[1]/community_layout-slds-flexible-layout[1]/div[1]/community_layout-section[1]/div[3]/community_layout-column[1]"
	  		+ "/div[1]/c-code-for-clock[1]/div[1]/button[1]")).isDisplayed();
	  if(stop)
	  {
		  driver.findElement(By.xpath("/html[1]/body[1]/webruntime-app[1]/lwr-router-container[1]/webruntime-inner-app[1]/dxp_data_provider-user-data-provider[1]/dxp_data_provider-data-proxy[1]/community_byo-scoped-header-and-footer[1]/main[1]/webruntime-router-container[1]/dxp_data_provider-user-data-provider[1]/dxp_data_provider-data-proxy[1]/community_layout-slds-flexible-layout[1]/div[1]/community_layout-section[1]/div[3]/community_layout-column[1]/div[1]/c-code-for-clock[1]/div[1]/button[1]")).click();
	  } 
  }


  @BeforeTest
  public void beforeTest() {
	  driver= new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("https://cloudappoint3-dev-ed.develop.my.site.com/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
