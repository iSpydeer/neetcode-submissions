class Solution {
    public int calPoints(String[] operations) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (String operation : operations) {
            if ("+".equals(operation)) {
                int val2 = q.pop();
                int val1 = q.peek();
                q.push(val2);
                q.push(val1 + val2);
            } else if ("D".equals(operation)) {
                q.push(2 * q.peek());
            } else if ("C".equals(operation)) {
                q.pop();
            } else {
                q.push(Integer.parseInt(operation));
            }
        }

        int sum = 0;
        while (!q.isEmpty()) {
            sum+=q.pop();
        }
        return sum;
    }
}