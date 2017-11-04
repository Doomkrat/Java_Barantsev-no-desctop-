package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

  protected static  ApplicationManager app;
  org.slf4j.Logger logger = LoggerFactory.getLogger(TestBase.class);

  @BeforeSuite
  public void setUp() throws Exception {
    app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

  @BeforeMethod
  public void logTestStart(Method m, Object[] p){
    logger.info("Start test"+m.getName()+ "with parameters"+ Arrays.asList(p));

  }
  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m){
    logger.info("Stop test "+m.getName());

  }


}
