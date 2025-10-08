/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 189 "model.ump"
// line 301 "model.ump"
public class Reward
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Reward Attributes
  private int rewardId;
  private String name;
  private String description;
  private int pointsCost;
  private String category;
  private boolean isAvailable;

  //Reward Associations
  private List<LoyaltyProgramAccount> loyaltyProgramAccounts;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Reward(int aRewardId, String aName, String aDescription, int aPointsCost, String aCategory, boolean aIsAvailable)
  {
    rewardId = aRewardId;
    name = aName;
    description = aDescription;
    pointsCost = aPointsCost;
    category = aCategory;
    isAvailable = aIsAvailable;
    loyaltyProgramAccounts = new ArrayList<LoyaltyProgramAccount>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRewardId(int aRewardId)
  {
    boolean wasSet = false;
    rewardId = aRewardId;
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

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public boolean setPointsCost(int aPointsCost)
  {
    boolean wasSet = false;
    pointsCost = aPointsCost;
    wasSet = true;
    return wasSet;
  }

  public boolean setCategory(String aCategory)
  {
    boolean wasSet = false;
    category = aCategory;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsAvailable(boolean aIsAvailable)
  {
    boolean wasSet = false;
    isAvailable = aIsAvailable;
    wasSet = true;
    return wasSet;
  }

  public int getRewardId()
  {
    return rewardId;
  }

  public String getName()
  {
    return name;
  }

  public String getDescription()
  {
    return description;
  }

  public int getPointsCost()
  {
    return pointsCost;
  }

  /**
   * travel, cashback, merchandise, services
   */
  public String getCategory()
  {
    return category;
  }

  public boolean getIsAvailable()
  {
    return isAvailable;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isIsAvailable()
  {
    return isAvailable;
  }
  /* Code from template association_GetMany */
  public LoyaltyProgramAccount getLoyaltyProgramAccount(int index)
  {
    LoyaltyProgramAccount aLoyaltyProgramAccount = loyaltyProgramAccounts.get(index);
    return aLoyaltyProgramAccount;
  }

  public List<LoyaltyProgramAccount> getLoyaltyProgramAccounts()
  {
    List<LoyaltyProgramAccount> newLoyaltyProgramAccounts = Collections.unmodifiableList(loyaltyProgramAccounts);
    return newLoyaltyProgramAccounts;
  }

  public int numberOfLoyaltyProgramAccounts()
  {
    int number = loyaltyProgramAccounts.size();
    return number;
  }

  public boolean hasLoyaltyProgramAccounts()
  {
    boolean has = loyaltyProgramAccounts.size() > 0;
    return has;
  }

  public int indexOfLoyaltyProgramAccount(LoyaltyProgramAccount aLoyaltyProgramAccount)
  {
    int index = loyaltyProgramAccounts.indexOf(aLoyaltyProgramAccount);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfLoyaltyProgramAccounts()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addLoyaltyProgramAccount(LoyaltyProgramAccount aLoyaltyProgramAccount)
  {
    boolean wasAdded = false;
    if (loyaltyProgramAccounts.contains(aLoyaltyProgramAccount)) { return false; }
    loyaltyProgramAccounts.add(aLoyaltyProgramAccount);
    if (aLoyaltyProgramAccount.indexOfRedeemedReward(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aLoyaltyProgramAccount.addRedeemedReward(this);
      if (!wasAdded)
      {
        loyaltyProgramAccounts.remove(aLoyaltyProgramAccount);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeLoyaltyProgramAccount(LoyaltyProgramAccount aLoyaltyProgramAccount)
  {
    boolean wasRemoved = false;
    if (!loyaltyProgramAccounts.contains(aLoyaltyProgramAccount))
    {
      return wasRemoved;
    }

    int oldIndex = loyaltyProgramAccounts.indexOf(aLoyaltyProgramAccount);
    loyaltyProgramAccounts.remove(oldIndex);
    if (aLoyaltyProgramAccount.indexOfRedeemedReward(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aLoyaltyProgramAccount.removeRedeemedReward(this);
      if (!wasRemoved)
      {
        loyaltyProgramAccounts.add(oldIndex,aLoyaltyProgramAccount);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addLoyaltyProgramAccountAt(LoyaltyProgramAccount aLoyaltyProgramAccount, int index)
  {  
    boolean wasAdded = false;
    if(addLoyaltyProgramAccount(aLoyaltyProgramAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLoyaltyProgramAccounts()) { index = numberOfLoyaltyProgramAccounts() - 1; }
      loyaltyProgramAccounts.remove(aLoyaltyProgramAccount);
      loyaltyProgramAccounts.add(index, aLoyaltyProgramAccount);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveLoyaltyProgramAccountAt(LoyaltyProgramAccount aLoyaltyProgramAccount, int index)
  {
    boolean wasAdded = false;
    if(loyaltyProgramAccounts.contains(aLoyaltyProgramAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLoyaltyProgramAccounts()) { index = numberOfLoyaltyProgramAccounts() - 1; }
      loyaltyProgramAccounts.remove(aLoyaltyProgramAccount);
      loyaltyProgramAccounts.add(index, aLoyaltyProgramAccount);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addLoyaltyProgramAccountAt(aLoyaltyProgramAccount, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<LoyaltyProgramAccount> copyOfLoyaltyProgramAccounts = new ArrayList<LoyaltyProgramAccount>(loyaltyProgramAccounts);
    loyaltyProgramAccounts.clear();
    for(LoyaltyProgramAccount aLoyaltyProgramAccount : copyOfLoyaltyProgramAccounts)
    {
      aLoyaltyProgramAccount.removeRedeemedReward(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "rewardId" + ":" + getRewardId()+ "," +
            "name" + ":" + getName()+ "," +
            "description" + ":" + getDescription()+ "," +
            "pointsCost" + ":" + getPointsCost()+ "," +
            "category" + ":" + getCategory()+ "," +
            "isAvailable" + ":" + getIsAvailable()+ "]";
  }
}