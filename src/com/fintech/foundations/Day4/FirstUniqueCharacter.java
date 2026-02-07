package com.fintech.foundations.Day4;

import java.util.HashMap;

public class FirstUniqueCharacter {
    
    /**
     * Finds index of first non-repeating character.
     * 
     * Pattern: Frequency map + iteration
     * Time: O(n), Space: O(1) - max 26 lowercase letters
     * 
     * @param s Input string
     * @return Index of first unique char, or -1 if none
     */
    public static int firstUniqChar(String s) {
        // Step 1: Build frequency map
        HashMap<Character, Integer> freq = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        // Step 2: Find first character with count = 1
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (freq.get(c) == 1) {
                return i;  // Found first unique
            }
        }
        
        return -1;  // No unique character
    }
    
    /**
     * Test cases
     */
    public static void main(String[] args) {
        // Test 1: Unique exists at beginning
        String test1 = "leetcode";
        int result1 = firstUniqChar(test1);
        System.out.println("'" + test1 + "' -> Index " + result1);
        if (result1 != -1) {
            System.out.println("Character: '" + test1.charAt(result1) + "'");
        }
        System.out.println();
        
        // Test 2: Unique exists in middle
        String test2 = "loveleetcode";
        int result2 = firstUniqChar(test2);
        System.out.println("'" + test2 + "' -> Index " + result2);
        if (result2 != -1) {
            System.out.println("Character: '" + test2.charAt(result2) + "'");
        }
        System.out.println();
        
        // Test 3: No unique character
        String test3 = "aabb";
        int result3 = firstUniqChar(test3);
        System.out.println("'" + test3 + "' -> Index " + result3);
        System.out.println("(No unique character)");
    }
}