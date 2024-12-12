class Solution {
    public static int minChar(String s) {
        // Write your code here
        // Step 1: Concatenate the string with its reverse
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        
        // Step 2: Compute the LPS array
        int[] lps = computeLPSArray(temp);
        
        // Step 3: Calculate the minimum characters to add
        return s.length() - lps[lps.length - 1];
    }

    // Function to compute the LPS array
    private static int[] computeLPSArray(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int length = 0;  // Length of the previous longest prefix suffix
        int i = 1;

        while (i < n) {
            if (str.charAt(i) == str.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
