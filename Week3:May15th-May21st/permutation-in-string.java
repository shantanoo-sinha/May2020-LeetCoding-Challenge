/*

Reference: https://leetcode.com/problems/permutation-in-string/

567. Permutation in String

Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.


Example 1:
Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False


Note:
    The input strings only contain lower case letters.
    The length of both given strings is in range [1, 10,000].

*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty() || s1.length() > s2.length())
            return false;
        
        
        int[] charCount = new int[26];
        for(char c: s1.toCharArray())
            charCount[c-'a']++;
        
        int start = 0, end = 0, counter = s1.length();
        while(end < s2.length()) {
            if(charCount[s2.charAt(end++)-'a']-- >= 1)
                counter--;
            
            if(counter == 0)
                return true;
            
            if((end-start) == s1.length() && charCount[s2.charAt(start++)-'a']++ >= 0)
                counter++;
        }
        return false;
    }
}
