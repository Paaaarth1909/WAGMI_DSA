package GFG.Easy;
/* Given an integer n, count the number of binary strings of length 2 * n that contain exactly n ones and n zeros such that every prefix of the string contains at least as many ones as zeros. Since the answer can be very large, return it modulo 109 + 7.

Examples:

Input: n = 2
Output: 2
Explanation: "1100", "1010" are two such strings of size 4 which have exactly two 1's in each.
Input: n = 3
Output: 5
Explanation: "111000", "101100", "101010", "110010", "110100" are such 5 strings which have exactly three 1's in each.
Constraints:

1 ≤ n ≤ 1000
 */
class Solution {
    static final long MOD = 1000000007;

    public int prefixStrings(int n) {

        long[] fact = new long[2 * n + 1];
        fact[0] = 1;

        for (int i = 1; i <= 2 * n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        long numerator = fact[2 * n];

        long denominator = (fact[n] * fact[n]) % MOD;

        // C(n) = (2n)! / (n! * n! * (n+1))
        denominator = (denominator * (n + 1)) % MOD;

        long inverse = power(denominator, MOD - 2);

        return (int) ((numerator * inverse) % MOD);
    }

    private long power(long a, long b) {

        long result = 1;

        while (b > 0) {

            if ((b & 1) == 1) {
                result = (result * a) % MOD;
            }

            a = (a * a) % MOD;
            b >>= 1;
        }

        return result;
    }
}