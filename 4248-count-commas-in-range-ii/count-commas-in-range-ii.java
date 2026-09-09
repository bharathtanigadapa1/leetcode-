class Solution {
    public long countCommas(long n) {
        /* The approach is finding the where the next coma is palced we know that the comma will be present after three diagts from right to left  . for a range we can say that n-newCommas number +1 results the number of commas in between the range eg: [1,000,1,000,000]  for this intially for 1000 we get 1000-1000+1 =1 commas and the next new comma  is at 1,000,000 so 1,000,000 - 1,000 +1 = 9,99,001. so result will be 9,99,002.*/
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