class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i< nums.length; i++)
        {
            int a=nums[i];
            if(map.containsKey(a))
            {
                map.put(a,map.get(a)+1);}
                else{
                map.put(a,1);
            }
        }
        int max =0;

        for(int frequency:map.values())
        {
            if(frequency>max)
            max = frequency;
        }

        int sum=0;
        for(int frequency:map.values())
        {
            if(frequency==max)
            sum+=frequency;
        }
        return sum;
    }
}