class Solution {
    // Function to build the LPS (Longest Prefix Suffix) array
    private static int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0; // length of the previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // Function to check if s2 is a rotation of s1 using KMP algorithm
    public static boolean areRotations(String s1, String s2) {
        // Step 1: Check if the lengths are the same
        if (s1.length() != s2.length()) {
            return false;
        }

        // Step 2: Concatenate s1 with itself
        String concatenated = s1 + s1;

        // Step 3: Apply KMP to find if s2 is a substring of concatenated
        int[] lps = buildLPS(s2);
        int i = 0; // index for concatenated string
        int j = 0; // index for s2

        while (i < concatenated.length()) {
            if (s2.charAt(j) == concatenated.charAt(i)) {
                i++;
                j++;
            }

            if (j == s2.length()) {
                return true; // Found a match
            } else if (i < concatenated.length() && s2.charAt(j) != concatenated.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1]; // Use the LPS array to avoid unnecessary comparisons
                } else {
                    i++;
                }
            }
        }

        // Step 4: If we reach here, there is no match
        return false;
    }
}
