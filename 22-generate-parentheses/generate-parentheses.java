class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        valid("",0,0,n,ans);
        return ans;
    }
        void valid(String s, int open, int close , int n, List<String>ans)
        {
            if(s.length()==2*n)
            {
                ans.add(s);
                return ;
            }
            if(open <n)
            {
                valid(s + "(", open+1, close, n, ans);
            }
            if(close < open)
            {
                valid(s +")", open, close+1, n, ans);
            }
        }
}