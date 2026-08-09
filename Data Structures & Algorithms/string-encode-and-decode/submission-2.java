class Solution {

    public String encode(List<String> strs) {
        StringBuilder ret = new StringBuilder();
        for(String str: strs) {
            ret.append(str.length());
            ret.append("#");
            ret.append(str);
        }
        return ret.toString();
    }

    public List<String> decode(String str) {
        List<String> ret = new ArrayList<>();
        int totalLength = str.length();
        int currentIndex = 0;
        
        while(currentIndex < totalLength) {
            int delimiterIndex = str.indexOf('#', currentIndex);
            int stringLength = Integer.parseInt(str.substring(currentIndex, delimiterIndex));
            int startingIndex = delimiterIndex + 1;
            int endingIndex = startingIndex + stringLength;
            ret.add(str.substring(startingIndex, endingIndex));
            currentIndex = endingIndex;
        }
        return ret;
    }
}
