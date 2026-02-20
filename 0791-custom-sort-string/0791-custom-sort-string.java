class Solution {
    public String customSortString(String order, String s) {
        int n = s.length();
     Map<Character, Integer> map = new HashMap<>();
       for(int i=0;i<order.length();i++){
        map.put(order.charAt(i), i);
       }
       // ab charcter ko stringmai convert kar rahe ahi 
        Character[] arr = new Character[s.length()];
         for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        // sort the array 
         Arrays.sort(arr, (a, b) -> {
            int p1 = map.getOrDefault(a, 100);
            int p2 = map.getOrDefault(b, 100);
            return p1 - p2;
        });

        //convert in to string 
           StringBuilder result = new StringBuilder();
        for (char c : arr) {
            result.append(c);
        }
        
        return result.toString();
    }
}