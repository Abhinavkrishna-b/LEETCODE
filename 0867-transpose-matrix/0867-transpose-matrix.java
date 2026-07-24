class Solution {
    public int[][] transpose(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        if(r==1 && c==1)    return matrix;
        int resMat[][] = new int[c][r];
        //Important here the transpose matrix no of rows and cols are interchanged
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                resMat[j][i] = matrix[i][j];
            }
        }
        return resMat;
    }
}
//Time- O(r*c)
//Space- O(r*c)