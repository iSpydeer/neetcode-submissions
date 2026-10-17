class Solution {
    public int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        // rob2, rob1, n, n+1
        for (int num: nums) {
            int temp = Math.max(rob2 + num, rob1);
            rob2 = rob1;
            rob1 = temp;
        }

        return rob1;
    }
}
