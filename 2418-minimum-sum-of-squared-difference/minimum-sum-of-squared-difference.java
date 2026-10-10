class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n =nums1.length;
        long k= (long)k1+k2;

        int maxDiff=0;
        int count[]= new int[100001]; // according to constraint 10^5 is the maxiumu diffence

        for(int i=0;i<n;i++){
            int diff=Math.abs(nums1[i]-nums2[i]);
            count[diff]++;
            maxDiff=Math.max(diff,maxDiff);
        }

        for(int d=maxDiff;d>0 && k>0; d--){
            if(count[d]==0) continue;
            long take=Math.min((long)count[d],k);
            count[d]-=take;
            count[d-1]+=take;
            k-=take;
        }

        long res=0;
        for(int d=1;d<=maxDiff;d++){
            if(count[d]>0){
                res+=(long) d*d*count[d];
            }
        }
        return res;

    }
}