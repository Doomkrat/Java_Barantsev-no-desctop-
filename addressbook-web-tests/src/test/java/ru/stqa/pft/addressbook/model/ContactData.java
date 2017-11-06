package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")

public class ContactData {

  @Id
  @Column(name = "id")
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "firstname")
  private  String firstname;

  @Expose
  @Column(name = "lastname")
  private  String lastname;

  @XStreamOmitField
  @Transient
  private  String group;

  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private  String homePhone;

  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private  String mobilePhone;

  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private  String workPhone;

  @XStreamOmitField
  @Transient
  private  String allPhones;

  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private  String eMail;

  @Expose
  @Column(name = "email2")
  @Type(type = "text")
  private  String eMail2;

  @Expose
  @Column(name = "email3")
  @Type(type = "text")
  private  String eMail3;

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @XStreamOmitField
  @Transient
  private  String address;

  @XStreamOmitField
  @Transient
  private  String allEmails;

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  public File getPhoto() {
    return new File(photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }



  public ContactData witheMail(String eMail) {
    this.eMail = eMail;
    return this;
  }



  public ContactData witheMail2(String eMail2) {
    this.eMail2 = eMail2;
    return this;
  }



  public ContactData witheMail3(String eMail3) {
    this.eMail3 = eMail3;
    return this;
  }


  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }


  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }



  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }
  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withMobilephone(String mobilephone) {
    this.mobilePhone = mobilephone;
    return this;
  }


  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }
  public String getAddress() { return address; }

  public String getAllEmails() { return allEmails; }

  public String geteMail3() { return eMail3; }

  public String geteMail2() { return eMail2; }

  public String geteMail() { return eMail; }

  public String getWorkPhone() { return workPhone; }

  public String getFirstname() { return firstname; }

  public int getId() { return id; }

  public String getLastname() { return lastname; }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

}
