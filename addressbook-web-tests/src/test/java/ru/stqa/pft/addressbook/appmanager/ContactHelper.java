package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(ApplicationManager app) {
    super(app);
    this.app = app;
    this.wd = app.wd;


  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("mobile"), contactData.getMobilephone());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      if (!(contactData.getGroup() == null)) {
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void modify(ContactData contact) {
    app.goTo().homePage();
    chooseEditContactButtonById(contact.getId());
    fillContactForm(contact, false);
    submitContactUpdate();
    contactCache = null;
    app.goTo().homePage();

  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContatCheckboxById(int id) {
    if (!wd.findElement(By.name("selected[]")).isSelected()) {
      wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void submitContactDeletion() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void dismissAlert() {
    wd.switchTo().alert().accept();
  }

  public void chooseEditContactButtonById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector("input[value='" + id + "']"));
    WebElement contactRow = checkbox.findElement(By.xpath("./../../."));
    contactRow.findElement(By.xpath(".//img[@title='Edit']")).click();
  }

  public void submitContactUpdate() {
    click(By.name("update"));
  }

  public void create(ContactData contact, boolean b) {
    initContactCreation();
    fillContactForm(contact, b);
    submitContactCreation();
    contactCache = null;
  }

  public void delete(ContactData contact) {
    selectContatCheckboxById(contact.getId());
    submitContactDeletion();
    dismissAlert();
    contactCache = null;
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;


  public Contacts all() {
    if (contactCache !=null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath(".//*[@name='entry']"));
    for (WebElement element : elements) {
      List<WebElement> contactEntries = element.findElements(By.cssSelector("td"));
      String firstName = contactEntries.get(2).getText();
      String lastName = contactEntries.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName));
    }
    return new Contacts(contactCache);
  }

}
