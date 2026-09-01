class Solution {
    public int[] countBits(int n) {
        int ans[] = new int [n+1];
        ans[0]=0;
        for(int i=1;i<=n;i++){
            ans[i]=ans[i>>1]+(i&1); // in ehich ans[i>>1] divides the number by 2 so loosing it last most bit we need add tis to our relsult if it is one so we used i&1 which add 1 if i is odd else 0 
        }
        return ans;
    }
   
}