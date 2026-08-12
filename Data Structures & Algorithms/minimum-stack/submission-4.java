class MinStack {

    private ArrayDeque<Integer> q;
    private ArrayDeque<Integer> minQ;

    public MinStack() {
        q = new ArrayDeque<>();
        minQ = new ArrayDeque<>();
    }
    
    public void push(int val) {
        q.push(val);
        if(minQ.isEmpty() || val <= minQ.peek()) {
            minQ.push(val);
        }
    }
    
    public void pop() {
        if (q.isEmpty()) {
            return;
        }

        int top = q.pop();
        if (top == minQ.peek()) {
            minQ.pop();
        }
    }
    
    public int top() {
        return q.peek();
    }
    
    public int getMin() {
        return minQ.peek();
    }
}
