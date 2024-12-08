class Solution {
    public int myAtoi(String s) {
        // Your code here
        // Step 1: Trim leading whitespaces
        s = s.trim();
        if (s.isEmpty()) return 0;

        int sign = 1; // Default positive
        int index = 0;
        long result = 0; // To handle overflow

        // Step 2: Check for sign
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            if (s.charAt(index) == '-') {
                sign = -1;
            }
            index++; // Move to the next character
        }

        // Step 3: Read digits
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            result = result * 10 + (s.charAt(index) - '0');

            // Step 4: Handle overflow
            if (result > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            index++;
        }

        // Step 5: Return result with the sign
        return (int) result * sign;
    }
}
