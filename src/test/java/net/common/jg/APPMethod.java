package net.common.jg;

import io.appium.java_client.AppiumDriver;

import net.init.jg.StartApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class APPMethod {
	
	public static WebElement WaitEle(final By by) {

		WebDriverWait wait = new WebDriverWait(StartApp.driver, 10);
		
		
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try {
					StartApp.driver.findElement(by).isDisplayed();
					return true;
				} catch (Exception e) {
//					logger.error("元素不存在" + by);
					return false;
				}
			}
		});
		// 等待元素可见且可被单击   有些下拉框为display:none 为不可见，所以不能执行下面这句方法
		wait.until(ExpectedConditions.elementToBeClickable(StartApp.driver.findElement(by)));
		return StartApp.driver.findElement(by);

	}
	
	
	public static void clickElement(WebElement box){
		box.click();
	}
	public static String AquireTest(WebElement box){
		return box.getText();
	}

	
	public static void SendElement(WebElement box,String input){
		box.clear();
		box.sendKeys(input);
	}
	
	
	 public static void swipeToDown(AppiumDriver driver, int during) {
	        int width = driver.manage().window().getSize().width;
	        int height = driver.manage().window().getSize().height;
	        driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, during);
	        // wait for page loading
	    }
	 public static void swipeToUp(AppiumDriver driver, int during) {
	        int width = driver.manage().window().getSize().width;
	        int height = driver.manage().window().getSize().height;
	        driver.swipe(width / 2, height * 3/ 4, width / 2, height * 1 / 4, during);
	        // wait for page loading
	    }
	 public static void special_swipeToUp(AppiumDriver driver, int during) {
		 int width = driver.manage().window().getSize().width;
		 int height = driver.manage().window().getSize().height;
		 driver.swipe(width / 2, height * 1/ 2, width / 2, height * 1 / 6, during);
		 // wait for page loading
	 }
}
