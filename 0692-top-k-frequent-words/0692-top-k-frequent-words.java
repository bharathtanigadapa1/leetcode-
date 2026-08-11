class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        HashMap<String,Integer> map= new HashMap<>();
        for(String word: words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> heap= new PriorityQueue<>((a,b)->{
            int freq=map.get(a)-map.get(b);
            if(freq==0) return b.compareTo(a);
            return freq;
        });
        for(String word: map.keySet()){
            heap.offer(word);
            if(heap.size()>k){
                heap.poll();
            }
        }
        while(!heap.isEmpty() && k-->0){
            res.add(heap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}