package GFG.Medium;
/* Given four integers n, i, d, and c, where:

i is the cost of inserting a single character,
d is the cost of deleting the last character,
c is the cost of copying the entire current string and pasting it immediately (thereby doubling its length).
Find the minimum cost required to obtain exactly n characters on the screen. Initially, the screen is empty.

Examples:

Input: n = 9, i = 1, d = 2, c = 1
Output: 5
Explanation: Perform the following operations:
Insert (1 character)
Insert (2 characters)
Copy-paste (4 characters)
Copy-paste (8 characters)
Insert (9 characters)
Total cost = 1 + 1 + 1 + 1 + 1 = 5.
Input: n = 9, i = 10, d = 1, c = 1
Output: 17
Explanation: Perform the following operations:
Insert (1 character)
Copy-paste (2 characters)
Copy-paste (4 characters)
Delete (3 characters)
Copy-paste (6 characters)
Delete (5 characters)
Copy-paste (10 characters)
Delete (9 characters)
Total cost = 10 + 1 + 1 + 1 + 1 + 1 + 1 + 1 = 17.
Since insertion is expensive, it is cheaper to use copy-paste operations and adjust the length using deletions.
Constraints:

1 ≤ n ≤ 106
1 ≤ i, d, c ≤ 100
*/
class Solution {
    public int minCost(int n, int i, int d, int c) {

        long[] dp = new long[n + 1];

        for (int x = 1; x <= n; x++) {
            dp[x] = dp[x - 1] + i;

            if (x % 2 == 0) {
                // Reach x by copy-pasting from x/2
                dp[x] = Math.min(dp[x],
                        dp[x / 2] + c);
            } else {
                // Reach x by first reaching x+1,
                // then deleting one character.
                dp[x] = Math.min(dp[x],
                        dp[(x + 1) / 2] + c + d);
            }
        }

        return (int) dp[n];
    }
}