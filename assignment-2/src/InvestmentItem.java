/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



/**
 * Investment items for investment accounts
 */
// line 60 "model.ump"
// line 241 "model.ump"
public class InvestmentItem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //InvestmentItem Attributes
  private String symbol;
  private String name;
  private int quantity;
  private double purchasePrice;
  private double currentPrice;

  //InvestmentItem Associations
  private InvestmentAccount investmentAccount;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public InvestmentItem(String aSymbol, String aName, int aQuantity, double aPurchasePrice, double aCurrentPrice, InvestmentAccount aInvestmentAccount)
  {
    symbol = aSymbol;
    name = aName;
    quantity = aQuantity;
    purchasePrice = aPurchasePrice;
    currentPrice = aCurrentPrice;
    boolean didAddInvestmentAccount = setInvestmentAccount(aInvestmentAccount);
    if (!didAddInvestmentAccount)
    {
      throw new RuntimeException("Unable to create inPortfolio due to investmentAccount. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSymbol(String aSymbol)
  {
    boolean wasSet = false;
    symbol = aSymbol;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setQuantity(int aQuantity)
  {
    boolean wasSet = false;
    quantity = aQuantity;
    wasSet = true;
    return wasSet;
  }

  public boolean setPurchasePrice(double aPurchasePrice)
  {
    boolean wasSet = false;
    purchasePrice = aPurchasePrice;
    wasSet = true;
    return wasSet;
  }

  public boolean setCurrentPrice(double aCurrentPrice)
  {
    boolean wasSet = false;
    currentPrice = aCurrentPrice;
    wasSet = true;
    return wasSet;
  }

  public String getSymbol()
  {
    return symbol;
  }

  public String getName()
  {
    return name;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public double getPurchasePrice()
  {
    return purchasePrice;
  }

  public double getCurrentPrice()
  {
    return currentPrice;
  }
  /* Code from template association_GetOne */
  public InvestmentAccount getInvestmentAccount()
  {
    return investmentAccount;
  }
  /* Code from template association_SetOneToMany */
  public boolean setInvestmentAccount(InvestmentAccount aInvestmentAccount)
  {
    boolean wasSet = false;
    if (aInvestmentAccount == null)
    {
      return wasSet;
    }

    InvestmentAccount existingInvestmentAccount = investmentAccount;
    investmentAccount = aInvestmentAccount;
    if (existingInvestmentAccount != null && !existingInvestmentAccount.equals(aInvestmentAccount))
    {
      existingInvestmentAccount.removeInPortfolio(this);
    }
    investmentAccount.addInPortfolio(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    InvestmentAccount placeholderInvestmentAccount = investmentAccount;
    this.investmentAccount = null;
    if(placeholderInvestmentAccount != null)
    {
      placeholderInvestmentAccount.removeInPortfolio(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "symbol" + ":" + getSymbol()+ "," +
            "name" + ":" + getName()+ "," +
            "quantity" + ":" + getQuantity()+ "," +
            "purchasePrice" + ":" + getPurchasePrice()+ "," +
            "currentPrice" + ":" + getCurrentPrice()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "investmentAccount = "+(getInvestmentAccount()!=null?Integer.toHexString(System.identityHashCode(getInvestmentAccount())):"null");
  }
}