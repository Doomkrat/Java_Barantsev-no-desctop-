package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {


  public SessionHelper(ApplicationManager app) {
    super(app);
    this.app = app;
    this.wd = app.wd;


  }
  public void login(String username, String password) {
    type(By.name("pass"),password);
    type(By.name("user"),username);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }
}
