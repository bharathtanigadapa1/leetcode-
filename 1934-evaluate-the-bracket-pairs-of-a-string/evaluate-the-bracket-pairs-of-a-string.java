class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map= new HashMap<>();

        for(List<String> pair: knowledge){
            map.put(pair.get(0),pair.get(1));
        }

        StringBuilder res= new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(c=='('){
                int j=i+1;
                while(j<s.length() && s.charAt(j)!=')'){
                    j++;
                }
                String key=s.substring(i+1,j);
                res.append(map.getOrDefault(key,"?"));
                i=j;
            }
            else{
                res.append(c);
            }
        }

        return res.toString();
    }
}