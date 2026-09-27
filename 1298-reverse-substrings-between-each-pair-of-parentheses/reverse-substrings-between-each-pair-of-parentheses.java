class Solution {
    public String reverseParentheses(String s) {
        StringBuilder res= new StringBuilder();
        for(char c: s.toCharArray()){
            if(c==')'){
                StringBuilder temp= new StringBuilder();
                while(res.length()>0 && res.charAt(res.length()-1)!='('){
                    temp.append(res.charAt(res.length()-1));
                    res.deleteCharAt(res.length()-1);
                }
                if(res.length()>0){
                    res.deleteCharAt(res.length()-1);
                }
                res.append(temp);

            }
            else{
            res.append(c);
            }

        }
        return res.toString();
    }
}