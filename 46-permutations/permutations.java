class Solution {
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        int start =0;
        generate(nums,start,ans);
        return ans;
    }

    public static void swap(int[] arr, int i, int j) 
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    void generate(int[] nums, int start,List<List<Integer>> ans)
        {
            if(start==nums.length)
            {
                List<Integer> temp = new ArrayList<>();
                for (int num : nums) 
                {
                    temp.add(num);
                }
                ans.add(temp);
                return;
            }

            for(int i=start; i<nums.length; i++)
            {
                swap(nums, start,i);
                generate(nums,start+1,ans);

                //backtracking

                swap(nums, start,i);
            }
        }
}