class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length, m = mat[0].length;
        if(r*c != n*m)    return mat;
        int newMat[][] = new int[r][c];
        for(int i=0;i<r*c;i++){
            newMat[i/c][i%c] = mat[i/m][i%m]; 
        }
        return newMat;
    }
}
//Time- O(nm)
//Space- O(1) - without considering the output array