class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        // Find the first occurrence of the target
        int first = findFirstOccurrence(arr, target);
        if (first == -1) {
            return 0; // Target not present in the array
        }

        // Find the last occurrence of the target
        int last = findLastOccurrence(arr, target);

        // Return the count of occurrences
        return last - first + 1;
    }

    private int findFirstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid; // Potential first occurrence
                high = mid - 1; // Move left to find earlier occurrence
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private int findLastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid; // Potential last occurrence
                low = mid + 1; // Move right to find later occurrence
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
