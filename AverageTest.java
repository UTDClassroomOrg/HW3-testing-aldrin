import static org.junit.Assert.*;
import org.junit.Test;

public class AverageTest {

    @Test
    public void testAverageWithFirstKElements() {
        Average avg = new Average();
        assertEquals(2, avg.average(3, new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testAverageWhenKExceedsArrayLength() {
        Average avg = new Average();
        assertEquals(3, avg.average(10, new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testAverageWhenKIsZero() {
        Average avg = new Average();
        assertEquals(0, avg.average(0, new int[]{1, 2, 3}));
    }

    @Test
    public void testAverageWithEmptyArray() {
        Average avg = new Average();
        assertEquals(0, avg.average(5, new int[]{}));
    }

    @Test
    public void testAverageWithNegativeAndPositiveValues() {
        Average avg = new Average();
        assertEquals(0, avg.average(2, new int[]{-3, 3, 6}));
    }
}
