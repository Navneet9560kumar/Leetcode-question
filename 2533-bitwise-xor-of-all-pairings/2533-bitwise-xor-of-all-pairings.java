class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;

        int res=0;
        int x1=0,x2=0;
        for(int i=0;i<m;i++){
            x1=(x1^nums1[i]);
        }

        for(int i=0;i<n;i++){
            x2=(x2^nums2[i]);
        }

        if(m%2 !=0 ){
            res=res^x2;
        }
        if(n%2!=0){
            res=res^x1;
        }
        

        return res;
    }
}