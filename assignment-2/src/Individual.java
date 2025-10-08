/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;
import java.sql.Date;

/**
 * Individual adult clients
 */
// line 124 "model.ump"
// line 271 "model.ump"
public class Individual extends Adult
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Individual Attributes
  private String employerName;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Individual(String aFirstName, String aLastName, Date aDateOfBirth, String aSocialInsuranceNumber, String aPhoneNumber, String aEmail, String aAddress, int aClientId, Date aRegistrationDate, String aClientStatus, BMO aBMO, String aOccupation, double aAnnualIncome, String aEmployerName)
  {
    super(aFirstName, aLastName, aDateOfBirth, aSocialInsuranceNumber, aPhoneNumber, aEmail, aAddress, aClientId, aRegistrationDate, aClientStatus, aBMO, aOccupation, aAnnualIncome);
    employerName = aEmployerName;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setEmployerName(String aEmployerName)
  {
    boolean wasSet = false;
    employerName = aEmployerName;
    wasSet = true;
    return wasSet;
  }

  public String getEmployerName()
  {
    return employerName;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "employerName" + ":" + getEmployerName()+ "]";
  }
}