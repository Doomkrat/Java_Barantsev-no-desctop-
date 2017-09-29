package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelperBase {
  public FirefoxDriver wd;

  public HelperBase(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void submitGroupCreation(WebElement locator) {
    locator.click();
  }

  protected void type(String locator, String text) {
    submitGroupCreation(wd.findElement(By.name(locator)));
    wd.findElement(By.name(locator)).clear();
    wd.findElement(By.name(locator)).sendKeys(text);
  }
  public  boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
