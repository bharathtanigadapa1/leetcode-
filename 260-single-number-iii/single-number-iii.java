class Solution {
    public int[] singleNumber(int[] nums) {
        int xorSum=0;
        for(int num: nums){
            xorSum^=num;
        }
        int rightMostSetBit=xorSum & -xorSum; 
        int num1=0;
        int num2=0;
        for(int num: nums){
            if((num & rightMostSetBit) !=0) num1^=num;
            else num2^=num;
        }
        return new int[] {num1,num2};
    }
}