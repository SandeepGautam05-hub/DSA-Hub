class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int r=cardPoints.length-1;
        int leftsum = 0;
        int maxsum;
        int rightsum = 0;
        for(int i=0;i<k;i++)
        {
            leftsum =  leftsum+cardPoints[i];
        }
        maxsum = leftsum;

        for(int i=k-1; i>=0; i--)
        {
            leftsum = leftsum-cardPoints[i];
            rightsum += cardPoints[r];
            maxsum = Math.max(maxsum, (leftsum+rightsum));
            r--;  
        }
        return maxsum;
    }
}