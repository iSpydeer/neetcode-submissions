class MinStack {

    private ArrayDeque<Integer> q;
    private ArrayDeque<Integer> minQ;

    public MinStack() {
        q = new ArrayDeque<>();
        minQ = new ArrayDeque<>();
    }
    
    public void push(int val) {
        q.push(val);
        if (minQ.isEmpty() || val <= minQ.peek()) {
            minQ.push(val);
        } else {
            minQ.push(minQ.peek());
        }
    }
    
    public void pop() {
        q.pop();
        minQ.pop();
    }
    
    public int top() {
        return q.peek();
    }
    
    public int getMin() {
        return minQ.peek();
    }
}
