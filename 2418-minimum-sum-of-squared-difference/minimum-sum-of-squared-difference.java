class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        /* Appraoch : Greedy based Approach 
          From the problem they have given k1+k2 operations we ca reduce 1 or add 1 to a number in the nums1 ans nums2 k1 and k2 times respecively so  we should perform a total of k1+k2 say k operations.. here inorder to get least difference it is always a better choice to remove it from maxDiff.
          So we take a fixed bucket that stores the differnce count , and reducing the count from max diff gives min sum of Squared Difference . */
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

