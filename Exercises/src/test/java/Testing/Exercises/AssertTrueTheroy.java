package Testing.Exercises;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AssertTrueTheroy {
	
	@Test
	public void test1()
	{
		assertTrue(true);
	}
	
	@Test
	public void test2()
	{
		assertTrue(2==2);
	}
	@Test
	public void test3()
	{
		assertTrue("abc".length()==3);
	}
}
