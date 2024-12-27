class Solution {
    // Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int mat[][]) {
        // code here
        int m = mat.length;  //row
        int n = mat[0].length;  //col
        //transpose
        for(int i=0;i<m;i++){
            for(int j=i;j<n;j++){
                int temp=mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        
        //reverse
        for(int i=0;i<m;i++){
            int li=0;
            int ri = n-1;
            
            while(li < ri){
             int temp=mat[li][i];
             mat[li][i] = mat[ri][i];
             mat[ri][i] = temp;
             li++;
             ri--;
            }
        }
        
    }
}
