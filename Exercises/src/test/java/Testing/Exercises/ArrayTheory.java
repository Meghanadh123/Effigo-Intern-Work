package Testing.Exercises;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class ArrayTheory {
	@Test
    public void myTest() {

        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};

        int[] array3 = {1, 7, 7};
        int[] array4 = {1, 2, 3, 4};

//        assertArrayEquals(array1, array2); //pass: same length, same elements
//        assertArrayEquals(array2, array3); //fail: one or more different elements
        assertArrayEquals(array3, array4); //fail: different lengths
}
}
