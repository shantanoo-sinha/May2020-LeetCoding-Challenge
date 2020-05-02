/*

Reference: https://leetcode.com/problems/jewels-and-stones/

771. Jewels and Stones

You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:
Input: J = "aA", S = "aAAbbbb"
Output: 3

Example 2:
Input: J = "z", S = "ZZ"
Output: 0

Note:
    S and J will consist of letters and have length at most 50.
    The characters in J are distinct.

*/
//My first solution
class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewel = new HashSet<>();
        for(char c: J.toCharArray()) {
            jewel.add(c);
        }
        int count = 0;
        for(char c: S.toCharArray()) {
            if(jewel.contains(c))
                count++;
        }
        return count;
    }
}

//A better time complexity solution
class Solution {
    public int numJewelsInStones(String J, String S) {
        int[] arr = new int[58];
        for(char c: J.toCharArray()) {
            arr[c - 'A'] = 1;
        }
        int count = 0;
        for(char c: S.toCharArray()) {
            count += arr[c-'A'];
        }
        return count;
    }
}
