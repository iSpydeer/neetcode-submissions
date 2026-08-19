class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = temperatures.length-1; i >= 0; i--) {
            while (!q.isEmpty() && temperatures[i] >= temperatures[q.peek()]) {
                q.pop();
            }

            if (!q.isEmpty()) {
                result[i] = q.peek() - i;
            }

            q.push(i);
        }

        return result;
    }
}
