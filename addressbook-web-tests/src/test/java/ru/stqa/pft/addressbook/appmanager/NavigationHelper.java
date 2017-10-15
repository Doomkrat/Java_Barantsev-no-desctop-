package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(ApplicationManager app) {
    super(app);
    this.app = app;
    this.wd = app.wd;


  }

  public void gotoGroupPage() {
    if (!isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
      return;
    }
      click(By.linkText("groups"));
  }
  public void gotoHomePage() {
    if (isElementPresent(By.id("maintable"))){
      return;
    }

    click(By.linkText("home"));
  }
}
