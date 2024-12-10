class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();

        // Step 1: Build LPS Array
        int[] lps = buildLPS(pat);

        int i = 0; // index for txt
        int j = 0; // index for pat

        // Step 2: Pattern Search in Text
        while (i < txt.length()) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == pat.length()) {
                // Pattern found, add starting index
                result.add(i - j);
                j = lps[j - 1]; // Use LPS to continue search
            } else if (i < txt.length() && txt.charAt(i) != pat.charAt(j)) {
                // Mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1]; // Jump using LPS
                } else {
                    i++; // Move to next character in txt
                }
            }
        }

        return result.isEmpty() ? new ArrayList<>() : result;
    }

    // Helper Function to Build LPS Array
    private int[] buildLPS(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0; // Length of previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // Reduce len using LPS
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
