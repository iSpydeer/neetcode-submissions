class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];

        int l = 1;
        int r = 1;

        for (int i = 0; i < length; i++) {
            l = l * nums[i];
            r = r * nums[length - 1 - i];
            left[i] = l;
            right[length -1 - i] = r;
        }

        int[] ret = new int[length];
        for (int i=0; i < length; i++) {
            if (i != 0 && i != length-1){
                ret[i] = left[i-1] * right[i+1];
            } else if(i == 0) {
                ret[i] = right[i+1];
            } else {
                ret[i] = left[i-1];
            }
        }

        return ret;
    }
}  
