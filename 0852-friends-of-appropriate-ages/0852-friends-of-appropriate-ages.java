class Solution {
       public int numFriendRequests(int[] ages) {
        Arrays.sort(ages); 
        int count = 0;
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] <= 14) continue;
            int minAge = (int) (0.5 * ages[i] + 7);
            int left = findLowerBound(ages, minAge + 1);
            int right = findUpperBound(ages, ages[i]);
            if (left <= right) {
                count += right - left;
            }
        }
        return count;
    }

    private int findLowerBound(int[] ages, int target) {
        int left = 0, right = ages.length - 1, result = ages.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (ages[mid] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private int findUpperBound(int[] ages, int target) {
        int left = 0, right = ages.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (ages[mid] <= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}






