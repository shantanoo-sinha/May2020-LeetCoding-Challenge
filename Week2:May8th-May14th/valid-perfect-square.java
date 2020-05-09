/*

Reference: https://leetcode.com/problems/valid-perfect-square/

367. Valid Perfect Square

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:
Input: 16
Output: true

Example 2:
Input: 14
Output: false

*/
class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i = i + 2;
        }
        return num == 0;
    }
}
// Slightly modified loop
class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > i) {
            num -= i;
            i = i + 2;
        }
        return num == i;
    }
}
