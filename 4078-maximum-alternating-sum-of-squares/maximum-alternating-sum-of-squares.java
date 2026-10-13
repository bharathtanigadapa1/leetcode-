class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        long squared[]= new long[n];

        for(int i=0;i<n;i++){
            squared[i]=(long) nums[i]*nums[i];
        }
        Arrays.sort(squared);
        int half=n/2;
        long sum=0;
        for(int i=0;i<half;i++) sum-=squared[i];
        for(int i=half;i<n;i++) sum+=squared[i];
        return sum;
    }
}