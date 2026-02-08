package com.fintech.foundations.Day5.Weekend1;
import java.util.HashSet;
import java.util.ArrayList;

/**
 * LeetCode #349 - Intersection of Two Arrays
 * 
 * Problem: Find unique common elements between two arrays
 * Pattern: Lookup (HashSet for O(1) contains check)
 * 
 * Fintech context: Find common transaction IDs between
 * two PayShap processing batches to detect duplicates.
 */
public class IntersectionArrays {
    
    /**
     * Finds intersection of two arrays.
     * 
     * Approach: Use HashSet for fast lookup
     * Time: O(n + m) where n, m are array lengths
     * Space: O(n) to store first array in set
     * 
     * @param nums1 First array
     * @param nums2 Second array
     * @return Array of unique common elements
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        // Put all elements from nums1 in a set (removes duplicates)
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        
        // Find common elements
        HashSet<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);  // HashSet ensures uniqueness
            }
        }
        
        // Convert HashSet to array
        int[] output = new int[result.size()];
        int i = 0;
        for (int num : result) {
            output[i++] = num;
        }
        
        return output;
    }
    
    /**
     * Test cases
     */
    public static void main(String[] args) {
        // Test 1: Multiple common elements
        int[] nums1a = {1, 2, 2, 1};
        int[] nums2a = {2, 2};
        int[] result1 = intersection(nums1a, nums2a);
        System.out.print("Test 1: [");
        for (int num : result1) System.out.print(num + " ");
        System.out.println("]");
        // Expected: [2]
        
        // Test 2: Multiple intersections
        int[] nums1b = {4, 9, 5};
        int[] nums2b = {9, 4, 9, 8, 4};
        int[] result2 = intersection(nums1b, nums2b);
        System.out.print("Test 2: [");
        for (int num : result2) System.out.print(num + " ");
        System.out.println("]");
        // Expected: [9, 4] or [4, 9]
        
        // Test 3: No intersection
        int[] nums1c = {1, 2, 3};
        int[] nums2c = {4, 5, 6};
        int[] result3 = intersection(nums1c, nums2c);
        System.out.print("Test 3: [");
        for (int num : result3) System.out.print(num + " ");
        System.out.println("]");
        // Expected: []
    }
}