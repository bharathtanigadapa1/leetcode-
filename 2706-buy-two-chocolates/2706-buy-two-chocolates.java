class Solution {
    public int buyChoco(int[] prices, int money) {
        int firstMin=Integer.MAX_VALUE,secondMin=Integer.MAX_VALUE;
        for(int num: prices){
            if(num<firstMin){
                secondMin=firstMin;
                firstMin=num;
            }
            else if (num<secondMin){
                secondMin=num;
            }
        }
        int sum=firstMin+secondMin;
        if(money-sum >=0) return money-sum;
        return money;
    }
}