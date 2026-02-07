package com.fintech.foundations.Day3;
import java.util.HashMap;

/**
* LeetCode #1 - Two Sum
* 
* Problem:
* Given an array of integers nums and an integer target,
* return indices of the two numbers that add up to target.
* 
* Example:
* Input: nums = [2,7,11,15], target = 9
* Output: [0,1]
* Explanation: nums[0] + nums[1] = 2 + 7 = 9
* 
* Constraints:
* - Each input has exactly one solution
* - Cannot use the same element twice
* 
* @author Jesse De Oliveira
* @since 2026-02-05
*/
public class TwoSum {
   
   /**
    * BRUTE FORCE SOLUTION (Not optimal - for comparison)
    * Time Complexity: O(n²) - nested loops
    * Space Complexity: O(1) - no extra space
    * 
    * This works but is TOO SLOW for interviews.
    * Included to show the difference.
    */
	
	public static int[] twoSumBruteForce(int[] nums, int target) {
        // Check every pair of numbers
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // If this pair adds to target, return their indices
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        
        // If no solution found (problem guarantees one exists)
        return new int[] {};
    }
	
	/**
     * OPTIMAL SOLUTION (This is what you use in interviews)
     * Time Complexity: O(n) - single pass through array
     * Space Complexity: O(n) - HashMap stores up to n elements
     * 
     * Key insight: Use HashMap to remember what we've seen.
     * For each number, check if we've seen its complement.
     */
    public static int[] twoSum(int[] nums, int target) {
    	// HashMap stores: number → index
        // This lets us check "have we seen this number?" in O(1) time
        HashMap<Integer, Integer> map = new HashMap<>();
        
     // Go through array once
        for (int i = 0; i < nums.length; i++) {
            // Calculate what number we NEED to reach target
            // If current number is 2 and target is 9, we need 7
            int complement = target - nums[i];
            
            // Check if we've already seen the complement
            if (map.containsKey(complement)) {
                // Found it! Return the two indices
                // map.get(complement) = index where we saw complement
                // i = current index
                return new int[] {map.get(complement), i};
            }
            
            // Haven't found complement yet
            // Store current number and its index for future lookups
            map.put(nums[i], i);
        }
        
        // If we get here, no solution exists
        // (Problem guarantees solution exists, so this won't happen)
        return new int[] {};
    }
    /**
     * Main method - Test both solutions
     */
    	
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════");
        System.out.println("   LEETCODE #1 - TWO SUM");
        System.out.println("═══════════════════════════════════════\n");
        
        // ═══════════════════════════════════════════════════════
        // TEST CASE 1: Example from problem description
        // ═══════════════════════════════════════════════════════
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        
        System.out.println("Test 1:");
        System.out.println("Input: nums = [2, 7, 11, 15], target = 9");
        
        int[] result1 = twoSum(nums1, target1);
        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]");
        System.out.println("Explanation: nums[" + result1[0] + "] + nums[" + 
                          result1[1] + "] = " + nums1[result1[0]] + " + " + 
                          nums1[result1[1]] + " = " + target1);
        System.out.println();
        
        // ═══════════════════════════════════════════════════════
        // TEST CASE 2: Different numbers
        // ═══════════════════════════════════════════════════════
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        
        System.out.println("Test 2:");
        System.out.println("Input: nums = [3, 2, 4], target = 6");
        
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]");
        System.out.println("Explanation: nums[" + result2[0] + "] + nums[" + 
                          result2[1] + "] = " + nums2[result2[0]] + " + " + 
                          nums2[result2[1]] + " = " + target2);
        System.out.println();
    
        // ═══════════════════════════════════════════════════════
        // TEST CASE 3: Only two numbers
        // ═══════════════════════════════════════════════════════
        int[] nums3 = {3, 3};
        int target3 = 6;
        
        System.out.println("Test 3:");
        System.out.println("Input: nums = [3, 3], target = 6");
        
        int[] result3 = twoSum(nums3, target3);
        System.out.println("Output: [" + result3[0] + ", " + result3[1] + "]");
        System.out.println();
        
        // ═══════════════════════════════════════════════════════
        // COMPARE BRUTE FORCE vs OPTIMAL
        // ═══════════════════════════════════════════════════════
        System.out.println("═══════════════════════════════════════");
        System.out.println("PERFORMANCE COMPARISON:");
        System.out.println("═══════════════════════════════════════");
        System.out.println("Brute Force: O(n²) time, O(1) space");
        System.out.println("  - Checks every pair");
        System.out.println("  - For 1000 numbers: 1,000,000 operations");
        System.out.println("  - Too slow for real systems");
        System.out.println();
        System.out.println("HashMap Solution: O(n) time, O(n) space");
        System.out.println("  - Single pass through array");
        System.out.println("  - For 1000 numbers: 1,000 operations");
        System.out.println("  - 1000x faster! ✓");
        System.out.println("═══════════════════════════════════════");
    }
}



