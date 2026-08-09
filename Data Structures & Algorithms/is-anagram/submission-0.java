class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) {
            return false;
        }

        Map<String, Integer> sMap = new HashMap();
        Map<String, Integer> tMap = new HashMap();
        
        for (String sChar: s.split("")){
            sMap.put(sChar, sMap.getOrDefault(sChar, 0) + 1);
        }

        for (String tChar: t.split("")){
            if (sMap.getOrDefault(tChar, 0) == 0) {
                return false;
            } else {
                sMap.put(tChar, sMap.get(tChar) - 1);
            }
        }

        return true;
    }
}
