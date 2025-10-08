/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;
import java.sql.Date;

/**
 * Small Business clients
 */
// line 138 "model.ump"
// line 281 "model.ump"
public class SmallBusiness extends Adult
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SmallBusiness Attributes
  private String businessName;
  private String businessNumber;
  private int numberOfEmployees;
  private String industry;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SmallBusiness(String aFirstName, String aLastName, Date aDateOfBirth, String aSocialInsuranceNumber, String aPhoneNumber, String aEmail, String aAddress, int aClientId, Date aRegistrationDate, String aClientStatus, BMO aBMO, String aOccupation, double aAnnualIncome, String aBusinessName, String aBusinessNumber, int aNumberOfEmployees, String aIndustry)
  {
    super(aFirstName, aLastName, aDateOfBirth, aSocialInsuranceNumber, aPhoneNumber, aEmail, aAddress, aClientId, aRegistrationDate, aClientStatus, aBMO, aOccupation, aAnnualIncome);
    businessName = aBusinessName;
    businessNumber = aBusinessNumber;
    numberOfEmployees = aNumberOfEmployees;
    industry = aIndustry;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBusinessName(String aBusinessName)
  {
    boolean wasSet = false;
    businessName = aBusinessName;
    wasSet = true;
    return wasSet;
  }

  public boolean setBusinessNumber(String aBusinessNumber)
  {
    boolean wasSet = false;
    businessNumber = aBusinessNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumberOfEmployees(int aNumberOfEmployees)
  {
    boolean wasSet = false;
    numberOfEmployees = aNumberOfEmployees;
    wasSet = true;
    return wasSet;
  }

  public boolean setIndustry(String aIndustry)
  {
    boolean wasSet = false;
    industry = aIndustry;
    wasSet = true;
    return wasSet;
  }

  public String getBusinessName()
  {
    return businessName;
  }

  public String getBusinessNumber()
  {
    return businessNumber;
  }

  /**
   * < 100
   */
  public int getNumberOfEmployees()
  {
    return numberOfEmployees;
  }

  public String getIndustry()
  {
    return industry;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "businessName" + ":" + getBusinessName()+ "," +
            "businessNumber" + ":" + getBusinessNumber()+ "," +
            "numberOfEmployees" + ":" + getNumberOfEmployees()+ "," +
            "industry" + ":" + getIndustry()+ "]";
  }
}