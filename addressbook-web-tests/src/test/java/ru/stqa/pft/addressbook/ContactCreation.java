package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

import org.openqa.selenium.*;

public class ContactCreation extends TestBase {
  @Test
    public void testContactCreation() {

    initContactCreation();
    fillContactForm(new ContactData("Johny", "Mnemonik", "323123", "johnymnemonik@gmail.com"));
    gotoHomePage();
  }

}
