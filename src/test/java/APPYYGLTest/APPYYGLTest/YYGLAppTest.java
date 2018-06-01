package APPYYGLTest.APPYYGLTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import net.busniess.jg.*;
import net.busniess.jg.Login;
import net.init.jg.StartApp;
/*
 * 1.6���ϰ汾��ȡtoast����Ҫ����capabilities.setCapability("automationName","uiautomator2");1.6���ϲ�ʶ��name��λ
 */
public class YYGLAppTest {
	// private static AppiumDriver driver;
	// private YamlUtil myYaml;

	@BeforeClass(alwaysRun = true)
	public void Setup() throws Exception {
		StartApp.Start();

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		StartApp.driver.quit();
	}

	@Test(enabled = true, priority = 1, dataProvider = "loginObjects")
	public void login(String username, String pwd) {

		Login login = new Login();
		login.Login("��¼����", username, pwd);
		if (StartApp.driver.findElementByName("Ӫ�˹���").isDisplayed()) {
			System.out.println("��¼�ɹ�");

		} else {
			System.out.println("��¼ʧ��");
		}
	}


	@Test(enabled = true, priority = 2)
	public static void GreenReporter() {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
for (int i = 0; i < 10; i++) {
	
	GreenReporter.GReproter();
	i++;
}

	}
	@Test(enabled = true, priority = 3)
	public static void IllegalReporter() {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
for (int i = 0; i < 1; i++) {
	
	IllegalReporter.IllReporter();
	i++;
}

	}

	@DataProvider
	public Object[][] loginObjects() {
		return new Object[][] { new Object[] { "xxx", "xxxx" }, };
	}
	
}
