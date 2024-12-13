class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        // code here
        // int n = arr.length;
        // int p0=0, p2=n-1, currIdx=0;
        // while(currIdx<=p2){
        //     if(arr[currIdx]==0){
        //         //swap arr[currIdx] & p0
        //         int temp = arr[currIdx];
        //         arr[currIdx] = arr[p0];
        //         arr[p0] = temp;
        //         p0++;
        //         currIdx++;
        //     }else if(arr[currIdx]==2){
        //         //swap arr[currIdx] & p2
        //         int temp = arr[currIdx];
        //         arr[currIdx] = arr[p2];
        //         arr[p2] = temp;
        //         p2--;
                
        //     }
        //     else{
        //       currIdx++;
        //     }
        // }
        
        Arrays.sort(arr);
        return;
    }
}
