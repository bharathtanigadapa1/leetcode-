class Solution {
    public boolean increasingTriplet(int[] nums) {
        /* The apprach i used here is we will track the first min element anf the second min alws ensure ther is a smaller numbr then that which is firstMin. We only consider second min n if n>first and n<=second , it ensures there are two values, And if incase a number n exists such that n>first & n>second then it is the third number it satifies first<second <number . so we can simply return true in this case. */
        int first=Integer.MAX_VALUE;
        int second =Integer.MAX_VALUE;
        for( int num: nums)
        {
            if(num<=first) first=num;
            else if ( num<=second) second=num;
            else return true;            
        }
        return false;
    }
}