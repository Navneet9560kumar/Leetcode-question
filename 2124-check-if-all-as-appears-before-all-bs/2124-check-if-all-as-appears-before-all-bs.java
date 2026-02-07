import java.util.Stack;

class Solution {
    public boolean checkString(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // agar pehle b aa chuka hai aur ab a aa gaya
            if (!st.isEmpty() && ch == 'a' && st.peek() == 'b') {
                return false;
            }

            // current character ko stack me daalo
            st.push(ch);
        }

        return true;
    }
}
