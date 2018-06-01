package APPYYGLTest.APPYYGLTest;

import java.io.File;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class YYGLApp {

	private static AppiumDriver driver;

	
	@BeforeMethod(alwaysRun=true)
	public void Setup() throws Exception {
		 //设置apk的路径
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "营运管理1.0.1.apk");
        
        //设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        
        //设置安卓系统版本
        capabilities.setCapability("platformVersion", "4.4.2");
        //隐藏输入法
//        capabilities.setCapability("unicodeKeyboard", "True");
//        capabilities.setCapability("resetKeyboard", "True");
        //设置apk路径
        capabilities.setCapability("app", app.getAbsolutePath()); 
        
        
        //设置app的主包名和主类名
        capabilities.setCapability("appPackage", "com.hundsun.om");
        capabilities.setCapability("appActivity", "com.hundsun.om.activity.WelcomeActivity");
        
        //初始化
//        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); 
//        
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);  
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
//        if(driver.isAppInstalled(null))
//        	driver.removeApp(null);
//        	else
//        	driver.installApp(app.getAbsolutePath());
//        	driver.launchApp();
        	
	}
	
	 @AfterMethod(alwaysRun=true)
	    public void tearDown() throws Exception {
	        driver.quit();
	    }
	
	 @Test(enabled=true)
	 public void login(){
//		 driver.findElementByName("取消").click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElementById("com.hundsun.om:id/acc_login_form_uid").sendKeys("261102");
//		 driver.hideKeyboard();
//		 driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'com.hundsun.om:id/acc_login_form_pwd')]").sendKeys("112233");
		 driver.findElementById("com.hundsun.om:id/acc_login_form_pwd").sendKeys("112233");
//		 driver.hideKeyboard();
		 driver.findElementById("com.hundsun.om:id/acc_tv_login_btn").click();
//		 driver.findElementByName("登录").click();
//	driver.findElementByXPath("//android.support.v7.widget.LinearLayoutCompat/android.widget.LinearLayout[1]/android.widget.EditText[1]").sendKeys("18758061219");
//	driver.findElementByXPath("//android.support.v7.widget.LinearLayoutCompat/android.widget.LinearLayout[2]/android.widget.EditText[1]").sendKeys("a123456"); 
//	driver.findElementByXPath("//android.widget.RelativeLayout/android.support.v7.widget.LinearLayoutCompat[1]/android.widget.RelativeLayout[1]/android.widget.Button[1]").click();
//	driver.findElementByXPath("//android.widget.RelativeLayout/android.support.v7.widget.LinearLayoutCompat[1]/android.widget.RelativeLayout[1]/android.widget.Button[1]").click();
	
	
	
	 if (driver.findElementByName("营运管理").isDisplayed()){
		 System.out.println("登录成功");
		 
	 }else{
	 System.out.println("登录失败");
	 }
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 }
	 
	 
	 @Test(enabled=true)
	 public static void WriterReporter(){
//		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 driver.findElementById("com.hundsun.om:id/main_greenpass_checkin").click();
		 //填报流程
		 driver.findElementById("com.hundsun.om:id/card_color_select").click();
		 driver.findElementByName("蓝").click();
		 driver.findElementById("com.hundsun.om:id/card_num_tv").sendKeys("123QWEE");
		 driver.findElementById("com.hundsun.om:id/car_channel_select").click();
		 driver.findElementByXPath("//*[contains(@resource-id,'com.hundsun.om:id/dialog_content')]//android.widget.LinearLayout[1]").click();
		 driver.findElementById("com.hundsun.om:id/flow_num_et").sendKeys(""+(int)(Math.random()*100));
		 special_swipeToUp(driver, 1000);
		 driver.findElementById("com.hundsun.om:id/goods_type_select").click();
		 driver.findElementByXPath("//*[contains(@resource-id,'com.hundsun.om:id/dialog_content')]//android.widget.LinearLayout[1]").click();
		 driver.findElementById("com.hundsun.om:id/violate_checkin_next").click();
		 
		 driver.findElementById("com.hundsun.om:id/photo_add_text").click();
		 
		 driver.findElementByXPath("//android.widget.Button[contains(@index,'1')]").click();
		  
		 
		 
	 }
	 
	 @org.testng.annotations.Test(enabled=false)
	 public void shezhi(){
		 driver.findElementByXPath("//android.widget.HorizontalScrollView/android.widget.LinearLayout[1]/*[5]").click();
		 
//		 int width=driver.manage().window().getSize().width;
//	        int height=driver.manage().window().getSize().height;
//	        driver.swipe(width/2,height*3/4, width/2,height/4, 1000);
		 swipeToDown(driver, 1000);
		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		 driver.findElementByName("设置").click();
		 
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
