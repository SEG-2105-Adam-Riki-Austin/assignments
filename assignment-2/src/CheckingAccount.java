/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;
import java.sql.Date;

/**
 * Checking Account - has nickname but no interest
 */
// line 33 "model.ump"
// line 226 "model.ump"
public class CheckingAccount extends NamedAccount
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CheckingAccount Attributes
  private double overdraftLimit;
  private int monthlyTransactionLimit;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CheckingAccount(int aAccountNumber, double aBalance, Date aOpenDate, String aStatus, Client aOwner, String aNickname, double aOverdraftLimit, int aMonthlyTransactionLimit)
  {
    super(aAccountNumber, aBalance, aOpenDate, aStatus, aOwner, aNickname);
    overdraftLimit = aOverdraftLimit;
    monthlyTransactionLimit = aMonthlyTransactionLimit;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setOverdraftLimit(double aOverdraftLimit)
  {
    boolean wasSet = false;
    overdraftLimit = aOverdraftLimit;
    wasSet = true;
    return wasSet;
  }

  public boolean setMonthlyTransactionLimit(int aMonthlyTransactionLimit)
  {
    boolean wasSet = false;
    monthlyTransactionLimit = aMonthlyTransactionLimit;
    wasSet = true;
    return wasSet;
  }

  public double getOverdraftLimit()
  {
    return overdraftLimit;
  }

  public int getMonthlyTransactionLimit()
  {
    return monthlyTransactionLimit;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "overdraftLimit" + ":" + getOverdraftLimit()+ "," +
            "monthlyTransactionLimit" + ":" + getMonthlyTransactionLimit()+ "]";
  }
}