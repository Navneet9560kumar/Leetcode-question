class Solution {


    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Map<String, Integer> priority = new HashMap<>();
        priority.put("electronics", 0);
        priority.put("grocery", 1);
        priority.put("pharmacy", 2);
        priority.put("restaurant", 3);

        List<String[]> validCoupons = new ArrayList<>();

        int n = code.length;

        for (int i = 0; i < n; i++) {

            // Condition 1: active hona chahiye
            if (!isActive[i]) continue;

            // Condition 2: code valid hona chahiye
            if (code[i] == null || code[i].isEmpty() ||
                !code[i].matches("[a-zA-Z0-9_]+")) {
                continue;
            }

            // Condition 3: business line valid honi chahiye
            if (!priority.containsKey(businessLine[i])) {
                continue;
            }

            validCoupons.add(new String[]{businessLine[i], code[i]});
        }

        // Sorting
        Collections.sort(validCoupons, (a, b) -> {
            int bl = priority.get(a[0]) - priority.get(b[0]);
            if (bl != 0) return bl;
            return a[1].compareTo(b[1]);
        });

        // Final answer
        List<String> result = new ArrayList<>();
        for (String[] c : validCoupons) {
            result.add(c[1]);
        }

        return result;
    
    }
}