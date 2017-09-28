package ru.stqa.pft.addressbook;
import org.testng.annotations.Test;
import org.openqa.selenium.*;

public class qwertytest extends TestBase {

  @Test
    public void testqwertytest() {

    gotoGroupPage();
    wd.findElement(By.name("new")).click();
    initGroupCreation();
    wd.findElement(By.name("group_name")).clear();
    fillGroupForm(new GroupData("zzzz", "aaaa", "b"));
    submitGroupCreation();

  }

}
