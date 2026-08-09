class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hMap = new HashMap<>();
        for (String el : strs) {
            char[] chArray = el.toCharArray();
            Arrays.sort(chArray);
            String sortedEl = new String(chArray);
            hMap.putIfAbsent(sortedEl, new ArrayList<String>());
            hMap.get(sortedEl).add(el);
        }
        return new ArrayList<>(hMap.values());
    }
}
