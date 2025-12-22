package GFG.Hard;

/* Given a string s, the task is to find the minimum characters to be added at the front to make the string palindrome.

Note: A palindrome string is a sequence of characters that reads the same forward and backward.

Examples:

Input: s = "abc"
Output: 2
Explanation: Add 'b' and 'c' at front of the above string to make it palindrome: "cbabc"
Input: s = "aacecaaaa"
Output: 2
Explanation: Add 2 a's at front of the above string to make it palindrome: "aaaacecaaaa"
Constraints:
1 ≤ s.size() ≤ 106
s consists of lowercase english alphabets

*/
class Solution {
    public int minChar(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;

        int[] lps = new int[combined.length()];
        int i = 1, len = 0;

        while (i < combined.length()) {
            if (combined.charAt(i) == combined.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) len = lps[len - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return s.length() - lps[combined.length() - 1];
    }
}