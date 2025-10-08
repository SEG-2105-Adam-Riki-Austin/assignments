/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;
import java.sql.Date;

/**
 * Investor clients
 */
// line 130 "model.ump"
// line 276 "model.ump"
public class Investor extends Adult
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Investor Attributes
  private String investorType;
  private double netWorth;
  private int yearsOfExperience;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Investor(String aFirstName, String aLastName, Date aDateOfBirth, String aSocialInsuranceNumber, String aPhoneNumber, String aEmail, String aAddress, int aClientId, Date aRegistrationDate, String aClientStatus, BMO aBMO, String aOccupation, double aAnnualIncome, String aInvestorType, double aNetWorth, int aYearsOfExperience)
  {
    super(aFirstName, aLastName, aDateOfBirth, aSocialInsuranceNumber, aPhoneNumber, aEmail, aAddress, aClientId, aRegistrationDate, aClientStatus, aBMO, aOccupation, aAnnualIncome);
    investorType = aInvestorType;
    netWorth = aNetWorth;
    yearsOfExperience = aYearsOfExperience;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setInvestorType(String aInvestorType)
  {
    boolean wasSet = false;
    investorType = aInvestorType;
    wasSet = true;
    return wasSet;
  }

  public boolean setNetWorth(double aNetWorth)
  {
    boolean wasSet = false;
    netWorth = aNetWorth;
    wasSet = true;
    return wasSet;
  }

  public boolean setYearsOfExperience(int aYearsOfExperience)
  {
    boolean wasSet = false;
    yearsOfExperience = aYearsOfExperience;
    wasSet = true;
    return wasSet;
  }

  /**
   * conservative, moderate, aggressive
   */
  public String getInvestorType()
  {
    return investorType;
  }

  public double getNetWorth()
  {
    return netWorth;
  }

  public int getYearsOfExperience()
  {
    return yearsOfExperience;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "investorType" + ":" + getInvestorType()+ "," +
            "netWorth" + ":" + getNetWorth()+ "," +
            "yearsOfExperience" + ":" + getYearsOfExperience()+ "]";
  }
}