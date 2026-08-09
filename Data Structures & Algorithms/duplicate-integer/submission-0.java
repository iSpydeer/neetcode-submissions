class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> intSet = new HashSet<Integer>();
        for (int el : nums) {
            intSet.add(el);
        }
        
        return nums.length != intSet.size();
    }
}