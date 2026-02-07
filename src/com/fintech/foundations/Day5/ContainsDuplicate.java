package com.fintech.foundations.Day5;

import java.util.HashSet;

/**
 * LeetCode #217 - Contains Duplicate
 * 
 * Problem: Check if array has any duplicates
 * Pattern: Lookup (HashSet existence check)
 * 
 * Fintech context: Detect duplicate PayShap transaction IDs
 * in a batch processing system to prevent double-charging.
 */
public class ContainsDuplicate {
    
    /**
     * Checks if array contains any duplicates.
     * 
     * Approach: HashSet to track seen elements
     * Time: O(n), Space: O(n)
     * 
     * @param nums Array of transaction IDs (as integers)
     * @return true if duplicates exist, false otherwise
     */
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            // Have we seen this transaction ID before?
            if (seen.contains(num)) {
                return true;  // Duplicate found!
            }
            
            // Remember this transaction ID
            seen.add(num);
        }
        
        // No duplicates found
        return false;
    }
    
    /**
     * Test cases
     */
    public static void main(String[] args) {
        // Test 1: Has duplicate
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Array [1,2,3,1] has duplicate: " + 
                          containsDuplicate(nums1));
        // Expected: true
        
        // Test 2: No duplicates
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Array [1,2,3,4] has duplicate: " + 
                          containsDuplicate(nums2));
        // Expected: false
        
        // Test 3: Multiple duplicates
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("Array with multiple duplicates: " + 
                          containsDuplicate(nums3));
        // Expected: true
        
        // Test 4: Empty array
        int[] nums4 = {};
        System.out.println("Empty array has duplicate: " + 
                          containsDuplicate(nums4));
        // Expected: false
        
        // Test 5: Single element
        int[] nums5 = {1};
        System.out.println("Single element [1] has duplicate: " + 
                          containsDuplicate(nums5));
        // Expected: false
    }
}