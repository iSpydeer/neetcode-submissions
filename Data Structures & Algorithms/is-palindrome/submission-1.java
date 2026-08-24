class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;

        while (l < r) {
            if (!isAlphanumeric(s.charAt(l))) {
                l++;
            } else if (!isAlphanumeric(s.charAt(r))) {
                r--;
            } else if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        if ((c >= 'A' && c <= 'Z') ||
            (c >= 'a' && c <= 'z') ||
            (c >= '0' && c <= '9')) {
            return true;
        } else {
            return false;
        }
    }
}
