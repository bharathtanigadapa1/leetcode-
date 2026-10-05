class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack= new ArrayDeque<>();
        stack.push(0);
        for(char c: s.toCharArray()){
            if(c=='('){
                stack.push(0);
            }
            else{
                int val=stack.pop();
                int score=Math.max(2*val,1);
                stack.push(score+stack.pop());
            }
        }
        return stack.pop();
    }
}