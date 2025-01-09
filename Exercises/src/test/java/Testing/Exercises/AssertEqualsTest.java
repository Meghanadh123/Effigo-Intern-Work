package Testing.Exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import Testing.Exercises.StringUtilities;
import org.junit.jupiter.api.Test;

public class AssertEqualsTest {

    @Test
    public void myTest() {
        String s = "hello";
        String y = "xyz";
        String v = null;
        StringUtilities utility = new StringUtilities();
               assertEquals(5, utility.count(s));
    }
}
