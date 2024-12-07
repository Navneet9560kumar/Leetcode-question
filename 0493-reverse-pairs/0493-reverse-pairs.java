class Solution {

    static int count;
      public  void inversion(int []a, int [] b){
          int i=0,j=0;
          while (i < a.length && j < b.length)  {
               if((long)a[i]>((long)2*b[j])){
                    count += (a.length - i);
                    j++;
               }
               else i++;
          }
      }


      public  void merge(int[] a, int[] b, int[] c) {
          int i = 0, j = 0, k = 0;
          while (i < a.length && j < b.length) {
              if (a[i] <= b[j])
                  c[k++] = a[i++];
              else
                  c[k++] = b[j++];
          }
          while (i < a.length) {
              c[k++] = a[i++];
          }
          while (j < b.length) {
              c[k++] = b[j++];
          }
      }
  
      public  void mergesort(int[] arr) {
          int n = arr.length;
          if (n == 1)
              return; // base case
  
          int[] a = new int[n / 2];
          int[] b = new int[n - n / 2];
  
          // Splitting array into two halves
          for (int i = 0; i < n / 2; i++) {
              a[i] = arr[i]; // Copy first half into a
          }
          for (int i = 0; i < n - n / 2; i++) {
              b[i] = arr[i + n / 2]; // Copy second half into b
          }
  
          // Recursive calls
          mergesort(a);
          mergesort(b);
  inversion(a,b);
          // Merging sorted halves
          merge(a, b, arr);
      }

    public int reversePairs(int[] nums) {
        count =0;
        mergesort(nums);
        return count;
    }
}