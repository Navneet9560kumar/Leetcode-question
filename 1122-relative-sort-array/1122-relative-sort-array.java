class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int i = 0;

        // step 2 :arr2 ke order me fill'
        for (int num : arr2) {
            int count = map.get(num);
            while (count-- > 0) {
                arr1[i++] = num;
            }
            map.remove(num);
        }

        List<Integer> remaining = new ArrayList<>();

        for (int key : map.keySet()) {
            int count = map.get(key);
            while (count-- > 0) {
                remaining.add(key);
            }
        }
        Collections.sort(remaining);

        for (int num : remaining) {
            arr1[i++] = num;
        }

        return arr1;
    }
}