package com.fintech.foundations.Day5.Weekend1;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * LeetCode #49 - Group Anagrams
 * 
 * Problem: Group strings that are anagrams of each other
 * Pattern: Counting + Lookup (sorted string as key)
 * 
 * Fintech context: Group similar PayShap transaction descriptions
 * that might have typos or different word orders but refer to
 * the same merchant (e.g., "ABC Store", "Store ABC", "Stoer ABC")
 */
public class GroupAnagrams {
    
    /**
     * Groups anagrams together.
     * 
     * Approach: Use sorted string as HashMap key
     * Time: O(n × k log k) where n = number of strings, k = max length
     * Space: O(n × k) to store all strings
     * 
     * @param strs Array of strings
     * @return List of grouped anagrams
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        // Map: sorted string → list of original strings
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Sort the string to create key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
            // If key doesn't exist, create new list
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            
            // Add original string to group
            map.get(sorted).add(str);
        }
        
        // Return all groups (values of the map)
        return new ArrayList<>(map.values());
    }
    
    /**
     * Test cases
     */
    public static void main(String[] args) {
        // Test 1: Multiple anagram groups
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = groupAnagrams(strs1);
        System.out.println("Test 1: " + result1);
        // Expected: [["bat"], ["nat","tan"], ["ate","eat","tea"]]
        
        // Test 2: Single empty string
        String[] strs2 = {""};
        List<List<String>> result2 = groupAnagrams(strs2);
        System.out.println("Test 2: " + result2);
        // Expected: [[""]]
        
        // Test 3: Single string
        String[] strs3 = {"a"};
        List<List<String>> result3 = groupAnagrams(strs3);
        System.out.println("Test 3: " + result3);
        // Expected: [["a"]]
        
        // Test 4: No anagrams
        String[] strs4 = {"abc", "def", "ghi"};
        List<List<String>> result4 = groupAnagrams(strs4);
        System.out.println("Test 4: " + result4);
        // Expected: [["abc"], ["def"], ["ghi"]]
    }
}