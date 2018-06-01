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

	// �˻�Ϊ��

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
								.xpath(".//*[contains(@text,'�������û���')]"))));
				System.out.println("Toast��ϢΪ��"
						+ StartApp.driver.findElementByXPath(
								".//*[contains(@text,'�������û���')]").getText());
			} catch (Exception e) {
				throw new AssertionError("�Ҳ���Toast");
			}
		}else if (username!="" && password=="") {
			APPMethod.SendElement(myYaml.getElement("login_input"), username);
			APPMethod.SendElement(myYaml.getElement("password_input"), password);

			try {
				final WebDriverWait wait = new WebDriverWait(StartApp.driver, 2);
				APPMethod.clickElement(myYaml.getElement("login_button"));
				Assert.assertNotNull(wait.until(ExpectedConditions
						.presenceOfElementLocated(By
								.xpath(".//*[contains(@text,'����������')]"))));
				System.out.println("Toast��ϢΪ��"
						+ StartApp.driver.findElementByXPath(
								".//*[contains(@text,'����������')]").getText());
			} catch (Exception e) {
				throw new AssertionError("�Ҳ���Toast");
			}
			
		}else {
			APPMethod.SendElement(myYaml.getElement("login_input"), username);
			APPMethod.SendElement(myYaml.getElement("password_input"), password);

			try {
				final WebDriverWait wait = new WebDriverWait(StartApp.driver, 2);
				APPMethod.clickElement(myYaml.getElement("login_button"));
				Assert.assertNotNull(wait.until(ExpectedConditions
						.presenceOfElementLocated(By
								.xpath(".//*[contains(@text,'�û������������')]"))));
				System.out.println("Toast��ϢΪ��"
						+ StartApp.driver.findElementByXPath(
								".//*[contains(@text,'�û������������')]").getText());
			} catch (Exception e) {
				throw new AssertionError("�Ҳ���Toast");
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
		// String toast="�û������������";

		String toast = "�������û���";
		try {
			final WebDriverWait wait = new WebDriverWait(StartApp.driver, 2);
			APPMethod.clickElement(myYaml.getElement("login_button"));
			Assert.assertNotNull(wait.until(ExpectedConditions
					.presenceOfElementLocated(By
							.xpath(".//*[contains(@text,'�û������������')]"))));
			// System.out.println("�ҵ���toast");
			System.out.println("Toast��ϢΪ��"
					+ StartApp.driver.findElementByXPath(
							".//*[contains(@text,'�û������������')]").getText());
		} catch (Exception e) {
			throw new AssertionError("�Ҳ���" + toast);
		}
		// try {
		//
		// final WebDriverWait wait = new WebDriverWait(StartApp.driver,2);
		// if(null != wait.until(
		// ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'�û������������')]")))){
		// System.out.println(StartApp.driver.findElementByXPath(".//*[contains(@text,'�û������������')]").getText());
		// }
		// System.out.println("****************7");
		// Assert.assertNotNull(wait.until(
		// ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'�û������������')]"))));
		//
		// } catch (Exception e) {
		// // TODO: handle exception
		// System.out.println("****************8");
		// } */

	}
}
