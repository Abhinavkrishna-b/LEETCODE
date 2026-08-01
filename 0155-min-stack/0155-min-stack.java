//But Time Complexity is O(n) as we iterate in pop to find the next min value
class MinStack {
    Stack<Integer> stack;
    int min;
    public MinStack() {
        //Initialize the stack
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int value) {
        if(stack.isEmpty()){
            min = value;
        }
        else{
            min = Math.min(min,value);
        }
        stack.push(value);
    }
    
    public void pop() {
        int removed = stack.pop();
        if(removed == min){
            //We need to find the next min in the stack which time is O(n)
            if(stack.isEmpty()){
                //reset min to max value
                min = Integer.MAX_VALUE;
                return;
            }
            min = stack.peek();
            //This loop iterates the stack in FIFO order
            for(int num : stack){
                min = Math.min(min,num);
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
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