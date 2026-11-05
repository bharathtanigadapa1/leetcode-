class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count=0;
        int n=arr1.length;
        int m=arr2.length;
        for(int i=0;i<n;i++){
            boolean valid=true;
            for(int j=0;j<m;j++){
                int difference=Math.abs(arr1[i]-arr2[j]);
                if(difference <= d) valid=false;
            }
            if(valid) count++;
        }
        return count;
    }
}