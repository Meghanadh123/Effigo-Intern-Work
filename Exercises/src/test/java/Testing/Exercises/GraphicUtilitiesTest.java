package Testing.Exercises;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import Testing.Exercises.GraphicUtilities;
public class GraphicUtilitiesTest {
	@Test
	public void testDim() {
	    int[] pixel = {1, 2, 3};
	    GraphicUtilities.dim(pixel);
	    int[] expected = {0, 1, 2};
	    assertArrayEquals(expected, pixel);

	    GraphicUtilities.dim(pixel);
	    expected = new int[]{0, 0, 1}; //should not go below 0
	    assertArrayEquals(expected, pixel);
	}

	@Test
	public void testBrighten() {
	    int[] pixel = {0, 254, 254};
	    GraphicUtilities.brighten(pixel);
	    int[] expected = {1, 255, 255};
	    assertArrayEquals(expected, pixel);

	    GraphicUtilities.brighten(pixel);
	    expected = new int[]{2, 255, 255}; //should not go above 255
	    assertArrayEquals(expected, pixel);
	}

}
