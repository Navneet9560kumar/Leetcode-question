class Solution {
    public boolean canChange(String start, String target) {
             StringBuilder startPositions = new StringBuilder();
        StringBuilder targetPositions = new StringBuilder();

         for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != '_') {
                startPositions.append(start.charAt(i));
            }
            if (target.charAt(i) != '_') {
                targetPositions.append(target.charAt(i));
            }
        }
          if (!startPositions.toString().equals(targetPositions.toString())) {
            return false;
        }

             int startIndex = 0, targetIndex = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != '_') {
                // Find the next non-blank in the target string
                while (target.charAt(targetIndex) == '_') {
                    targetIndex++;
                }

                // 'L' must not move right and 'R' must not move left
                char piece = start.charAt(i);
                if ((piece == 'L' && i < targetIndex) || (piece == 'R' && i > targetIndex)) {
                    return false;
                }
                targetIndex++; // Move to the next non-blank position
            }
        }

        return true;
    

    }
}