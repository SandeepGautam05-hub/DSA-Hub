class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, int start,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Add the current subset
        result.add(new ArrayList<>(current));

        int i = start;

        while (i < nums.length) {

            // Skip duplicate elements at the same level
            if (i > start && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }

            // Include the current element
            current.add(nums[i]);

            // Recursive call
            backtrack(nums, i + 1, current, result);

            // Backtracking
            current.remove(current.size() - 1);

            i++;
        }
    }
}