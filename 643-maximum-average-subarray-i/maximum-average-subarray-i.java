class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0.0;
        
        for(int i=0; i<k; i++)
        {
            sum+=nums[i];
        }
        double MaxSum = sum;

        for(int i=k; i<nums.length; i++)
        {
            sum+=nums[i];
            sum-=nums[i-k];

            MaxSum = Math.max(MaxSum,sum);
        }

        return (MaxSum/k);
        
    }
}