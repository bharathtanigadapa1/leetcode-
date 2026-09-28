class Solution {
    public int maxDepth(String s) {
        int leftBrackets=0;
        int rightBrackets=0;
        int ans=0;
        for(char c: s.toCharArray()){
            if(c=='('){
                leftBrackets++;
            }
            else if(c==')'){
                rightBrackets++;
            }
            ans=Math.max(ans,leftBrackets-rightBrackets);
        }
        return ans;
    }
}