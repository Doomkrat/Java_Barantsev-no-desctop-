package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;

  private ContactHelper contactHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private SessionHelper sessionHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }


  public void init() {
    if (Objects.equals(browser, BrowserType.FIREFOX)) {
      wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    } else if (Objects.equals(browser, BrowserType.CHROME)){
      wd = new ChromeDriver();
    } else if (Objects.equals(browser, BrowserType.SAFARI)){
      wd = new SafariDriver(new SafariOptions().setUseTechnologyPreview(true));
    }
    wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    wd.get("http://localhost:8080/addressbook");
    groupHelper = new GroupHelper(this);
    navigationHelper = new NavigationHelper(this);
    sessionHelper = new SessionHelper(this);
    contactHelper = new ContactHelper(this);
    sessionHelper.login("admin", "secret");
  }



  public void stop() {
    wd.quit();
  }

  public GroupHelper group() {
    return groupHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public ContactHelper contact() {
    return contactHelper;
  }
}
