class Solution {
     public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> smap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            smap.put(key, smap.getOrDefault(key, 0) + 1);
        }

        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            tmap.put(key, tmap.getOrDefault(key, 0) + 1);
        }

        // Compare both maps
        for (char key : smap.keySet()) {
            if (!tmap.containsKey(key)) return false;
            if (!smap.get(key).equals(tmap.get(key))) return false;
        }

        return true;
    }
}