// Given an array of integers nums and a number k, write a function that returns true if given array can be divided into pairs such that sum of every pair is divisible by k.

#include <unordered_map>
#include <vector>

class Solution {
public:
    bool canPair(std::vector<int>& nums, int k) {
        if (nums.size() % 2 != 0) {
            return false;
        }

        // Create a HashMap to store the remainders and their frequencies
        std::unordered_map<int, int> remainderCount;

        for (int num : nums) {
            int remainder = (num % k + k) % k; // Handle negative numbers

            // Update the count of remainders in the HashMap
            remainderCount[remainder]++;
        }

        // Check if each remainder has a corresponding complement remainder such that their sum is divisible by k
        for (int num : nums) {
            int remainder = (num % k + k) % k;
            int complement = (k - remainder) % k;

            // Check if the complement remainder is present in the HashMap
            if (remainderCount[complement] <= 0) {
                return false;
            }

            // Update the count of remainders in the HashMap
            remainderCount[complement]--;
        }

        return true;
    }
};
