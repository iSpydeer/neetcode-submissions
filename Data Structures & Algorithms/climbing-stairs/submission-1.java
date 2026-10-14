class Solution {
    public int climbStairs(int n) {
        // if (n <= 2) {
        //     return n;
        // }
        // return climbStairs(n-1) + climbStairs(n-2);
        return memoization(n, new HashMap<Integer, Integer>());
    }

    public int memoization(int n, HashMap<Integer, Integer> cache) {
        if (n <= 2) {
            return n;
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int result = memoization(n-1, cache) + memoization(n-2, cache);
        cache.put(n, result);
        return result;
    }
}
