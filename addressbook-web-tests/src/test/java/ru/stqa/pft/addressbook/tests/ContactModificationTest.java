package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size()==0) {
      app.contact().create(new ContactData().withFirstname("Aram").withLastname("Zamzam"), true);
    }
  }
  @Test
  public void contactModificationTests(){

    List<ContactData> before = app.contact().list();
    int index = before.size()-1;
    ContactData contact = new ContactData()
            .withId(before.get(index).getId()).withFirstname("Aram").withLastname("Zamzam")
            .withMobilephone("323123").withEmail("johnymnemomonik@gmail.com");
    app.contact().modifyC(contact,index);
    List<ContactData> after = app.contact().list();
    app.goTo().homePage();

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1,g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }


}
