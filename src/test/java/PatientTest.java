import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
// import java.util.Arrays;

public class PatientTest {

  @Test
  public void Patient_instantiatesCorrectly_true(){
    Patient newPatient = new Patient("Luca Pasta", "5/18/1987", 1);
    assertTrue(newPatient instanceof Patient);
  }

  @Test
  public void Patient_returnsName_Luca(){
    Patient newPatient = new Patient("Luca Pasta", "5/18/1987", 1);
    assertEquals("Luca Pasta", newPatient.getName());
  }

  @Test
  public void Patient_returnsBirthdate_birthdateString(){
    Patient newPatient = new Patient("Luca Pasta", "5/18/1987", 1);
    assertEquals("5/18/1987", newPatient.getBirthdate());
  }

  @Test
  public void Patient_returnsDoctorID_1(){
    Patient newPatient = new Patient("Luca Pasta", "5/18/1987", 1);
    assertEquals(1, newPatient.getDoctorID());
  }


}
