class Solution {
    public String makeSmallestPalindrome(String s) {
        char arr[] = s.toCharArray();
        int i = 0, j=arr.length-1;

        while(i<j){
            if(arr[i]!=arr[j])
            {
                char min = (char)Math.min(arr[i],arr[j]);
                arr[i] = min;
                arr[j] = min;
            }
            i++;
            j--;
        }
        return new String(arr);
    }
}