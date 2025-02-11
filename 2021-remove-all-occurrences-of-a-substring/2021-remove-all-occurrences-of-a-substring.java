class Solution {

   public String removeOccurrences(String s, String part) {
        StringBuffer str = new StringBuffer(s);
        while(str.length() > 0 && str.indexOf(part) < str.length()) {
            if(str.indexOf(part) == -1)
                return str.toString();
            else 
                str.delete(str.indexOf(part), str.indexOf(part)+part.length());
        }

        return str.toString();
    }
}