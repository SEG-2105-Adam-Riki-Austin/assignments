/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;
import java.sql.Date;

/**
 * ==================== BANK ENTITY ====================
 */
// line 200 "model.ump"
// line 306 "model.ump"
public class BMO
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static BMO theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BMO Associations
  private List<Client> activeClients;
  private List<NonBMOClient> potentialClient;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private BMO()
  {
    activeClients = new ArrayList<Client>();
    potentialClient = new ArrayList<NonBMOClient>();
  }

  public static BMO getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new BMO();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Client getActiveClient(int index)
  {
    Client aActiveClient = activeClients.get(index);
    return aActiveClient;
  }

  /**
   * Association with all BMO clients
   */
  public List<Client> getActiveClients()
  {
    List<Client> newActiveClients = Collections.unmodifiableList(activeClients);
    return newActiveClients;
  }

  public int numberOfActiveClients()
  {
    int number = activeClients.size();
    return number;
  }

  public boolean hasActiveClients()
  {
    boolean has = activeClients.size() > 0;
    return has;
  }

  public int indexOfActiveClient(Client aActiveClient)
  {
    int index = activeClients.indexOf(aActiveClient);
    return index;
  }
  /* Code from template association_GetMany */
  public NonBMOClient getPotentialClient(int index)
  {
    NonBMOClient aPotentialClient = potentialClient.get(index);
    return aPotentialClient;
  }

  public List<NonBMOClient> getPotentialClient()
  {
    List<NonBMOClient> newPotentialClient = Collections.unmodifiableList(potentialClient);
    return newPotentialClient;
  }

  public int numberOfPotentialClient()
  {
    int number = potentialClient.size();
    return number;
  }

  public boolean hasPotentialClient()
  {
    boolean has = potentialClient.size() > 0;
    return has;
  }

  public int indexOfPotentialClient(NonBMOClient aPotentialClient)
  {
    int index = potentialClient.indexOf(aPotentialClient);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfActiveClients()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */


  public boolean addActiveClient(Client aActiveClient)
  {
    boolean wasAdded = false;
    if (activeClients.contains(aActiveClient)) { return false; }
    BMO existingBMO = aActiveClient.getBMO();
    boolean isNewBMO = existingBMO != null && !this.equals(existingBMO);
    if (isNewBMO)
    {
      aActiveClient.setBMO(this);
    }
    else
    {
      activeClients.add(aActiveClient);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeActiveClient(Client aActiveClient)
  {
    boolean wasRemoved = false;
    //Unable to remove aActiveClient, as it must always have a bMO
    if (!this.equals(aActiveClient.getBMO()))
    {
      activeClients.remove(aActiveClient);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addActiveClientAt(Client aActiveClient, int index)
  {  
    boolean wasAdded = false;
    if(addActiveClient(aActiveClient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfActiveClients()) { index = numberOfActiveClients() - 1; }
      activeClients.remove(aActiveClient);
      activeClients.add(index, aActiveClient);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveActiveClientAt(Client aActiveClient, int index)
  {
    boolean wasAdded = false;
    if(activeClients.contains(aActiveClient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfActiveClients()) { index = numberOfActiveClients() - 1; }
      activeClients.remove(aActiveClient);
      activeClients.add(index, aActiveClient);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addActiveClientAt(aActiveClient, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPotentialClient()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public NonBMOClient addPotentialClient(String aFirstName, String aLastName, Date aDateOfBirth, String aSocialInsuranceNumber, String aPhoneNumber, String aEmail, String aAddress, String aPrimaryBankName, String aReasonForTracking, Date aTrackingStartDate)
  {
    return new NonBMOClient(aFirstName, aLastName, aDateOfBirth, aSocialInsuranceNumber, aPhoneNumber, aEmail, aAddress, aPrimaryBankName, aReasonForTracking, aTrackingStartDate, this);
  }

  public boolean addPotentialClient(NonBMOClient aPotentialClient)
  {
    boolean wasAdded = false;
    if (potentialClient.contains(aPotentialClient)) { return false; }
    BMO existingTrackedBy = aPotentialClient.getTrackedBy();
    boolean isNewTrackedBy = existingTrackedBy != null && !this.equals(existingTrackedBy);
    if (isNewTrackedBy)
    {
      aPotentialClient.setTrackedBy(this);
    }
    else
    {
      potentialClient.add(aPotentialClient);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePotentialClient(NonBMOClient aPotentialClient)
  {
    boolean wasRemoved = false;
    //Unable to remove aPotentialClient, as it must always have a trackedBy
    if (!this.equals(aPotentialClient.getTrackedBy()))
    {
      potentialClient.remove(aPotentialClient);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPotentialClientAt(NonBMOClient aPotentialClient, int index)
  {  
    boolean wasAdded = false;
    if(addPotentialClient(aPotentialClient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPotentialClient()) { index = numberOfPotentialClient() - 1; }
      potentialClient.remove(aPotentialClient);
      potentialClient.add(index, aPotentialClient);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePotentialClientAt(NonBMOClient aPotentialClient, int index)
  {
    boolean wasAdded = false;
    if(potentialClient.contains(aPotentialClient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPotentialClient()) { index = numberOfPotentialClient() - 1; }
      potentialClient.remove(aPotentialClient);
      potentialClient.add(index, aPotentialClient);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPotentialClientAt(aPotentialClient, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=activeClients.size(); i > 0; i--)
    {
      Client aActiveClient = activeClients.get(i - 1);
      aActiveClient.delete();
    }
    for(int i=potentialClient.size(); i > 0; i--)
    {
      NonBMOClient aPotentialClient = potentialClient.get(i - 1);
      aPotentialClient.delete();
    }
  }

}