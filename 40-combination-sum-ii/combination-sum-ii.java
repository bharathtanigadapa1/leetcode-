class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        Recursive(0,target,candidates,new ArrayList<>(),res);
        
        return res;
    }
    public void Recursive(int index,int target,int []arr,List<Integer> ans, List<List<Integer>> res){
        if(index==arr.length){
            if(target==0) res.add(new ArrayList<>(ans));
            return ;
        }
        if(arr[index]<=target){
            ans.add(arr[index]);
            Recursive(index+1,target-arr[index],arr,ans,res);
            ans.remove(ans.size()-1);
        }
        while(index+1 <arr.length && arr[index]==arr[index+1]) index++;
        Recursive(index+1,target,arr,ans,res);
    }
}