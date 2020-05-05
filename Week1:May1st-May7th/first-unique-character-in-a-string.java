/*

Reference: https://leetcode.com/problems/first-unique-character-in-a-string/

387. First Unique Character in a String

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:
s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters.

*/
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            if(set.contains(s.charAt(i)))
                map.remove(s.charAt(i));
            else {
                set.add(s.charAt(i));
                map.put(s.charAt(i), i);
            }
        }
        return map.isEmpty() ? -1 : map.entrySet().iterator().next().getValue();
    }
}
