class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        List<int[]> merged= new ArrayList<>();
        int[] currInterval= intervals[0];
        merged.add(currInterval);

        for(int[] interval: intervals){
            int curEnd=currInterval[1];
            int nextStart=interval[0];
            int nextEnd=interval[1];
            if(curEnd>=nextStart){
                currInterval[1]=Math.max(curEnd,nextEnd);
            }
            else{
                currInterval=interval;
                merged.add(currInterval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}