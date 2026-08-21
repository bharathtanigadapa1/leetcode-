class Solution {
    public int jump(int[] nums) {
        int maxIndex=0;
        int jumps=0;
        int currentEnd=0;
        for(int i=0;i<nums.length-1;i++){
            maxIndex=Math.max(maxIndex,i+nums[i]);
            if(i==currentEnd){
                currentEnd=maxIndex;
                jumps++;
            }
        }
        return jumps;
    }
}