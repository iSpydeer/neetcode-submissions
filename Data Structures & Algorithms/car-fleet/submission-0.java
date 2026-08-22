class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a,b) -> Integer.compare(b[0], a[0]));
        Deque<Double> q = new ArrayDeque<>();

        for (int i=0; i<n; i++) {
            double time = (double) (target - pairs[i][0])/pairs[i][1];
            if(q.isEmpty()) {
                q.push(time);
            }else if (!q.isEmpty() && q.peek() < time) {
                q.push(time);
            }
        }

        return q.size();
    }
}
