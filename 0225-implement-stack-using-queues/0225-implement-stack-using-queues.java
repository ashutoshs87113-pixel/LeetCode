class MyStack {

Queue<Integer> q = new LinkedList<>();
Queue<Integer> q1 = new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
       while(q.size() > 1){
        q1.add(q.remove());
       } 
       int k = q.remove();
     
     while(q1.size() > 0){
        q.add(q1.remove());
       } 
      return k;
    }
    
    public int top() {
     while(q.size() > 1){
        q1.add(q.remove());
       } 
       int k = q.remove();
     
     while(q1.size() > 0){
        q.add(q1.remove());
       } 
       q.add(k);
      return k;
    }
    
    public boolean empty() {
        return (q.size() == 0);
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