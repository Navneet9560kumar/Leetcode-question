class Solution {
      public  int rev(int n) {
        int r = 0;
        while (n != 0) {
            r = r * 10 + n % 10;
            n = n / 10;
        }
        return r;
    }
    public int countNicePairs(int[] nums) {
        int count =0;
        int n= nums.length;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<n;i++){
            int ele = nums[i]-rev(nums[i]);
           if (map.containsKey(ele)){
                int freq = map.get(ele);
                count += freq;
                count %=1000000007;
                map.put(ele,freq+1);
            }
            else map.put(ele,1);
        }
        return count;
    }
}