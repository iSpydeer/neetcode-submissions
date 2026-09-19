class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        dfs(0, new ArrayList<>(), retList, nums);
        return retList;
    }

    private void dfs(int index, List<Integer> list, List<List<Integer>> retList,int[] nums) {
        if (index >= nums.length) {
            retList.add(list);
            return;
        }

        List<Integer> excludingList = new ArrayList<>(list);
        List<Integer> includingList = new ArrayList<>(list);
        includingList.add(nums[index]);
        dfs(index + 1, excludingList, retList, nums);
        dfs(index + 1, includingList, retList, nums);
    }
}
