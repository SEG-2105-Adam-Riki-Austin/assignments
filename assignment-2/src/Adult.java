/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;
import java.sql.Date;

/**
 * Adult clients - base for all adult types
 */
// line 116 "model.ump"
// line 266 "model.ump"
public abstract class Adult extends Client
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Adult Attributes
  private String occupation;
  private double annualIncome;

  //Adult Associations
  private List<Minor> guardedMinor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Adult(String aFirstName, String aLastName, Date aDateOfBirth, String aSocialInsuranceNumber, String aPhoneNumber, String aEmail, String aAddress, int aClientId, Date aRegistrationDate, String aClientStatus, BMO aBMO, String aOccupation, double aAnnualIncome)
  {
    super(aFirstName, aLastName, aDateOfBirth, aSocialInsuranceNumber, aPhoneNumber, aEmail, aAddress, aClientId, aRegistrationDate, aClientStatus, aBMO);
    occupation = aOccupation;
    annualIncome = aAnnualIncome;
    guardedMinor = new ArrayList<Minor>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setOccupation(String aOccupation)
  {
    boolean wasSet = false;
    occupation = aOccupation;
    wasSet = true;
    return wasSet;
  }

  public boolean setAnnualIncome(double aAnnualIncome)
  {
    boolean wasSet = false;
    annualIncome = aAnnualIncome;
    wasSet = true;
    return wasSet;
  }

  public String getOccupation()
  {
    return occupation;
  }

  public double getAnnualIncome()
  {
    return annualIncome;
  }
  /* Code from template association_GetMany */
  public Minor getGuardedMinor(int index)
  {
    Minor aGuardedMinor = guardedMinor.get(index);
    return aGuardedMinor;
  }

  public List<Minor> getGuardedMinor()
  {
    List<Minor> newGuardedMinor = Collections.unmodifiableList(guardedMinor);
    return newGuardedMinor;
  }

  public int numberOfGuardedMinor()
  {
    int number = guardedMinor.size();
    return number;
  }

  public boolean hasGuardedMinor()
  {
    boolean has = guardedMinor.size() > 0;
    return has;
  }

  public int indexOfGuardedMinor(Minor aGuardedMinor)
  {
    int index = guardedMinor.indexOf(aGuardedMinor);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfGuardedMinor()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addGuardedMinor(Minor aGuardedMinor)
  {
    boolean wasAdded = false;
    if (guardedMinor.contains(aGuardedMinor)) { return false; }
    guardedMinor.add(aGuardedMinor);
    if (aGuardedMinor.indexOfGuardian(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aGuardedMinor.addGuardian(this);
      if (!wasAdded)
      {
        guardedMinor.remove(aGuardedMinor);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeGuardedMinor(Minor aGuardedMinor)
  {
    boolean wasRemoved = false;
    if (!guardedMinor.contains(aGuardedMinor))
    {
      return wasRemoved;
    }

    int oldIndex = guardedMinor.indexOf(aGuardedMinor);
    guardedMinor.remove(oldIndex);
    if (aGuardedMinor.indexOfGuardian(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aGuardedMinor.removeGuardian(this);
      if (!wasRemoved)
      {
        guardedMinor.add(oldIndex,aGuardedMinor);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addGuardedMinorAt(Minor aGuardedMinor, int index)
  {  
    boolean wasAdded = false;
    if(addGuardedMinor(aGuardedMinor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGuardedMinor()) { index = numberOfGuardedMinor() - 1; }
      guardedMinor.remove(aGuardedMinor);
      guardedMinor.add(index, aGuardedMinor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveGuardedMinorAt(Minor aGuardedMinor, int index)
  {
    boolean wasAdded = false;
    if(guardedMinor.contains(aGuardedMinor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGuardedMinor()) { index = numberOfGuardedMinor() - 1; }
      guardedMinor.remove(aGuardedMinor);
      guardedMinor.add(index, aGuardedMinor);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addGuardedMinorAt(aGuardedMinor, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Minor> copyOfGuardedMinor = new ArrayList<Minor>(guardedMinor);
    guardedMinor.clear();
    for(Minor aGuardedMinor : copyOfGuardedMinor)
    {
      if (aGuardedMinor.numberOfGuardian() <= Minor.minimumNumberOfGuardian())
      {
        aGuardedMinor.delete();
      }
      else
      {
        aGuardedMinor.removeGuardian(this);
      }
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "occupation" + ":" + getOccupation()+ "," +
            "annualIncome" + ":" + getAnnualIncome()+ "]";
  }
}