package APPYYGLTest.APPYYGLTest;

import net.busniess.jg.Check_car;
import net.init.jg.StartApp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;


public class DependTest {
  @Test(dataProvider = "dp",dependsOnGroups = {"net.busniess.jg.IllegalReporter"})
  public void check_car(Integer n, String s) {
	 Check_car.car();
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  try {
		StartApp.Start();
	} catch (Exception e) {
		e.printStackTrace();
	}
  }

  @AfterMethod
  public void afterMethod() {
	  StartApp.driver.quit();
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "≥µ¡æ≤È—Ø" },
    };
  }
}
