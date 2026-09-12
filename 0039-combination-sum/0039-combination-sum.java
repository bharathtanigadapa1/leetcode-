class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        Recursive(0,candidates,target,new ArrayList<>(),ans);
        return ans;
    }
    private void Recursive(int index, int arr[], int target,List<Integer> res,List<List<Integer>> ans){
        if(index==arr.length){
            if(target==0) ans.add(new ArrayList<>(res));
            return ;
        }
        if(arr[index]<=target) {
            res.add(arr[index]);
            Recursive(index,arr,target-arr[index],res,ans);
            res.remove(res.size()-1);
        }
        Recursive(index+1,arr,target,res,ans);
    }
}