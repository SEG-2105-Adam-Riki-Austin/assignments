/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.sql.Date;

/**
 * ==================== CLIENT HIERARCHY ====================
 * Base Person class for all individuals
 */
// line 71 "model.ump"
// line 246 "model.ump"
public abstract class Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Person Attributes
  private String firstName;
  private String lastName;
  private Date dateOfBirth;
  private String socialInsuranceNumber;
  private String phoneNumber;
  private String email;
  private String address;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Person(String aFirstName, String aLastName, Date aDateOfBirth, String aSocialInsuranceNumber, String aPhoneNumber, String aEmail, String aAddress)
  {
    firstName = aFirstName;
    lastName = aLastName;
    dateOfBirth = aDateOfBirth;
    socialInsuranceNumber = aSocialInsuranceNumber;
    phoneNumber = aPhoneNumber;
    email = aEmail;
    address = aAddress;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFirstName(String aFirstName)
  {
    boolean wasSet = false;
    firstName = aFirstName;
    wasSet = true;
    return wasSet;
  }

  public boolean setLastName(String aLastName)
  {
    boolean wasSet = false;
    lastName = aLastName;
    wasSet = true;
    return wasSet;
  }

  public boolean setDateOfBirth(Date aDateOfBirth)
  {
    boolean wasSet = false;
    dateOfBirth = aDateOfBirth;
    wasSet = true;
    return wasSet;
  }

  public boolean setSocialInsuranceNumber(String aSocialInsuranceNumber)
  {
    boolean wasSet = false;
    socialInsuranceNumber = aSocialInsuranceNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhoneNumber(String aPhoneNumber)
  {
    boolean wasSet = false;
    phoneNumber = aPhoneNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setEmail(String aEmail)
  {
    boolean wasSet = false;
    email = aEmail;
    wasSet = true;
    return wasSet;
  }

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public Date getDateOfBirth()
  {
    return dateOfBirth;
  }

  public String getSocialInsuranceNumber()
  {
    return socialInsuranceNumber;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public String getEmail()
  {
    return email;
  }

  public String getAddress()
  {
    return address;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "firstName" + ":" + getFirstName()+ "," +
            "lastName" + ":" + getLastName()+ "," +
            "socialInsuranceNumber" + ":" + getSocialInsuranceNumber()+ "," +
            "phoneNumber" + ":" + getPhoneNumber()+ "," +
            "email" + ":" + getEmail()+ "," +
            "address" + ":" + getAddress()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "dateOfBirth" + "=" + (getDateOfBirth() != null ? !getDateOfBirth().equals(this)  ? getDateOfBirth().toString().replaceAll("  ","    ") : "this" : "null");
  }
}