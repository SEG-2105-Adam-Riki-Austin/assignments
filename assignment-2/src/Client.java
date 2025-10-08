/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;
import java.sql.Date;

/**
 * Base Client class - BMO clients
 */
// line 83 "model.ump"
// line 251 "model.ump"
public abstract class Client extends Person
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<Integer, Client> clientsByClientId = new HashMap<Integer, Client>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Client Attributes
  private int clientId;
  private Date registrationDate;
  private String clientStatus;

  //Client Associations
  private LoyaltyProgramAccount loyaltyAccount;
  private List<Account> accounts;
  private BMO bMO;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Client(String aFirstName, String aLastName, Date aDateOfBirth, String aSocialInsuranceNumber, String aPhoneNumber, String aEmail, String aAddress, int aClientId, Date aRegistrationDate, String aClientStatus, BMO aBMO)
  {
    super(aFirstName, aLastName, aDateOfBirth, aSocialInsuranceNumber, aPhoneNumber, aEmail, aAddress);
    registrationDate = aRegistrationDate;
    clientStatus = aClientStatus;
    if (!setClientId(aClientId))
    {
      throw new RuntimeException("Cannot create due to duplicate clientId. See https://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    accounts = new ArrayList<Account>();
    boolean didAddBMO = setBMO(aBMO);
    if (!didAddBMO)
    {
      throw new RuntimeException("Unable to create activeClient due to bMO. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setClientId(int aClientId)
  {
    boolean wasSet = false;
    Integer anOldClientId = getClientId();
    if (anOldClientId != null && anOldClientId.equals(aClientId)) {
      return true;
    }
    if (hasWithClientId(aClientId)) {
      return wasSet;
    }
    clientId = aClientId;
    wasSet = true;
    if (anOldClientId != null) {
      clientsByClientId.remove(anOldClientId);
    }
    clientsByClientId.put(aClientId, this);
    return wasSet;
  }

  public boolean setRegistrationDate(Date aRegistrationDate)
  {
    boolean wasSet = false;
    registrationDate = aRegistrationDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setClientStatus(String aClientStatus)
  {
    boolean wasSet = false;
    clientStatus = aClientStatus;
    wasSet = true;
    return wasSet;
  }

  public int getClientId()
  {
    return clientId;
  }
  /* Code from template attribute_GetUnique */
  public static Client getWithClientId(int aClientId)
  {
    return clientsByClientId.get(aClientId);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithClientId(int aClientId)
  {
    return getWithClientId(aClientId) != null;
  }

  public Date getRegistrationDate()
  {
    return registrationDate;
  }

  /**
   * active, inactive, suspended
   */
  public String getClientStatus()
  {
    return clientStatus;
  }
  /* Code from template association_GetOne */
  public LoyaltyProgramAccount getLoyaltyAccount()
  {
    return loyaltyAccount;
  }

  public boolean hasLoyaltyAccount()
  {
    boolean has = loyaltyAccount != null;
    return has;
  }
  /* Code from template association_GetMany */
  public Account getAccount(int index)
  {
    Account aAccount = accounts.get(index);
    return aAccount;
  }

  public List<Account> getAccounts()
  {
    List<Account> newAccounts = Collections.unmodifiableList(accounts);
    return newAccounts;
  }

  public int numberOfAccounts()
  {
    int number = accounts.size();
    return number;
  }

  public boolean hasAccounts()
  {
    boolean has = accounts.size() > 0;
    return has;
  }

  public int indexOfAccount(Account aAccount)
  {
    int index = accounts.indexOf(aAccount);
    return index;
  }
  /* Code from template association_GetOne */
  public BMO getBMO()
  {
    return bMO;
  }
  /* Code from template association_SetOptionalOneToOne */
  public boolean setLoyaltyAccount(LoyaltyProgramAccount aNewLoyaltyAccount)
  {
    boolean wasSet = false;
    if (loyaltyAccount != null && !loyaltyAccount.equals(aNewLoyaltyAccount) && equals(loyaltyAccount.getClient()))
    {
      //Unable to setLoyaltyAccount, as existing loyaltyAccount would become an orphan
      return wasSet;
    }

    loyaltyAccount = aNewLoyaltyAccount;
    Client anOldClient = aNewLoyaltyAccount != null ? aNewLoyaltyAccount.getClient() : null;

    if (!this.equals(anOldClient))
    {
      if (anOldClient != null)
      {
        anOldClient.loyaltyAccount = null;
      }
      if (loyaltyAccount != null)
      {
        loyaltyAccount.setClient(this);
      }
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAccounts()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */


  public boolean addAccount(Account aAccount)
  {
    boolean wasAdded = false;
    if (accounts.contains(aAccount)) { return false; }
    Client existingOwner = aAccount.getOwner();
    boolean isNewOwner = existingOwner != null && !this.equals(existingOwner);
    if (isNewOwner)
    {
      aAccount.setOwner(this);
    }
    else
    {
      accounts.add(aAccount);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAccount(Account aAccount)
  {
    boolean wasRemoved = false;
    //Unable to remove aAccount, as it must always have a owner
    if (!this.equals(aAccount.getOwner()))
    {
      accounts.remove(aAccount);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAccountAt(Account aAccount, int index)
  {  
    boolean wasAdded = false;
    if(addAccount(aAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccounts()) { index = numberOfAccounts() - 1; }
      accounts.remove(aAccount);
      accounts.add(index, aAccount);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAccountAt(Account aAccount, int index)
  {
    boolean wasAdded = false;
    if(accounts.contains(aAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccounts()) { index = numberOfAccounts() - 1; }
      accounts.remove(aAccount);
      accounts.add(index, aAccount);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAccountAt(aAccount, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setBMO(BMO aBMO)
  {
    boolean wasSet = false;
    if (aBMO == null)
    {
      return wasSet;
    }

    BMO existingBMO = bMO;
    bMO = aBMO;
    if (existingBMO != null && !existingBMO.equals(aBMO))
    {
      existingBMO.removeActiveClient(this);
    }
    bMO.addActiveClient(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    clientsByClientId.remove(getClientId());
    LoyaltyProgramAccount existingLoyaltyAccount = loyaltyAccount;
    loyaltyAccount = null;
    if (existingLoyaltyAccount != null)
    {
      existingLoyaltyAccount.delete();
    }
    for(int i=accounts.size(); i > 0; i--)
    {
      Account aAccount = accounts.get(i - 1);
      aAccount.delete();
    }
    BMO placeholderBMO = bMO;
    this.bMO = null;
    if(placeholderBMO != null)
    {
      placeholderBMO.removeActiveClient(this);
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "clientId" + ":" + getClientId()+ "," +
            "clientStatus" + ":" + getClientStatus()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "registrationDate" + "=" + (getRegistrationDate() != null ? !getRegistrationDate().equals(this)  ? getRegistrationDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "loyaltyAccount = "+(getLoyaltyAccount()!=null?Integer.toHexString(System.identityHashCode(getLoyaltyAccount())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "bMO = "+(getBMO()!=null?Integer.toHexString(System.identityHashCode(getBMO())):"null");
  }
}