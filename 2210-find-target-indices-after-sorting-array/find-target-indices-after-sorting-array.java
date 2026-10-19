class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        // Applying the concept of count 
        /*we simply count the numbers that are eauql to target and then less than target n.. Then the indicestareget indeices will be presrtn at next to last lest number */
        
        int targetNumberCount=0;
        int lessThanTarget=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<target){
                lessThanTarget++;
            }
            else if(nums[i]==target){
                targetNumberCount++;
            }
        }
        List<Integer> res= new ArrayList<>();
        for(int i=0;i<targetNumberCount;i++){
            res.add(lessThanTarget+i);
        }
        return res;
    }
}