package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GfroupHelper {
  public FirefoxDriver wd;

  public GfroupHelper(FirefoxDriver wd) {
  this.wd = wd;
  }

  public void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  public void initGroupCreation() {
    wd.findElement(By.name("group_name")).click();
  }

  public void returnToGroupPage() {
      wd.findElement(By.linkText("group page")).click();
  }

  public void deleteGroup() {
      wd.findElement(By.name("delete")).click();
  }

  public void groupSelection() {
      if (!wd.findElement(By.xpath("//div[@id='content']/form/span[4]/input")).isSelected()) {
          wd.findElement(By.xpath("//div[@id='content']/form/span[4]/input")).click();
      }
  }
}
