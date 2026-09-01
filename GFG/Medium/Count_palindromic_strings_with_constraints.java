/* Given two integers n  and k, consider an alphabet consisting of the first k lowercase English letters. Find the number of palindromic strings whose length is less than or equal to n, such that:

Every character in the string belongs to the given alphabet.
No character appears more than twice in the string.
Note: Since the answer can be very large, return it modulo 10^9+7.

Examples:

Input: n = 3, k = 2
Output: 6
Explanation: The possible strings are: "a", "b", "aa", "bb", "aba", "bab".
Input: n = 4, k = 3
Output: 18
Explanation: The possible strings are:"a", "b", "c", "aa", "bb", "cc", "aba", "aca", "bab", "bcb", "cac", "cbc", "abba", "acca", "baab", "bccb", "caac", "cbbc". 
Constraints:
1 ≤ k ≤ 26
1 ≤ n ≤ 52
n ≤ 2*k 
*/
class Solution {
    static final long MOD = 1000000007;

    public int palindromicStrings(int n, int k) {

        long ans = 0;
        long ways = 1;

        // m = number of pairs
        // Maximum possible length is min(n, 2*k)
        for (int m = 0; m <= k; m++) {

            // Even length = 2*m
            if (2 * m <= n) {
                if (m == 0) {
                    ans = (ans + 0) % MOD; // empty string is not counted
                } else {
                    ways = (ways * (k - m + 1)) % MOD;
                    ans = (ans + ways) % MOD;
                }
            }

            // Odd length = 2*m + 1
            if (2 * m + 1 <= n) {
                long oddWays = (ways * (k - m)) % MOD;
                ans = (ans + oddWays) % MOD;
            }
        }

        return (int) ans;
    }
}