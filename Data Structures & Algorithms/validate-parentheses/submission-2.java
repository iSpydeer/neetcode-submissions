class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> dq = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            if (c == '(') {
                dq.push(')');
            } else if (c == '{') {
                dq.push('}');
            } else if (c == '[') {
                dq.push(']');
            } else {
                if (dq.isEmpty() || c != dq.poll()) {
                    return false;
                }
            }
        }

        return dq.isEmpty();
    }
}
