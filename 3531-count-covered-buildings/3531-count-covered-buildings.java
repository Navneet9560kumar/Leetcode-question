class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer,TreeSet<Integer>> rows=new HashMap<>();
        Map<Integer,TreeSet<Integer>> cols=new HashMap<>();
        for(int build[]: buildings){
            int x=build[0];
            int y=build[1];
            rows.computeIfAbsent(x,k-> new TreeSet<>()).add(y);
            cols.computeIfAbsent(y,k-> new TreeSet<>()).add(x);
        }
        int count=0;
        for(int build[]: buildings){
            int x=build[0];
            int y=build[1];
            Integer left=rows.get(x).lower(y);
            Integer right=rows.get(x).higher(y);
            Integer up=cols.get(y).higher(x);
            Integer down=cols.get(y).lower(x);

            if((left!=null ) && (right!=null) && (up!=null) && (down!=null)){
                count++;
            }
        }
        return count;
    }
}