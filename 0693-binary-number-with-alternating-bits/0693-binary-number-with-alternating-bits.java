class Solution {
    public boolean hasAlternatingBits(int n) {
        // n xor n value after shifting will always result pow(2,k)-1 1s 
        // if we do and opertion on both of them then if it continas a//alternatiove ones it will alswys reulst result to 0 
        // eg: 5 101 ^ 010 == 111 so 111 and 1000 this results in all zeros so qe can asya that number caintians alterbate ines in its binary represntion
        int x=n^(n>>1);
        return (x&((long)x+1)) ==0;
    }
}