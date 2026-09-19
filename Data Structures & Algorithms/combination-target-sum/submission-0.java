class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> retList = new ArrayList<>();
        dfs(0, nums, target, new ArrayList<>(), retList);
        return retList;
    }

    private void dfs(int index, int[] nums, int target, List<Integer> list, List<List<Integer>> retList) {
        if (index >= nums.length) {
            return;
        }

        if (target < 0) {
            return;
        } else if (target == 0) {
            retList.add(new ArrayList<>(list));
            return;
        } else {
            list.add(nums[index]);
            dfs(index, nums, target - nums[index], list, retList);
            list.remove(list.size() -1);
            dfs(index + 1, nums, target, list, retList);
        } 
    }
}
