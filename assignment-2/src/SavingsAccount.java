/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;
import java.sql.Date;

/**
 * Savings Account - has interest rate and nickname
 */
// line 26 "model.ump"
// line 221 "model.ump"
public class SavingsAccount extends NamedAccount
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SavingsAccount Attributes
  private double interestRate;
  private double minimumBalance;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SavingsAccount(int aAccountNumber, double aBalance, Date aOpenDate, String aStatus, Client aOwner, String aNickname, double aInterestRate, double aMinimumBalance)
  {
    super(aAccountNumber, aBalance, aOpenDate, aStatus, aOwner, aNickname);
    interestRate = aInterestRate;
    minimumBalance = aMinimumBalance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setInterestRate(double aInterestRate)
  {
    boolean wasSet = false;
    interestRate = aInterestRate;
    wasSet = true;
    return wasSet;
  }

  public boolean setMinimumBalance(double aMinimumBalance)
  {
    boolean wasSet = false;
    minimumBalance = aMinimumBalance;
    wasSet = true;
    return wasSet;
  }

  public double getInterestRate()
  {
    return interestRate;
  }

  public double getMinimumBalance()
  {
    return minimumBalance;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "interestRate" + ":" + getInterestRate()+ "," +
            "minimumBalance" + ":" + getMinimumBalance()+ "]";
  }
}