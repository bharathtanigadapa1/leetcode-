class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();

        for(char c: num.toCharArray()){
            while(k>0 && sb.length()> 0 && sb.charAt(sb.length()-1)>c){
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
            sb.append(c);
        }
        sb.setLength(sb.length()-k);
        int start=0;
        while(start<sb.length() && sb.charAt(start)=='0'){
            start++;
        }
        String ans= sb.substring(start,sb.length());
        return ans.isEmpty() ? "0":ans;
    }
}