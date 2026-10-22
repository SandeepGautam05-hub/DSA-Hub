
class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int mid = n / 2;

        String a = s.substring(0, mid);
        String b = s.substring(mid);

        int countA = 0;
        int countB = 0;

        for (int i = 0; i < mid; i++) {
            char ch1 = a.charAt(i);
            char ch2 = b.charAt(i);

            if (isVowel(ch1)) {
                countA++;
            }

            if (isVowel(ch2)) {
                countB++;
            }
        }

        return countA == countB;
    }

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}
