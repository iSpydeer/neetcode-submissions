class MinStack {

    private ArrayDeque<Integer> q;
    private ArrayDeque<Integer> minQ;

    private int minVal;

    public MinStack() {
        q = new ArrayDeque<>();
        minQ = new ArrayDeque<>();
        minVal = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        q.push(val);
        if (val <= minVal) {
            minVal = val;
            minQ.push(val);
        }
    }
    
    public void pop() {
        System.out.println("Pop q.peek: " + q.peek() + ", minQpeek: " + minQ.peek());
        if(q.pop().intValue() == minQ.peek().intValue()) {
            minQ.pop();
            minVal = minQ.peek() != null ? minQ.peek() : Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return q.peek();
    }
    
    public int getMin() {
        return minQ.peek();
    }
}
