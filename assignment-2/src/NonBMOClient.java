/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.sql.Date;

/**
 * Non-BMO clients (clients of other banks)
 */
// line 157 "model.ump"
// line 291 "model.ump"
public class NonBMOClient extends Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //NonBMOClient Attributes
  private String primaryBankName;
  private String reasonForTracking;
  private Date trackingStartDate;

  //NonBMOClient Associations
  private BMO trackedBy;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public NonBMOClient(String aFirstName, String aLastName, Date aDateOfBirth, String aSocialInsuranceNumber, String aPhoneNumber, String aEmail, String aAddress, String aPrimaryBankName, String aReasonForTracking, Date aTrackingStartDate, BMO aTrackedBy)
  {
    super(aFirstName, aLastName, aDateOfBirth, aSocialInsuranceNumber, aPhoneNumber, aEmail, aAddress);
    primaryBankName = aPrimaryBankName;
    reasonForTracking = aReasonForTracking;
    trackingStartDate = aTrackingStartDate;
    boolean didAddTrackedBy = setTrackedBy(aTrackedBy);
    if (!didAddTrackedBy)
    {
      throw new RuntimeException("Unable to create potentialClient due to trackedBy. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPrimaryBankName(String aPrimaryBankName)
  {
    boolean wasSet = false;
    primaryBankName = aPrimaryBankName;
    wasSet = true;
    return wasSet;
  }

  public boolean setReasonForTracking(String aReasonForTracking)
  {
    boolean wasSet = false;
    reasonForTracking = aReasonForTracking;
    wasSet = true;
    return wasSet;
  }

  public boolean setTrackingStartDate(Date aTrackingStartDate)
  {
    boolean wasSet = false;
    trackingStartDate = aTrackingStartDate;
    wasSet = true;
    return wasSet;
  }

  public String getPrimaryBankName()
  {
    return primaryBankName;
  }

  public String getReasonForTracking()
  {
    return reasonForTracking;
  }

  public Date getTrackingStartDate()
  {
    return trackingStartDate;
  }
  /* Code from template association_GetOne */
  public BMO getTrackedBy()
  {
    return trackedBy;
  }
  /* Code from template association_SetOneToMany */
  public boolean setTrackedBy(BMO aTrackedBy)
  {
    boolean wasSet = false;
    if (aTrackedBy == null)
    {
      return wasSet;
    }

    BMO existingTrackedBy = trackedBy;
    trackedBy = aTrackedBy;
    if (existingTrackedBy != null && !existingTrackedBy.equals(aTrackedBy))
    {
      existingTrackedBy.removePotentialClient(this);
    }
    trackedBy.addPotentialClient(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    BMO placeholderTrackedBy = trackedBy;
    this.trackedBy = null;
    if(placeholderTrackedBy != null)
    {
      placeholderTrackedBy.removePotentialClient(this);
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "primaryBankName" + ":" + getPrimaryBankName()+ "," +
            "reasonForTracking" + ":" + getReasonForTracking()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "trackingStartDate" + "=" + (getTrackingStartDate() != null ? !getTrackingStartDate().equals(this)  ? getTrackingStartDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "trackedBy = "+(getTrackedBy()!=null?Integer.toHexString(System.identityHashCode(getTrackedBy())):"null");
  }
}