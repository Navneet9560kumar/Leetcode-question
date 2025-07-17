import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = nums[i] % k;
        }
        
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            l.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            l.get(r[i]).add(i);
        }
        
        int m = 0;
        for (List<Integer> lst : l) {
            m = Math.max(m, lst.size());
        }
        
        if (k == 0 || k == 1) {
            return m;
        }
        
        for (int x = 0; x < k; x++) {
            for (int y = x + 1; y < k; y++) {
                List<Integer> a = l.get(x);
                List<Integer> b = l.get(y);
                int la = a.size();
                int lb = b.size();
                if (la == 0 && lb == 0) {
                    continue;
                }
                int i = 0, j = 0;
                int sx = 0, sy = 0;
                while (i < la || j < lb) {
                    if (j == lb || (i < la && a.get(i) < b.get(j))) {
                        int nx = 1;
                        if (sy > 0) {
                            nx = sy + 1;
                        }
                        if (nx > sx) {
                            sx = nx;
                        }
                        i++;
                    } else {
                        int ny = 1;
                        if (sx > 0) {
                            ny = sx + 1;
                        }
                        if (ny > sy) {
                            sy = ny;
                        }
                        j++;
                    }
                }
                int c = Math.max(sx, sy);
                if (c > m) {
                    m = c;
                }
            }
        }
        return m;
    }
}