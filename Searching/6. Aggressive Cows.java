class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // Sort the stalls to calculate distances sequentially
        Arrays.sort(stalls);
        
        int n = stalls.length;
        int low = 1; // Minimum possible distance
        int high = stalls[n - 1] - stalls[0]; // Maximum possible distance
        int result = 0;

        // Binary search to find the maximum minimum distance
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceCows(stalls, k, mid)) {
                result = mid; // Update result to current mid
                low = mid + 1; // Try for a larger distance
            } else {
                high = mid - 1; // Try for a smaller distance
            }
        }

        return result;
    }

    // Helper function to check if cows can be placed with at least 'minDist' distance
    private static boolean canPlaceCows(int[] stalls, int k, int minDist) {
        int count = 1; // Place the first cow
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= minDist) {
                count++; // Place another cow
                lastPosition = stalls[i]; // Update last placed position

                if (count == k) {
                    return true; // Successfully placed all cows
                }
            }
        }

        return false; // Not enough stalls to place all cows
    }
}
