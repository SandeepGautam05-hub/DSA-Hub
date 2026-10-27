class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        generate(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    void generate(int[] nums, int index, List<Integer> current,
                  List<List<Integer>> ans) {

        // Base case
        if (index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Don't take nums[index]
        generate(nums, index + 1, current, ans);

        // Take nums[index]
        current.add(nums[index]);
        generate(nums, index + 1, current, ans);

        // Backtrack
        current.remove(current.size() - 1);
    }
}