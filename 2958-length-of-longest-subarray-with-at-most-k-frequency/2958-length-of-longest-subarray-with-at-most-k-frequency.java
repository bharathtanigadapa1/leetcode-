class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int left=0;
        int ans=0;
        for(int right=0;right<nums.length;right++){
            int val=nums[right];
            map.put(val,map.getOrDefault(val,0)+1);

            while(map.get(val)>k){
                int ele=nums[left];
                map.put(ele,map.get(ele)-1);
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}