package net.init.jg;


import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class StartApp {
	
public static  AppiumDriver driver;

public static void Start() throws Exception{
	

	 //设置apk的路径
    File classpathRoot = new File(System.getProperty("user.dir"));
    File appDir = new File(classpathRoot, "apps");
    File app = new File(appDir, "营运管理1.0.0.apk");
    
    //设置自动化相关参数
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "Android Emulator");
    //为True好像是覆盖安装
//    capabilities.setCapability("noReset", "False");
    
//    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
    //appium 1.6以上版本试用
//    capabilities.setCapability("automationName","uiautomator2");
    
    //设置安卓系统版本
//    capabilities.setCapability("platformVersion", "4.4.2");
    capabilities.setCapability("platformVersion", "5.0.2");
//    capabilities.setCapability("platformVersion", "5.1.1");
    //隐藏输入法
    capabilities.setCapability("unicodeKeyboard", "True");
    capabilities.setCapability("resetKeyboard", "True");
    //设置apk路径
    capabilities.setCapability("app", app.getAbsolutePath()); 
    
    
    //设置app的主包名和主类名
    capabilities.setCapability("appPackage", "com.hundsun.om");
    capabilities.setCapability("appActivity", "com.hundsun.om.activity.WelcomeActivity");
    
    //初始化
//    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); 
//    
    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); 
	
}
}
