class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
    List<String> result = new ArrayList<>();
        Stack<String> st = new Stack<>();
        Set<String> seen = new HashSet<>();
        Set<String> added = new HashSet<>();
        int n = s.length();

        for (int i = 0; i <= n - 10; i++) {
            String substring = s.substring(i, i + 10);
            st.push(substring);

            if (seen.contains(substring) && !added.contains(substring)) {
                result.add(substring);
                added.add(substring);
            } else {
                seen.add(substring);
            }
        }

        return result;
    }
}





