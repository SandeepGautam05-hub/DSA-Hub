
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            // Odd-length palindrome
            int l = i;
            int r = i;

            while (l >= 0 && r < n &&
                   s.charAt(l) == s.charAt(r)) {

                if (r - l + 1 > maxLen) {
                    start = l;
                    maxLen = r - l + 1;
                }

                l--;
                r++;
            }

            // Even-length palindrome
            l = i;
            r = i + 1;

            while (l >= 0 && r < n &&
                   s.charAt(l) == s.charAt(r)) {

                if (r - l + 1 > maxLen) {
                    start = l;
                    maxLen = r - l + 1;
                }

                l--;
                r++;
            }
        }

        return s.substring(start, start + maxLen);
    }
}
