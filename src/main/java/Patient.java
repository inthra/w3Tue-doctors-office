import java.util.List;
import org.sql2o.*;
// import java.util.Arrays;



public class Patient {
  private String name;
  private String birthdate;
  private int doctorId;
  private int id;

  public Patient (String name, String birthdate){
    this.name = name;
    this.birthdate = birthdate;
  }

  @Override
  public boolean equals(Object otherPatient){
    if (!(otherPatient instanceof Patient)){
      return false;
    } else {
      Patient newPatient = (Patient) otherPatient;
      return this.getName().equals(newPatient.getName()) && this.getBirthdate().equals(newPatient.getBirthdate());
    }
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

  public void assignDoctor(int doctorId){
    this.doctorId = doctorId;
  }

  public static List<Patient> all(){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT name, birthdate FROM patients";
      return con.createQuery(sql).executeAndFetch(Patient.class);
    }
  }

  public void save(){
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO patients (name, birthdate) values (:name, :birthdate)";
      con.createQuery(sql, true).addParameter("name", this.name)
      .addParameter("birthdate", this.birthdate)
      .executeUpdate();
    }
  }

  public static Patient find(int id){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT name, birthdate FROM patients WHERE id=:id";
      Patient newPatient =
      con.createQuery(sql).addParameter("id", id)
      .executeAndFetchFirst(Patient.class);
      return newPatient;
    }
  }

  public int getId(){ // to complete
    return id;
  }

}
