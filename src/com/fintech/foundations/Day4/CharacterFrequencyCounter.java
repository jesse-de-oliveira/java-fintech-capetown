package com.fintech.foundations.Day4;

import java.util.HashMap;

public class CharacterFrequencyCounter {
    
    /**
     * Counts frequency of each character in string.
     * 
     * Pattern: Counting with HashMap
     * Time: O(n), Space: O(k) where k = unique chars
     * 
     * @param s Input string
     * @return HashMap with character counts
     */
    public static HashMap<Character, Integer> countCharacters(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        
        // Count each character
        for (char c : s.toCharArray()) {
            // getOrDefault returns 0 if key doesn't exist
            // Then we add 1
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        return freq;
    }
    
    /**
     * Test cases
     */
    public static void main(String[] args) {
        // Test 1: Simple word
        String test1 = "fintech";
        HashMap<Character, Integer> result1 = countCharacters(test1);
        System.out.println("'" + test1 + "' frequencies:");
        for (char c : result1.keySet()) {
            System.out.println(c + ": " + result1.get(c));
        }
        System.out.println();
        
        // Test 2: Repeated letters
        String test2 = "leetcode";
        HashMap<Character, Integer> result2 = countCharacters(test2);
        System.out.println("'" + test2 + "' frequencies:");
        for (char c : result2.keySet()) {
            System.out.println(c + ": " + result2.get(c));
        }
        System.out.println();
        
        // Test 3: Find most frequent character
        String test3 = "programming";
        HashMap<Character, Integer> result3 = countCharacters(test3);
        
        char mostFrequent = ' ';
        int maxCount = 0;
        
        for (char c : result3.keySet()) {
            if (result3.get(c) > maxCount) {
                maxCount = result3.get(c);
                mostFrequent = c;
            }
        }
        
        System.out.println("In '" + test3 + "':");
        System.out.println("Most frequent: '" + mostFrequent + 
                          "' appears " + maxCount + " times");
    }
}