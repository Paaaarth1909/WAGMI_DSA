package GFG.Easy;

public class Number_of_occurence {
    public static int countFreq(int[] arr, int target) {
        int n = arr.length;
        int lower = lowerBound(arr, n, target);
        int upper = upperBound(arr, n, target);
        return upper - lower;
    }

    private static int lowerBound(int[] arr, int n, int x) {
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int upperBound(int[] arr, int n, int x) {
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}