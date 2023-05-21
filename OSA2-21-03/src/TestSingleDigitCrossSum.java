import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestSingleDigitCrossSum {

    @Test
    public void TestSingleDigitCrossSum1(){
        SingleDigitCrossSum testCrossSum = new SingleDigitCrossSum();
        int returnedChecksum = testCrossSum.checksum("Hallo Welt!");
        assertEquals(1, returnedChecksum);
    }

    @Test
    public void TestSingleDigitCrossSum2(){
        SingleDigitCrossSum testCrossSum = new SingleDigitCrossSum();
        int returnedChecksum = testCrossSum.checksum("123-456-789");
        assertEquals(9, returnedChecksum);
    }

    @Test
    public void TestSingleDigitCrossSum3(){
        SingleDigitCrossSum testCrossSum = new SingleDigitCrossSum();
        int returnedChecksum = testCrossSum.checksum("%r [%t] %-5p %c %x - %m%n");
        assertEquals(1, returnedChecksum);
    }
}