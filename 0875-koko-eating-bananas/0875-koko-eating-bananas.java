class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int  low=1;
        int high=0;
        for(int  num: piles){
            if (num>high) high=num;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canEat(piles,h,mid)) {
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return low;
    }
    public static boolean canEat(int [] piles, int h, int k){
        long hours=0;
        for(int p: piles){
            hours+=(p+k-1)/k;
        }
        return hours<=h;
        
    }
}