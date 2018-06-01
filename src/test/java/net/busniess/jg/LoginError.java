package net.busniess.jg;

import net.common.jg.APPMethod;
import net.entity.jg.YamlUtil;
import net.init.jg.StartApp;

import org.eclipse.jetty.io.ArrayByteBufferPool.Bucket;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class LoginError {

	// 账户为空

	public void User_null(String test, String username, String password) {
		YamlUtil myYaml = new YamlUtil(StartApp.driver, "./src/test.yaml");
		if (username == "") {
			APPMethod.SendElement(myYaml.getElement("login_input"), username);
			
//			StartApp.driver.findElement(By.id("com.hundsun.om:id/acc_login_form_uid")).sendKeys("1");
//			StartApp.driver.findElement(By.id("com.hundsun.om:id/acc_login_form_pwd")).sendKeys("2");
//			StartApp.driver.findElementById("com.hundsun.om:id/acc_login_form_pwd").sendKeys("22");
			APPMethod.SendElement(myYaml.getElement("password_input"), password);

			try {
				final WebDriverWait wait = new WebDriverWait(StartApp.driver, 2);
				APPMethod.clickElement(myYaml.getElement("login_button"));
				Assert.assertNotNull(wait.until(ExpectedConditions
						.presenceOfElementLocated(By
								.xpath(".//*[contains(@text,'请输入用户名')]"))));
				System.out.println("Toast信息为："
						+ StartApp.driver.findElementByXPath(
								".//*[contains(@text,'请输入用户名')]").getText());
			} catch (Exception e) {
				throw new AssertionError("找不到Toast");
			}
		}else if (username!="" && password=="") {
			APPMethod.SendElement(myYaml.getElement("login_input"), username);
			APPMethod.SendElement(myYaml.getElement("password_input"), password);

			try {
				final WebDriverWait wait = new WebDriverWait(StartApp.driver, 2);
				APPMethod.clickElement(myYaml.getElement("login_button"));
				Assert.assertNotNull(wait.until(ExpectedConditions
						.presenceOfElementLocated(By
								.xpath(".//*[contains(@text,'请输入密码')]"))));
				System.out.println("Toast信息为："
						+ StartApp.driver.findElementByXPath(
								".//*[contains(@text,'请输入密码')]").getText());
			} catch (Exception e) {
				throw new AssertionError("找不到Toast");
			}
			
		}else {
			APPMethod.SendElement(myYaml.getElement("login_input"), username);
			APPMethod.SendElement(myYaml.getElement("password_input"), password);

			try {
				final WebDriverWait wait = new WebDriverWait(StartApp.driver, 2);
				APPMethod.clickElement(myYaml.getElement("login_button"));
				Assert.assertNotNull(wait.until(ExpectedConditions
						.presenceOfElementLocated(By
								.xpath(".//*[contains(@text,'用户名或密码错误')]"))));
				System.out.println("Toast信息为："
						+ StartApp.driver.findElementByXPath(
								".//*[contains(@text,'用户名或密码错误')]").getText());
			} catch (Exception e) {
				throw new AssertionError("找不到Toast");
			}
			
		}
		/*
		 * 
		
		// StartApp.driver.findElementById("com.hundsun.om:id/acc_login_form_uid").click();
		// StartApp.driver.findElementById("com.hundsun.om:id/acc_login_form_uid").sendKeys("");

		// APPMethod.SendElement(myYaml.getElement("login_input"), username);
		// APPMethod.SendElement(myYaml.getElement("password_input"), password);

		// APPMethod.clickElement(myYaml.getElement("login_button"));
		// StartApp.driver.
		// String toast="用户名或密码错误";

		String toast = "请输入用户名";
		try {
			final WebDriverWait wait = new WebDriverWait(StartApp.driver, 2);
			APPMethod.clickElement(myYaml.getElement("login_button"));
			Assert.assertNotNull(wait.until(ExpectedConditions
					.presenceOfElementLocated(By
							.xpath(".//*[contains(@text,'用户名或密码错误')]"))));
			// System.out.println("找到了toast");
			System.out.println("Toast信息为："
					+ StartApp.driver.findElementByXPath(
							".//*[contains(@text,'用户名或密码错误')]").getText());
		} catch (Exception e) {
			throw new AssertionError("找不到" + toast);
		}
		// try {
		//
		// final WebDriverWait wait = new WebDriverWait(StartApp.driver,2);
		// if(null != wait.until(
		// ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'用户名或密码错误')]")))){
		// System.out.println(StartApp.driver.findElementByXPath(".//*[contains(@text,'用户名或密码错误')]").getText());
		// }
		// System.out.println("****************7");
		// Assert.assertNotNull(wait.until(
		// ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'用户名或密码错误')]"))));
		//
		// } catch (Exception e) {
		// // TODO: handle exception
		// System.out.println("****************8");
		// } */

	}
}
