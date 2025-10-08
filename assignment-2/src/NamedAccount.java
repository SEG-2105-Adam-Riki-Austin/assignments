/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;
import java.sql.Date;

/**
 * Account with nickname capability - intermediate class
 */
// line 19 "model.ump"
// line 216 "model.ump"
public abstract class NamedAccount extends Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //NamedAccount Attributes
  private String nickname;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public NamedAccount(int aAccountNumber, double aBalance, Date aOpenDate, String aStatus, Client aOwner, String aNickname)
  {
    super(aAccountNumber, aBalance, aOpenDate, aStatus, aOwner);
    nickname = aNickname;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNickname(String aNickname)
  {
    boolean wasSet = false;
    nickname = aNickname;
    wasSet = true;
    return wasSet;
  }

  public String getNickname()
  {
    return nickname;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "nickname" + ":" + getNickname()+ "]";
  }
}