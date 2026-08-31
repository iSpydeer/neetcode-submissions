public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int res = n;
        int[] cnt = new int[2];
        for (int i = 0; i < n; i++) {
            cnt[students[i]]++;
        }

        for (int i = 0; i < n; i++) {
            if (cnt[sandwiches[i]] > 0) {
                res--;
                cnt[sandwiches[i]]--;
            } else {
                break;
            }
        }

        return res;
    }
}