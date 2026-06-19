class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
HashMap<Integer, Integer> st = new HashMap<>();

for (int num : nums) {
    st.put(num, st.getOrDefault(num, 0) + 1);
}

for (int num : st.keySet()) {
    if (st.get(num) == 1) {
        return num;
    }
}

return -1;
    }
}