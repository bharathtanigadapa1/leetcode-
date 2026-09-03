class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        generate(0,new ArrayList<>(),nums,res);
        return res;
    }
    public void generate(int index, List<Integer> nums,int arr[], List<List<Integer>> res){
        if(index==arr.length){
            res.add(new ArrayList<>(nums));
            return ;
        }
        nums.add(arr[index]);// This is considering the the current element
        generate(index+1,nums,arr,res);
        nums.remove(nums.size()-1); //removing the considered element 
        generate(index+1,nums,arr,res);
    }
}