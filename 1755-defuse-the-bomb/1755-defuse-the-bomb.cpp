class Solution {
public:
     vector<int> decrypt(vector<int>& code, int k) {
        int n = code.size();
        vector<int> result(n, 0); // Initialize result with 0

        if (k == 0) {
            return result; // All elements are 0 if k == 0
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;

            if (k > 0) {
                // Sum of the next k elements
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n]; // Circular indexing
                }
            } else {
                // Sum of the previous |k| elements
                for (int j = 1; j <= abs(k); j++) {
                    sum += code[(i - j + n) % n]; // Circular indexing for negative direction
                }
            }

            result[i] = sum;
        }

        return result;
    }
};