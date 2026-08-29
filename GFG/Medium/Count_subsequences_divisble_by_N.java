package GFG.Medium;
/* Given a numeric string s containing only digits and an integer n, count the number of non-empty subsequences of s whose numeric value is divisible by n. Return the answer modulo 1e9 + 7.

Examples:

Input: s = "1234", n = 4
Output: 4
Explanation: The subsequences 4, 12, 24 and 124 are divisible by 4.
Input: s = "330", n = 6
Output: 4
Explanation: The subsequences 30, 30, 330 and 0 are divisible by 6.
Constraints:
1 ≤ |s| * n ≤ 106
*/
class Solution {
    public int countSubsequences(String s, int n) {

        final int MOD = 1000000007;

        // dp[r] = number of non-empty subsequences
        // whose value % n == r
        long[] dp = new long[n];

        for (int i = 0; i < s.length(); i++) {

            int digit = s.charAt(i) - '0';

            // We must use a separate array so that the current
            // digit is not used multiple times.
            long[] next = dp.clone();

            // Subsequence consisting only of this digit
            next[digit % n]++;

            // Append current digit to every existing subsequence
            for (int r = 0; r < n; r++) {

                if (dp[r] == 0) {
                    continue;
                }

                int newR = (r * 10 + digit) % n;

                next[newR] = (next[newR] + dp[r]) % MOD;
            }

            dp = next;
        }

        return (int) (dp[0] % MOD);
    }
}