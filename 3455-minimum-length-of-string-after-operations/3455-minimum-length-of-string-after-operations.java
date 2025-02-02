class Solution {
    public int minimumLength(String s) {
        int[] arr = new int[26];
        for(char c : s.toCharArray()){
            arr[c-'a']++;
        }
        int count = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(arr[i]!=0 && arr[i]%2==0){
                count+=2;
            }
            else if(arr[i]!=0 && arr[i]%2!=0){
                count++;
            }
        }
        return count;
    }
}