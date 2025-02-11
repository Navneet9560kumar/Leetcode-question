class Solution {

    public String removeOccurrences(String s, String part) {
        // Keep removing the part as long as it exists in the string
        while (s.contains(part)) {
            // Find the leftmost occurrence of part and remove it
            s = s.replaceFirst(part, "");
        }
        // Return the modified string
        return s;
    }
}