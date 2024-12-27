class Solution {
    public int kthMissing(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        // Perform binary search to determine the position of kth missing number
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Calculate the number of missing elements till the current position
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                // If less missing elements, move to the right half
                low = mid + 1;
            } else {
                // If enough missing elements, move to the left half
                high = mid - 1;
            }
        }

        // Calculate the kth missing number
        return low + k;
    }
}
