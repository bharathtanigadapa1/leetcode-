class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0,high=0;
        for(int num :  nums){
            if(num>low) low=num;
            high+=num;
        }
        while(low<high){
            int mid=low+(high-low)/2;
            if(possible(nums,k,mid)){
                
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    private  boolean possible(int nums[] ,int k, int mid){
        int count=1;
        int sum=0;
        for(int num: nums){
            if(sum+num>mid){
                count++;
                sum=num;
                if(count>k) return false;
            }
            else{
                sum+=num;
            }
        }
        return count<=k;
    }
}