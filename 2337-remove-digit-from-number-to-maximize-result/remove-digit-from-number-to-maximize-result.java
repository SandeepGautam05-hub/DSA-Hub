class Solution {
    // Sandeep Gautam
    public String removeDigit(String number, char digit) {

        int lastIndex = -1;

        for (int i = 0; i < number.length(); i++) {

            if (number.charAt(i) == digit) {

                lastIndex = i;

                if (i + 1 < number.length()
                        && number.charAt(i + 1) > digit) {

                    return number.substring(0, i)
                         + number.substring(i + 1);
                }
            }
        }

        return number.substring(0, lastIndex)
             + number.substring(lastIndex + 1);
    }
}