class Solution {
 public List<List<Integer>> combine(int n, int k){
            List<List<Integer>>result = new ArrayList<>();
            backtracking(result,new ArrayList<>(),1,n,k);
            return result;
          }

          public void backtracking(List<List<Integer>> result, List<Integer> comd, int start, int n, int k) {
            if (comd.size() == k) {
                  result.add(new ArrayList<>(comd));
                  return;
            }
            for (int i = start; i <= n; i++) {
                  comd.add(i);
                  backtracking(result, comd, i + 1, n, k);
                  comd.remove(comd.size() - 1);
            }
          }
}