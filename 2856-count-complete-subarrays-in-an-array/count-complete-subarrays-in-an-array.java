class Solution {
    public int countCompleteSubarrays(int[] nums) {

        // Find total number of distinct elements
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int totalDistinct = set.size();

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {

            // Add current element
            map.put(nums[right],
                    map.getOrDefault(nums[right], 0) + 1);

            // Window is complete
            while (map.size() == totalDistinct) {

                // Every subarray starting from 0 to left
                // and ending at right is complete
                ans += nums.length - right;

                // Remove nums[left]
                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }

                left++;
            }
        }

        return ans;
    }
}