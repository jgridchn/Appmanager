package net.entity.jg;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import net.common.jg.APPMethod;

import org.ho.yaml.Yaml;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;





public class YamlUtil {
	private String yamlfile;
	public AppiumDriver driver;
	private Map<String, Map<String, String>> locators;

	/**
	 * 加载yaml文件 
	 * 
	 */

	public YamlUtil(AppiumDriver driver, String YamlFilePath) {
		this.driver = driver;
		this.yamlfile = YamlFilePath;
		getYamlFile();
	}

	private void getYamlFile() {
		// TODO Auto-generated method stub
		
		File f = new File(this.yamlfile);
		try {
			locators = Yaml.loadType(new FileInputStream(f.getAbsolutePath()),
					HashMap.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public  By getBy(String key) {
		By by = null;
		// System.out.println(key);
		if (locators.containsKey(key)) {
			Map<String, String> m = locators.get(key);
			String type = m.get("type");
			String value = m.get("value");
			// System.out.println(value);

			switch (type) {
			case "id":
				by = By.id(value);
				break;
			case "name":
				by = By.name(value);
				break;
			case "xpath":
				by = By.xpath(value);
				break;
			case "class":
				by = By.className(value);
				break;

			case "linkText":
				by = By.linkText(value);
				break;
			}
		} else {
			System.out.println("Locator" + key + " is not exist in" + yamlfile);
		}
		return by;

	}
	

	// 根据名称，返回webElement对象
	public WebElement getElement(String key) {
		By by = this.getBy(key);
		System.out.println(by);
//		WebElement element =driver.findElement(by);
		WebElement element =APPMethod.WaitEle(by);
		return element;
	}
	// 根据名称，返回被隐藏的webElement对象
		public WebElement get_specialElement(String key) {
			By by = this.getBy(key);
			System.out.println(by);
			WebElement element =driver.findElement(by);
//			WebElement element =Mthead.Wait_special_ele( by);
			return element;
		}
	
	
	
	
	
	
	
}
