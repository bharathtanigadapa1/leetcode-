class Solution {
    public int distinctSubseqII(String s) {
        int MOD= 1_000_000_007;
        long last[] = new long[26];
        long total=0;

        for(char c: s.toCharArray()){
            int idx=c-'a';
            long added=(total+1-last[idx]+MOD)%MOD;
            total=(total+added)%MOD;
            last[idx]=(last[idx]+added) % MOD;
        }
        return (int) total;
    }
}