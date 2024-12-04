class Solution {
    int getMinDiff(int[] arr, int k) {
        int n=arr.length;
        Arrays.sort(arr);

        // Initial difference
        int result = arr[n - 1] - arr[0];

        // Iterate through the array to find the optimal difference
        for (int i = 0; i < n - 1; i++) {
            int maxElement = Math.max(arr[i] + k, arr[n - 1] - k);
            int minElement = Math.min(arr[0] + k, arr[i + 1] - k);

            // If a tower height becomes negative, skip this case
            if (minElement < 0) continue;

            result = Math.min(result, maxElement - minElement);
        }

        return result;
    }
}
