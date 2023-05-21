import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestCrossSum {

    @Test
    public void TestCrossSum1(){
        CrossSum testCrossSum = new CrossSum();
        int returnedChecksum = testCrossSum.checksum("Hallo Welt!");
        assertEquals(91, returnedChecksum);
    }

    @Test
    public void TestCrossSum2(){
        CrossSum testCrossSum = new CrossSum();
        int returnedChecksum = testCrossSum.checksum("123-456-789");
        assertEquals(99, returnedChecksum);
    }

    @Test
    public void TestCrossSum3(){
        CrossSum testCrossSum = new CrossSum();
        int returnedChecksum = testCrossSum.checksum("%r [%t] %-5p %c %x - %m%n");
        assertEquals(199, returnedChecksum);
    }

}
