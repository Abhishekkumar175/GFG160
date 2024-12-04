class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {

        // Your code here
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for (int num : arr) {
            currentSum = Math.max(num, currentSum + num); 
            maxSum = Math.max(maxSum, currentSum);      
        }

        return maxSum;

    }
}
