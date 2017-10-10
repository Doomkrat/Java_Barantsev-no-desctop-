package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.GroupHelper;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test
  public void contactDeletionTests(){

    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Johny", "Mnemonik", "323123", "johnymnemonik@gmail.com", "Sergii"),true);
    }
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContatCheckbox(before.size()-1);
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().dismissAlert();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size() - 1);

    before.remove(before.size()-1);
    Assert.assertEquals(before, after);
  }

}
