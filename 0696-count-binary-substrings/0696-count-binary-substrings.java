class Solution {
    public int countBinarySubstrings(String s) {
        int n= s.length();
        int res=0, pre=0,str=1;
        
        for(int i=1;i<n;i++){
           
                if(s.charAt(i)== s.charAt(i-1))str++;
                        else{
                            pre =str;
                            str=1;
                        }
                        if(str<=pre)res++;
        }

                    
                    return res;


    }
}