class MinStack {
    Stack<int[]> st;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int value) {

        if (st.isEmpty()) {
            st.push(new int[]{value, value});
        } 
        else {
            int currentMin = Math.min(value, st.peek()[1]);
            st.push(new int[]{value, currentMin});
        }
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek()[0];
    }

    public int getMin() {
        return st.peek()[1];
    }
}