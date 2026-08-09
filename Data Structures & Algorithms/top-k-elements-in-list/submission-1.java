class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> imap = new HashMap<>();
        for (int i: nums) {
            imap.put(i, imap.getOrDefault(i, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        imap.forEach((num, freq) -> {
            if(bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        });

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = bucket.length -1; i > 0 && result.size() < k; i--) {
            if(bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
