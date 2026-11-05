class Solution {
    public long sumAndMultiply(int n) {
        long digit=0;
        int place=1;
        int sum=0;
        while(n!=0){
            int rem=n%10;
            if(rem!=0){
                digit=rem*place+digit;
                place*=10;
                sum+=rem;
            }
            n/=10;
        }
        return sum*digit;
    }
}