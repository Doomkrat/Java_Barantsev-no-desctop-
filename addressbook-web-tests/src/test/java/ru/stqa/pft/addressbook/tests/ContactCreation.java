package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreation extends TestBase {
  @Test
    public void testContactCreation() {

    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Johny", "Mnemonik", "323123", "johnymnemonik@gmail.com"));
    app.getNavigationHelper().gotoHomePage();
  }

}
