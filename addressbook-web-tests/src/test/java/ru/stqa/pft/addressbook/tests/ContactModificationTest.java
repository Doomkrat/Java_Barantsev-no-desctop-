package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTest extends TestBase {
  @Test
  public void contactModificationTests(){
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Johny", "Mnemonik", "323123", "johnymnemonik@gmail.com", "Sergii"),true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().chooseEditContactButton(before.size() - 1);
    app.getContactHelper().fillContactForm(new ContactData("Johny", "Mnemonik", "323123", "johnymnemomonik@gmail.com","Sergii"),false);
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoHomePage();
    Assert.assertEquals(after.size(),before.size());
  }
}
