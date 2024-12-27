class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        
        int rows = mat.length;     // Number of rows
        int cols = mat[0].length;  // Number of columns
        
        int startRow = 0, startCol = 0; 
        int endRow = rows - 1, endCol = cols - 1;
        
        while (startRow <= endRow && startCol <= endCol) {
            // Traverse the top row
            for (int j = startCol; j <= endCol; j++) {
                result.add(mat[startRow][j]);
            }
            startRow++; 
            
            // Traverse the right column
            for (int i = startRow; i <= endRow; i++) {
                result.add(mat[i][endCol]);
            }
            endCol--; 
            
            // Traverse the bottom row (if still valid)
            if (startRow <= endRow) {
                for (int j = endCol; j >= startCol; j--) {
                    result.add(mat[endRow][j]);
                }
                endRow--; // Move up the ending row
            }
            
            // Traverse the left column (if still valid)
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    result.add(mat[i][startCol]);
                }
                startCol++;
            }
        }
        
        return result;
        
    }
}
