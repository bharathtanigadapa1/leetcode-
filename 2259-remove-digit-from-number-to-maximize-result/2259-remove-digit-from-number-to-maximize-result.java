class Solution {
    public String removeDigit(String number, char digit) {
        int n=number.length();
        int lastIndex=-1;
        for(int i=0;i<n;i++){
            if(number.charAt(i)==digit){
                lastIndex=i;
                if(i+1<n && number.charAt(i+1)>digit){
                    return number.substring(0,i) +number.substring(i+1);
                }
            }
        }
        return number.substring(0,lastIndex) +number.substring(lastIndex+1);
    }
}