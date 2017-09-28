package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class qwertytest extends TestBase {

  @Test
    public void testqwertytest() {

    app.gotoGroupPage();
    app.wd.findElement(By.name("new")).click();
    app.initGroupCreation();
    app.wd.findElement(By.name("group_name")).clear();
    app.fillGroupForm(new GroupData("zzzz", "aaaa", "b"));
    app.submitGroupCreation();

  }

}
