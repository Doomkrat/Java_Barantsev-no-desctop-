package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
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
    }else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }
  public void modifyC(ContactData contactData, int index) {
    app.goTo().homePage();
    chooseEditContactButton(index);
    fillContactForm(contactData,false);
    submitContactUpdate();
    app.goTo().homePage();

  }

  public void initContactCreation() { click(By.linkText("add new")); }

  public void selectContatCheckbox(int index) {
    if (!wd.findElement(By.name("selected[]")).isSelected()) {
      wd.findElements(By.name("selected[]")).get(index).click();
    }
  }
  public void submitContactCreation(){click(By.name("submit"));}

  public void submitContactDeletion() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void dismissAlert() {
    wd.switchTo().alert().accept();
  }

  public void chooseEditContactButton(int index) {
    wd.findElements(By.cssSelector("[name='entry'] td:nth-of-type(8) a")).get(index).click();
  }

  public void submitContactUpdate() {
    click(By.name("update"));
  }

  public void create(ContactData contact, boolean b) {
    initContactCreation();
    fillContactForm(contact,b);
    submitContactCreation();
  }
  public void deleteContact(int index) {
    selectContatCheckbox(index);
    submitContactDeletion();
    dismissAlert();
  }
  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement>elements=wd.findElements(By.xpath(".//*[@name='entry']"));
    for (WebElement element : elements){
      List <WebElement> contactEntries = element.findElements(By.cssSelector("td"));
      String firstName = contactEntries.get(2).getText();
      String lastName = contactEntries.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName));
    }
    return contacts;
  }
  public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement>elements=wd.findElements(By.xpath(".//*[@name='entry']"));
    for (WebElement element : elements){
      List <WebElement> contactEntries = element.findElements(By.cssSelector("td"));
      String firstName = contactEntries.get(2).getText();
      String lastName = contactEntries.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName));
    }
    return contacts;
  }
}
