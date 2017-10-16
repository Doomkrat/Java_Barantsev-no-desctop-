package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size()==0) {
      app.contact().create(new ContactData().withFirstname("Aram").withLastname("Zamzam"), true);
    }
  }
  @Test
  public void contactModificationTests(){

    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("Aram").withLastname("Zamzam")
            .withMobilephone("323123").withEmail("johnymnemomonik@gmail.com");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    app.goTo().homePage();

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before,after);
  }


}
