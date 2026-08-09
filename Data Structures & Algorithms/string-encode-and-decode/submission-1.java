class Solution {

    public String encode(List<String> strs) {
        StringBuilder ret = new StringBuilder();
        for(String str: strs) {
            ret.append(str.length());
            ret.append("#");
            for(char c: str.toCharArray()) {
                ret.append(c);
            }
            ret.append("#");
        }
        System.out.println(ret);
        return ret.toString();
    }

    public List<String> decode(String str) {
        List<String> ret = new ArrayList<>();
        char[] c = str.toCharArray();
        int i = 0;
        
        while(i < str.length()) {
            StringBuilder sizeBuilder = new StringBuilder();
            while (c[i] != '#') {
                sizeBuilder.append(c[i]);
                i++;
            }
            int size = Integer.parseInt(sizeBuilder.toString());
            i++;

            StringBuilder wordBuilder = new StringBuilder();
            for(int j = i; j < i+size; j++) {
                wordBuilder.append(c[j]);
            }
            i = i + size + 1;

            ret.add(wordBuilder.toString());
        }
        return ret;
    }
}
