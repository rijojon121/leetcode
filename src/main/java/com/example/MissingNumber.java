package com.example;

public class MissingNumber {

    /**
     * Function to find the missing number in an array of distinct numbers
     * @param nums - Array of distinct numbers
     * @return Missing number
     */
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        // Calculate the sum of the first n natural numbers
        int expectedSum = (n * (n + 1)) / 2;
        // Calculate the sum of the elements in the array
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        // The missing number is the difference between the expected sum and the actual sum
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {3, 0, 1};
        System.out.println("Output for [3, 0, 1]: " + missingNumber(nums1)); // Output: 2

        int[] nums2 = {0, 1};
        System.out.println("Output for [0, 1]: " + missingNumber(nums2)); // Output: 2

        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("Output for [9, 6, 4, 2, 3, 5, 7, 0, 1]: " + missingNumber(nums3)); // Output: 8
    }
}
