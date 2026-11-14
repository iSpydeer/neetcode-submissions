class Solution {
    public int reverseBits(int n) {
        int result = 0;
        int bitPointer = 31;
        while (n != 0) {
            if ((n & 1) == 1) {
                result += 1 << bitPointer;
            }
            n = n >>> 1;
            bitPointer--;
        }

        return result;
    }
}
