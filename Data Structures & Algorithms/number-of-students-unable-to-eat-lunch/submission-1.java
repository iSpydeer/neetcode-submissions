class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int zeros = 0;
        int ones = 0;

        for (int student: students) {
            if (student == 1) {
                ones++;
            } else {
                zeros++;
            }
        }

        int i = 0;
        while (i < sandwiches.length) {
            if (sandwiches[i] == 1) {
                if (ones == 0) {
                    break;
                }
                ones--;
            } else {
                if (zeros == 0) {
                    break;
                }
                zeros--;
            }
            i++;
        }
        return ones+zeros;
    }
}