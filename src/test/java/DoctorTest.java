import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;


public class DoctorTest {

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
  public void Doctor_instantiatesCorrectly_true() {
    Doctor newDoctor = new Doctor("John Doe", "Surgery");
    assertTrue(newDoctor instanceof Doctor);
  }

  @Test
  public void Doctor_instantiatesWithNameAndSpecialty_String() {
    Doctor newDoctor = new Doctor("John Doe", "Surgery");
    assertEquals("John Doe", newDoctor.getName());
    assertEquals("Surgery", newDoctor.getSpecialty());
  }

}
