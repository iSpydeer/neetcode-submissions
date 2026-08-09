class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> hMap = new HashMap<>();
        for (String el : strs) {
            List<Integer> keyArray = getKeyArray(el);
            hMap.putIfAbsent(keyArray, new ArrayList<String>());
            hMap.get(keyArray).add(el);
        }
        return new ArrayList<>(hMap.values());
    }

    private List<Integer> getKeyArray(String el) {
        int[] tempArray = new int[26];
        for (char ch: el.toCharArray()) {
            tempArray[ch - 97]++;
        }
        return Arrays.stream(tempArray).boxed().toList();
    }
}
