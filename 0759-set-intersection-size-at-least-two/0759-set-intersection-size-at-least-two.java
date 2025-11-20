class Solution {


    public int intersectionSizeTwo(int[][] intervals) {
    // Pehle intervals ko sort karenge:
    // 1) end value increasing order mein
    // 2) agar end same ho to start value decreasing order mein
    Arrays.sort(intervals, (a, b) ->
        a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]
    );

    // a aur b – yeh hamare last do selected points ko track karenge
    int a = -1, b = -1;
    int count = 0; // total selected points

    for (int[] interval : intervals) {
        int start = interval[0], end = interval[1];

        // check karo kya a aur b iss interval ke andar aa rahe hain
        boolean aIn = (a >= start);
        boolean bIn = (b >= start);

        // Agar dono points interval ke andar already hai,
        // to koi naya number choose karne ki zarurat nahi
        if (aIn && bIn) continue;

        // Agar sirf b interval ke andar hai,
        // to bas ek naya point add karna hoga (end wale jagah pe)
        if (bIn) {
            count++;   // ek point add kar diya
            a = b;     // a ko b ki value de di (shift)
            b = end;   // naya point end hai
        }
        // Agar a aur b dono interval se bahar hain,
        // to hume 2 points add karne honge (end-1 aur end)
        else {
            count += 2; 
            a = end - 1; 
            b = end;
        }
    }

    return count;
}
// second  methoda 
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


