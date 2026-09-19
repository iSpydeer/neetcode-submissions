class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        dfs(0, new ArrayList<>(), retList, nums);
        return retList;
    }

    private void dfs(int index, List<Integer> list, List<List<Integer>> retList,int[] nums) {
        if (index >= nums.length) {
            retList.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        dfs(index + 1, list, retList, nums);
        list.remove(list.size() - 1);
        dfs(index + 1, list, retList, nums);
    }
}
