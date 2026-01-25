/* Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

1 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;

        String[] map = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
        };

        dfs(0, digits, map, new StringBuilder(), res);
        return res;
    }

    void dfs(int i, String d, String[] map, StringBuilder cur, List<String> res) {
        if (i == d.length()) {
            res.add(cur.toString());
            return;
        }
        String letters = map[d.charAt(i) - '0'];
        for (int j = 0; j < letters.length(); j++) {
            cur.append(letters.charAt(j));
            dfs(i + 1, d, map, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}