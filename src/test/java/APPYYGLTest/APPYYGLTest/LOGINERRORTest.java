package APPYYGLTest.APPYYGLTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import net.busniess.*;
import net.busniess.jg.LoginError;
import net.init.jg.StartApp;
/*
 * 1.6以上版本获取toast，且要设置capabilities.setCapability("automationName","uiautomator2");1.6以上不识别name定位
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
		// Error.User_null("用户名空", "", "112233");
		Error.User_null("用户名空", username, pwd);
	}

/*
 * loginError=用户名错误、密码错误、用户名密码错误
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
