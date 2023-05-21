public class SingleDigitCrossSum extends CrossSum implements Checksum {

    /**
     * This function calculates the cross sum for a string.
     * It does that by converting the string into it's bytes and then adding each digit of each byte together to the
     * checksum. After that the resulting digits get summed together over and over again until there is only one digit.
     * @param input a string to calculate the checksum from
     * @return the checksum
     */
    @Override
    public int checksum(String input) {
        int sum = super.checksum(input);
        while (sum >= 10) {
            int tempSum = 0;
            while (sum > 0) {
                tempSum += sum % 10;
                sum /= 10;
            }
            sum = tempSum;
        }
        return sum;
    }

}
