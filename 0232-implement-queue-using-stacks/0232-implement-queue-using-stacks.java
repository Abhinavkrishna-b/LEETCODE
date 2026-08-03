//Push Time Complexity- O(n)
//Pop Time Complexity- O(1)
//Space- O(n)
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer>s2;
    int front; //To track the peek()
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        front = 0;
    }
    
    public void push(int x) {
        if(s1.isEmpty()){
            s1.push(x);
            front = x;
            return;
        }
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        //Ensure not poping in empty stack
        if(!s1.isEmpty()){
            int res = s1.pop();
            //To reassign front we need to ensure now the stack is not empty
            if(s1.isEmpty()){
                front = 0;
            }
            else{
                front = s1.peek(); //This peek is the peek of stack don't confuse it with the queue peek function below
            }
            return res;
        }
        return -1;
    }
    
    //This is the peek of queue don't confuse it with s1.peek()
    public int peek() {
        return front;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
 