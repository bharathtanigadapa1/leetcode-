class Solution {
    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                sb.append(c);
            }
            else{
                if(sb.length()==0) return false;
                if(c==')' && sb.charAt(sb.length()-1)!='(') return false;
                if(c==']' && sb.charAt(sb.length()-1)!='[') return false;
                if(c=='}' && sb.charAt(sb.length()-1)!='{') return false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.length()==0;
    }
}