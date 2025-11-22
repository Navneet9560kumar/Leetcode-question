class Solution {
  public int maxSatisfied(int[] arr, int[] grumpy, int k) {

        int n = arr.length, i = 0, j = k - 1, unsaticfied = 0;

        int maxunsaticfied = 0;   // ❌ pehle declare hi nahi kiya tha
        int a = i; 
        int b = 0;

        // first window
        for (int x = i; x <= j && x < n; x++) {
            if (grumpy[x] == 1) unsaticfied += arr[x];
        }

        // sliding window
        while (j < n) {

            if (maxunsaticfied < unsaticfied) {
                maxunsaticfied = unsaticfied;
                a = i; 
                b = j;
            }

            // move window
            j++;
            if (j < n && grumpy[j] == 1) unsaticfied += arr[j];

            // ❌ tum subtract karna bhool gaye the
            if (grumpy[i] == 1) unsaticfied -= arr[i];

            i++;
        }

        // window calm kar diya
        for (int x = a; x <= b; x++) {
            grumpy[x] = 0;
        }

        int satisfied = 0;

        for (int x = 0; x < n; x++) {
            // ❌ yahan tum arr[i] add kar rahe the — galat index
            if (grumpy[x] == 0) satisfied += arr[x];
        }

        return satisfied;   // ❌ missing return
    }
}