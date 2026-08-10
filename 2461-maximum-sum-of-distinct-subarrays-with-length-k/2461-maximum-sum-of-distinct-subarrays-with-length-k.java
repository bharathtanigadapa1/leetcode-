class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum=0,max=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<k;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])==1) sum+=nums[i];
        }
        max= map.size() == k ? sum : 0;
        for(int i=k;i<nums.length;i++){
            int out=nums[i-k];
            map.put(out,map.get(out)-1);
            if(map.get(out)==0){
                map.remove(out);
                sum-=out;
            }
            int in=nums[i];
            map.put(in,map.getOrDefault(in,0)+1);
            if(map.get(in)==1) sum+=in;
            if(map.size()==k && sum>max) max=sum;
        }
        return max;
    }
}