class Solution {
    public boolean isCircularSentence(String sentence) {
          String[] words = sentence.split(" ");
          // dekh rahe ke last hota hai 
             if (words[0].charAt(0) != words[words.length - 1].charAt(words[words.length - 1].length() - 1)) {
            return false;
        }
          for (int i = 0; i < words.length - 1; i++) {
            String currentWord = words[i];
            String nextWord = words[i + 1];
            
            // If the last character of the current word does not match the first character of the next word, return false
            if (currentWord.charAt(currentWord.length() - 1) != nextWord.charAt(0)) {
                return false;
            }
        }
        
        // If all checks pass, the sentence is circular
        return true;
    }
}
   