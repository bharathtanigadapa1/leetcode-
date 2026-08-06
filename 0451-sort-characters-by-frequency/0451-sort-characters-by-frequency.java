class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map =  new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> maxheap= new PriorityQueue<>((a,b)->map.get(b)-map.get(a));

        maxheap.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while(!maxheap.isEmpty()){
            char ch= maxheap.poll();
            for(int i=0;i<map.get(ch);i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}