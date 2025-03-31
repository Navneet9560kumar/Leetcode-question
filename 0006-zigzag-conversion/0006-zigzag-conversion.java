class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        int i = 0, n = s.length();
        while (i < n) {
            for (int j = 0; j < numRows && i < n; j++) {
                sb[j].append(s.charAt(i++));
            }
            for (int j = numRows - 2; j > 0 && i < n; j--) {
                sb[j].append(s.charAt(i++));
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : sb) {
            result.append(row);
        }
        
        return result.toString();
    }
}