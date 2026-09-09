class Solution {
    public long countCommas(long n) {
        if (n<1000) return 0;
        long ans=0;
        long nextComma=1000;
        while(nextComma <= n){
            ans+=(n-nextComma+1);
            nextComma*=1000;
        }
        return ans;
    }
}