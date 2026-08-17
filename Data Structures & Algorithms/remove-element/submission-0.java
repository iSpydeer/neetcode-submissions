class Solution {
    public int removeElement(int[] nums, int val) {
        int lPointer = 0;
        int rPointer = nums.length -1;
        int k = 0;

        while (rPointer >= lPointer) {
            if (nums[lPointer] != val) {
                lPointer++;
                k++;
            } else if (nums[rPointer] == val) {
                rPointer--;
            } else {
                nums[lPointer] = nums[rPointer];
                nums[rPointer] = val;
                lPointer++;
                rPointer--;
                k++;
            }
        }
        return k;
    }
}