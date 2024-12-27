class Solution {
    public static int findPages(int[] arr, int k) {
        // If the number of students is more than the number of books, allocation is impossible
        if (k > arr.length) {
            return -1;
        }

        int low = getMax(arr); // Minimum possible allocation is the largest book
        int high = getSum(arr); // Maximum possible allocation is the sum of all books
        int result = -1;

        // Binary search to minimize the maximum pages allocated to a student
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(arr, k, mid)) {
                result = mid; // Update result to current mid
                high = mid - 1; // Try for a smaller maximum
            } else {
                low = mid + 1; // Try for a larger maximum
            }
        }

        return result;
    }

    // Helper function to check if allocation is valid with max pages as 'mid'
    private static boolean isValid(int[] arr, int k, int mid) {
        int students = 1; // Start with one student
        int currentPages = 0;

        for (int pages : arr) {
            if (currentPages + pages > mid) {
                students++; // Allocate to the next student
                currentPages = pages; // Start new allocation

                if (students > k) {
                    return false; // More students needed than available
                }
            } else {
                currentPages += pages; // Continue allocation
            }
        }

        return true;
    }

    // Helper function to get the maximum value in the array
    private static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int pages : arr) {
            max = Math.max(max, pages);
        }
        return max;
    }

    // Helper function to get the sum of all elements in the array
    private static int getSum(int[] arr) {
        int sum = 0;
        for (int pages : arr) {
            sum += pages;
        }
        return sum;
    }
}
