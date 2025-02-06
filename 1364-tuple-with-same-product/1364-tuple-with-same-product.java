class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int prod=nums[i]*nums[j];
                mp.put(prod,mp.getOrDefault(prod,0)+1);
            }
        }
        int count = 0;
        for (int ele : mp.values()) {
            if (ele > 1) {
                count += ele * (ele - 1) / 2; 
            }
        }
        return count * 8;
    }
}