package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {
  @Test
  public void contactModificationTests(){
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().chooseEditContactButton();
    app.getContactHelper().fillContactForm(new ContactData("Johny",
            "Mnemonik", "323123", "johnymnemomonik@gmail.com",null),false);
    app.getContactHelper().submitContactUpdate();
  }
}
