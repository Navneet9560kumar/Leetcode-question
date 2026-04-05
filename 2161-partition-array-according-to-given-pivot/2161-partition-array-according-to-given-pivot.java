class Solution {
  public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;

        List<Integer> lessPivot = new ArrayList<>();
        List<Integer> equalPivot = new ArrayList<>();
        List<Integer> greaterPivot = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) {
                lessPivot.add(num);
            } else if (num == pivot) {
                equalPivot.add(num);
            } else {
                greaterPivot.add(num);
            }
        }

        List<Integer> result = new ArrayList<>();
        result.addAll(lessPivot);
        result.addAll(equalPivot);
        result.addAll(greaterPivot);

        return result.stream().mapToInt(i -> i).toArray();
    }

}