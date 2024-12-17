class Solution {
    // Function to find hIndex
    public int hIndex(int[] citations) {
        // code here
        int n = citations.length;
        int[] buckets = new int[n + 1]; // Buckets to count citations

        // Step 1: Populate buckets
        for (int c : citations) {
            if (c >= n) {
                buckets[n]++; // Count all citations >= n
            } else {
                buckets[c]++;
            }
        }

        // Step 2: Calculate H-Index
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += buckets[i];
            if (count >= i) {
                return i; // Found the H-Index
            }
        }
        return 0;
    }
}
