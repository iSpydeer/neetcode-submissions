class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> intSet = new HashSet<Integer>();
        for (int el : nums) {
            if(!intSet.add(el)) {
                return true;
            }
        }
        
        return false;
    }
}