//Here Time Complexity is O(1)
//And Space Complexity is O(n)
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;
    public MinStack() {
        stack=new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int value) {
        if(stack.isEmpty()){
            min = value;
            stack.push(min);
            minStack.push(min);
            return;
        }

        if(value < min){
            min = value;
            stack.push(value);
            minStack.push(min);
        }
        else{
            stack.push(value);
            minStack.push(min);
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            minStack.pop();
            //Updating the min after is important
            if(!minStack.isEmpty()){
                min = minStack.peek();
            }
            else{
                min = Integer.MAX_VALUE;
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
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