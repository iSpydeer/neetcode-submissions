class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        HashSet<String> op = new HashSet<>();
        op.add("+");
        op.add("-");
        op.add("*");
        op.add("/");

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (String token: tokens) {
            if (!op.contains(token)) {
                q.push(Integer.parseInt(token));
            } else {
                int val2 = q.pop();
                int val1 = q.pop();
                int val = switch(token) {
                    case "+" -> val1 + val2;
                    case "-" -> val1 - val2;
                    case "*" -> val1 * val2;
                    default -> val1 / val2;
                };

                q.push(val);
            }
        }

        return q.pop();
    }


}
