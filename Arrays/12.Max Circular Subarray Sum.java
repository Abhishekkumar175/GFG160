class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {
        // Your code here
        int totalSum = 0;
        int maxKadane = Integer.MIN_VALUE, currentMax = 0;
        int minKadane = Integer.MAX_VALUE, currentMin = 0;

        for (int num : arr) {
            // Maximum subarray sum (Kadane's algorithm)
            currentMax = Math.max(num, currentMax + num);
            maxKadane = Math.max(maxKadane, currentMax);

            // Minimum subarray sum (inverse of Kadane's)
            currentMin = Math.min(num, currentMin + num);
            minKadane = Math.min(minKadane, currentMin);

            // Total sum of the array
            totalSum += num;
        }

        // If all numbers are negative, maxCircular will be 0; return maxKadane instead.
        if (totalSum == minKadane) {
            return maxKadane;
        }

        // Maximum of non-circular and circular sums
        return Math.max(maxKadane, totalSum - minKadane);
    }
}
