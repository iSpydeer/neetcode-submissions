class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> iMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if(iMap.containsKey(target - nums[i])) {
                return new int[]{iMap.get(target - nums[i]), i};
            } else {
                iMap.put(nums[i], i);
            }
        }
        return new int[]{-1,-1};
    }
}
