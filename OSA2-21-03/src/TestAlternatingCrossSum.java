import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestAlternatingCrossSum {

    @Test
    public void TestAlternatingCrossSum1(){
        AlternatingCrossSum testCrossSum = new AlternatingCrossSum();
        int returnedChecksum = testCrossSum.checksum("Hallo Welt!");
        assertEquals(7, returnedChecksum);
    }

    @Test
    public void TestAlternatingCrossSum2(){
        AlternatingCrossSum testCrossSum = new AlternatingCrossSum();
        int returnedChecksum = testCrossSum.checksum("123-456-789");
        assertEquals(5, returnedChecksum);
    }

    @Test
    public void TestAlternatingCrossSum3(){
        AlternatingCrossSum testCrossSum = new AlternatingCrossSum();
        int returnedChecksum = testCrossSum.checksum("%r [%t] %-5p %c %x - %m%n");
        assertEquals(13, returnedChecksum);
    }
}