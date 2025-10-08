/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.sql.Date;
import java.util.*;

/**
 * Student clients
 */
// line 107 "model.ump"
// line 261 "model.ump"
public class Student extends Client
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Student Attributes
  private String universityName;
  private String studentId;
  private String program;
  private Date expectedGraduation;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Student(String aFirstName, String aLastName, Date aDateOfBirth, String aSocialInsuranceNumber, String aPhoneNumber, String aEmail, String aAddress, int aClientId, Date aRegistrationDate, String aClientStatus, BMO aBMO, String aUniversityName, String aStudentId, String aProgram, Date aExpectedGraduation)
  {
    super(aFirstName, aLastName, aDateOfBirth, aSocialInsuranceNumber, aPhoneNumber, aEmail, aAddress, aClientId, aRegistrationDate, aClientStatus, aBMO);
    universityName = aUniversityName;
    studentId = aStudentId;
    program = aProgram;
    expectedGraduation = aExpectedGraduation;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUniversityName(String aUniversityName)
  {
    boolean wasSet = false;
    universityName = aUniversityName;
    wasSet = true;
    return wasSet;
  }

  public boolean setStudentId(String aStudentId)
  {
    boolean wasSet = false;
    studentId = aStudentId;
    wasSet = true;
    return wasSet;
  }

  public boolean setProgram(String aProgram)
  {
    boolean wasSet = false;
    program = aProgram;
    wasSet = true;
    return wasSet;
  }

  public boolean setExpectedGraduation(Date aExpectedGraduation)
  {
    boolean wasSet = false;
    expectedGraduation = aExpectedGraduation;
    wasSet = true;
    return wasSet;
  }

  public String getUniversityName()
  {
    return universityName;
  }

  public String getStudentId()
  {
    return studentId;
  }

  public String getProgram()
  {
    return program;
  }

  public Date getExpectedGraduation()
  {
    return expectedGraduation;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "universityName" + ":" + getUniversityName()+ "," +
            "studentId" + ":" + getStudentId()+ "," +
            "program" + ":" + getProgram()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "expectedGraduation" + "=" + (getExpectedGraduation() != null ? !getExpectedGraduation().equals(this)  ? getExpectedGraduation().toString().replaceAll("  ","    ") : "this" : "null");
  }
}