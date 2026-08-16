class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hmap= new HashMap<>();
        for (int i: nums) {
            hmap.put(i, hmap.getOrDefault(i, 0) + 1);
        }

        List<Integer>[] ilist = new List[nums.length + 1];
        hmap.forEach((num, freq) -> {
            if (ilist[freq] == null) {
                ilist[freq] = new ArrayList<Integer>();
            }
            ilist[freq].add(num);
        });

        ArrayList<Integer> retList = new ArrayList<>();
        for (int i = ilist.length - 1; i > 0 && retList.size() < k; i--) {
            if (ilist[i] != null) {
                retList.addAll(ilist[i]);
            }
        }

        return retList.stream().mapToInt(i -> i).toArray();
    }
}
