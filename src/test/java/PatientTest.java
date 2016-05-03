import org.sql2o.*;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
// import java.util.Arrays;

public class PatientTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/doctors_office_test", null, null);
  }

  @After
  public void tearDown(){
    try (Connection con = DB.sql2o.open()){
      String deletePatientsQuery = "DELETE FROM patients *";
      String deleteDoctorsQuery = "DELETE FROM doctors *";
      con.createQuery(deletePatientsQuery).executeUpdate();
      con.createQuery(deleteDoctorsQuery).executeUpdate();
    }
  }

  @Test
  public void Patient_instantiatesCorrectly_true(){
    Patient newPatient = new Patient("Luca Pasta", "5/18/1987");
    assertTrue(newPatient instanceof Patient);
  }

  @Test
  public void Patient_returnsName_Luca(){
    Patient newPatient = new Patient("Luca Pasta", "5/18/1987");
    assertEquals("Luca Pasta", newPatient.getName());
  }

  @Test
  public void Patient_returnsBirthdate_birthdateString(){
    Patient newPatient = new Patient("Luca Pasta", "5/18/1987");
    assertEquals("5/18/1987", newPatient.getBirthdate());
  }

  @Test
  public void assignDoctor_assignDoctorIDCorrectly_1(){
    Patient newPatient = new Patient("Luca Pasta", "5/18/1987");
    newPatient.assignDoctor(1);
    assertEquals(1, newPatient.getDoctorID());
  }

  @Test
  public void getDoctorID_returnsDoctorID_1(){
    Patient newPatient = new Patient("Luca Pasta", "5/18/1987");
    newPatient.assignDoctor(1);
    assertEquals(1, newPatient.getDoctorID());
  }

  @Test
  public void allisEmptyAtFirst(){
    assertEquals(Patient.all().size(), 0);
  }

  @Test
  public void equalsReturnTrueWhenTwoObjectsAreTheSame(){
    Patient newPatient = new Patient("Luca Pasta", "5/18/1987");
    Patient newPatient2 = new Patient("Luca Pasta", "5/18/1987");
    assertTrue(newPatient.equals(newPatient2));
  }

  @Test
  public void save_saveCorrectly_true(){
    Patient newPatient = new Patient("Luca Pasta", "5/18/1987");
    newPatient.save();
    assertTrue(Patient.all().get(0).equals(newPatient));
  }

  @Test
  public void find_patientCorrectly_true(){
    Patient newPatient = new Patient("Luca Pasta", "5/18/1987");
    newPatient.save();
    Patient savedPatient = Patient.find(newPatient.getId());
    assertTrue(newPatient.equals(savedPatient));
  }

}
