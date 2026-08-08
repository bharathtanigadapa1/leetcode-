class Solution {
    public int majorityElement(int[] nums) {
        int candidate=nums[0];
        int count=0;
        for(int num : nums)
        {
            if(count==0) {
                candidate=num;
                count++;
            }
            else if(candidate==num) count++;
            else count--;
        }
        //For checking majority exist aor not for this [roblem ist is not neccesrray]
        /*int freq=0;
        for(int num: nums)
        {
            if(num==candidate) frea++;
        }
        if(freq<=nums.length/2)  candidate=-1;*/
        return candidate;
    }
}