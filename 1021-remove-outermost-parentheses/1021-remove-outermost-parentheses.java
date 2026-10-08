class Solution {
    public String removeOuterParentheses(String str) {
        StringBuilder result = new StringBuilder();
        int openCount = 0;
        
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                if (openCount > 0) {
                    result.append(ch);
                }
                openCount++;
            } else if (ch == ')') {
                openCount--;
                if (openCount > 0) {
                    result.append(ch);
                }
            }
        }
        
        return result.toString();
    }
}