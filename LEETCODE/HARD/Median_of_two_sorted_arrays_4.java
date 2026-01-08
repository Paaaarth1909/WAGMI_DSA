/* Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 
*/
public class Median_of_two_sorted_arrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int p1 = 0, p2 = 0, pos = 0;
    	int ls1 = nums1.length, ls2 = nums2.length;
    	int[] all_nums = new int[ls1+ls2];
    	double median = 0.0;
    	while (p1 < ls1 && p2 < ls2){
    		if (nums1[p1] <= nums2[p2])
    			all_nums[pos++] = nums1[p1++];
    		else
    			all_nums[pos++] = nums2[p2++];
    	}
    	while (p1 < ls1)
    		all_nums[pos++] = nums1[p1++];
    	while (p2 < ls2)
    		all_nums[pos++] = nums2[p2++];
    	if ((ls1 + ls2) % 2 == 1)
    		median = all_nums[(ls1 + ls2) / 2];
    	else
    		median = (all_nums[(ls1 + ls2) / 2] + all_nums[(ls1 + ls2) / 2 - 1]) / 2.0;
        return median;
    }
}