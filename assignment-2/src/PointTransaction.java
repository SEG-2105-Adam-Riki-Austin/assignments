/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.sql.Date;

// line 182 "model.ump"
// line 296 "model.ump"
public class PointTransaction
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PointTransaction Attributes
  private Date transactionDate;
  private int pointsAmount;
  private String transactionType;
  private String description;

  //PointTransaction Associations
  private LoyaltyProgramAccount loyaltyProgramAccount;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PointTransaction(Date aTransactionDate, int aPointsAmount, String aTransactionType, String aDescription, LoyaltyProgramAccount aLoyaltyProgramAccount)
  {
    transactionDate = aTransactionDate;
    pointsAmount = aPointsAmount;
    transactionType = aTransactionType;
    description = aDescription;
    boolean didAddLoyaltyProgramAccount = setLoyaltyProgramAccount(aLoyaltyProgramAccount);
    if (!didAddLoyaltyProgramAccount)
    {
      throw new RuntimeException("Unable to create transaction due to loyaltyProgramAccount. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTransactionDate(Date aTransactionDate)
  {
    boolean wasSet = false;
    transactionDate = aTransactionDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setPointsAmount(int aPointsAmount)
  {
    boolean wasSet = false;
    pointsAmount = aPointsAmount;
    wasSet = true;
    return wasSet;
  }

  public boolean setTransactionType(String aTransactionType)
  {
    boolean wasSet = false;
    transactionType = aTransactionType;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public Date getTransactionDate()
  {
    return transactionDate;
  }

  public int getPointsAmount()
  {
    return pointsAmount;
  }

  /**
   * earned, redeemed
   */
  public String getTransactionType()
  {
    return transactionType;
  }

  public String getDescription()
  {
    return description;
  }
  /* Code from template association_GetOne */
  public LoyaltyProgramAccount getLoyaltyProgramAccount()
  {
    return loyaltyProgramAccount;
  }
  /* Code from template association_SetOneToMany */
  public boolean setLoyaltyProgramAccount(LoyaltyProgramAccount aLoyaltyProgramAccount)
  {
    boolean wasSet = false;
    if (aLoyaltyProgramAccount == null)
    {
      return wasSet;
    }

    LoyaltyProgramAccount existingLoyaltyProgramAccount = loyaltyProgramAccount;
    loyaltyProgramAccount = aLoyaltyProgramAccount;
    if (existingLoyaltyProgramAccount != null && !existingLoyaltyProgramAccount.equals(aLoyaltyProgramAccount))
    {
      existingLoyaltyProgramAccount.removeTransaction(this);
    }
    loyaltyProgramAccount.addTransaction(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    LoyaltyProgramAccount placeholderLoyaltyProgramAccount = loyaltyProgramAccount;
    this.loyaltyProgramAccount = null;
    if(placeholderLoyaltyProgramAccount != null)
    {
      placeholderLoyaltyProgramAccount.removeTransaction(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "pointsAmount" + ":" + getPointsAmount()+ "," +
            "transactionType" + ":" + getTransactionType()+ "," +
            "description" + ":" + getDescription()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "transactionDate" + "=" + (getTransactionDate() != null ? !getTransactionDate().equals(this)  ? getTransactionDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "loyaltyProgramAccount = "+(getLoyaltyProgramAccount()!=null?Integer.toHexString(System.identityHashCode(getLoyaltyProgramAccount())):"null");
  }
}