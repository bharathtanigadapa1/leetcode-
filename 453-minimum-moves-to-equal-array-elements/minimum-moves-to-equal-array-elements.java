class Solution {
    public int minMoves(int[] nums) {
        //Instead of thinginking like incrementing all n-1 elements if we decrement that one element we will get the same thing as asked.
        
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
        }

        int moves = 0;
        for (int num : nums) {
            moves += num - min;
        }

        return moves;
    }
}