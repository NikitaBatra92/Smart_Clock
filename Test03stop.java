package projectPremiumLearnings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Test03stop {

	WebDriver driver;

	public Test03stop(WebDriver driver) {
		this.driver = driver;
	}
	public boolean stopAlarm()
	  {
		  Boolean stop= driver.findElement(By.xpath("/html/body/webruntime-app/lwr-router-container/webruntime-inner-app/dxp_data_provider-user-data-provider/dxp_data_provider-data-proxy/community_byo-scoped-header-and-footer/main/webruntime-router-container/dxp_data_provider-user-data-provider/dxp_data_provider-data-proxy/community_layout-slds-flexible-layout/div/community_layout-section/div[3]"
		  		+ "/community_layout-column/div/c-smart-alarm-app/div/button[1]")).isDisplayed();
		  if(stop)
		  {
			  driver.findElement(By.xpath("/html/body/webruntime-app/lwr-router-container/webruntime-inner-app/dxp_data_provider-user-data-provider/dxp_data_provider-data-proxy/community_byo-scoped-header-and-footer/main/webruntime-router-container/dxp_data_provider-user-data-provider/dxp_data_provider-data-proxy/community_layout-slds-flexible-layout/div/community_layout-section/div[3]"
			  		+ "/community_layout-column/div/c-smart-alarm-app/div/button[1]")).click();
		  }
		return stop; 
	  }
}
