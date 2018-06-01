package net.busniess.jg;

import net.common.jg.APPMethod;
import net.entity.jg.YamlUtil;
import net.init.jg.StartApp;



public class IllegalReporter {
	
	public static void IllReporter(){
		
	
	YamlUtil myYaml = new YamlUtil(StartApp.driver, "./src/IllegalReporter.yaml");
	
	APPMethod.clickElement(myYaml.getElement("Illeagl_check"));
	APPMethod.clickElement(myYaml.getElement("Licence_color"));
	APPMethod.clickElement(myYaml.getElement("Licence_color_sl"));
	APPMethod.SendElement(myYaml.getElement("Licence_number"), "qweasd");
	APPMethod.clickElement(myYaml.getElement("lane"));
	APPMethod.clickElement(myYaml.getElement("lane_sl"));
	APPMethod.SendElement(myYaml.getElement("serinal"), ""+(int)(Math.random()*100));
	APPMethod.clickElement(myYaml.getElement("category"));
	APPMethod.clickElement(myYaml.getElement("category_sl"));
	APPMethod.clickElement(myYaml.getElement("category_small"));
	APPMethod.clickElement(myYaml.getElement("category_small_sl"));
	APPMethod.SendElement((myYaml.getElement("remark")),"test"+(int)(Math.random()*1000));
	APPMethod.clickElement(myYaml.getElement("save"));
	APPMethod.clickElement(myYaml.getElement("add"));
	APPMethod.clickElement(myYaml.getElement("photo"));
	APPMethod.clickElement(myYaml.getElement("photo_sl"));
	APPMethod.clickElement(myYaml.getElement("photo_save"));
	
	APPMethod.clickElement(myYaml.getElement("left_back"));
	APPMethod.clickElement(myYaml.getElement("left_back"));
	//系统 返回键值 java-1.2.1 可以用 且不存在 5.0-SNAPSHOT
//	StartApp.driver.sendKeyEvent(AndroidKeyCode.BACK);
//	StartApp.driver.sendKeyEvent(AndroidKeyCode.BACK);
//	StartApp.driver
	}
}
