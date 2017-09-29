package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class qwertytest extends TestBase {

  @Test
    public void testqwertytest() {

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("zzzz", "aaaa", "b"));
    app.getGroupHelper().submitGroupCreation(app.getGroupHelper().wd.findElement(By.name("submit")));

  }

}
