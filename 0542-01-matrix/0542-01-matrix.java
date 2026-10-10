class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        int result[][] = new int[r][c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j] == 0){
                    result[i][j] = 0;
                }
                else{
                    result[i][j] = Integer.MAX_VALUE;
                    for(int k=0;k<r;k++){
                        for(int l=0;l<c;l++){
                            if(mat[k][l] == 0){
                                //Need to find the distance
                                //So basically the distance the how much steps we are away(move) from the row + how much step we are away(move) from the col
                                int dist = Math.abs(i-k) + Math.abs(j-l);
                                result[i][j] = Math.min(dist, result[i][j]);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
//Time- O( (rc)^2 )
//Space- O(rc)