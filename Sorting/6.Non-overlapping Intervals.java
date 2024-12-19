class Solution {
    static int minRemoval(int intervals[][]) {
        // code here
         // Step 1: Sort intervals by their end times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int removeCount = 0;
        int prevEnd = Integer.MIN_VALUE;

        // Step 2: Iterate through the intervals
        for (int[] interval : intervals) {
            if (interval[0] >= prevEnd) {
                // Non-overlapping interval
                prevEnd = interval[1];
            } else {
                // Overlapping interval
                removeCount++;
            }
        }

        return removeCount;
    }
}
