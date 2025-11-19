class Solution {
public int subarraySum(int[] arr, int k){
        //     int count = 0;
        //     for(int i=0;i<arr.length;i++){
        //           int sum = 0;
        //           for(int j=i;j<arr.length;j++){
        //                 sum += arr[j];
        //                 if(sum == k)count++;
        //           }
        //     }
        //     return count;
        //   }   method frist 
 int count =0, n =arr.length;
            // make arr prefix sum array
            for(int i=1;i<n;i++){
                  arr[i] += arr[i-1];

            }
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<n;i++){
                  int ele = arr[i];
                  if(ele==k)count++;
                  int rem = ele -k;
                  if(map.containsKey(rem)) count += map.get(rem);
                  if(map.containsKey(ele)){
                        int freq = map.get(ele);
                        map.put(ele, freq +1);

                  }else map.put(ele, 1);
            }
            return count;
}
        
}