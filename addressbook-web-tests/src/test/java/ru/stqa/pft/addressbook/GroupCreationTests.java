package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreationtion() {

    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("Sergii", "ThisHeader", "ThisFooter"));
    submitGroupCreation();

  }

}
