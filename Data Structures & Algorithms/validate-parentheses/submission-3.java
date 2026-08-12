class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> dq = new ArrayDeque<>();
        Map<Character, Character> cto = new HashMap<>();
        cto.put(')','(');
        cto.put('}','{');
        cto.put(']','[');

        for (char c: s.toCharArray()) {
            if (cto.containsKey(c)) {
                if (dq.isEmpty() || dq.pop() != cto.get(c)) {
                    return false;
                } 
            } else {
                dq.push(c);
            }
        }
        return dq.isEmpty();
    }
}
