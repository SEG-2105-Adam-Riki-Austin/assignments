/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;
import java.sql.Date;

/**
 * Minor clients (under 18)
 */
// line 98 "model.ump"
// line 256 "model.ump"
public class Minor extends Client
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Minor Attributes
  private String schoolName;

  //Minor Associations
  private List<Adult> guardian;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Minor(String aFirstName, String aLastName, Date aDateOfBirth, String aSocialInsuranceNumber, String aPhoneNumber, String aEmail, String aAddress, int aClientId, Date aRegistrationDate, String aClientStatus, BMO aBMO, String aSchoolName, Adult... allGuardian)
  {
    super(aFirstName, aLastName, aDateOfBirth, aSocialInsuranceNumber, aPhoneNumber, aEmail, aAddress, aClientId, aRegistrationDate, aClientStatus, aBMO);
    schoolName = aSchoolName;
    guardian = new ArrayList<Adult>();
    boolean didAddGuardian = setGuardian(allGuardian);
    if (!didAddGuardian)
    {
      throw new RuntimeException("Unable to create Minor, must have 1 to 2 guardian. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSchoolName(String aSchoolName)
  {
    boolean wasSet = false;
    schoolName = aSchoolName;
    wasSet = true;
    return wasSet;
  }

  public String getSchoolName()
  {
    return schoolName;
  }
  /* Code from template association_GetMany */
  public Adult getGuardian(int index)
  {
    Adult aGuardian = guardian.get(index);
    return aGuardian;
  }

  /**
   * Association with guardian (must be an Adult)
   */
  public List<Adult> getGuardian()
  {
    List<Adult> newGuardian = Collections.unmodifiableList(guardian);
    return newGuardian;
  }

  public int numberOfGuardian()
  {
    int number = guardian.size();
    return number;
  }

  public boolean hasGuardian()
  {
    boolean has = guardian.size() > 0;
    return has;
  }

  public int indexOfGuardian(Adult aGuardian)
  {
    int index = guardian.indexOf(aGuardian);
    return index;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfGuardianValid()
  {
    boolean isValid = numberOfGuardian() >= minimumNumberOfGuardian() && numberOfGuardian() <= maximumNumberOfGuardian();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfGuardian()
  {
    return 1;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfGuardian()
  {
    return 2;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addGuardian(Adult aGuardian)
  {
    boolean wasAdded = false;
    if (guardian.contains(aGuardian)) { return false; }
    if (numberOfGuardian() >= maximumNumberOfGuardian())
    {
      return wasAdded;
    }

    guardian.add(aGuardian);
    if (aGuardian.indexOfGuardedMinor(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aGuardian.addGuardedMinor(this);
      if (!wasAdded)
      {
        guardian.remove(aGuardian);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMNToMany */
  public boolean removeGuardian(Adult aGuardian)
  {
    boolean wasRemoved = false;
    if (!guardian.contains(aGuardian))
    {
      return wasRemoved;
    }

    if (numberOfGuardian() <= minimumNumberOfGuardian())
    {
      return wasRemoved;
    }

    int oldIndex = guardian.indexOf(aGuardian);
    guardian.remove(oldIndex);
    if (aGuardian.indexOfGuardedMinor(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aGuardian.removeGuardedMinor(this);
      if (!wasRemoved)
      {
        guardian.add(oldIndex,aGuardian);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMNToMany */
  public boolean setGuardian(Adult... newGuardian)
  {
    boolean wasSet = false;
    ArrayList<Adult> verifiedGuardian = new ArrayList<Adult>();
    for (Adult aGuardian : newGuardian)
    {
      if (verifiedGuardian.contains(aGuardian))
      {
        continue;
      }
      verifiedGuardian.add(aGuardian);
    }

    if (verifiedGuardian.size() != newGuardian.length || verifiedGuardian.size() < minimumNumberOfGuardian() || verifiedGuardian.size() > maximumNumberOfGuardian())
    {
      return wasSet;
    }

    ArrayList<Adult> oldGuardian = new ArrayList<Adult>(guardian);
    guardian.clear();
    for (Adult aNewGuardian : verifiedGuardian)
    {
      guardian.add(aNewGuardian);
      if (oldGuardian.contains(aNewGuardian))
      {
        oldGuardian.remove(aNewGuardian);
      }
      else
      {
        aNewGuardian.addGuardedMinor(this);
      }
    }

    for (Adult anOldGuardian : oldGuardian)
    {
      anOldGuardian.removeGuardedMinor(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addGuardianAt(Adult aGuardian, int index)
  {  
    boolean wasAdded = false;
    if(addGuardian(aGuardian))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGuardian()) { index = numberOfGuardian() - 1; }
      guardian.remove(aGuardian);
      guardian.add(index, aGuardian);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveGuardianAt(Adult aGuardian, int index)
  {
    boolean wasAdded = false;
    if(guardian.contains(aGuardian))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfGuardian()) { index = numberOfGuardian() - 1; }
      guardian.remove(aGuardian);
      guardian.add(index, aGuardian);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addGuardianAt(aGuardian, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Adult> copyOfGuardian = new ArrayList<Adult>(guardian);
    guardian.clear();
    for(Adult aGuardian : copyOfGuardian)
    {
      aGuardian.removeGuardedMinor(this);
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "schoolName" + ":" + getSchoolName()+ "]";
  }
}