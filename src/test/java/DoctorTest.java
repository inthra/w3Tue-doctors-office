import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;


public class DoctorTest {

  @Test
  public void Doctor_instantiatesCorrectly_true() {
    Doctor newDoctor = new Doctor("John Doe", "Surgery");
    assertTrue(newDoctor instanceof Doctor);
  }
}
