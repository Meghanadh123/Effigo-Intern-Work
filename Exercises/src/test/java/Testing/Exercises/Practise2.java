package Testing.Exercises;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Practise2 {
		int x=2;
		int y=2;
		int z=3;
		boolean a=(x==y);//true
		boolean b=(y==z);//false
		
		@Test
		public void test1()
		{
			assertTrue(a);
		}
		
		@Test
		public void test2()
		{
			assertFalse(false);
		}
}
