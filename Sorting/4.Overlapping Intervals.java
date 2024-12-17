class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // Code here // Code here
        // If there are no intervals, return an empty list
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }

        // Sort intervals based on the starting point
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedIntervals = new ArrayList<>();

        // Initialize with the first interval
        int[] currentInterval = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // Check if intervals overlap
            if (currentInterval[1] >= arr[i][0]) {
                // Merge the intervals
                currentInterval[1] = Math.max(currentInterval[1], arr[i][1]);
            } else {
                // No overlap, add current interval to the result and move to the next
                mergedIntervals.add(currentInterval);
                currentInterval = arr[i];
            }
        }

        // Add the last interval
        mergedIntervals.add(currentInterval);

        return mergedIntervals;
    }
}
