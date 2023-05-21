public class CrossSum implements Checksum {

    /**
     * This function calculates the cross sum for a string.
     * It does that by converting the string into it's bytes and then adding each digit of each byte together to the
     * checksum.
     * @param input a string to calculate the checksum from
     * @return the checksum
     */
    @Override
    public int checksum(String input) {
        byte[] bytes = input.getBytes();
        int sum = 0;
        for (byte b : bytes) {
            while ( b > 0 ) {
                sum += b % 10;
                b /= 10;
            }
        }
        return sum;
    }
}
