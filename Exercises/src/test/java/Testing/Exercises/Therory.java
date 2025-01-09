package Testing.Exercises;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Therory {
	@BeforeAll
    public static void setup() {
        System.out.println("first");
    }

    @AfterAll
    public static void teardown() {
        System.out.println("last");
    }

    @Test
    public void test1() {
        System.out.println("now running test 1");
    }

    @Test
    public void test2() {
        System.out.println("now running test 2");
    }
}
