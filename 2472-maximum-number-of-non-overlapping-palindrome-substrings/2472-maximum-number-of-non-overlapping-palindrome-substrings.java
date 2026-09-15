class Solution {
    public int maxPalindromes(String s, int k) {
        /*The key concept that I applied her is the greedy one which chekc if plaidnorme sof size k is posiible or not then palidnorme os sixe k+1 is pesible . First we check if i to i+k is there a valid palindrome if yes we incremtn the count move our curretnt i pointer to t+k ot check is ther an yother palindorme or not this gives the maximum number of palindormes. And here using greedy we check form smaller palindormes so if ther any chance of getting palindormes of lesser sie than it wil become the optimal solution no need to chekc for th eother things */

        int count=0;
        int n=s.length();
        int i=0;
        while(i<n){
            if(i+k<=n && isPalindrome(s,i,i+k-1)){
                count++;
                i=i+k;
            }
            else if(i+k+1<=n && isPalindrome(s,i,i+k)){
                count++;
                i=i+k+1;
            }
            else{
                i++;
            }
        }
        return count;
    }
    private boolean isPalindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;

    }
}