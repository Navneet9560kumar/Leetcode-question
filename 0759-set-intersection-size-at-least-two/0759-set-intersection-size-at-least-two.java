class Solution {


      public int intersectionSizeTwo(int[][] intervals) {
        // Sort by end increasing, if tie, start decreasing
        Arrays.sort(intervals, (a, b) -> 
            a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]
        );

        // last two chosen points
        int a = -1, b = -1; 
        int count = 0;

        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];

            boolean aIn = (a >= start);
            boolean bIn = (b >= start);

            // If both a and b are inside interval, nothing needed
            if (aIn && bIn) continue;

            // If only one is inside, add one more point (end)
            if (bIn) {
                count++;
                a = b;
                b = end;
            } 
            // If none is inside, add two points (end-1, end)
            else {
                count += 2;
                a = end - 1;
                b = end;
            }
        }

        return count;
    }
    // public int intersectionSizeTwo(int[][] intervals) {
    //     Arrays.sort(intervals, (a, b) -> 
    //         a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]
    //     );

    //     int ans = 0;
    //     int a = -1, b = -1;

    //     for (int[] it : intervals) {
    //         int l = it[0], r = it[1];

    //         if (l > b) {
    //             a = r - 1;
    //             b = r;
    //             ans += 2;
    //         } else if (l > a) {
    //             a = b;
    //             b = r;
    //             ans += 1;
    //         }
    //     }

    //     return ans;
    // }  



}