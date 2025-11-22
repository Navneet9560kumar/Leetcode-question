class Solution {
   public static int totalFruit(int[] arr) {
                        int n = arr.length, i=0, j=0, maxLen =0;
                        Map<Integer, Integer>map = new HashMap<>();
                        while (j<n) {
                              if(map.containsKey(arr[j])){
                                    int freq = map.get(arr[j]);
                                    map.put(arr[j],freq+1);
                              }
                              else map.put(arr[j],1);

                              while (map.size()>2){
                                    int freq = map.get(arr[i]);
                                    if(freq==1)map.remove(arr[i]);
                                    else map.put(arr[i],freq-1);
                                    i++;
                              }
                              maxLen = Math.max(maxLen,j-i+1);
                              j++;
                        }
                        return maxLen;
    }
    
   
}