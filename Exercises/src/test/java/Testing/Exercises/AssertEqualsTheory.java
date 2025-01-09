package Testing.Exercises;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.*;
import org.junit.jupiter.api.Test;


public class AssertEqualsTheory {
	
	@Test
	public void myTest()
	{
		assertEquals(2,2);
		System.out.println("Hello");
	}
	
	@Test
	public void notEquals()
	{
		assertNotEquals(1,2);
		System.out.println("no");
	}
}
