class Solution {
    public int numSquares(int n) {
        int minvalue = Integer.MAX_VALUE;

        while (n % 4 == 0) {
            n /= 4;
        }

        if (n % 8 == 7) {
            return 4;
        }

        if (isSquare(n)) {
            return 1;
        }

        for (int i = 1; i * i <= n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }

        return 3;
    }

    public boolean isSquare(int n) {
        int root = (int) Math.sqrt(n);
        return root * root == n;
    }
}

// class Solution {
//     public int numSquares(int n) {
//         int[] dp = new int[n + 1];

//         for (int i = 1; i <= n; i++) {
//             dp[i] = Integer.MAX_VALUE;

//             for (int j = 1; j * j <= i; j++) {
//                 dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
//             }
//         }

//         return dp[n];
//     }
// }