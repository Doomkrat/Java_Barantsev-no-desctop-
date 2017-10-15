package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Johny", "Mnemonik", null, null, null), true);
    }
  }
  @Test
  public void contactModificationTests(){

    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size()-1;
    ContactData contact = new ContactData(before.get(index).getId(),"Johny", "Mnemonik", "323123", "johnymnemomonik@gmail.com","Sergii");
    app.getContactHelper().modifyContact(contact,index);
    List<ContactData> after = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoHomePage();

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1,g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }


}
