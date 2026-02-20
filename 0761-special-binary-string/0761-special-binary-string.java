class Solution {
    public String makeLargestSpecial(String s) {
           List<String> list = new ArrayList<>();
           int count =0,start=0;
           for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')count++;
            else count--;

            if(count==0){
                String inner  = s.substring(start+1,i);
                list.add("1" + makeLargestSpecial(inner)+ "0");
                start= i+1;
            }
           }
            Collections.sort(list, Collections.reverseOrder());
        return String.join("", list);
    }
}