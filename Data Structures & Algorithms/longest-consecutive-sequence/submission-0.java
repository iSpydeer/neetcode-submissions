class Solution {
    public int longestConsecutive(int[] nums) {
        int ret = 0;
        int counter = 0;;
        HashSet<Integer> hset = new HashSet<>();
        for (int num : nums) {
            hset.add(num);
        }

        for (int num: nums) {
            counter = 0;
            if (!hset.contains(num-1)) {
                while (hset.contains(num + counter)) {
                    counter++;
                }
                if (counter > ret) {
                    ret = counter;
                }
            }
        }
        return ret;
    }
}
