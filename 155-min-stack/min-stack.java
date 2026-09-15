class MinStack {
    Stack<Long>st;
    long mini=0;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            mini=value;
            st.push((long)value);
        }
        else{
            if(value>mini){
                st.push((long)value);
            }
            else{
                st.push(2L*value-mini);
                mini=value;
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }
        long n=st.pop();
        if(n<mini){
            mini=2L*mini-n;
        }
    }
    
    public int top() {
        long n=st.peek();
        if(n<mini){
            return (int)mini;
        }
        return (int)n;
    }
    
    public int getMin() {
        return (int)mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */