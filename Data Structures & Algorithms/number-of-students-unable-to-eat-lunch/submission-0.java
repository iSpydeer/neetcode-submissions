class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i=0; i < students.length; i++) {
            q.offer(students[i]);
            stack.offer(sandwiches[i]);
        }

        int counter = students.length;
        while (!stack.isEmpty() && counter > 0) {
            if (q.peek() == stack.peek()) {
                q.poll();
                stack.pop();
                counter = stack.size();
            } else {
                q.offer(q.poll());
                counter--;
            }
        }

        return q.size();
    }
}