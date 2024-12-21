class Solution {
    int search(int[] arr, int key) {
        // Complete this function
        int n = arr.length;
        int low=0;
        int high = n-1;
         while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if the key is found
            if (arr[mid] == key) {
                return mid;
            }

            // Determine the sorted half
            if (arr[low] <= arr[mid]) { // Left half is sorted
                if (key >= arr[low] && key < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // Right half is sorted
                if (key > arr[mid] && key <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        // Key not found
        return -1;
        
    }
}
