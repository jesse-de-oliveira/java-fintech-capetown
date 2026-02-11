package com.fintech.foundations.Day5;
import java.util.HashMap;

/**
 * LeetCode #242 - Valid Anagram
 * 
 * Problem: Check if two strings are anagrams
 * Pattern: Counting (Character Frequency)
 * 
 * Fintech context: Verify duplicate transaction IDs that might
 * be scrambled due to encoding issues in cross-border payments.
 */
public class ValidAnagram {
    
    /**
     * Checks if two strings are anagrams.
     * 
     * Approach: Compare frequency maps
     * Time: O(n), Space: O(1) - max 26 letters
     * 
     * @param s First string
     * @param t Second string
     * @return true if anagrams, false otherwise
     */

public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> freq = new HashMap<>();
        
        // Increment for s
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        // Decrement for t
        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) - 1);
            
            // If count goes negative, not an anagram
            if (freq.get(c) < 0) {
                return false;
            }
        }
        
        // All counts should be 0
        for (int count : freq.values()) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }

/**
 * Test cases
 */
public static void main(String[] args) {
    // Test 1: Valid anagram
    String s1 = "anagram";
    String t1 = "nagaram";
    System.out.println("'" + s1 + "' and '" + t1 + "': " + 
                      isAnagram(s1, t1));
    // Expected: true
    
    // Test 2: Not anagram
    String s2 = "rat";
    String t2 = "car";
    System.out.println("'" + s2 + "' and '" + t2 + "': " + 
                      isAnagram(s2, t2));
    // Expected: false
    
    // Test 3: Valid anagram (real words)
    String s3 = "listen";
    String t3 = "silent";
    System.out.println("'" + s3 + "' and '" + t3 + "': " + 
                      isAnagram(s3, t3));
    // Expected: true
    
    // Test 4: Different lengths
    String s4 = "abc";
    String t4 = "abcd";
    System.out.println("'" + s4 + "' and '" + t4 + "': " + 
                      isAnagram(s4, t4));
    // Expected: false
}
}
