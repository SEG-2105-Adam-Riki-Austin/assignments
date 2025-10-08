/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;
import java.sql.Date;

/**
 * ==================== LOYALTY PROGRAM ====================
 */
// line 169 "model.ump"
// line 311 "model.ump"
public class LoyaltyProgramAccount
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<Integer, LoyaltyProgramAccount> loyaltyprogramaccountsByMemberNumber = new HashMap<Integer, LoyaltyProgramAccount>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LoyaltyProgramAccount Attributes
  private int memberNumber;
  private int pointsBalance;
  private String tier;
  private Date enrollmentDate;

  //LoyaltyProgramAccount Associations
  private List<PointTransaction> transactions;
  private List<Reward> redeemedRewards;
  private Client client;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LoyaltyProgramAccount(int aMemberNumber, int aPointsBalance, String aTier, Date aEnrollmentDate, Client aClient)
  {
    pointsBalance = aPointsBalance;
    tier = aTier;
    enrollmentDate = aEnrollmentDate;
    if (!setMemberNumber(aMemberNumber))
    {
      throw new RuntimeException("Cannot create due to duplicate memberNumber. See https://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    transactions = new ArrayList<PointTransaction>();
    redeemedRewards = new ArrayList<Reward>();
    boolean didAddClient = setClient(aClient);
    if (!didAddClient)
    {
      throw new RuntimeException("Unable to create loyaltyAccount due to client. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMemberNumber(int aMemberNumber)
  {
    boolean wasSet = false;
    Integer anOldMemberNumber = getMemberNumber();
    if (anOldMemberNumber != null && anOldMemberNumber.equals(aMemberNumber)) {
      return true;
    }
    if (hasWithMemberNumber(aMemberNumber)) {
      return wasSet;
    }
    memberNumber = aMemberNumber;
    wasSet = true;
    if (anOldMemberNumber != null) {
      loyaltyprogramaccountsByMemberNumber.remove(anOldMemberNumber);
    }
    loyaltyprogramaccountsByMemberNumber.put(aMemberNumber, this);
    return wasSet;
  }

  public boolean setPointsBalance(int aPointsBalance)
  {
    boolean wasSet = false;
    pointsBalance = aPointsBalance;
    wasSet = true;
    return wasSet;
  }

  public boolean setTier(String aTier)
  {
    boolean wasSet = false;
    tier = aTier;
    wasSet = true;
    return wasSet;
  }

  public boolean setEnrollmentDate(Date aEnrollmentDate)
  {
    boolean wasSet = false;
    enrollmentDate = aEnrollmentDate;
    wasSet = true;
    return wasSet;
  }

  public int getMemberNumber()
  {
    return memberNumber;
  }
  /* Code from template attribute_GetUnique */
  public static LoyaltyProgramAccount getWithMemberNumber(int aMemberNumber)
  {
    return loyaltyprogramaccountsByMemberNumber.get(aMemberNumber);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithMemberNumber(int aMemberNumber)
  {
    return getWithMemberNumber(aMemberNumber) != null;
  }

  public int getPointsBalance()
  {
    return pointsBalance;
  }

  /**
   * bronze, silver, gold, platinum
   */
  public String getTier()
  {
    return tier;
  }

  public Date getEnrollmentDate()
  {
    return enrollmentDate;
  }
  /* Code from template association_GetMany */
  public PointTransaction getTransaction(int index)
  {
    PointTransaction aTransaction = transactions.get(index);
    return aTransaction;
  }

  /**
   * Association with transactions
   */
  public List<PointTransaction> getTransactions()
  {
    List<PointTransaction> newTransactions = Collections.unmodifiableList(transactions);
    return newTransactions;
  }

  public int numberOfTransactions()
  {
    int number = transactions.size();
    return number;
  }

  public boolean hasTransactions()
  {
    boolean has = transactions.size() > 0;
    return has;
  }

  public int indexOfTransaction(PointTransaction aTransaction)
  {
    int index = transactions.indexOf(aTransaction);
    return index;
  }
  /* Code from template association_GetMany */
  public Reward getRedeemedReward(int index)
  {
    Reward aRedeemedReward = redeemedRewards.get(index);
    return aRedeemedReward;
  }

  /**
   * Association with rewards
   */
  public List<Reward> getRedeemedRewards()
  {
    List<Reward> newRedeemedRewards = Collections.unmodifiableList(redeemedRewards);
    return newRedeemedRewards;
  }

  public int numberOfRedeemedRewards()
  {
    int number = redeemedRewards.size();
    return number;
  }

  public boolean hasRedeemedRewards()
  {
    boolean has = redeemedRewards.size() > 0;
    return has;
  }

  public int indexOfRedeemedReward(Reward aRedeemedReward)
  {
    int index = redeemedRewards.indexOf(aRedeemedReward);
    return index;
  }
  /* Code from template association_GetOne */
  public Client getClient()
  {
    return client;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTransactions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public PointTransaction addTransaction(Date aTransactionDate, int aPointsAmount, String aTransactionType, String aDescription)
  {
    return new PointTransaction(aTransactionDate, aPointsAmount, aTransactionType, aDescription, this);
  }

  public boolean addTransaction(PointTransaction aTransaction)
  {
    boolean wasAdded = false;
    if (transactions.contains(aTransaction)) { return false; }
    LoyaltyProgramAccount existingLoyaltyProgramAccount = aTransaction.getLoyaltyProgramAccount();
    boolean isNewLoyaltyProgramAccount = existingLoyaltyProgramAccount != null && !this.equals(existingLoyaltyProgramAccount);
    if (isNewLoyaltyProgramAccount)
    {
      aTransaction.setLoyaltyProgramAccount(this);
    }
    else
    {
      transactions.add(aTransaction);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTransaction(PointTransaction aTransaction)
  {
    boolean wasRemoved = false;
    //Unable to remove aTransaction, as it must always have a loyaltyProgramAccount
    if (!this.equals(aTransaction.getLoyaltyProgramAccount()))
    {
      transactions.remove(aTransaction);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTransactionAt(PointTransaction aTransaction, int index)
  {  
    boolean wasAdded = false;
    if(addTransaction(aTransaction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransactions()) { index = numberOfTransactions() - 1; }
      transactions.remove(aTransaction);
      transactions.add(index, aTransaction);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTransactionAt(PointTransaction aTransaction, int index)
  {
    boolean wasAdded = false;
    if(transactions.contains(aTransaction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransactions()) { index = numberOfTransactions() - 1; }
      transactions.remove(aTransaction);
      transactions.add(index, aTransaction);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTransactionAt(aTransaction, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRedeemedRewards()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addRedeemedReward(Reward aRedeemedReward)
  {
    boolean wasAdded = false;
    if (redeemedRewards.contains(aRedeemedReward)) { return false; }
    redeemedRewards.add(aRedeemedReward);
    if (aRedeemedReward.indexOfLoyaltyProgramAccount(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aRedeemedReward.addLoyaltyProgramAccount(this);
      if (!wasAdded)
      {
        redeemedRewards.remove(aRedeemedReward);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeRedeemedReward(Reward aRedeemedReward)
  {
    boolean wasRemoved = false;
    if (!redeemedRewards.contains(aRedeemedReward))
    {
      return wasRemoved;
    }

    int oldIndex = redeemedRewards.indexOf(aRedeemedReward);
    redeemedRewards.remove(oldIndex);
    if (aRedeemedReward.indexOfLoyaltyProgramAccount(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aRedeemedReward.removeLoyaltyProgramAccount(this);
      if (!wasRemoved)
      {
        redeemedRewards.add(oldIndex,aRedeemedReward);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addRedeemedRewardAt(Reward aRedeemedReward, int index)
  {  
    boolean wasAdded = false;
    if(addRedeemedReward(aRedeemedReward))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRedeemedRewards()) { index = numberOfRedeemedRewards() - 1; }
      redeemedRewards.remove(aRedeemedReward);
      redeemedRewards.add(index, aRedeemedReward);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRedeemedRewardAt(Reward aRedeemedReward, int index)
  {
    boolean wasAdded = false;
    if(redeemedRewards.contains(aRedeemedReward))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRedeemedRewards()) { index = numberOfRedeemedRewards() - 1; }
      redeemedRewards.remove(aRedeemedReward);
      redeemedRewards.add(index, aRedeemedReward);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRedeemedRewardAt(aRedeemedReward, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToOptionalOne */
  public boolean setClient(Client aNewClient)
  {
    boolean wasSet = false;
    if (aNewClient == null)
    {
      //Unable to setClient to null, as loyaltyAccount must always be associated to a client
      return wasSet;
    }
    
    LoyaltyProgramAccount existingLoyaltyAccount = aNewClient.getLoyaltyAccount();
    if (existingLoyaltyAccount != null && !equals(existingLoyaltyAccount))
    {
      //Unable to setClient, the current client already has a loyaltyAccount, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Client anOldClient = client;
    client = aNewClient;
    client.setLoyaltyAccount(this);

    if (anOldClient != null)
    {
      anOldClient.setLoyaltyAccount(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    loyaltyprogramaccountsByMemberNumber.remove(getMemberNumber());
    for(int i=transactions.size(); i > 0; i--)
    {
      PointTransaction aTransaction = transactions.get(i - 1);
      aTransaction.delete();
    }
    ArrayList<Reward> copyOfRedeemedRewards = new ArrayList<Reward>(redeemedRewards);
    redeemedRewards.clear();
    for(Reward aRedeemedReward : copyOfRedeemedRewards)
    {
      aRedeemedReward.removeLoyaltyProgramAccount(this);
    }
    Client existingClient = client;
    client = null;
    if (existingClient != null)
    {
      existingClient.setLoyaltyAccount(null);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "memberNumber" + ":" + getMemberNumber()+ "," +
            "pointsBalance" + ":" + getPointsBalance()+ "," +
            "tier" + ":" + getTier()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "enrollmentDate" + "=" + (getEnrollmentDate() != null ? !getEnrollmentDate().equals(this)  ? getEnrollmentDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "client = "+(getClient()!=null?Integer.toHexString(System.identityHashCode(getClient())):"null");
  }
}