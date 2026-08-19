class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        boolean ZeroRows[]= new boolean[n];
        boolean ZeroCols[] = new boolean[m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0) {
                    ZeroRows[i]=true;
                    ZeroCols[j]=true;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(ZeroRows[i]|| ZeroCols[j]){
                    matrix[i][j]=0;
                }
            }
        }


    }
}