/*

Reference: https://leetcode.com/problems/k-closest-points-to-origin/

973. K Closest Points to Origin

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)


Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
 

Note:

1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000

*/
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] output = new int[K][2];
        if(points == null || K ==0 || K > points.length)
            return output;
        
        PriorityQueue<int[]> queue = new PriorityQueue<>(K,
            new Comparator<int[]>() {
                public int compare(int[] a1, int[] a2) {
                    Double a1Val = Math.pow(a1[0], 2) + Math.pow(a1[1], 2);
                    Double a2Val = Math.pow(a2[0], 2) + Math.pow(a2[1], 2);
                    return a2Val.compareTo(a1Val);
                }
        });
        
        for(int i=0; i<points.length; i++) {
            queue.add(points[i]);
            if(queue.size() > K)
                queue.poll();
        }

        for(int i=0; i<K; i++) {
            int[] pair = queue.poll();
            output[i][0] = pair[0];
            output[i][1] = pair[1];
        }
        return output;
    }
}
