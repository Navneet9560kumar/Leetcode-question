class Solution {
    public boolean rotateString(String s, String goal) {
        // Step 1: Check karo agar dono strings ki length same hai
        // Agar length same nahi hai, toh goal kabhi bhi s ka rotation nahi ho sakta
        //( in english 😉😉 = Step 1: Check if lengths are the same)
         if (s.length() != goal.length()) {
            return false;
        }
         // Step 2: s ko usi ke saath concatenate karo (s + s)
        // Yeh isliye ki hum sari possible rotations ko cover kar sakein
        //(in English 😉😉 =   // Step 2: Check if goal is a substring of s + s)
          String doubled = s + s;


        // Step 3: Check karo agar goal string doubled wale string ka substring hai
        // Agar goal, doubled ka substring hai toh return true, warna false
        //(in english 😉😉 // Step 3: Check if the goal string is a substring of the doubled string
// If goal is a substring of doubled, then return true; otherwise, return false )
        return doubled.contains(goal);
    }
}