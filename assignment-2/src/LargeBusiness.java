/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;
import java.sql.Date;

/**
 * Large Business clients
 */
// line 147 "model.ump"
// line 286 "model.ump"
public class LargeBusiness extends Adult
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LargeBusiness Attributes
  private String corporationName;
  private String corporationNumber;
  private int numberOfEmployees;
  private String industry;
  private String stockSymbol;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LargeBusiness(String aFirstName, String aLastName, Date aDateOfBirth, String aSocialInsuranceNumber, String aPhoneNumber, String aEmail, String aAddress, int aClientId, Date aRegistrationDate, String aClientStatus, BMO aBMO, String aOccupation, double aAnnualIncome, String aCorporationName, String aCorporationNumber, int aNumberOfEmployees, String aIndustry, String aStockSymbol)
  {
    super(aFirstName, aLastName, aDateOfBirth, aSocialInsuranceNumber, aPhoneNumber, aEmail, aAddress, aClientId, aRegistrationDate, aClientStatus, aBMO, aOccupation, aAnnualIncome);
    corporationName = aCorporationName;
    corporationNumber = aCorporationNumber;
    numberOfEmployees = aNumberOfEmployees;
    industry = aIndustry;
    stockSymbol = aStockSymbol;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCorporationName(String aCorporationName)
  {
    boolean wasSet = false;
    corporationName = aCorporationName;
    wasSet = true;
    return wasSet;
  }

  public boolean setCorporationNumber(String aCorporationNumber)
  {
    boolean wasSet = false;
    corporationNumber = aCorporationNumber;
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

  public boolean setStockSymbol(String aStockSymbol)
  {
    boolean wasSet = false;
    stockSymbol = aStockSymbol;
    wasSet = true;
    return wasSet;
  }

  public String getCorporationName()
  {
    return corporationName;
  }

  public String getCorporationNumber()
  {
    return corporationNumber;
  }

  /**
   * >= 100
   */
  public int getNumberOfEmployees()
  {
    return numberOfEmployees;
  }

  public String getIndustry()
  {
    return industry;
  }

  public String getStockSymbol()
  {
    return stockSymbol;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "corporationName" + ":" + getCorporationName()+ "," +
            "corporationNumber" + ":" + getCorporationNumber()+ "," +
            "numberOfEmployees" + ":" + getNumberOfEmployees()+ "," +
            "industry" + ":" + getIndustry()+ "," +
            "stockSymbol" + ":" + getStockSymbol()+ "]";
  }
}