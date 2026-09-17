class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        // Sliding Window + prefix minimum Approach
        // Using sindg windw we find the subbarray whose sum fi target
        // With prefx min we kep track of until the curretn index wht is the minim length of substring with target sum

        int n=arr.length;
        int best[]= new int[n];

        Arrays.fill(best,Integer.MAX_VALUE);
        int sum=0;
        int left=0;
        int ans=Integer.MAX_VALUE;
        for(int right=0;right<n;right++){
            sum+=arr[right];
            while(sum>target){
                sum-=arr[left];
                left++;
            }
            if(sum==target){ 
                int curLength= right-left+1;
                if(left>0 && best[left-1]!=Integer.MAX_VALUE){
                    ans=Math.min(ans,curLength+best[left-1]);
                }
                best[right]=curLength;
            }
            if(right>0){
                best[right]=Math.min(best[right],best[right-1]);
            }
        }
        return ans==Integer.MAX_VALUE ? -1: ans;
    }
}