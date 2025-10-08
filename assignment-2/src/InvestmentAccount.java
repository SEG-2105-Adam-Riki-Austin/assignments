/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;
import java.sql.Date;

/**
 * Investment Account - has nickname
 */
// line 40 "model.ump"
// line 231 "model.ump"
public class InvestmentAccount extends NamedAccount
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //InvestmentAccount Attributes
  private String investmentType;
  private double riskLevel;

  //InvestmentAccount Associations
  private List<InvestmentItem> inPortfolio;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public InvestmentAccount(int aAccountNumber, double aBalance, Date aOpenDate, String aStatus, Client aOwner, String aNickname, String aInvestmentType, double aRiskLevel)
  {
    super(aAccountNumber, aBalance, aOpenDate, aStatus, aOwner, aNickname);
    investmentType = aInvestmentType;
    riskLevel = aRiskLevel;
    inPortfolio = new ArrayList<InvestmentItem>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setInvestmentType(String aInvestmentType)
  {
    boolean wasSet = false;
    investmentType = aInvestmentType;
    wasSet = true;
    return wasSet;
  }

  public boolean setRiskLevel(double aRiskLevel)
  {
    boolean wasSet = false;
    riskLevel = aRiskLevel;
    wasSet = true;
    return wasSet;
  }

  /**
   * stocks, bonds, mutual funds
   */
  public String getInvestmentType()
  {
    return investmentType;
  }

  /**
   * 1-10 scale
   */
  public double getRiskLevel()
  {
    return riskLevel;
  }
  /* Code from template association_GetMany */
  public InvestmentItem getInPortfolio(int index)
  {
    InvestmentItem aInPortfolio = inPortfolio.get(index);
    return aInPortfolio;
  }

  /**
   * Association with portfolio items
   */
  public List<InvestmentItem> getInPortfolio()
  {
    List<InvestmentItem> newInPortfolio = Collections.unmodifiableList(inPortfolio);
    return newInPortfolio;
  }

  public int numberOfInPortfolio()
  {
    int number = inPortfolio.size();
    return number;
  }

  public boolean hasInPortfolio()
  {
    boolean has = inPortfolio.size() > 0;
    return has;
  }

  public int indexOfInPortfolio(InvestmentItem aInPortfolio)
  {
    int index = inPortfolio.indexOf(aInPortfolio);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfInPortfolio()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public InvestmentItem addInPortfolio(String aSymbol, String aName, int aQuantity, double aPurchasePrice, double aCurrentPrice)
  {
    return new InvestmentItem(aSymbol, aName, aQuantity, aPurchasePrice, aCurrentPrice, this);
  }

  public boolean addInPortfolio(InvestmentItem aInPortfolio)
  {
    boolean wasAdded = false;
    if (inPortfolio.contains(aInPortfolio)) { return false; }
    InvestmentAccount existingInvestmentAccount = aInPortfolio.getInvestmentAccount();
    boolean isNewInvestmentAccount = existingInvestmentAccount != null && !this.equals(existingInvestmentAccount);
    if (isNewInvestmentAccount)
    {
      aInPortfolio.setInvestmentAccount(this);
    }
    else
    {
      inPortfolio.add(aInPortfolio);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeInPortfolio(InvestmentItem aInPortfolio)
  {
    boolean wasRemoved = false;
    //Unable to remove aInPortfolio, as it must always have a investmentAccount
    if (!this.equals(aInPortfolio.getInvestmentAccount()))
    {
      inPortfolio.remove(aInPortfolio);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addInPortfolioAt(InvestmentItem aInPortfolio, int index)
  {  
    boolean wasAdded = false;
    if(addInPortfolio(aInPortfolio))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInPortfolio()) { index = numberOfInPortfolio() - 1; }
      inPortfolio.remove(aInPortfolio);
      inPortfolio.add(index, aInPortfolio);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveInPortfolioAt(InvestmentItem aInPortfolio, int index)
  {
    boolean wasAdded = false;
    if(inPortfolio.contains(aInPortfolio))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInPortfolio()) { index = numberOfInPortfolio() - 1; }
      inPortfolio.remove(aInPortfolio);
      inPortfolio.add(index, aInPortfolio);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addInPortfolioAt(aInPortfolio, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=inPortfolio.size(); i > 0; i--)
    {
      InvestmentItem aInPortfolio = inPortfolio.get(i - 1);
      aInPortfolio.delete();
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "investmentType" + ":" + getInvestmentType()+ "," +
            "riskLevel" + ":" + getRiskLevel()+ "]";
  }
}