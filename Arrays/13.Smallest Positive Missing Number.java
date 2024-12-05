class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        // Your code here
        int n = arr.length;

        // Step 1: Ignore numbers out of range (1 to n)
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = n + 1; // Invalid numbers ko out-of-range banado
            }
        }

        // Step 2: Mark numbers as visited
        for (int i = 0; i < n; i++) {
            int num = Math.abs(arr[i]); // Positive treat karte hain
            if (num <= n) {
                arr[num - 1] = -Math.abs(arr[num - 1]); // Mark as negative
            }
        }

        // Step 3: Find first positive index
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1; // First missing number
            }
        }

        // Step 4: All numbers are present, return n+1
        return n + 1;
    }
}
