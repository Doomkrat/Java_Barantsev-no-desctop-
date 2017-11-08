package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size()==0) {
      app.contact().create(new ContactData().withFirstname("Aram").withLastname("Zamzam")
              .withHomePhone("323123").witheMail("johnymnemomonik@gmail.com").withMobilephone("")
              .withWorkPhone("").witheMail2("").witheMail3("").withAddress(""), true);
      app.goTo().homePage();
    }
  }
  @Test
  public void contactModificationTests(){

    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("Aram").withLastname("Zamzam")
            .withHomePhone("323123").witheMail("johnymnemomonik@gmail.com").withMobilephone("")
            .withWorkPhone("").witheMail2("").witheMail3("").withAddress("");
    app.contact().modify(contact);
    assertThat(app.contact().count(),equalTo(before.size()));
    Contacts after = app.db().contacts();
    app.goTo().homePage();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListUI();
  }


}
