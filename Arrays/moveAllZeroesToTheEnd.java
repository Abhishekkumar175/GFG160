class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
        // base case condition
        if (arr.length <= 1) {
            return;
        }

        // two pointer approach
        int i = 0, j = 1;
        while (j < arr.length) {
            if (arr[i] == 0 && arr[j] != 0) {
                // swap (arr[i], arr[j])
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            } else if (arr[i] == 0 && arr[j] == 0) {
                j++;
            } else {
                i++;
                j++;
            }
        }
    }
}