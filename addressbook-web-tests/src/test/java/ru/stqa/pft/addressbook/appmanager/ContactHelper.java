package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.tests.ContactPhoneTests;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContactHelper extends HelperBase {

  public ContactHelper(ApplicationManager app) {
    super(app);
    this.app = app;
    this.wd = app.wd;


  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("email"), contactData.geteMail());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("email2"), contactData.geteMail2());
    type(By.name("email3"), contactData.geteMail3());
    type(By.name("address"), contactData.getAddress());


    if (creation) {
      if ((contactData.getGroups().size() >0 )) {
        Assert.assertTrue(contactData.getGroups().size()==1);
        String groupName= contactData.getGroups().iterator().next().getName();
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(groupName);
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void modify(ContactData contact) {
    app.goTo().homePage();
    initContactModificationById(contact.getId());
    fillContactForm(contact, false);
    submitContactUpdate();
    contactCache = null;
    app.goTo().homePage();

  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContatCheckboxById(int id) {
    /*WebElement checkbox = wd.findElement(By.cssSelector("input[value='" + id + "']"));
    WebElement contactRow = checkbox.findElement(By.xpath("./../../."));
    contactRow.findElement(By.xpath(".//img[@title='Edit']")).click();*/
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

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");

    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).
            withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withAddress(address).
            witheMail(email).witheMail2(email2).witheMail3(email3);

  }


  public void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
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

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;


  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath(".//*[@name='entry']"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.cssSelector("td"));
      String firstName = cells.get(2).getText();
      String lastName = cells.get(1).getText();
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      String address = cells.get(3).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName).
              withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address));
    }
    return new Contacts(contactCache);
  }

 /* public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }*/

  public String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getWorkPhone(), contact.getMobilePhone()).
            stream().filter((s) -> !s.equals("")).map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));

  }
  public String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.geteMail(),contact.geteMail2(), contact.geteMail3())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));

  }
  public boolean isContactInGroup(ContactData contact, GroupData group){
    if(contact.getGroups().size() == 0){
      return false;
    }
    Groups contactGroups = contact.getGroups();
    for (GroupData contactGroup:contactGroups){
      if (contactGroup.equals(group)){
        return true;
      }
    }
    return false;
  }

public void addContactToGroup(ContactData contact, GroupData groupAssigned){
  selectContatCheckboxById(contact.getId());
 // String groupName = groupAssigned.getName();
  new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(groupAssigned.getName());
  wd.findElement(By.name("add")).click();
}

public void removeContactFromGroup(ContactData contact, GroupData groupUnassigned){
  app.goTo().homePage();
  selectGroup(groupUnassigned.getName());
  selectContatCheckboxById(contact.getId());
  wd.findElement(By.name("remove")).click();
  app.goTo().homePage();
}
private void selectGroup(String groupName){
  new Select(wd.findElement(By.name("group"))).selectByVisibleText(groupName);
}

/*public ContactData setContactGroups(ContactData modifiedContact, ContactData contact){
  Groups contactsGroups = modifiedContact.getGroups();
  if (contactsGroups.size() > 0) {
    for (GroupData group : contactsGroups){
      contact.inGroup(group);
    }
    return contact;
  }
  return contact;
}*/
}
