import java.util.List;
import org.sql2o.*;
// import java.util.Arrays;

public class Patient {
  private String name;
  private String birthdate;
  private int doctorId;

  public Patient (String name, String birthdate, int doctorId){
    this.name = name;
    this.birthdate = birthdate;
    this.doctorId = doctorId;
  }

  public String getName(){
    return name;
  }

  public String getBirthdate(){
    return birthdate;
  }

  public int getDoctorID(){
    return doctorId;
  }


}
