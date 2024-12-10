class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Your code here
                // Step 1: Frequency count using array
        int[] freq = new int[26];
        
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++; // Increment frequency
        }

        // Step 2: Traverse again to find first non-repeating character
        for (char ch : s.toCharArray()) {
            if (freq[ch - 'a'] == 1) {
                return ch; // Found first non-repeating character
            }
        }

        // Step 3: No non-repeating character found
        return '$';
    }
}
