package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTest extends TestBase {
  @Test
  public void contactModificationTests(){
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Johny", "Mnemonik", "323123", "johnymnemonik@gmail.com", "Sergii"),true);
    }
    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().chooseEditContactButton(before - 1);
    app.getContactHelper().fillContactForm(new ContactData("Johny",
            "Mnemonik", "323123", "johnymnemomonik@gmail.com","Sergii"),false);
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    app.getNavigationHelper().gotoHomePage();
    Assert.assertEquals(after,before);
  }
}
