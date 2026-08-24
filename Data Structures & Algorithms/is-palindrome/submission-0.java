class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        String sl = s.toLowerCase();

        while (l <= r) {
            if (!isAlphanumeric(sl.charAt(l))) {
                l++;
            } else if (!isAlphanumeric(sl.charAt(r))) {
                r--;
            } else if (sl.charAt(l) == sl.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        if ((c >= 'a' && c <= 'z') ||
            (c >= '0' && c <= '9')) {
            return true;
        } else {
            return false;
        }
    }
}
