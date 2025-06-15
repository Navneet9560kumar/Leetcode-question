class Solution {
    public int maxDiff(int num) {
        String str = Integer.toString(num);

        // --- MAX number (a) ---
        char replaceMax = ' ';
        for (char c : str.toCharArray()) {
            if (c != '9') {
                replaceMax = c;
                break;
            }
        }
        String aStr = (replaceMax == ' ') ? str : str.replace(replaceMax, '9');
        int a = Integer.parseInt(aStr);

        // --- MIN number (b) ---
        char[] chars = str.toCharArray();
        char replaceMin = ' ';
        char target = ' ';

        if (chars[0] != '1') {
            replaceMin = chars[0];
            target = '1';
        } else {
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] != '0' && chars[i] != '1') {
                    replaceMin = chars[i];
                    target = '0';
                    break;
                }
            }
        }

        String bStr = (replaceMin == ' ') ? str : str.replace(replaceMin, target);
        int b = Integer.parseInt(bStr);

        return a - b;
    }
}
