package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.GroupHelper;

public class ContactDeletionTests extends TestBase {

  @Test
  public void contactDeletionTests(){

    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContatCheckbox();
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().dismissAlert();

  }

}
