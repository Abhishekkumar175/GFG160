class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        // code here
        if(arr.length == 0) return 0;
        int result = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) continue;
            int product = 1;
            for(int j =i; j<arr.length;j++){
                product*=arr[j];
                result=Math.max(result,product);
            }
        }
        return result;
    }
}
