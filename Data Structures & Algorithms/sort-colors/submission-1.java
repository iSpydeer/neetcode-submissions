class Solution {
    public void sortColors(int[] nums) {
        int[] bucket = {0, 0, 0};

        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]+= 1;
        }

        int idx = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                nums[idx] = i;
                idx++;
            }
        }
    }
}