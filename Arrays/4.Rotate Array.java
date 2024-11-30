class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        // add your code here
        int n = arr.length;
        // out of bound error resolve
        d = d%n;
        reverse(arr, 0, d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);
    }
    
    // reverse using two pointer approach
    static void reverse(int[] arr, int start, int last){
        while(start < last){
            int temp = arr[start];
            arr[start] = arr[last];
            arr[last] = temp;
            start ++;
            last --;
        }
    }
}
