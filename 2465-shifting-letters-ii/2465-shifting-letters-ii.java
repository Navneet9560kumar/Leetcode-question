class Solution {

        public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1];

        // Populate the difference array based on shifts
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            
            if (direction == 1) { // Forward shift
                diff[start] += 1;
                diff[end + 1] -= 1;
            } else { // Backward shift
                diff[start] -= 1;
                diff[end + 1] += 1;
            }
        }

        // Calculate cumulative shifts
        int cumulativeShift = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            cumulativeShift += diff[i]; // Update cumulative shift
            int shift = (cumulativeShift % 26 + 26) % 26; // Normalize shift
            char shiftedChar = (char) ((s.charAt(i) - 'a' + shift) % 26 + 'a'); // Apply shift
            result.append(shiftedChar);
        }

        return result.toString();
    }
}
