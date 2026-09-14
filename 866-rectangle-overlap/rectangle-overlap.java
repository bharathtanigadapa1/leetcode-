class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
       //for an overlap to exist we need to check that if min of x2 cordinates are in max of x1 cordinates  similary for y axis

       return Math.min(rec1[2],rec2[2]) > Math.max(rec1[0],rec2[0]) &&
              Math.min(rec1[3],rec2[3]) > Math.max(rec1[1],rec2[1]);
     }
}