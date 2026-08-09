class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> imap = new HashMap<>();
        for (int i: nums) {
            int temp = imap.getOrDefault(i, 0);
            imap.put(i, ++temp);
        }

        List<Integer> reverseList = imap.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .toList();


        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = reverseList.get(reverseList.size() - 1 - i);
        }

        return res;
    }
}
