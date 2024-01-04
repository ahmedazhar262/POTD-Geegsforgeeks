// Find element occuring once when all other are present thrice

class Solution {
    static int singleElement(int[] arr , int N) {
        // code here
        int result = 0;

        // Iterate through each bit
        for (int i = 0; i < 32; i++) {
            int sum = 0;

            // Count the number of set bits at position i for all elements
            for (int j = 0; j < N; j++) {
                if ((arr[j] & (1 << i)) != 0) {
                    sum++;
                }
            }

            // If the sum is not a multiple of 3, then the single element has a set bit at position i
            if (sum % 3 != 0) {
                result |= (1 << i);
            }
        }

        return result;
    }         
}