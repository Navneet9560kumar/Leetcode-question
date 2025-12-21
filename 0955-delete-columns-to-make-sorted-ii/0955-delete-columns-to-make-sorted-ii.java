class Solution {
    public int minDeletionSize(String[] strs) {

        int rows = strs.length;
        int cols = strs[0].length();
        int count = 0;

        boolean[] aheadSorted = new boolean[rows - 1];

        for (int j = 0; j < cols; j++) {

            boolean delete = false;

            for (int i = 0; i < rows - 1; i++) {
                if (!aheadSorted[i] &&
                    strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    delete = true;
                    count++;
                    break;
                }
            }

            if (delete) continue;

            for (int i = 0; i < rows - 1; i++) {
                if (!aheadSorted[i] &&
                    strs[i].charAt(j) < strs[i + 1].charAt(j)) {
                    aheadSorted[i] = true;
                }
            }
        }

        return count;
    }
}
