/* You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
*/
class Solution {
    int rows = 0;
    int cols = 0;
    int[][] m;
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        m = matrix;
        rows = matrix.length;
        cols = matrix[0].length;

        int start = 0;
        int end = rows * cols - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (getValue(mid) == target) {
                return true;
            } else if (getValue(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (getValue(start) == target) {
            return true;
        }
        if (getValue(end) == target) {
            return true;
        }
        return false;
    }
 private int getValue(int index) {
        return m[index / cols][index % cols];
    }
}