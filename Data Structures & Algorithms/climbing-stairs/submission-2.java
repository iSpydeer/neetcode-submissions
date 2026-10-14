class Solution {
    public int climbStairs(int n) {
        int prev = 1;
        int cur = 1;

        for (int i = 0; i < n - 1; i++) {
            int temp = cur;
            cur = cur + prev;
            prev = temp;
        }
        return cur;
    }
}
