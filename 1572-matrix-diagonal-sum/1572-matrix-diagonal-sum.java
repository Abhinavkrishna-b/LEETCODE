class Solution {
    public int diagonalSum(int[][] mat) {
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;
        int i=0,j=0;
        int r=mat.length,c=mat[0].length;

        while(i<r && j<c){
            primaryDiagonal += mat[i][j];
            j+=1;
            i+=1;
        }

        i=0;
        j=c-1;
        while(i<r && j>=0){
            if(i != j){
                secondaryDiagonal += mat[i][j];
            }
            i+=1;
            j-=1;
        }
        return primaryDiagonal + secondaryDiagonal;
    }
}
//Time- O(n)
//Space- O(1)