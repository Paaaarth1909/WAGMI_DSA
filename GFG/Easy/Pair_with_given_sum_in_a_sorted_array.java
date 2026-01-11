/* You are given an integer target and an array arr[]. You have to find number of pairs in arr[] which sums up to target. It is given that the elements of the arr[] are in sorted order.
Note: pairs should have elements of distinct indexes. 

Examples :

Input: arr[] = [-1, 1, 5, 5, 7], target = 6
Output: 3
Explanation: There are 3 pairs which sum up to 6 : {1, 5}, {1, 5} and {-1, 7}.
Input: arr[] = [1, 1, 1, 1], target = 2
Output: 6
Explanation: There are 6 pairs which sum up to 2 : {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1} and {1, 1}.
Input: arr[] = [-1, 10, 10, 12, 15], target = 125
Output: 0
Explanation: There is no such pair which sums up to 125.
Constraints:
-105 <= target <=105
 2 <= arr.size() <= 105
-105 <= arr[i] <= 105

*/
class Solution {

    int countPairs(int arr[], int target) {
        int n = arr.length;
        int left = 0, right = n - 1;
        long count = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                // sum == target
                if (arr[left] == arr[right]) {
                    int cnt = right - left + 1;
                    count += (long) cnt * (cnt - 1) / 2;
                    break;
                } else {
                    int leftVal = arr[left];
                    int rightVal = arr[right];
                    int cntL = 0, cntR = 0;

                    while (left < right && arr[left] == leftVal) {
                        cntL++;
                        left++;
                    }
                    while (left <= right && arr[right] == rightVal) {
                        cntR++;
                        right--;
                    }

                    count += (long) cntL * cntR;
                }
            }
        }

        return (int) count;
    }
}

