// class Solution {
//     public String shortestCommonSupersequence(String str1, String str2) {
        
//     }
// }

// class Solution {
//     public String shortestCommonSupersequence(String str1, String str2) {

//         int m = str1.length();
//         int n = str2.length();

//         int[][] dp = new int[m + 1][n + 1];

//         // Find LCS
//         for (int i = 1; i <= m; i++) {
//             for (int j = 1; j <= n; j++) {

//                 if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
//                     dp[i][j] = 1 + dp[i - 1][j - 1];
//                 } else {
//                     dp[i][j] = Math.max(
//                         dp[i - 1][j],
//                         dp[i][j - 1]
//                     );
//                 }
//             }
//         }

//         // Reconstruct LCS
//         StringBuilder lcs = new StringBuilder();

//         int i = m;
//         int j = n;

//         while (i > 0 && j > 0) {

//             if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
//                 lcs.append(str1.charAt(i - 1));
//                 i--;
//                 j--;
//             } else if (dp[i - 1][j] > dp[i][j - 1]) {
//                 i--;
//             } else {
//                 j--;
//             }
//         }

//         lcs.reverse();

//         // Remove LCS characters from str1
//         StringBuilder remaining = new StringBuilder(str1);

//         for (int k = 0; k < lcs.length(); k++) {
//             char ch = lcs.charAt(k);

//             int index = remaining.indexOf(String.valueOf(ch));

//             if (index != -1) {
//                 remaining.deleteCharAt(index);
//             }
//         }

//         // Combine remaining str1 with str2
//         return remaining.toString() + str2;
//     }
// }

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Find LCS
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(
                        dp[i - 1][j],
                        dp[i][j - 1]
                    );
                }
            }
        }

        // Reconstruct LCS
        StringBuilder lcs = new StringBuilder();

        int i = m;
        int j = n;

        while (i > 0 && j > 0) {

            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        lcs.reverse();

        // Remove LCS characters from str1
        StringBuilder remaining = new StringBuilder(str1);

        for (int k = 0; k < lcs.length(); k++) {
            char ch = lcs.charAt(k);

            int index = remaining.indexOf(String.valueOf(ch));

            if (index != -1) {
                remaining.deleteCharAt(index);
            }
        }

        // Combine both strings
        String result = remaining.toString() + str2;

        // Validate both subsequences
        if (isSubsequence(str1, result) &&
            isSubsequence(str2, result)) {
            return result;
        }

        // Fallback: construct SCS correctly using the LCS table
        return buildSCS(str1, str2, dp);
    }

    boolean isSubsequence(String s, String result) {
        int i = 0;

        for (int j = 0; j < result.length() && i < s.length(); j++) {
            if (s.charAt(i) == result.charAt(j)) {
                i++;
            }
        }

        return i == s.length();
    }

    String buildSCS(String str1, String str2, int[][] dp) {
        StringBuilder ans = new StringBuilder();

        int i = str1.length();
        int j = str2.length();

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                ans.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                ans.append(str1.charAt(i - 1));
                i--;
            } else {
                ans.append(str2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            ans.append(str1.charAt(--i));
        }

        while (j > 0) {
            ans.append(str2.charAt(--j));
        }

        return ans.reverse().toString();
    }
}