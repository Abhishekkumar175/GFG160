class Solution {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
         ArrayList<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;

        // Step 1: Add all intervals before the newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Step 3: Add all intervals after the merged interval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result;
    }
}
