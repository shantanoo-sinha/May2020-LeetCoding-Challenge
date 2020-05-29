/*

Reference: https://leetcode.com/problems/counting-bits/

338. Counting Bits

Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]

Example 2:

Input: 5
Output: [0,1,1,2,1,2]

Follow up:
    It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
    Space complexity should be O(n).
    Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

*/
// O(n * sizeOf(Integer)) single pass solution
class Solution {
    public int[] countBits(int num) {
        // Store a cache array containing the number of set bits in a nibble (4 bits number)
        // Iterate from 1 to number
        // Use bit manipulation to find the last 4 bits of the number 
        // and lookup the number of set bits from the cache array
        // Keep on adding the number of set bits for every last 4 bits of the number
        // Repeat the process untill the number becomes 0
        //
        // Example 1:
        // n=15 (1111)
        // last 4 bits = 1111 & 1111 = 1111
        // lookup the number of bits from the cache array = 4
        // total set bits = 4
        // n=n>>4
        // 1111 >> 4 = 0000
        // Since, the number became 0, we will stop.
        //
        // Example 2:
        // n=27 (11011)
        // last 4 bits = 1011 & 1111 = 1011
        // lookup the number of bits from the cache array = 3
        // total set bits = 3
        // n=n>>4
        // 11011 >> 4 = 0001
        // last 4 bits = 0001 & 1111 = 0001
        // lookup the number of bits from the cache array = 1
        // total set bits = 3 + 1 = 4
        // 0001 >> 4 = 0000
        // Since, the number became 0, we will stop.
        int[] numToBits = new int[] { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4 };
        int[] output = new int[num+1];
        for(int i=1; i<= num; i++) {
            int j = i, nibble = 0;
            while(j != 0) {
                nibble = j & 15;
                output[i] += numToBits[nibble];
                j >>= 4;
            }
        }
        return output;
    }
}

// O(n) single pass solution
class Solution {
    public int[] countBits(int num) {
        // If number n is odd, the number of set bits will be 
        // one more than the number of set bits in number (n-1)
        // Example 1:
        // n=15 (1111)
        // number of set bits = 4
        // n=14 (1110)
        // number of set bits = 3
        // So, number of set bits in 15 =  (number of set bit in 14) + 1
        // 
        // Example 2:
        // n=27 (11011)
        // number of set bits = 4
        // n=26 (11010)
        // number of set bits = 3
        // So, number of set bits in 27 =  (number of set bit in 26) + 1
        //
        // If number n is even, the number of set bits will be 
        // same as in the number (n >> 1) or n/2.
        // Example 1:
        // n=14 (1110)
        // number of set bits = 3
        // n=(14>>1) = 7 (111)
        // number of set bits = 3
        // So, number of set bits in 14 =  number of set bit in 14>>1 = 7
        // 
        // Example 2:
        // n=26 (11010)
        // number of set bits = 3
        // n=(26>>1) = 13 (1101)
        // number of set bits = 3
        // So, number of set bits in 26 =  number of set bit in 26>>1 = 13
        int[] output = new int[num+1];
        for(int i=1; i<= num; i++) {
            output[i] = ((i & 1) == 1) ? output[i-1] + 1 : output[i >> 1];
        }
        return output;
    }
}
