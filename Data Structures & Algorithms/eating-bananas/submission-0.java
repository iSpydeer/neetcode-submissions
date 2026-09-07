class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int L = 0;
        int R = Arrays.stream(piles).max().getAsInt();
        int minK = R;
        
        while (L <= R) {
            int k = L + (R-L)/2;
            int currentH = calculate(piles, k);
            if (currentH > h) {
                L = k + 1;
            } else {
                R = k - 1;
                minK = k;
            }
        }
        return minK;
    }

    private int calculate(int[] piles, int k) {
        int currentH = 0;
        for (int pile : piles) {
            currentH += Math.ceil((double) pile/k);
        }
        return currentH;
    }
}
