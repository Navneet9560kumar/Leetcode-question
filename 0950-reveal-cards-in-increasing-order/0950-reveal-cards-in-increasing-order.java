class Solution {
     public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] result = new int[n];
        
        boolean skip = false;
        
        int i = 0; // deck
        int j = 0; // result
        
        Arrays.sort(deck);
        
        while (i < n) {
            if (result[j] == 0) { // khali hai
                if (!skip) {
                    result[j] = deck[i];
                    i++;
                }
                
                skip = !skip; // alternate
            }
            
            j = (j + 1) % n;
        }
        
        return result;
    }
}