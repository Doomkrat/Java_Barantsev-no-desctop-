package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

  public GroupHelper(FirefoxDriver wd) {

    super(wd);
  }

  public void fillGroupForm(GroupData groupData) {
    type("group_name", groupData.getName());
    type("group_header", groupData.getHeader());
    type("group_footer", groupData.getFooter());
  }

  public void initGroupCreation() {
    submitGroupCreation(wd.findElement(By.name("group_name")));
  }

  public void returnToGroupPage() {
    submitGroupCreation(wd.findElement(By.linkText("group page")));
  }

  public void deleteGroup() {
    submitGroupCreation(wd.findElement(By.name("delete")));
  }

  public void groupSelection() {
      if (!wd.findElement(By.xpath("//div[@id='content']/form/span[4]/input")).isSelected()) {
        submitGroupCreation(wd.findElement(By.xpath("//div[@id='content']/form/span[4]/input")));
      }
  }
}
