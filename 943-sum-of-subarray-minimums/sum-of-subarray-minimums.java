// class Solution {
//     public int sumSubarrayMins(int[] arr) {

//         int n = arr.length;
//         long sum = 0;

//         for (int i = 0; i < n; i++) {

//             int min = Integer.MAX_VALUE;

//             for (int j = i; j < n; j++) {

//                 min = Math.min(min, arr[j]);

//                 sum += min;
//             }
//         }

//         return (int)(sum % 1000000007);
//     }
// }


class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        int MOD = 1000000007;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        // Find previous smaller element
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                left[i] = i + 1;
            } else {
                left[i] = i - st.peek();
            }

            st.push(i);
        }

        st.clear();

        // Find next smaller element
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                right[i] = n - i;
            } else {
                right[i] = st.peek() - i;
            }

            st.push(i);
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {

            long contribution =
                    (long) arr[i] * left[i] * right[i];

            sum = (sum + contribution) % MOD;
        }

        return (int) sum;
    }
}