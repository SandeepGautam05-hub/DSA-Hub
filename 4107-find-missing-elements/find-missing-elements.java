class Solution {
    // Sandeep Gautam
    public List<Integer> findMissingElements(int[] nums) {
        int max = nums[0];
        int min = nums[0];

        for(int num : nums)
        {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        Set<Integer>set = new HashSet<>();

        for(int i=0; i< nums.length; i++)
        {
            set.add(nums[i]);
        }
        List<Integer> result = new ArrayList<>();

        for(int i=min; i<=max; i++)
        {
            if(!set.contains(i))
            result.add(i);
        }
        return result;
    }
}