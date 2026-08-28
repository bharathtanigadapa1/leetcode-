class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean isPresent[]= new boolean[101];
        for(int num: nums){
            isPresent[num]=true;
        }
        for(int i=k;i<101;i+=k){
            if(!isPresent[i]){
                return i;
        }
        }
        return ((100/k)+1)*k;
    }
}