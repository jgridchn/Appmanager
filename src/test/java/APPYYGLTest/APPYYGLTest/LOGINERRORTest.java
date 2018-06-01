package APPYYGLTest.APPYYGLTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import net.busniess.*;
import net.busniess.jg.LoginError;
import net.init.jg.StartApp;
/*
 * 1.6���ϰ汾��ȡtoast����Ҫ����capabilities.setCapability("automationName","uiautomator2");1.6���ϲ�ʶ��name��λ
 */
public class LOGINERRORTest {
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

	@Test(enabled = true, priority = 1, dataProvider = "loginError")
	public void loginErr(String username, String pwd) {
		LoginError Error = new LoginError();
		// Error.User_null("�û�����", "", "112233");
		Error.User_null("�û�����", username, pwd);
	}

/*
 * loginError=�û���������������û����������
 * 
 */
	@DataProvider
	public Object[][] loginError() {
		return new Object[][] { 
				new Object[] { "1", "112xxx3" },
				new Object[] { "xxxx", "123" },
				new Object[] { "1", "123" },
				new Object[] { "", "" },
				new Object[] { "", "112233" },
				new Object[]	{"",""},
				};
	}
	
}
