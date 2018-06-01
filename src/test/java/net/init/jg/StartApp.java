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
	

	 //����apk��·��
    File classpathRoot = new File(System.getProperty("user.dir"));
    File appDir = new File(classpathRoot, "apps");
    File app = new File(appDir, "Ӫ�˹���1.0.0.apk");
    
    //�����Զ�����ز���
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "Android Emulator");
    //ΪTrue�����Ǹ��ǰ�װ
//    capabilities.setCapability("noReset", "False");
    
//    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
    //appium 1.6���ϰ汾����
//    capabilities.setCapability("automationName","uiautomator2");
    
    //���ð�׿ϵͳ�汾
//    capabilities.setCapability("platformVersion", "4.4.2");
    capabilities.setCapability("platformVersion", "5.0.2");
//    capabilities.setCapability("platformVersion", "5.1.1");
    //�������뷨
    capabilities.setCapability("unicodeKeyboard", "True");
    capabilities.setCapability("resetKeyboard", "True");
    //����apk·��
    capabilities.setCapability("app", app.getAbsolutePath()); 
    
    
    //����app����������������
    capabilities.setCapability("appPackage", "com.hundsun.om");
    capabilities.setCapability("appActivity", "com.hundsun.om.activity.WelcomeActivity");
    
    //��ʼ��
//    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); 
//    
    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); 
	
}
}
