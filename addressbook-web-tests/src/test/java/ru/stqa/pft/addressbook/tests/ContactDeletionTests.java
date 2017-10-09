package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.GroupHelper;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void contactDeletionTests(){

    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Johny", "Mnemonik", "323123", "johnymnemonik@gmail.com", "Sergii"),true);
    }
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContatCheckbox();
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().dismissAlert();

  }

}
