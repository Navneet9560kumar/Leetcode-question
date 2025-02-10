class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Agar digit milta hai, to stack se top ka non-digit remove karo
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Agar character non-digit hai, to stack me add karo
                stack.push(ch);
            }
        }

        // Final string banane ke liye stack ko use karein
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
}