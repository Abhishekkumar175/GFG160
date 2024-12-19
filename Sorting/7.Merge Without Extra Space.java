class Solution {
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        // code here
        int n = a.length;
        int m = b.length;
        int gap = (n + m + 1) / 2; // Initial gap

        while (gap > 0) {
            int i = 0, j = gap;

            // Compare elements within the combined virtual array
            while (j < (n + m)) {
                if (j < n && i < n) {
                    // Compare elements within a[]
                    if (a[i] > a[j]) {
                        swap(a, i, j);
                    }
                } else if (j >= n && i < n) {
                    // Compare elements between a[] and b[]
                    if (a[i] > b[j - n]) {
                        swap(a, b, i, j - n);
                    }
                } else {
                    // Compare elements within b[]
                    if (b[i - n] > b[j - n]) {
                        swap(b, i - n, j - n);
                    }
                }
                i++;
                j++;
            }

            // Reduce the gap
            gap = (gap == 1) ? 0 : (gap + 1) / 2;
        }
    }

    // Swap function for arrays a[] and b[].
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void swap(int[] a, int[] b, int i, int j) {
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }
}
