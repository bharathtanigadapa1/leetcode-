class Solution {
    public int singleNumber(int[] arr) {
        int ones=0,twos=0;
        for(int num : arr){
            ones=(ones^num) & ~twos;
            twos=(twos^num) & ~ones;
        }
        return ones;
    }
}