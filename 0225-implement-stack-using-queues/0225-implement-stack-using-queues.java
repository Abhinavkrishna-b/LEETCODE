//Time Complexity- push/enqueue- O(1)   pop/dequeue- O(n)   peek- O(n)
//Space Complexity- O(n)
class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        if(!q1.isEmpty()){
            while(q1.size() > 1){
                q2.add(q1.remove());
            }
            int removedVal = q1.remove();
            //Instead of swapping all the values of q1 and q2 just swap the reference obj of q1 and q2
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            //Just like normal variable swap without temp the obj of q1 is lost

            return removedVal;
        }
        return -1;
    }
    
    public int top() {
        if(!q1.isEmpty()){
            while(q1.size() > 1){
                q2.add(q1.remove());
            }
            int res = q1.remove();//Or also you can use q1.peek();
            q2.add(res);

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;

            return res;
        }
        return -1;
    }
    
    public boolean empty() {
        if(q1.isEmpty() && q2.isEmpty()){
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */