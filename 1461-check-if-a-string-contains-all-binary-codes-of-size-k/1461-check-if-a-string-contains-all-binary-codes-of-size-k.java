class Solution {
    public boolean hasAllCodes(String s, int k) {
        int uniq =1<<k;
        boolean[]seen = new boolean[uniq];
        int mask= uniq-1,hash=0;
        for(int i=0;i<s.length();i++){
            hash= ((hash<<1)&mask)|(s.charAt(i)&1);
    if(i>=k-1&&!seen[hash]){
        seen[hash]=true;
        uniq--;
        if(uniq==0)return true;
    }
        }
        return false;
    }
}