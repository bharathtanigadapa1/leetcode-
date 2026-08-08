class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> sortedFreq= new PriorityQueue<>(
            (a,b)-> map.get(b)-map.get(a) );
        sortedFreq.addAll(map.keySet());
        int res[] = new int [k];
        int in=0;
        while(k-->0){
            res[in++]=sortedFreq.poll();
        }
        return res;
    }
}