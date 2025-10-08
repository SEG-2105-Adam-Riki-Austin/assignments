/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;
import java.sql.Date;

/**
 * BMO Banking System - UML Class Diagram in Umple
 * ==================== ACCOUNT HIERARCHY ====================
 * Base Account class - abstract parent for all account types
 */
// line 7 "model.ump"
// line 211 "model.ump"
public abstract class Account
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<Integer, Account> accountsByAccountNumber = new HashMap<Integer, Account>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Account Attributes
  private int accountNumber;
  private double balance;
  private Date openDate;
  private String status;

  //Account Associations
  private Client owner;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Account(int aAccountNumber, double aBalance, Date aOpenDate, String aStatus, Client aOwner)
  {
    balance = aBalance;
    openDate = aOpenDate;
    status = aStatus;
    if (!setAccountNumber(aAccountNumber))
    {
      throw new RuntimeException("Cannot create due to duplicate accountNumber. See https://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    boolean didAddOwner = setOwner(aOwner);
    if (!didAddOwner)
    {
      throw new RuntimeException("Unable to create account due to owner. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAccountNumber(int aAccountNumber)
  {
    boolean wasSet = false;
    Integer anOldAccountNumber = getAccountNumber();
    if (anOldAccountNumber != null && anOldAccountNumber.equals(aAccountNumber)) {
      return true;
    }
    if (hasWithAccountNumber(aAccountNumber)) {
      return wasSet;
    }
    accountNumber = aAccountNumber;
    wasSet = true;
    if (anOldAccountNumber != null) {
      accountsByAccountNumber.remove(anOldAccountNumber);
    }
    accountsByAccountNumber.put(aAccountNumber, this);
    return wasSet;
  }

  public boolean setBalance(double aBalance)
  {
    boolean wasSet = false;
    balance = aBalance;
    wasSet = true;
    return wasSet;
  }

  public boolean setOpenDate(Date aOpenDate)
  {
    boolean wasSet = false;
    openDate = aOpenDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setStatus(String aStatus)
  {
    boolean wasSet = false;
    status = aStatus;
    wasSet = true;
    return wasSet;
  }

  public int getAccountNumber()
  {
    return accountNumber;
  }
  /* Code from template attribute_GetUnique */
  public static Account getWithAccountNumber(int aAccountNumber)
  {
    return accountsByAccountNumber.get(aAccountNumber);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithAccountNumber(int aAccountNumber)
  {
    return getWithAccountNumber(aAccountNumber) != null;
  }

  public double getBalance()
  {
    return balance;
  }

  public Date getOpenDate()
  {
    return openDate;
  }

  /**
   * active, closed, frozen
   */
  public String getStatus()
  {
    return status;
  }
  /* Code from template association_GetOne */
  public Client getOwner()
  {
    return owner;
  }
  /* Code from template association_SetOneToMany */
  public boolean setOwner(Client aOwner)
  {
    boolean wasSet = false;
    if (aOwner == null)
    {
      return wasSet;
    }

    Client existingOwner = owner;
    owner = aOwner;
    if (existingOwner != null && !existingOwner.equals(aOwner))
    {
      existingOwner.removeAccount(this);
    }
    owner.addAccount(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    accountsByAccountNumber.remove(getAccountNumber());
    Client placeholderOwner = owner;
    this.owner = null;
    if(placeholderOwner != null)
    {
      placeholderOwner.removeAccount(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "accountNumber" + ":" + getAccountNumber()+ "," +
            "balance" + ":" + getBalance()+ "," +
            "status" + ":" + getStatus()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "openDate" + "=" + (getOpenDate() != null ? !getOpenDate().equals(this)  ? getOpenDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "owner = "+(getOwner()!=null?Integer.toHexString(System.identityHashCode(getOwner())):"null");
  }
}