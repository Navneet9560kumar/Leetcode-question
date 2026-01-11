class Solution {
       public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (char[] row : matrix) {

          
            for (int j = 0; j < cols; j++) {
                if (row[j] == '1')
                    heights[j]++;
                else
                    heights[j] = 0;
            }

            maxArea = Math.max(maxArea, largestRectangle(heights));
        }
        return maxArea;
    }

    // Largest rectangle dekhte
public static int largestRectangle(int[] heights) {

    Stack<Integer> st = new Stack<>();
    int maxArea = 0;
    int n = heights.length;

    for (int i = 0; i <= n; i++) {

        int currHeight = (i == n) ? 0 : heights[i];

        while (!st.isEmpty() && currHeight < heights[st.peek()]) {

            int height = heights[st.pop()];
            int width;

            if (st.isEmpty())
                width = i;
            else
                width = i - st.peek() - 1;

            maxArea = Math.max(maxArea, height * width);
        }

        st.push(i);
    }

    return maxArea;
}

}
