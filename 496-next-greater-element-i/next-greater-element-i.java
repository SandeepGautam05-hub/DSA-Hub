import java.util.*;

class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // Map to store:
        // element -> next greater element
        HashMap<Integer, Integer> map = new HashMap<>();

        // Monotonic decreasing stack
        Stack<Integer> stack = new Stack<>();

        // Traverse nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {

            int current = nums2[i];

            // Remove elements smaller than or equal to current
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            // If stack is empty, no greater element exists
            if (stack.isEmpty()) {
                map.put(current, -1);
            } 
            else {
                map.put(current, stack.peek());
            }

            // Add current element to stack
            stack.push(current);
        }

        // Build answer for nums1
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}