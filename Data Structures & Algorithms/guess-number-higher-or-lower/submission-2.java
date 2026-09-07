/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int L = 1;
        int R = n;

        while (L <= R) {
            int M = L + (R - L)/2;
            if (guess(M) < 0) {
                R = M - 1;
            } else if (guess(M) > 0) {
                L = M + 1;
            } else {
                return M;
            }
        }
        return -1;
    }
}