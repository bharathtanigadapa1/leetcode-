class Solution {
    public int calculate(String s) {
        Deque<Integer> stack= new ArrayDeque<>();
        int res=0;
        char op='+';
        int num=0;
        for(int i=0;i<=s.length();i++){
            char c=(i==s.length())?'+':s.charAt(i);

            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }
            else if(c!=' '){
                if(op=='+') stack.push(num);
                else if(op=='+') stack.push(num);
                else if(op=='-') stack.push(-num);
                else if(op=='*') stack.push(stack.pop()*num);
                else if(op=='/') stack.push(stack.pop()/num);
                op=c;
                num=0;
            }
        }

        for(int n: stack) res+=n;
        return res;
    }
}