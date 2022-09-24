class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        int size = q.size();
        size--;
        int topOfStack = q.remove();
        while(size--> 0){
            q.add(topOfStack);
            topOfStack = q.remove();
        }
        return topOfStack;
    }
    
    public int top() {
        int size = q.size();
        int topOfStack = 0;
        while(size--> 0){
            topOfStack = q.remove();
            q.add(topOfStack);
        }
        return topOfStack;
    }
    
    public boolean empty() {
        return q.isEmpty();
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