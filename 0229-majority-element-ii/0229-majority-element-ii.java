class Solution {
    public List<Integer> majorityElement(int[] v) {
        int n = v.length;
        List<Integer> ls = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (ls.size() == 0 || ls.get(0) != v[i]) {
                int cnt = 0;
             for (int j = 0; j < n; j++) {
                    if (v[j] == v[i]) {
                        cnt++;
                    }
                }
                 if (cnt > (n / 3)) {
                    ls.add(v[i]);
                }
            }
            
             if (ls.size() == 2) {
                break;
            }
        }
        
        return ls;
    }
}