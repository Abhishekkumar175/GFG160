class Solution {

    public int peakElement(int[] arr) {
        // code here
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == n - 1 || arr[mid] > arr[mid + 1])) {
                return mid;
            }

            // Move to the left half if the left neighbor is greater
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            } else {
                // Move to the right half otherwise
                left = mid + 1;
            }
        }

        return -1;
    }    
}
