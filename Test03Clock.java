package projectPremiumLearnings;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Test03Clock {
 
  WebDriver driver;
  Test03stop t1;
  DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss a");
  LocalTime currentTime = LocalTime.now().plusSeconds(30);

  String hourValue = String.format("%02d", currentTime.getHour() > 12 ? currentTime.getHour() - 12 : currentTime.getHour());
  String minuteValue = String.format("%02d", currentTime.getMinute()); // Ensure two-digit format
  String amOrPm = (currentTime.getHour() < 12) ? "AM" : "PM";  
  @Test(priority= 1)
  public void setAlarm() throws InterruptedException 
  { 
	  //Happy Path
      if (hourValue.equals("00")) 
      {
          hourValue = "12"; // Adjust for 12 AM
      } 
      //hour field
      Select hourSelect = new Select(driver.findElement(By.id("hourOptions-21")));     
      hourSelect.selectByVisibleText(hourValue);
      
      //minute field    
      Select minuteSelect = new Select(driver.findElement(By.id("minutesOptions-22")));
      minuteSelect.selectByVisibleText(minuteValue);
      
      //AM/PM select    
      new Select(driver.findElement(By.id("meridiemsOptions-23"))).selectByVisibleText(amOrPm);
      
      driver.findElement(By.xpath("/html/body/webruntime-app/lwr-router-container/webruntime-inner-app/dxp_data_provider-user-data-provider/dxp_data_provider-data-proxy/community_byo-scoped-header-and-footer/main/webruntime-router-container/dxp_data_provider-user-data-provider/dxp_data_provider-data-proxy/community_layout-slds-flexible-layout/div/community_layout-section/div[3]"
      		+ "/community_layout-column/div/c-smart-alarm-app/div/button")).click();
     Thread.sleep(10000);
       
  }
  @Test(priority= 3)
  public void stopAlarmt1() throws InterruptedException
  {
	  Thread.sleep(10000);
	  t1.stopAlarm();
  }
 @Test(priority= 2)
  public void snooseAlarm()
  { 
	 // Assert.assertTrue(stopValue, "Stop button not displayed, cannot snooze alarm");
      Boolean snooze= driver.findElement(By.xpath("/html/body/webruntime-app/lwr-router-container/webruntime-inner-app/dxp_data_provider-user-data-provider/dxp_data_provider-data-proxy/community_byo-scoped-header-and-footer/main/webruntime-router-container/dxp_data_provider-user-data-provider/dxp_data_provider-data-proxy/community_layout-slds-flexible-layout/div/community_layout-section/div[3]"
		  		+ "/community_layout-column/div/c-smart-alarm-app/div/button[2]")).isDisplayed();
		  if(snooze)
			  driver.findElement(By.xpath("/html/body/webruntime-app/lwr-router-container/webruntime-inner-app/dxp_data_provider-user-data-provider/dxp_data_provider-data-proxy/community_byo-scoped-header-and-footer/main/webruntime-router-container/dxp_data_provider-user-data-provider/dxp_data_provider-data-proxy/community_layout-slds-flexible-layout/div/community_layout-section/div[3]"
		  		+ "/community_layout-column/div/c-smart-alarm-app/div/button[2]")).click();
  }
  @BeforeTest
  public void beforeTest() {
	  driver= new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("https://premiumlearnings-bf-dev-ed.develop.my.site.com/smart-alarm-clock");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 t1=new Test03stop(driver);
  }

  @AfterTest
  public void afterTest() {
	 driver.close();
  }

}
