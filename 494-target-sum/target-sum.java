class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return Count(0,nums,target,0);
    }
    public static int Count(int index, int []nums, int target, int sum){
        if(index==nums.length  ){
            return sum==target ? 1:0;
        }
        return Count(index+1,nums,target,sum+nums[index]) + 
               Count(index+1,nums,target,sum-nums[index]);
    }
}