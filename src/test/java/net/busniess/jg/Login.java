package net.busniess.jg;

import net.common.jg.APPMethod;
import net.entity.jg.YamlUtil;
import net.init.jg.StartApp;

import org.openqa.selenium.By;


public class Login {

	
	
	public  void Login(String test,String username,String password){
		 YamlUtil myYaml = new YamlUtil(StartApp.driver, "./src/test.yaml");
//		 StartApp.driver.findElementById("com.hundsun.om:id/acc_login_form_uid").sendKeys("11");
//		 StartApp.driver.findElementById("com.hundsun.om:id/acc_login_form_uid").sendKeys("11");
		
		APPMethod.SendElement(myYaml.getElement("login_input"), username);
//		StartApp.driver.findElement(By.id("com.hundsun.om:id/acc_login_form_pwd")).sendKeys("xxx");
		APPMethod.SendElement(myYaml.getElement("password_input"), password);
//		StartApp.driver.findElement(By.name("µÇ Â¼")).click();
		APPMethod.clickElement(myYaml.getElement("login_button"));
		
		
		
	}
}
