/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.sql.Date;
import java.util.*;

/**
 * Loan Account - has interest but NO nickname
 */
// line 50 "model.ump"
// line 236 "model.ump"
public class LoanAccount extends Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LoanAccount Attributes
  private double interestRate;
  private double principalAmount;
  private double remainingBalance;
  private Date maturityDate;
  private String loanType;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LoanAccount(int aAccountNumber, double aBalance, Date aOpenDate, String aStatus, Client aOwner, double aInterestRate, double aPrincipalAmount, double aRemainingBalance, Date aMaturityDate, String aLoanType)
  {
    super(aAccountNumber, aBalance, aOpenDate, aStatus, aOwner);
    interestRate = aInterestRate;
    principalAmount = aPrincipalAmount;
    remainingBalance = aRemainingBalance;
    maturityDate = aMaturityDate;
    loanType = aLoanType;
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

  public boolean setPrincipalAmount(double aPrincipalAmount)
  {
    boolean wasSet = false;
    principalAmount = aPrincipalAmount;
    wasSet = true;
    return wasSet;
  }

  public boolean setRemainingBalance(double aRemainingBalance)
  {
    boolean wasSet = false;
    remainingBalance = aRemainingBalance;
    wasSet = true;
    return wasSet;
  }

  public boolean setMaturityDate(Date aMaturityDate)
  {
    boolean wasSet = false;
    maturityDate = aMaturityDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setLoanType(String aLoanType)
  {
    boolean wasSet = false;
    loanType = aLoanType;
    wasSet = true;
    return wasSet;
  }

  public double getInterestRate()
  {
    return interestRate;
  }

  public double getPrincipalAmount()
  {
    return principalAmount;
  }

  public double getRemainingBalance()
  {
    return remainingBalance;
  }

  public Date getMaturityDate()
  {
    return maturityDate;
  }

  public String getLoanType()
  {
    return loanType;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "interestRate" + ":" + getInterestRate()+ "," +
            "principalAmount" + ":" + getPrincipalAmount()+ "," +
            "remainingBalance" + ":" + getRemainingBalance()+ "," +
            "loanType" + ":" + getLoanType()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "maturityDate" + "=" + (getMaturityDate() != null ? !getMaturityDate().equals(this)  ? getMaturityDate().toString().replaceAll("  ","    ") : "this" : "null");
  }
}