class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++)
        {
            int curr = asteroids[i];
            while(curr<0 && !st.isEmpty() && st.peek()>0)
            {
                if(st.peek()<Math.abs(curr))
                {
                    st.pop();
                }
                else if(st.peek()==Math.abs(curr))
                {
                    st.pop();
                    curr=0;
                    break;
                }
                else if(st.peek()>Math.abs(curr))
                {
                    curr=0;
                    break;
                }
            }
            if(curr!=0)
            {
                st.push(curr);
            }
        }
        int result[] = new int[st.size()];
        for(int i=0; i<st.size(); i++)
        {
            result[i] = st.get(i);
        }
        return result;
    }
}