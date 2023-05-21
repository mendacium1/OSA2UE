public class AlternatingCrossSum implements Checksum {

    /**
     * This function calculates the cross sum for a string.
     * It does that by converting the string into it's bytes and then adding/subtracting (alternating) each digit of
     * each byte.
     * Therefore, the output can be negative.
     * Note:
     * The approach from the other classes where the checksum-function separates the digits from the bytes via modulo
     * does not work in this case, since the most-significant digit must be taken first (the alternation would get
     * mixed up). Therefore, the simplest approach is converting the byte-values into char-arrays.
     * @param input a string to calculate the checksum from
     * @return the checksum
     */
    @Override
    public int checksum(String input) {
        byte[] bytes = input.getBytes();
        int sum = 0;
        int sign = 1;
        for (byte b : bytes) {
            char[] tmpChars = Byte.toString(b).toCharArray();
            for (char c : tmpChars) {
                sum += sign * (Character.getNumericValue(c));
                sign = -sign;
            }
        }
        return sum;
    }
}
