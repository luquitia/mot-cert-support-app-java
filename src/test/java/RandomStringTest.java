import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomStringTest {

    @Test
    public void testRandomStringCanBeCreated() {
        RandomString random_string_var = new RandomString(10);
        //create an object that will create a random string with length of 10
        String created_string_var = random_string_var.nextString();
        //store a value for a randomized string; at a later point this could be looped
        assertEquals(10, created_string_var.length());
        //verify the generated string has exactly 10 characters
    }
}
